package electric.cycle.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import electric.cycle.R;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    String Link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        getSupportActionBar().hide();

        ImageView back_arrow=findViewById(R.id.back);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        LinearLayout sanatan_link=findViewById(R.id.website_link);
//        sanatan_link.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(), WebViewActivity.class);
//                intent.putExtra("Website Link","https://electriccycle.online/");
//                startActivity(intent);
//            }
//        });

        webView=findViewById(R.id.webView);

        Link= getIntent().getStringExtra("Website Link");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(Link);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setDomStorageEnabled(true);
    }
}