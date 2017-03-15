package ignite.anand.abhishek.phoenixhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                    startActivity(new Intent(getApplicationContext(), Team_Number.class));
                    finish();

                } catch (Exception e) {
                }
            }
        };
        background.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
