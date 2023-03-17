package electric.cycle.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import electric.cycle.Activities.ServiceActivity;
import electric.cycle.R;
import electric.cycle.SliderAdapter;
import electric.cycle.SliderData;

public class SellFragment extends Fragment {

    ImageView imported_bicycle,e_bike,assemble_cycle,gear_cycle,non_gear,kids_cycle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_sell, container, false);

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = root.findViewById(R.id.slider);
        sliderDataArrayList.add(new SliderData(R.drawable.ec3));
        sliderDataArrayList.add(new SliderData(R.drawable.ec2));
        sliderDataArrayList.add(new SliderData(R.drawable.ec1));
        SliderAdapter adapter = new SliderAdapter(getActivity(), sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(5);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        imported_bicycle=root.findViewById(R.id.imported_bicycle);
        e_bike=root.findViewById(R.id.e_bike);
        assemble_cycle=root.findViewById(R.id.assemble_cycle);
        gear_cycle=root.findViewById(R.id.gear_cycle);
        non_gear=root.findViewById(R.id.non_gear);
        kids_cycle=root.findViewById(R.id.kids_cycle);

        kids_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ServiceActivity.class);
                intent.putExtra("Type","Kids Cycle");
                startActivity(intent);
            }
        });
        non_gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ServiceActivity.class);
                intent.putExtra("Type","Non-Gear Cycle");
                startActivity(intent);
            }
        });
        gear_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ServiceActivity.class);
                intent.putExtra("Type","Gear Cycle");
                startActivity(intent);
            }
        });
        assemble_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ServiceActivity.class);
                intent.putExtra("Type","Assemble New Cycle");
                startActivity(intent);
            }
        });
        e_bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ServiceActivity.class);
                intent.putExtra("Type","e-Bike");
                startActivity(intent);
            }
        });
        imported_bicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ServiceActivity.class);
                intent.putExtra("Type","Imported Bicycle");
                startActivity(intent);
            }
        });


        return root;
    }
}