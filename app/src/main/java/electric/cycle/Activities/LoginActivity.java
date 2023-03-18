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
    EditText password,phone;
    Button login;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference=firebaseDatabase.getInstance().getReference("UserDetails");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();


        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        register_here=findViewById(R.id.register_here);
        login=findViewById(R.id.login);
        skip=findViewById(R.id.skip);


        mAuth = FirebaseAuth.getInstance();
        sp = getSharedPreferences("login",MODE_PRIVATE);
        String UserLocation=getIntent().getStringExtra("UserLocation");

        if(sp.getBoolean("logged",false)){
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
            public void onClick(View v) {

                String Password=password.getText().toString();
                String Mobile=phone.getText().toString();

                if(TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(phone.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Enter valid credentials",Toast.LENGTH_SHORT).show();
                }
                else {


                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(Mobile)){

                                final String getPassword=snapshot.child(Mobile).child("userPassword").getValue(String.class);

                                if(getPassword.equals(Password)){
                                    Toast.makeText(getApplicationContext(), "Login Successful.", Toast.LENGTH_SHORT).show();
                                    goToMainActivity();
                                    sp.edit().putBoolean("logged",true).apply();
                                    sp.edit().putString("Mobile",Mobile).apply();


//                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                                    i.putExtra("Mobile Number",Mobile);
//                                    startActivity(i);
                                    finish();

                                }
                                else{

                                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{

                                Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

    }
    public void goToMainActivity(){
        Intent i = new Intent(this,NavigationDrawer.class);
        i.putExtra("Mobile Number",phone.getText().toString());
        startActivity(i);
    }
}