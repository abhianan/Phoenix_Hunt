package ignite.anand.abhishek.phoenixhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Abhishek on 04-03-2017.
 */

public class Treasure extends AppCompatActivity {
    private Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treasure);
        b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button5);
        b3=(Button)findViewById(R.id.button6);
        b4=(Button)findViewById(R.id.button7);
        b5=(Button)findViewById(R.id.button8);

        //----------------------------------------------------------------------------------------------------------------------------

        int [][]team_seq={{1,3,5,7,9},{2,4,6,8,10},{3,5,7,9,11},{4,6,8,10,12},{5,7,9,11,13},{6,8,10,12,14},{7,9,11,13,15},
                {8,10,12,14,16},{9,11,13,15,17},{10,13,16,19,2},{11,14,17,20,3},{12,15,18,1,4},{13,16,19,2,5},{14,17,20,3,6},
                {15,18,1,4,19},{16,20,4,6,18},{17,1,2,5,8},{18,2,3,16,1},{19,12,15,18,20},{20,19,14,17,7},{9,7,5,3,1},{10,8,6,4,2},
                {11,9,7,5,3},{12,10,8,6,4},{13,11,9,7,5},{14,12,10,8,6},{15,13,11,9,7},{16,14,12,10,8},{17,15,13,11,9},
                {2,19,16,13,10},{3,20,17,14,11},{4,1,18,15,12},{5,2,19,16,13},{6,3,20,17,14},{19,4,1,18,15},{18,6,4,20,16},
                {8,5,2,1,17},{1,16,3,2,18},{20,18,15,12,19},{7,17,14,19,20}};
//-------------------------------------------------------------------------------------------------------------------------------

        Intent i1=getIntent();
        int get_team = i1.getIntExtra("teamno", 0);
        final int[] team_get_seq=team_seq[get_team-1];

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), Link_View.class);
                i.putExtra("getlink",team_get_seq[0]-1);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), Link_View.class);
                i.putExtra("getlink",team_get_seq[1]-1);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), Link_View.class);
                i.putExtra("getlink",team_get_seq[2]-1);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), Link_View.class);
                i.putExtra("getlink",team_get_seq[3]-1);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), Link_View.class);
                i.putExtra("getlink",team_get_seq[4]-1);
                startActivity(i);
            }
        });

    }
}
