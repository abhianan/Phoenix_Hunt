package ignite.anand.abhishek.phoenixhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Abhishek on 01-03-2017.
 */

public class Team_Number extends AppCompatActivity {
    private Button click;
    private EditText teamNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_number);
        click = (Button) findViewById(R.id.button);
        teamNo = (EditText) findViewById(R.id.editText);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String team=teamNo.getText().toString();
                if(team.matches("")) {
                    Toast.makeText(getApplicationContext(),"Please Enter Your Team No." ,Toast.LENGTH_LONG).show();
                }else if(Integer.parseInt(team)<1 || Integer.parseInt(team)>40){
                    Toast.makeText(getApplicationContext(),"Please Enter a Valid Team No." ,Toast.LENGTH_LONG).show();
                }
                else {
                    int teamval = Integer.parseInt(team);
                    Intent i = new Intent(getApplicationContext(), Treasure.class);
                    i.putExtra("teamno", teamval);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            }
        });
    }
}
