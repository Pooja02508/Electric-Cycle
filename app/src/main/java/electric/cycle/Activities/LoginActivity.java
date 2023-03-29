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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import electric.cycle.R;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sp;

    private FirebaseAuth mAuth;
    TextView register_here,skip;
    EditText pass,mobile,emailid;
    Button login;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference=firebaseDatabase.getInstance().getReference("UserDetails");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();


        pass=findViewById(R.id.password);
        mobile=findViewById(R.id.phone);
        register_here=findViewById(R.id.register_here);
        login=findViewById(R.id.login);
        skip=findViewById(R.id.skip);
        emailid=findViewById(R.id.email);


        mAuth = FirebaseAuth.getInstance();
        sp = getSharedPreferences("login",MODE_PRIVATE);
        String UserLocation=getIntent().getStringExtra("UserLocation");

        {
            goToMainActivity();
        }



        register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), SignUp.class);
                intent.putExtra("UserLocation",UserLocation);
                startActivity(intent);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), NavigationDrawer.class);
                intent.putExtra("UserLocation",UserLocation);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });


    }
    private void loginUserAccount() {

        String email, password;
        email = emailid.getText().toString();
        password = pass.getText().toString();

        // validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
            return;
        }

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    String phone="+91"+mobile.getText().toString();
                                    Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();
                                    sp.edit().putBoolean("logged",true).apply();
                                    sp.edit().putString("UserMobile",phone).apply();
                                    goToMainActivity();
                                    finish();
                                }

                                else {
                                    Toast.makeText(getApplicationContext(), "Login failed!!", Toast.LENGTH_LONG).show();

                                }
                            }
                        });
    }

    public void goToMainActivity(){
        startActivity(new Intent(LoginActivity.this, NavigationDrawer.class));
        finish();
    }
}


// login.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//
//        String Password=password.getText().toString();
//        String Mobile=phone.getText().toString();
//
//        if(TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(phone.getText().toString())){
//        Toast.makeText(getApplicationContext(),"Enter valid credentials",Toast.LENGTH_SHORT).show();
//        }
//        else {
//
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//@Override
//public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//        if(snapshot.hasChild(Mobile)){
//
//final String getPassword=snapshot.child(Mobile).child("userPassword").getValue(String.class);
//
//        if(getPassword.equals(Password)){
//        Toast.makeText(getApplicationContext(), "Login Successful.", Toast.LENGTH_SHORT).show();
//        goToMainActivity();
//        sp.edit().putBoolean("logged",true).apply();
//        sp.edit().putString("Mobile",Mobile).apply();
//
//
////                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
////                                    i.putExtra("Mobile Number",Mobile);
////                                    startActivity(i);
//        finish();
//
//        }
//        else{
//
//        Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//        }
//        }
//        else{
//
//        Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//        }
//
//        }
//
//@Override
//public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//        });
//
//        }
//        }
//        });