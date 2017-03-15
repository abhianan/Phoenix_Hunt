package ignite.anand.abhishek.phoenixhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;

/**
 * Created by Abhishek on 01-03-2017.
 */

public class Link_View extends AppCompatActivity {
    private Button click;
    Barcode barcodeResult;
    final String []barcodeval={"http://q-r.to/bajaZ0","http://q-r.to/bajaYs","http://q-r.to/bajaYd","http://q-r.to/bajGyl",
            "http://q-r.to/bajGyp","http://q-r.to/bajaYS","http://q-r.to/bajaae","http://q-r.to/bajGz7",
            "http://q-r.to/bajaYF","http://q-r.to/bajGzG","http://q-r.to/bajGzJ","http://q-r.to/bajaWi",
            "http://q-r.to/bajGzU","http://q-r.to/bajGza","http://q-r.to/bajGzf","http://q-r.to/bajawX",
            "http://q-r.to/bajaHU","http://q-r.to/bajGzt","http://q-r.to/bajGzz","http://q-r.to/bajH04"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_view);
        click=(Button)findViewById(R.id.button2);

        Intent i1=getIntent();
        int getval = i1.getIntExtra("getlink", 0);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setVerticalScrollBarEnabled(true);
        myWebView.setHorizontalScrollBarEnabled(true);
        myWebView .requestFocusFromTouch();
        myWebView .getSettings().setJavaScriptEnabled(true);
        myWebView .getSettings().setUseWideViewPort(true);
        myWebView .getSettings().setLoadWithOverviewMode(true);
        myWebView .getSettings().setBuiltInZoomControls(true);

        myWebView.loadUrl(barcodeval[getval]);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScan();
            }
        });
    }
    private void startScan() {
        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(Link_View.this)
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withBackfacingCamera()
                .withText("Scanning...")
                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {
                        barcodeResult = barcode;
                        Intent i2=getIntent();
                        int getval = i2.getIntExtra("getlink", 0);
                        if(barcodeval[getval].equals(barcodeResult.rawValue)){
                            Intent i =new Intent(getApplicationContext(), Question.class);
                            i.putExtra("getlink",getval);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Wrong QR",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .build();
        materialBarcodeScanner.startScan();
    }
}
