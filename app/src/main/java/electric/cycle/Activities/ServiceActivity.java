package electric.cycle.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import electric.cycle.R;

public class ServiceActivity extends AppCompatActivity {

    TextView price,packages,service_type;
    Button bookService;
    ImageView serviceImg;
    final int UPI_PAYMENT = 0;
    String charges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        getSupportActionBar().hide();

        String Type=getIntent().getStringExtra("Type");

        service_type=findViewById(R.id.service_type);
        packages=findViewById(R.id.packages);
        price=findViewById(R.id.price);
        bookService=findViewById(R.id.bookService);
        serviceImg=findViewById(R.id.serviceImg);

        service_type.setText(Type);

        if(Type.equals("Kids Cycle")){
            price.setText("Rs 649.00");
            serviceImg.setBackgroundResource(R.drawable.kids_cycle_service);
            packages.setText("\u2713  Right saddle height\n" +
                    "\u2713  Tyre pressure\n" +
                    "\u2713  Inspect Brake, Spokes, Pedals, Tyres\n" +
                    "\u2713  Inspect Chain, Frame\n" +
                    "\u2713  True Wheel\n" +
                    "\u2713  Inspect Bell, Light\n" +
                    "\u2713  Fix flat Tyre/Tube\n" +
                    "\u2713  Tighten the Nuts, Bolts\n" +
                    "\u2713  Brake pas assessment for safety\n" +
                    "\u2713  Lubricate all moving parts\n" +
                    "\u2713  Inspect Gear function\n" +
                    "\u2713  Wipe the cycle");
            charges="649.00";

        }
        else if(Type.equals("Non-Gear Cycle")){
            price.setText("Rs 699.00");
            serviceImg.setBackgroundResource(R.drawable.non_gear_service);
            packages.setText("\u2713  Check the tyres and inflate it to correct PSI\n" +
                    "\u2713  Tighten the Nuts & Bolts and True Wheel & Tension\n" +
                    "\u2713  Brake pad inspection and change if necessary\n" +
                    "\u2713  Fix flat Tyre/Tube\n" +
                    "\u2713  True Wheel/Tension\n" +
                    "\u2713  Brake pad assessment for safety\n" +
                    "\u2713  Check Bearings/Lube Cables and Chain\n" +
                    "\u2713  Test ride by the engineer");
            charges="699.00";
        }
        else if(Type.equals("Gear Cycle")){
            price.setText("Rs 849.00");
            serviceImg.setBackgroundResource(R.drawable.gear_cycle_service);
            packages.setText("\u2713  Check the tyres and inflate it to correct PSI\n" +
                    "\u2713  Tighten the Nuts & Bolts and True Wheel & Tension\n" +
                    "\u2713  Brake pad inspection and change if necessary\n" +
                    "\u2713  Check Bearings/Lube Cables and Chain\n" +
                    "\u2713  Brake and derailleur levers, Cables and assemblies\n" +
                    "\u2713  Gear tuning\n" +
                    "\u2713  Test ride by the engineer");
            charges="849.00";

        }
        else if(Type.equals("Assemble New Cycle")){
            price.setText("Rs 799.00");
            serviceImg.setBackgroundResource(R.drawable.assemble_cycle_service);
            packages.setText("\u2713  Assemble a cycle");
            charges="799.00";

        }
        else if(Type.equals("e-Bike")){
            price.setText("Rs 999.00");
            serviceImg.setBackgroundResource(R.drawable.e_bike_service);
            packages.setText("\u2713  Inspect electric motor, Battery\n" +
                    "\u2713  True Wheel, Tension\n" +
                    "\u2713  Inspect the Brake Pads/Disc brakes and tighten the Bolts and safety check\n" +
                    "\u2713  Drivetrain cleaning, Cranks, cassette and gears\n" +
                    "\u2713  Check Bearings/Lube cables and chain\n" +
                    "\u2713  Inspect Fork, Suspension\n" +
                    "\u2713  Test ride by the engineer");
            charges="999.00";

        }
        else{
            price.setText("Rs 1299.00");
            serviceImg.setBackgroundResource(R.drawable.imported_cycle_service);
            packages.setText("\u2713  Check and tightening all the screws,bolts, lube chain and cables\n" +
                    "\u2713  Gear tune up and hubs checkup\n" +
                    "\u2713  Alignment of headset and bottom bracket checkup\n" +
                    "\u2713  Check and adjust the brakes\n" +
                    "\u2713  Check the tyres and inflate it to right pressure\n" +
                    "\u2713  Truing wheel\n" +
                    "\u2713  Inspect and lubricate Chain & cables");
            charges="1299.00";
        }

        bookService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payUsingUpi("Electric Cycle", "247helpdesk@ibl", "Book your service", charges);

            }
        });
    }
    private void payUsingUpi(String name,String upiId, String note, String amount) {
        Log.e("main ", "name "+name +"--up--"+upiId+"--"+ note+"--"+amount);
        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();


        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

        if(null != chooser.resolveActivity(getApplicationContext().getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(getApplicationContext(),"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("main ", "response "+resultCode );

        switch (requestCode) {
            case UPI_PAYMENT:
                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                    if (data != null) {
                        String trxt = data.getStringExtra("response");
                        Log.e("UPI", "onActivityResult: " + trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    } else {
                        Log.e("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                } else {
                    //when user simply back without payment
                    Log.e("UPI", "onActivityResult: " + "Return data is null");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(getApplicationContext())) {
            String str = data.get(0);
            Log.e("UPIPAY", "upiPaymentDataOperation: "+str);
            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if(equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    }
                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                }
                else {
                    paymentCancel = "Payment cancelled by user.";
                }
            }

            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(getApplicationContext(), "Transaction successful.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "payment successfull: "+approvalRefNo);
            }
            else if("Payment cancelled by user.".equals(paymentCancel)) {
                Toast.makeText(getApplicationContext(), "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "Cancelled by user: "+approvalRefNo);

            }
            else {
                Toast.makeText(getApplicationContext(), "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "failed payment: "+approvalRefNo);

            }
        } else {
            Log.e("UPI", "Internet issue: ");

            Toast.makeText(getApplicationContext(), "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}