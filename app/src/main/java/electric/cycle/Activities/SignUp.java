package electric.cycle.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import electric.cycle.R;
import electric.cycle.UserDetails;

public class SignUp extends AppCompatActivity {

    SharedPreferences sp;

    private FirebaseAuth mAuth;
    private EditText edtPhone,edtName,edtEmail, edtOTP,edtPassword;
    private Button verifyOTPBtn, generateOTPBtn;
    TextView login_here,skip;
    private String verificationId;
    EditText city;
    UserDetails userDetails;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        edtPhone = findViewById(R.id.idPhoneNumber);
        edtName = findViewById(R.id.idName);
        edtEmail = findViewById(R.id.idEmail);
        edtPassword=findViewById(R.id.idPassword);
        edtOTP = findViewById(R.id.idOtp);
        verifyOTPBtn = findViewById(R.id.idVerify);
        generateOTPBtn = findViewById(R.id.idGetOtp);
        city=findViewById(R.id.idCity);
        login_here=findViewById(R.id.login_here);
        skip=findViewById(R.id.skip);


        sp = getSharedPreferences("login",MODE_PRIVATE);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserDetails");
        userDetails = new UserDetails();

        login_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
        login_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NavigationDrawer.class));
            }
        });


        generateOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtPhone.getText().toString()) || TextUtils.isEmpty(edtEmail.getText().toString()) ||
                        TextUtils.isEmpty(edtName.getText().toString()) ||TextUtils.isEmpty(city.getText().toString()) ||TextUtils.isEmpty(edtPhone.getText().toString())) {
                    Toast.makeText(SignUp.this, "Please enter all details.", Toast.LENGTH_SHORT).show();
                }
                else {
                    String phone = "+91" + edtPhone.getText().toString();
                    Toast.makeText(getApplicationContext(),"OTP sent to your mobile number",Toast.LENGTH_SHORT).show();
                    sendVerificationCode(phone);
                }
            }
        });

        verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtOTP.getText().toString())) {
                    Toast.makeText(SignUp.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    verifyCode(edtOTP.getText().toString());
                }
            }
        });
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            Toast.makeText(SignUp.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            sp.edit().putBoolean("logged",true).apply();
                            sp.edit().putString("Mobile",edtPhone.getText().toString().trim()).apply();

                            Intent i = new Intent(SignUp.this, NavigationDrawer.class);
                            i.putExtra("Mobile Number",edtPhone.getText().toString().trim());
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    private void sendVerificationCode(String number) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(number)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallBack)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks

            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            final String code = phoneAuthCredential.getSmsCode();

            if (code != null) {
                edtOTP.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        String UserName = edtName.getText().toString().trim();
        String EmailId = edtEmail.getText().toString().trim();
        String Address = city.getText().toString().trim();
        String Mobile = edtPhone.getText().toString().trim();
        String Password = edtPassword.getText().toString().trim();


        addData(UserName,EmailId,Address,Mobile,Password);
        sendEmail();
        signInWithCredential(credential);
    }


    public void addData(String UserName,String EmailId,String Address,String Mobile,String Password){

        userDetails.setUserName(UserName);
        userDetails.setUserEmail(EmailId);
        userDetails.setUserCity(Address);
        userDetails.setUserMobile(Mobile);
        userDetails.setUserPassword(Password);



        databaseReference.child("UserDetails").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(Mobile)){
                    Toast.makeText(getApplicationContext(), "User already exists.", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child(Mobile).setValue(userDetails);

                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void sendEmail(){

        try {
            String stringSenderEmail = "electriccycleonline@gmail.com";
            String stringReceiverEmail = edtEmail.getText().toString();
            String stringPasswordSenderEmail = "dhfctspndpwxagzn";

            String stringHost = "smtp.gmail.com";

            Properties properties = System.getProperties();

            properties.put("mail.smtp.host", stringHost);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail);
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stringReceiverEmail));



            mimeMessage.setSubject("Rice Delivery Registration");
            mimeMessage.setText("Hello "+ edtName.getText().toString()+"\nYou have successfully registered in Electric Cycle.");

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Transport.send(mimeMessage);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}