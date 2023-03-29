package electric.cycle.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import electric.cycle.R;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences sp;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference=firebaseDatabase.getInstance().getReference("UserDetails");
    TextView user_name,user_email,user_city,user_mobile;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sp = getSharedPreferences("login",MODE_PRIVATE);
        String MobileNumber=sp.getString("UserMobile",null);

        mAuth = FirebaseAuth.getInstance();


        user_name=findViewById(R.id.user_name);
        user_email=findViewById(R.id.user_email);
        user_city=findViewById(R.id.user_city);
        user_mobile=findViewById(R.id.user_mobile);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.hasChild(MobileNumber)){

                    final String getUserName=snapshot.child(MobileNumber).child("userName").getValue(String.class);
                    final String getUserMobile=snapshot.child(MobileNumber).child("userMobile").getValue(String.class);
                    final String getUserEmail=snapshot.child(MobileNumber).child("userEmail").getValue(String.class);
                    final String getUserCity=snapshot.child(MobileNumber).child("userCity").getValue(String.class);


                    user_name.setText(getUserName);
                    user_mobile.setText(getUserMobile);
                    user_email.setText(getUserEmail);
                    user_city.setText(getUserCity);


                }
                else{

                    Toast.makeText(getApplicationContext(), "Please Sign up.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}