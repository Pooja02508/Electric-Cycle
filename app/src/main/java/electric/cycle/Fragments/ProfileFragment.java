package electric.cycle.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import electric.cycle.Activities.LoginActivity;
import electric.cycle.R;


public class ProfileFragment extends Fragment {

    SharedPreferences sp;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference=firebaseDatabase.getInstance().getReference("UserDetails");
    TextView user_name,user_email,user_city,user_mobile;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_profile, container, false);


        sp = getActivity().getSharedPreferences("login",MODE_PRIVATE);
        String MobileNumber=sp.getString("Mobile",null);


        mAuth = FirebaseAuth.getInstance();


        user_name=root.findViewById(R.id.user_name);
        user_email=root.findViewById(R.id.user_email);
        user_city=root.findViewById(R.id.user_city);
        user_mobile=root.findViewById(R.id.user_mobile);

        if(MobileNumber==null){
            user_name.setText("");
            user_mobile.setText("");
            user_email.setText("");
            user_city.setText("");
        }
        else{
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

                        Toast.makeText(getActivity(), "Please Sign up.", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }




        return root;
        }
}