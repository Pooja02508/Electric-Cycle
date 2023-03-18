package electric.cycle.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import electric.cycle.BikeAdapter;
import electric.cycle.BikeModel;
import electric.cycle.R;
import electric.cycle.Activities.WebViewActivity;

public class HomeFragment extends Fragment implements BikeAdapter.ItemClickListener{

    FusedLocationProviderClient fusedLocationProviderClient;
    private  final  static int REQUEST_CODE=100;
    TextView loaction_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_home, container, false);

        loaction_text=root.findViewById(R.id.location_text);

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(getActivity());
        getLastLocation();

        RecyclerView bikeRV = root.findViewById(R.id.bikeRV);

        ArrayList<BikeModel> bikeModelArrayList = new ArrayList<BikeModel>();

        bikeModelArrayList.add(new BikeModel("Hero Cycle ", R.drawable.hero_cycle));
        bikeModelArrayList.add(new BikeModel("Geekay Bikes", R.drawable.geekay_bikes));
        bikeModelArrayList.add(new BikeModel("Nibe Motors", R.drawable.nibe_bike));
        bikeModelArrayList.add(new BikeModel("Swagtron", R.drawable.swagtron));
        bikeModelArrayList.add(new BikeModel("Addmotor", R.drawable.addmotor));
        bikeModelArrayList.add(new BikeModel("Ancheer", R.drawable.ancheer));
        bikeModelArrayList.add(new BikeModel("Amego", R.drawable.amego));
        bikeModelArrayList.add(new BikeModel("Aostirmotor", R.drawable.aostirmotor));
        bikeModelArrayList.add(new BikeModel("Ariel Rider", R.drawable.ariel_rider));
        bikeModelArrayList.add(new BikeModel("Aventon", R.drawable.aventon));
        bikeModelArrayList.add(new BikeModel("Batch", R.drawable.batch));
        bikeModelArrayList.add(new BikeModel("Bee Cool Bikes", R.drawable.bee_cool_bikes));
        bikeModelArrayList.add(new BikeModel("Benelli", R.drawable.benelli));
        bikeModelArrayList.add(new BikeModel("Benno", R.drawable.benno));
        bikeModelArrayList.add(new BikeModel("BESV", R.drawable.besv));
        bikeModelArrayList.add(new BikeModel("BH Bikes", R.drawable.bh_bikes));
        bikeModelArrayList.add(new BikeModel("Big Cat", R.drawable.big_cat));
        bikeModelArrayList.add(new BikeModel("Biktrix", R.drawable.biktrix));
        bikeModelArrayList.add(new BikeModel("Bintelli", R.drawable.bintelli));
        bikeModelArrayList.add(new BikeModel("Biomega", R.drawable.biomega));
        bikeModelArrayList.add(new BikeModel("Biria", R.drawable.biria));
        bikeModelArrayList.add(new BikeModel("Blix", R.drawable.blix));
        bikeModelArrayList.add(new BikeModel("BMEBIKES", R.drawable.bmebikes));
        bikeModelArrayList.add(new BikeModel("Bolton Electric Bikes", R.drawable.bolton_electric_bikes));
        bikeModelArrayList.add(new BikeModel("BPM Imports", R.drawable.bpm_imports));
        bikeModelArrayList.add(new BikeModel("Brompton", R.drawable.brompton));
        bikeModelArrayList.add(new BikeModel("Bulls", R.drawable.bulls));
        bikeModelArrayList.add(new BikeModel("Bunch Bikes", R.drawable.bunch_bikes));
        bikeModelArrayList.add(new BikeModel("Butchers & Bicycles", R.drawable.butchers_bicycles));
        bikeModelArrayList.add(new BikeModel("Buzz Bikes", R.drawable.buzz_bikes));
        bikeModelArrayList.add(new BikeModel("California Bicycle Factory", R.drawable.california_bicycle_factory));
        bikeModelArrayList.add(new BikeModel("Cannondale", R.drawable.cannondale));
        bikeModelArrayList.add(new BikeModel("Cero", R.drawable.cero));
        bikeModelArrayList.add(new BikeModel("Charge Bikes", R.drawable.charge_bikes));
        bikeModelArrayList.add(new BikeModel("Civia", R.drawable.civia));
        bikeModelArrayList.add(new BikeModel("Cobac", R.drawable.cobac));
        bikeModelArrayList.add(new BikeModel("Co-Op (REI brand)", R.drawable.co_op));
        bikeModelArrayList.add(new BikeModel("Corratec", R.drawable.corratec));
        bikeModelArrayList.add(new BikeModel("Cube", R.drawable.cube));
        bikeModelArrayList.add(new BikeModel("Cyrusher", R.drawable.cyrusher));
        bikeModelArrayList.add(new BikeModel("DAY 6", R.drawable.day6));
        bikeModelArrayList.add(new BikeModel("Desiknio", R.drawable.desiknio));
        bikeModelArrayList.add(new BikeModel("DJ Bikes", R.drawable.dj_bikes));
        bikeModelArrayList.add(new BikeModel("Doheny", R.drawable.doheny));
        bikeModelArrayList.add(new BikeModel("DŌST Bikes", R.drawable.dost_bikes));
        bikeModelArrayList.add(new BikeModel("DYU", R.drawable.dyu));
        bikeModelArrayList.add(new BikeModel("Eahora", R.drawable.eahora));
        bikeModelArrayList.add(new BikeModel("EccoBike", R.drawable.eccobike));
        bikeModelArrayList.add(new BikeModel("EcoMotion Bikes", R.drawable.ecomotion_bikes));
        bikeModelArrayList.add(new BikeModel("Ecotric", R.drawable.ecotric));
        bikeModelArrayList.add(new BikeModel("E-Glide", R.drawable.e_glide));
        bikeModelArrayList.add(new BikeModel("e-JOE Bike", R.drawable.e_joe_bike));
        bikeModelArrayList.add(new BikeModel("Elby", R.drawable.elby));
        bikeModelArrayList.add(new BikeModel("Electra", R.drawable.electra));
        bikeModelArrayList.add(new BikeModel("Electric Bike Company", R.drawable.electric_bike_company));
        bikeModelArrayList.add(new BikeModel("Electric Fat Bike Company", R.drawable.electric_fat_bike_company));
        bikeModelArrayList.add(new BikeModel("Electric Bike Technologies", R.drawable.electric_bike_technologies));
        bikeModelArrayList.add(new BikeModel("E-Lux Electric Bikes", R.drawable.e_lux_electric_bikes));
        bikeModelArrayList.add(new BikeModel("Emojo", R.drawable.emojo));
        bikeModelArrayList.add(new BikeModel("Energie Cycles ", R.drawable.energie_cycles));
        bikeModelArrayList.add(new BikeModel("Enzo eBikes", R.drawable.enzo_ebikes));
        bikeModelArrayList.add(new BikeModel("eProdigy", R.drawable.eprodigy));
        bikeModelArrayList.add(new BikeModel("Espin", R.drawable.espin));
        bikeModelArrayList.add(new BikeModel("ET.Cycle", R.drawable.et_cycle));
        bikeModelArrayList.add(new BikeModel("Eunorau", R.drawable.eunorau));
        bikeModelArrayList.add(new BikeModel("Euphree", R.drawable.euphree));
        bikeModelArrayList.add(new BikeModel("EVELO", R.drawable.evelo));
        bikeModelArrayList.add(new BikeModel("EVO", R.drawable.evo));
        bikeModelArrayList.add(new BikeModel("EZ Pedaler", R.drawable.ez_pedaler));
        bikeModelArrayList.add(new BikeModel("Fantic", R.drawable.fantic));
        bikeModelArrayList.add(new BikeModel("Faraday", R.drawable.faraday));
        bikeModelArrayList.add(new BikeModel("Felt", R.drawable.felt));
        bikeModelArrayList.add(new BikeModel("Fiido", R.drawable.fiido));
        bikeModelArrayList.add(new BikeModel("Flash", R.drawable.flash));
        bikeModelArrayList.add(new BikeModel("FLX Ebikes", R.drawable.flx_ebikes));
        bikeModelArrayList.add(new BikeModel("Focus", R.drawable.focus));
        bikeModelArrayList.add(new BikeModel("Fuji", R.drawable.fuji));
        bikeModelArrayList.add(new BikeModel("Furo Systems", R.drawable.furo_systems));
        bikeModelArrayList.add(new BikeModel("Gazelle", R.drawable.gazelle));
        bikeModelArrayList.add(new BikeModel("Genze", R.drawable.genze));
        bikeModelArrayList.add(new BikeModel("Gepida", R.drawable.gepida));
        bikeModelArrayList.add(new BikeModel("Ghost", R.drawable.ghost));
        bikeModelArrayList.add(new BikeModel("Giant", R.drawable.giant));
        bikeModelArrayList.add(new BikeModel("Gocycle", R.drawable.gocycle));
        bikeModelArrayList.add(new BikeModel("GoTrax", R.drawable.gotrax));
        bikeModelArrayList.add(new BikeModel("Go Power", R.drawable.go_power));
        bikeModelArrayList.add(new BikeModel("Gyroor", R.drawable.gyroor));
        bikeModelArrayList.add(new BikeModel("Haibike", R.drawable.haibike));
        bikeModelArrayList.add(new BikeModel("Haoqi", R.drawable.haoqi));
        bikeModelArrayList.add(new BikeModel("Haro", R.drawable.haro));
        bikeModelArrayList.add(new BikeModel("Heybike", R.drawable.heybike));
        bikeModelArrayList.add(new BikeModel("Hilltopper", R.drawable.hilltopper));
        bikeModelArrayList.add(new BikeModel("Himiway", R.drawable.himiway));
        bikeModelArrayList.add(new BikeModel("Honbike", R.drawable.honbike));
        bikeModelArrayList.add(new BikeModel("HPC", R.drawable.hpc));
        bikeModelArrayList.add(new BikeModel("HP Velotechnik", R.drawable.hp_velotechnik));
        bikeModelArrayList.add(new BikeModel("Husqvarna Bicycles", R.drawable.husqvarna_bicycles));
        bikeModelArrayList.add(new BikeModel("iGO", R.drawable.igo));
        bikeModelArrayList.add(new BikeModel("IZIP", R.drawable.izip));
        bikeModelArrayList.add(new BikeModel("Jetson", R.drawable.jetson));
        bikeModelArrayList.add(new BikeModel("Juiced Bikes", R.drawable.juiced_bikes));
        bikeModelArrayList.add(new BikeModel("Junto", R.drawable.junto));
        bikeModelArrayList.add(new BikeModel("JupiterBikes", R.drawable.jupiterbikes));
        bikeModelArrayList.add(new BikeModel("Kalkhoff", R.drawable.kalkhoff));
        bikeModelArrayList.add(new BikeModel("KBO", R.drawable.kbo));
        bikeModelArrayList.add(new BikeModel("Kona", R.drawable.kona));
        bikeModelArrayList.add(new BikeModel("Kuake", R.drawable.kuake));
        bikeModelArrayList.add(new BikeModel("Lapierre", R.drawable.lapierre));
        bikeModelArrayList.add(new BikeModel("Lemond", R.drawable.lemond));
        bikeModelArrayList.add(new BikeModel("Liberty Trike", R.drawable.liberty_trike));
        bikeModelArrayList.add(new BikeModel("Life EV", R.drawable.life_ev));
        bikeModelArrayList.add(new BikeModel("Liv", R.drawable.liv));
        bikeModelArrayList.add(new BikeModel("Luna Cycle", R.drawable.luna_cycle));
        bikeModelArrayList.add(new BikeModel("M1-Sporttechnik", R.drawable.m1_sporttechnik));
        bikeModelArrayList.add(new BikeModel("Macwheel", R.drawable.macwheel));
        bikeModelArrayList.add(new BikeModel("Magnum", R.drawable.magnum));
        bikeModelArrayList.add(new BikeModel("Magicycle", R.drawable.magicycle));
        bikeModelArrayList.add(new BikeModel("Maxfoot Electric Bike", R.drawable.maxfoot_electric_bike));
        bikeModelArrayList.add(new BikeModel("Metakoo", R.drawable.metakoo));
        bikeModelArrayList.add(new BikeModel("M2S Bikes", R.drawable.m2s_bikes));
        bikeModelArrayList.add(new BikeModel("Mod Bikes", R.drawable.mod_bikes));
        bikeModelArrayList.add(new BikeModel("Mokwheel", R.drawable.mokwheel));
        bikeModelArrayList.add(new BikeModel("Mondraker", R.drawable.mondraker));
        bikeModelArrayList.add(new BikeModel("Montague", R.drawable.montague));
        bikeModelArrayList.add(new BikeModel("Motiv", R.drawable.motiv));
        bikeModelArrayList.add(new BikeModel("Moustache Bikes", R.drawable.moustache_bikes));
        bikeModelArrayList.add(new BikeModel("Nakto", R.drawable.nakto));
        bikeModelArrayList.add(new BikeModel("Ness", R.drawable.ness));
        bikeModelArrayList.add(new BikeModel("Nicolai Bikes", R.drawable.nicolai_bikes));
        bikeModelArrayList.add(new BikeModel("NCM", R.drawable.ncm));
        bikeModelArrayList.add(new BikeModel("OHM", R.drawable.ohm));
        bikeModelArrayList.add(new BikeModel("Optibike", R.drawable.optibike));
        bikeModelArrayList.add(new BikeModel("Opus", R.drawable.opus));
        bikeModelArrayList.add(new BikeModel("Orbea", R.drawable.orbea));
        bikeModelArrayList.add(new BikeModel("Outrider", R.drawable.outrider));
        bikeModelArrayList.add(new BikeModel("Oyama", R.drawable.oyama));
        bikeModelArrayList.add(new BikeModel("Paselec", R.drawable.paselec));
        bikeModelArrayList.add(new BikeModel("Pedego Electric Bikes", R.drawable.pedego_electric_bikes));
        bikeModelArrayList.add(new BikeModel("Pegasus", R.drawable.pegasus));
        bikeModelArrayList.add(new BikeModel("Piaggio", R.drawable.piaggio));
        bikeModelArrayList.add(new BikeModel("Pivot Cycles", R.drawable.pivot));
        bikeModelArrayList.add(new BikeModel("Polarna", R.drawable.polarna));
        bikeModelArrayList.add(new BikeModel("Populo", R.drawable.populo));
        bikeModelArrayList.add(new BikeModel("Priority Bicycles", R.drawable.priority_bicycles));
        bikeModelArrayList.add(new BikeModel("ProdecoTech", R.drawable.prodecotech));
        bikeModelArrayList.add(new BikeModel("Propella", R.drawable.propella));
        bikeModelArrayList.add(new BikeModel("Pure Cycles", R.drawable.pure_cycles));
        bikeModelArrayList.add(new BikeModel("Qualisports", R.drawable.qualisports));
        bikeModelArrayList.add(new BikeModel("QuietKat", R.drawable.quietkat));
        bikeModelArrayList.add(new BikeModel("Rad Power Bikes", R.drawable.rad_power_bikes));
        bikeModelArrayList.add(new BikeModel("Raleigh", R.drawable.raleigh));
        bikeModelArrayList.add(new BikeModel("Rambo Bikes", R.drawable.rambo_bikes));
        bikeModelArrayList.add(new BikeModel("Rattan", R.drawable.rattan));
        bikeModelArrayList.add(new BikeModel("Retrospec", R.drawable.retrospec));
        bikeModelArrayList.add(new BikeModel("Revelo", R.drawable.revelo));
        bikeModelArrayList.add(new BikeModel("Revolve", R.drawable.revolve));
        bikeModelArrayList.add(new BikeModel("Ride1Up", R.drawable.ride1up));
        bikeModelArrayList.add(new BikeModel("Ride Scoozy", R.drawable.ride_scoozy));
        bikeModelArrayList.add(new BikeModel("Riese & Müller", R.drawable.riese_muller));
        bikeModelArrayList.add(new BikeModel("Rize Bikes", R.drawable.rize_bikes));
        bikeModelArrayList.add(new BikeModel("Rocky Mountain", R.drawable.rocky_mountain));
        bikeModelArrayList.add(new BikeModel("Schwinn", R.drawable.schwinn));
        bikeModelArrayList.add(new BikeModel("Scott", R.drawable.scott));
        bikeModelArrayList.add(new BikeModel("Smartmotion", R.drawable.smartmotion));
        bikeModelArrayList.add(new BikeModel("Sondors", R.drawable.sondors));
        bikeModelArrayList.add(new BikeModel("Soul Beach Cruisers", R.drawable.soul_beach_cruisers));
        bikeModelArrayList.add(new BikeModel("Specialized", R.drawable.specialized));
        bikeModelArrayList.add(new BikeModel("Stealth Electric Bikes", R.drawable.stealth_electric_bikes));
        bikeModelArrayList.add(new BikeModel("Stromer", R.drawable.stromer));
        bikeModelArrayList.add(new BikeModel("Surface604", R.drawable.surface604));
        bikeModelArrayList.add(new BikeModel("Surly", R.drawable.surly));
        bikeModelArrayList.add(new BikeModel("Super73", R.drawable.super73));
        bikeModelArrayList.add(new BikeModel("Tern", R.drawable.tern));
        bikeModelArrayList.add(new BikeModel("The Ride", R.drawable.the_ride));
        bikeModelArrayList.add(new BikeModel("Tower", R.drawable.tower));
        bikeModelArrayList.add(new BikeModel("Trek", R.drawable.trek));
        bikeModelArrayList.add(new BikeModel("Troxus", R.drawable.troxus));
        bikeModelArrayList.add(new BikeModel("Urban Arrow", R.drawable.urban_arrow));
        bikeModelArrayList.add(new BikeModel("Trek", R.drawable.trek));
        bikeModelArrayList.add(new BikeModel("Urtopia", R.drawable.urtopia));
        bikeModelArrayList.add(new BikeModel("Vanmoof", R.drawable.vanmoof));
        bikeModelArrayList.add(new BikeModel("Vello", R.drawable.vello));
        bikeModelArrayList.add(new BikeModel("Velotric", R.drawable.velotric));
        bikeModelArrayList.add(new BikeModel("VoltBike", R.drawable.voltbike));
        bikeModelArrayList.add(new BikeModel("Vvolt", R.drawable.vvolt));
        bikeModelArrayList.add(new BikeModel("Wallke Ebikes", R.drawable.wallke_ebikes));
        bikeModelArrayList.add(new BikeModel("Wing Bikes", R.drawable.wing_bikes));
        bikeModelArrayList.add(new BikeModel("Woom", R.drawable.woom));
        bikeModelArrayList.add(new BikeModel("Xtracycle", R.drawable.xtracycle));
        bikeModelArrayList.add(new BikeModel("Yamaha", R.drawable.yamaha));
        bikeModelArrayList.add(new BikeModel("Yuba", R.drawable.yuba));
        bikeModelArrayList.add(new BikeModel("Zooz", R.drawable.zooz));
        bikeModelArrayList.add(new BikeModel("Zugo Bike", R.drawable.zugo_bike));


        int numberOfColumns = 2;
        bikeRV.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        BikeAdapter adapter = new BikeAdapter(getActivity(),bikeModelArrayList);
        bikeRV.setAdapter(adapter);
        adapter.setClickListener(this);
        return root;
    }


    @Override
    public void onItemClick(View view, int position) {

        Intent intent=new Intent(getActivity(), WebViewActivity.class);

        switch (position){
            case 0:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p193_Hero-Lectro-Bikes-Company-Buy--Zugo--Electric-Cycles-online.html");
                break;
            case 1:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p196_Buy-Geekay-Bikes-Company-Electric-Cycles-online.html");
                break;
            case 2:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p210_Nibelimited-Bikes-Company-Buy--Zugo--Electric-Cycles-online.html");
                break;
            case 3:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/p194_SWAGTRON-Bikes-Company-Buy--Zugo--Electric-Cycles-online.html");
                break;
            case 4:intent.putExtra("Website Link", "https://electriccycle.online/contents/en-us/d1002_Buy-Addmotor-Electric-Cycles-online.html");
                break;
            case 5:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1003_Buy-Ancheer-Electric-Cycles-online.html");
                break;
            case 6:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1004_Buy-Amego-Electric-Cycles-online.html");
                break;
            case 7:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1005_Buy-Aostirmotor-Electric-Cycles-online.html");
                break;
            case 8:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1006_Buy-Ariel-Rider-Electric-Cycles-online.html");
                break;
            case 9:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1007_Buy-Aventon-Electric-Cycles-online.html");
                break;
            case 10:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1008_Buy-Batch-Electric-Cycles-online.html");
                break;
            case 11:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1009_Buy-Bee-Cool-Bikes-Electric-Cycles-online.html");
                break;
            case 12:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1010_Buy-Benelli-Electric-Cycles-online.html");
                break;
            case 13:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1011_Buy-Benno-Electric-Cycles-online.html");
                break;
            case 14:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1012_Buy-BESV-Electric-Cycles-online.html");
                break;
            case 15:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1013_Buy-BH-Bikes-Electric-Cycles-online.html");
                break;
            case 16:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1014_Buy-Big-Cat-Electric-Cycles-online.html");
                break;
            case 17:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1015_Buy-Biktrix-Electric-Cycles-online.html");
                break;
            case 18:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1016_Buy-Bintelli-Electric-Cycles-online.html");
                break;
            case 19:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1017_Buy-Biomega-Electric-Cycles-online.html");
                break;
            case 20:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1018_Buy-Biria-Electric-Cycles-online.html");
                break;
            case 21:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1019_Buy-Blix-Electric-Cycles-online.html");
                break;
            case 22:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1020_Buy-BMEBIKES-Electric-Cycles-online.html");
                break;
            case 23:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1021_Buy-Bolton-Electric-Bikes-Electric-Cycles-online.html");
                break;
            case 24:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1022_Buy-BPM-Imports-Electric-Cycles-online.html");
                break;
            case 25:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1023_Buy-Brompton-Electric-Cycles-online.html");
                break;
            case 26:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1024_Buy-Bulls-Electric-Cycles-online.html");
                break;
            case 27:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1025_Buy-Bunch-Bikes-Electric-Cycles-online.html");
                break;
            case 28:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1026_Buy-Butchers--Bicycles-Electric-Cycles-online.html");
                break;
            case 29:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1027_Buy-Buzz-Bikes-Electric-Cycles-online.html");
                break;
            case 30:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1028_Buy-California-Bicycle-Factory-Electric-Cycles-online.html");
                break;
            case 31:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1029_Buy-Cannondale-Electric-Cycles-online.html");
                break;
            case 32:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1030_Buy-Cero-Electric-Cycles-online.html");
                break;
            case 33:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1031_Buy-Charge-Bikes-Electric-Cycles-online.html");
                break;
            case 34:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1032_Buy-Civia-Electric-Cycles-online.html");
                break;
            case 35:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1033_Buy-Cobac-Electric-Cycles-online.html");
                break;
            case 36:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1034_Buy-Co-Op-(REI-brand)-Electric-Cycles-online.html");
                break;
            case 37:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1035_Buy-Corratec-Electric-Cycles-online.html");
                break;
            case 38:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1036_Buy-Cube-Electric-Cycles-online.html");
                break;
            case 39:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1037_Buy-Cyrusher-Electric-Cycles-online.html");
                break;
            case 40:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1038_Buy-DAY-6-Electric-Cycles-online.html");
                break;
            case 41:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1039_Buy-Desiknio-Electric-Cycles-online.html");
                break;
            case 42:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1040_Buy-DJ-Bikes-Electric-Cycles-online.html");
                break;
            case 43:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1041_Buy-Doheny-Electric-Cycles-online.html");
                break;
            case 44:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1042_Buy-D%C5%8CST-Bikes-Electric-Cycles-online.html");
                break;
            case 45:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1043_Buy-DYU-Electric-Cycles-online.html");
                break;
            case 46:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1044_Buy-Eahora-Electric-Cycles-online.html");
                break;
            case 47:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1045_Buy-EccoBike-Electric-Cycles-online.html");
                break;
            case 48:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1046_Buy-EcoMotion-Bikes-Electric-Cycles-online.html");
                break;
            case 49:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1047_Buy-Ecotric-Electric-Cycles-online.html");
                break;
            case 50:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1048_Buy-E-Glide-Electric-Cycles-online.html");
                break;
            case 51:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1049_Buy-e-JOE-Bike-Electric-Cycles-online.html");
                break;
            case 52:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1050_Buy-Elby-Electric-Cycles-online.html");
                break;
            case 53:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1051_Buy-Electra-Electric-Cycles-online.html");
                break;
            case 54:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1052_Buy-Electric-Bike-Company-Electric-Cycles-online.html");
                break;
            case 55:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1053_Buy-Electric-Fat-Bike-Company-Electric-Cycles-online.html");
                break;
            case 56:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1054_Buy-Electric-Bike-Technologies-Electric-Cycles-online.html");
                break;
            case 57:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1055_Buy-E-Lux-Electric-Bikes-Electric-Cycles-online.html");
                break;
            case 58:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1056_Buy-Emojo-Electric-Cycles-online.html");
                break;
            case 59:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1057_Buy-Energie-Cycles-Electric-Cycles-online.html");
                break;
            case 60:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1058_Buy-Enzo-eBikes-Electric-Cycles-online.html");
                break;
            case 61:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1059_Buy-eProdigy-Electric-Cycles-online.html");
                break;
            case 62:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1060_Buy-Espin-Electric-Cycles-online.html");
                break;
            case 63:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1061_Buy-ET.Cycle-Electric-Cycles-online.html");
                break;
            case 64:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1062_Buy-Eunorau-Electric-Cycles-online.html");
                break;
            case 65:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1063_Buy-Euphree-Electric-Cycles-online.html");
                break;
            case 66:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1064_Buy-EVELO-Electric-Cycles-online.html");
                break;
            case 67:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1065_Buy-EVO-Electric-Cycles-online.html");
                break;
            case 68:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1066_Buy-EZ-Pedaler-Electric-Cycles-online.html");
                break;
            case 69:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1067_Buy-Fantic-Electric-Cycles-online.html");
                break;
            case 70:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1068_Buy-Faraday-Electric-Cycles-online.html");
                break;
            case 71:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1069_Buy-Felt-Electric-Cycles-online.html");
                break;
            case 72:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1070_Buy-Fiido-Electric-Cycles-online.html");
                break;
            case 73:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1071_Buy-Flash-Electric-Cycles-online.html");
                break;
            case 74:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1072_Buy-FLX-Ebikes-Electric-Cycles-online.html");
                break;
            case 75:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1073_Buy-Focus-Electric-Cycles-online.html");
                break;
            case 76:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1074_Buy-Fuji-Electric-Cycles-online.html");
                break;
            case 77:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1075_Buy-Furo-Systems-Electric-Cycles-online.html");
                break;
            case 78:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1076_Buy-Gazelle-Electric-Cycles-online.html");
                break;
            case 79:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1077_Buy-Genze-Electric-Cycles-online.html");
                break;
            case 80:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1078_Buy-Gepida-Electric-Cycles-online.html");
                break;
            case 81:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1079_Buy-Ghost-Electric-Cycles-online.html");
                break;
            case 82:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1080_Buy-Giant-Electric-Cycles-online.html");
                break;
            case 83:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1081_Buy-Gocycle-Electric-Cycles-online.html");
                break;
            case 84:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1082_Buy-GoTrax-Electric-Cycles-online.html");
                break;
            case 85:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1083_Buy-Go-Power-Electric-Cycles-online.html");
                break;
            case 86:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1084_Buy-Gyroor-Electric-Cycles-online.html");
                break;
            case 87:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1085_Buy-Haibike-Electric-Cycles-online.html");
                break;
            case 88:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1086_Buy-Haoqi-Electric-Cycles-online.html");
                break;
            case 89:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1087_Buy-Haro-Electric-Cycles-online.html");
                break;
            case 90:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1088_Buy-Heybike-Electric-Cycles-online.html");
                break;
            case 91:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1089_Buy-Hilltopper-Electric-Cycles-online.html");
                break;
            case 92:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1090_Buy-Himiway-Electric-Cycles-online.html");
                break;
            case 93:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1091_Buy-Honbike-Electric-Cycles-online.html");
                break;
            case 94:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1092_Buy-HPC-Electric-Cycles-online.html");
                break;
            case 95:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1093_Buy-HP-Velotechnik-Electric-Cycles-online.html");
                break;
            case 96:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1094_Buy-Husqvarna-Bicycles-Electric-Cycles-online.html");
                break;
            case 97:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1095_Buy-iGO-Electric-Cycles-online.html");
                break;
            case 98:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1096_Buy-IZIP-Electric-Cycles-online.html");
                break;
            case 99:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1097_Buy-Jetson-Electric-Cycles-online.html");
                break;
            case 100:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1098_Buy-Juiced-Bikes-Electric-Cycles-online.html");
                break;
            case 101:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1099_Buy-Junto-Electric-Cycles-online.html");
                break;
            case 102:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1100_Buy-JupiterBikes-Electric-Cycles-online.html");
                break;
            case 103:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1101_Buy-Kalkhoff-Electric-Cycles-online.html");
                break;
            case 104:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1102_Buy-KBO-Electric-Cycles-online.html");
                break;
            case 105:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1103_Buy-Kona-Electric-Cycles-online.html");
                break;
            case 106:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1104_Buy-Kuake-Electric-Cycles-online.html");
                break;
            case 107:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1105_Buy-Lapierre-Electric-Cycles-online.html");
                break;
            case 108:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1106_Buy-Lemond-Electric-Cycles-online.html");
                break;
            case 109:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1107_Buy-Liberty-Trike-Electric-Cycles-online.html");
                break;
            case 110:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1108_Buy-Life-EV-Electric-Cycles-online.html");
                break;
            case 111:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1109_Buy-Liv-Electric-Cycles-online.html");
                break;
            case 112:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1110_Buy-Luna-Cycle-Electric-Cycles-online.html");
                break;
            case 113:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1111_Buy-M1-Sporttechnik-Electric-Cycles-online.html");
                break;
            case 114:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1112_Buy-Macwheel-Electric-Cycles-online.html");
                break;
            case 115:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1113_Buy-Magnum-Electric-Cycles-online.html");
                break;
            case 116:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1114_Buy-Magicycle-Electric-Cycles-online.html");
                break;
            case 117:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1115_Buy-Maxfoot-Electric-Bike-Electric-Cycles-online.html");
                break;
            case 118:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1116_Buy-Metakoo-Electric-Cycles-online.html");
                break;
            case 119:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1117_Buy-M2S-Bikes-Electric-Cycles-online.html");
                break;
            case 120:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1118_Buy-Mod-Bikes-Electric-Cycles-online.html");
                break;
            case 121:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1119_Buy-Mokwheel-Electric-Cycles-online.html");
                break;
            case 122:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1120_Buy-Mondraker-Electric-Cycles-online.html");
                break;
            case 123:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1121_Buy-Montague-Electric-Cycles-online.html");
                break;
            case 124:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1122_Buy-Motiv-Electric-Cycles-online.html");
                break;
            case 125:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1123_Buy-Moustache-Bikes-Electric-Cycles-online.html");
                break;
            case 126:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1124_Buy-Nakto-Electric-Cycles-online.html");
                break;
            case 127:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1125_Buy-Ness-Electric-Cycles-online.html");
                break;
            case 128:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1126_Buy-Nicolai-Bikes-Electric-Cycles-online.html");
                break;
            case 129:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1127_Buy-NCM-Electric-Cycles-online.html");
                break;
            case 130:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1128_Buy-OHM-Electric-Cycles-online.html");
                break;
            case 131:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1129_Buy-Optibike-Electric-Cycles-online.html");
                break;
            case 132:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1130_Buy-Opus-Electric-Cycles-online.html");
                break;
            case 133:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1131_Buy-Orbea-Electric-Cycles-online.html");
                break;
            case 134:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1132_Buy-Outrider-Electric-Cycles-online.html");
                break;
            case 135:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1133_Buy-Oyama-Electric-Cycles-online.html");
                break;
            case 136:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1134_Buy-Paselec-Electric-Cycles-online.html");
                break;
            case 137:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1135_Buy-Pedego-Electric-Bikes-Electric-Cycles-online.html");
                break;
            case 138:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1136_Buy-Pegasus-Electric-Cycles-online.html");
                break;
            case 139:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1137_Buy-Piaggio-Electric-Cycles-online.html");
                break;
            case 140:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1138_Buy-Pivot-Cycles-Electric-Cycles-online.html");
                break;
            case 141:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1139_Buy-Polarna-Electric-Cycles-online.html");
                break;
            case 142:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1140_Buy-Populo-Electric-Cycles-online.html");
                break;
            case 143:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1141_Buy-Priority-Bicycles-Electric-Cycles-online.html");
                break;
            case 144:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1142_Buy-ProdecoTech-Electric-Cycles-online.html");
                break;
            case 145:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1143_Buy-Propella-Electric-Cycles-online.html");
                break;
            case 146:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1144_Buy-Pure-Cycles-Electric-Cycles-online.html");
                break;
            case 147:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1145_Buy-Qualisports-Electric-Cycles-online.html");
                break;
            case 148:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1146_Buy-QuietKat-Electric-Cycles-online.html");
                break;
            case 149:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1147_Buy-Rad-Power-Bikes-Electric-Cycles-online.html");
                break;
            case 150:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1148_Buy-Raleigh-Electric-Cycles-online.html");
                break;
            case 151:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1149_Buy-Rambo-Bikes-Electric-Cycles-online.html");
                break;
            case 152:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1150_Buy-Rattan-Electric-Cycles-online.html");
                break;
            case 153:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1151_Buy-Retrospec-Electric-Cycles-online.html");
                break;
            case 154:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1152_Buy-Revelo-Electric-Cycles-online.html");
                break;
            case 155:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1153_Buy-Revolve-Electric-Cycles-online.html");
                break;
            case 156:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1154_Buy-Ride1Up-Electric-Cycles-online.html");
                break;
            case 157:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1155_Buy-Ride-Scoozy-Electric-Cycles-online.html");
                break;
            case 158:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1156_Buy-Riese--Mueller-Electric-Cycles-online.html");
                break;
            case 159:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1157_Buy-Rize-Bikes-Electric-Cycles-online.html");
                break;
            case 160:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1158_Buy-Rocky-Mountain-Electric-Cycles-online.html");
                break;
            case 161:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1159_Buy-Schwinn-Electric-Cycles-online.html");
                break;
            case 162:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1160_Buy-Scott-Electric-Cycles-online.html");
                break;
            case 163:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1161_Buy-Smartmotion-Electric-Cycles-online.html");
                break;
            case 164:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1162_Buy-Sondors-Electric-Cycles-online.html");
                break;
            case 165:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1163_Buy-Soul-Beach-Cruisers-Electric-Cycles-online.html");
                break;
            case 166:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1164_Buy-Specialized-Electric-Cycles-online.html");
                break;
            case 167:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1165_Buy-Stealth-Electric-Bikes-Electric-Cycles-online.html");
                break;
            case 168:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1166_Buy-Stromer-Electric-Cycles-online.html");
                break;
            case 169:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1167_Buy-Surface604-Electric-Cycles-online.html");
                break;
            case 170:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1168_Buy-Surly-Electric-Cycles-online.html");
                break;
            case 171:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1169_Buy-Super73-Electric-Cycles-online.html");
                break;
            case 172:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1170_Buy-Tern-Electric-Cycles-online.html");
                break;
            case 173:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1171_Buy-The-Ride-Electric-Cycles-online.html");
                break;
            case 174:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1172_Buy-Tower-Electric-Cycles-online.html");
                break;
            case 175:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1173_Buy-Trek-Electric-Cycles-online.html");
                break;
            case 176:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1174_Buy-Troxus-Electric-Cycles-online.html");
                break;
            case 177:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1175_Buy-Turboant-Electric-Cycles-online.html");
                break;
            case 178:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1176_Buy-Urban-Arrow-Electric-Cycles-online.html");
                break;
            case 179:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1177_Buy-Urtopia-Electric-Cycles-online.html");
                break;
            case 180:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1178_Buy-Vanmoof-Electric-Cycles-online.html");
                break;
            case 181:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1179_Buy-Vello-Electric-Cycles-online.html");
                break;
            case 182:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1180_Buy-Velotric-Electric-Cycles-online.html");
                break;
            case 183:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1181_Buy-VoltBike-Electric-Cycles-online.html");
                break;
            case 184:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1182_Buy-Vvolt-Electric-Cycles-online.html");
                break;
            case 185:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1183_Buy-Wallke-Ebikes-Electric-Cycles-online.html");
                break;
            case 186:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1184_Buy-Wing-Bikes-Electric-Cycles-online.html");
                break;
            case 187:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1185_Buy-Woom-Electric-Cycles-online.html");
                break;
            case 188:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1186_Buy-Xtracycle-Electric-Cycles-online.html");
                break;
            case 189:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1187_Buy-Yamaha-Electric-Cycles-online.html");
                break;
            case 190:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1188_Buy-Yuba-Electric-Cycles-online.html");
                break;
            case 191:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1189_Buy-Zooz-Electric-Cycles-online.html");
                break;
            case 192:intent.putExtra("Website Link","https://electriccycle.online/contents/en-us/d1190_Buy-Zugo-Bike-Electric-Cycles-online.html");
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }

        startActivity(intent);
    }

    private void getLastLocation() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location !=null){
                                Geocoder geocoder=new Geocoder(getActivity(), Locale.getDefault());
                                List<Address> addresses= null;
                                try {
                                    addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                                    loaction_text.setText(addresses.get(0).getAddressLine(0));
//                                    city.setText("City :"+addresses.get(0).getLocality());
//                                    country.setText("Country :"+addresses.get(0).getCountryName());

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }



                            }

                        }
                    });


        }else
        {

            askPermission();

        }
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(getActivity(), new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode==REQUEST_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }
            else {
                Toast.makeText(getActivity(), "Required Permission", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}