package electric.cycle.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import electric.cycle.Fragments.HomeFragment;
import electric.cycle.Fragments.ProfileFragment;
import electric.cycle.Fragments.SellFragment;
import electric.cycle.R;
import electric.cycle.databinding.NavigationDrawerBinding;

public class NavigationDrawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavigationDrawerBinding binding;
    SharedPreferences sp;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = NavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String UserLocation=getIntent().getStringExtra("UserLocation");

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);
//        binding.appBarNavigationDrawer.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_profile)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        sp = getSharedPreferences("login",MODE_PRIVATE);
        String MobileNumber=sp.getString("UserMobile",null);

        toggle=new ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout sanatan_link=findViewById(R.id.website_link);
        sanatan_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("Website Link","https://electriccycle.online/");
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                Intent intent=new Intent(getApplicationContext(),WebViewActivity.class);
                Intent intent2=new Intent(getApplicationContext(),ProfileActivity.class);

                switch (id){

                    case R.id.nav_profile:startActivity(intent2);
                        break;
                    case R.id.nav_home:startActivity(new Intent(getApplicationContext(),NavigationDrawer.class));
                        finish();
                        break;

                    case  R.id.nav_b1:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p193_Hero-Lectro-Bikes-Company-Buy--Zugo--Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b2:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p196_Buy-Geekay-Bikes-Company-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b4:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p210_Nibelimited-Bikes-Company-Buy--Zugo--Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b5:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p194_SWAGTRON-Bikes-Company-Buy--Zugo--Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b6:intent.putExtra("Website Link", "https://electriccycle.online/contents/en-us/d1002_Buy-Addmotor-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b7:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1003_Buy-Ancheer-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b8:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1004_Buy-Amego-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b9:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1005_Buy-Aostirmotor-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b10:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1006_Buy-Ariel-Rider-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b11:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1007_Buy-Aventon-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b12:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1008_Buy-Batch-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b13:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1009_Buy-Bee-Cool-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b14:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1010_Buy-Benelli-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b15:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1011_Buy-Benno-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b16:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1012_Buy-BESV-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b17:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1013_Buy-BH-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b18:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1014_Buy-Big-Cat-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b19:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1015_Buy-Biktrix-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b20:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1016_Buy-Bintelli-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b21:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1017_Buy-Biomega-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b22:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1018_Buy-Biria-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b23:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1019_Buy-Blix-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b24:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1020_Buy-BMEBIKES-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b25:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1021_Buy-Bolton-Electric-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b26:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1022_Buy-BPM-Imports-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b27:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1023_Buy-Brompton-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b28:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1024_Buy-Bulls-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b29:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1025_Buy-Bunch-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b30:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1026_Buy-Butchers--Bicycles-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b31:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1027_Buy-Buzz-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b32:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1028_Buy-California-Bicycle-Factory-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b33:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1029_Buy-Cannondale-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b34:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1030_Buy-Cero-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b35:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1031_Buy-Charge-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b36:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1032_Buy-Civia-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b37:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1033_Buy-Cobac-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b38:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1034_Buy-Co-Op-(REI-brand)-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b39:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1035_Buy-Corratec-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b40:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1036_Buy-Cube-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b41:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1037_Buy-Cyrusher-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b42:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1038_Buy-DAY-6-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b43:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1039_Buy-Desiknio-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b44:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1040_Buy-DJ-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b45:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1041_Buy-Doheny-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b46:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1042_Buy-D%C5%8CST-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b47:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1043_Buy-DYU-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b48:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1044_Buy-Eahora-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b49:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1045_Buy-EccoBike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b50:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1046_Buy-EcoMotion-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b51:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1047_Buy-Ecotric-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b52:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1048_Buy-E-Glide-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b53:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1049_Buy-e-JOE-Bike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b54:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1050_Buy-Elby-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b55:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1051_Buy-Electra-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b56:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1052_Buy-Electric-Bike-Company-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b57:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1053_Buy-Electric-Fat-Bike-Company-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b58:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1054_Buy-Electric-Bike-Technologies-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b59:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1055_Buy-E-Lux-Electric-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case  R.id.nav_b60:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1056_Buy-Emojo-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b61:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1057_Buy-Energie-Cycles-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b62:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1058_Buy-Enzo-eBikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b63:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1059_Buy-eProdigy-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b64:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1060_Buy-Espin-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b65:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1061_Buy-ET.Cycle-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b66:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1062_Buy-Eunorau-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b67:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1063_Buy-Euphree-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b68:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1064_Buy-EVELO-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b69:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1065_Buy-EVO-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b70:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1066_Buy-EZ-Pedaler-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b71:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1067_Buy-Fantic-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b72:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1068_Buy-Faraday-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b73:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1069_Buy-Felt-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b74:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1070_Buy-Fiido-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b75:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1071_Buy-Flash-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b76:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1072_Buy-FLX-Ebikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b77:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1073_Buy-Focus-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b78:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1074_Buy-Fuji-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b79:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1075_Buy-Furo-Systems-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b80:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1076_Buy-Gazelle-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b81:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1077_Buy-Genze-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b82:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1078_Buy-Gepida-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b83:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1079_Buy-Ghost-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b84:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1080_Buy-Giant-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b85:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1081_Buy-Gocycle-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b86:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1082_Buy-GoTrax-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b87:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1083_Buy-Go-Power-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b88:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1084_Buy-Gyroor-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b89:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1085_Buy-Haibike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b90:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1086_Buy-Haoqi-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b91:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1087_Buy-Haro-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b92:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1088_Buy-Heybike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b93:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1089_Buy-Hilltopper-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b94:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1090_Buy-Himiway-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b95:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1091_Buy-Honbike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b96:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1092_Buy-HPC-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b97:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1093_Buy-HP-Velotechnik-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b98:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1094_Buy-Husqvarna-Bicycles-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b99:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1095_Buy-iGO-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b100:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1096_Buy-IZIP-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b101:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1097_Buy-Jetson-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b102:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1098_Buy-Juiced-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b103:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1099_Buy-Junto-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b104:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1100_Buy-JupiterBikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b105:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1101_Buy-Kalkhoff-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b106:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1102_Buy-KBO-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b107:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1103_Buy-Kona-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b108:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1104_Buy-Kuake-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b109:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1105_Buy-Lapierre-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b110:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1106_Buy-Lemond-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b111:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1107_Buy-Liberty-Trike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b112:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1108_Buy-Life-EV-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b113:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1109_Buy-Liv-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b114:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1110_Buy-Luna-Cycle-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b115:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1111_Buy-M1-Sporttechnik-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b116:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1112_Buy-Macwheel-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b117:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1113_Buy-Magnum-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b118:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1114_Buy-Magicycle-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b119:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1115_Buy-Maxfoot-Electric-Bike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b120:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1116_Buy-Metakoo-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b121:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1117_Buy-M2S-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b122:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1118_Buy-Mod-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b123:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1119_Buy-Mokwheel-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b124:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1120_Buy-Mondraker-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b125:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1121_Buy-Montague-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b126:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1122_Buy-Motiv-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b127:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1123_Buy-Moustache-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b128:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1124_Buy-Nakto-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b129:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1125_Buy-Ness-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b130:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1126_Buy-Nicolai-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b131:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1127_Buy-NCM-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b132:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1128_Buy-OHM-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b133:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1129_Buy-Optibike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b134:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1130_Buy-Opus-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b135:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1131_Buy-Orbea-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b136:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1132_Buy-Outrider-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b137:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1133_Buy-Oyama-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b138:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1134_Buy-Paselec-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b139:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1135_Buy-Pedego-Electric-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b140:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1136_Buy-Pegasus-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b141:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1137_Buy-Piaggio-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b142:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1138_Buy-Pivot-Cycles-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b143:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1139_Buy-Polarna-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b144:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1140_Buy-Populo-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b145:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1141_Buy-Priority-Bicycles-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b146:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1142_Buy-ProdecoTech-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b147:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1143_Buy-Propella-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b148:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1144_Buy-Pure-Cycles-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b149:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1145_Buy-Qualisports-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b150:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1146_Buy-QuietKat-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b151:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1147_Buy-Rad-Power-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b152:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1148_Buy-Raleigh-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b153:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1149_Buy-Rambo-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b154:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1150_Buy-Rattan-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b155:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1151_Buy-Retrospec-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b156:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1152_Buy-Revelo-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b157:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1153_Buy-Revolve-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b158:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1154_Buy-Ride1Up-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b159:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1155_Buy-Ride-Scoozy-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b160:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1156_Buy-Riese--Mueller-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b161:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1157_Buy-Rize-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b162:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1158_Buy-Rocky-Mountain-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b163:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1159_Buy-Schwinn-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b164:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1160_Buy-Scott-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b165:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1161_Buy-Smartmotion-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b166:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1162_Buy-Sondors-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b167:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1163_Buy-Soul-Beach-Cruisers-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b168:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1164_Buy-Specialized-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b169:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1165_Buy-Stealth-Electric-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b170:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1166_Buy-Stromer-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b171:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1167_Buy-Surface604-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b172:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1168_Buy-Surly-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b173:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1169_Buy-Super73-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b174:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1170_Buy-Tern-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b175:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1171_Buy-The-Ride-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b176:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1172_Buy-Tower-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b177:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1173_Buy-Trek-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b178:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1174_Buy-Troxus-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b179:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1175_Buy-Turboant-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b180:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1176_Buy-Urban-Arrow-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b181:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1177_Buy-Urtopia-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b182:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1178_Buy-Vanmoof-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b183:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1179_Buy-Vello-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b184:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1180_Buy-Velotric-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b185:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1181_Buy-VoltBike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b186:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1182_Buy-Vvolt-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b187:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1183_Buy-Wallke-Ebikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b188:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1184_Buy-Wing-Bikes-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b189:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1185_Buy-Woom-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b190:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1186_Buy-Xtracycle-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b191:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1187_Buy-Yamaha-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b192:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1188_Buy-Yuba-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b193:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1189_Buy-Zooz-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;
                    case R.id.nav_b194:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1190_Buy-Zugo-Bike-Electric-Cycles-online.html");
                        startActivity(intent);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }

                return false;
            }
        });

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {

        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            selectedFragment = new HomeFragment();
        } else if (itemId == R.id.nav_profile) {
            selectedFragment = new ProfileFragment();
        }
        else if (itemId == R.id.nav_sell) {
            selectedFragment = new SellFragment();
        }
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
        return true;
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()){
            case R.id.action_settings:
                SharedPreferences.Editor editor=sp.edit();
                editor.clear();
                editor.apply();
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(),"Logout Successful",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(NavigationDrawer.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}



