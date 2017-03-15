package ignite.anand.abhishek.phoenixhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Abhishek on 04-03-2017.
 */

public class Question extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;

    public TextView tv;

    private Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        radioButton1=(RadioButton)findViewById(R.id.radioButton1);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioButton3=(RadioButton)findViewById(R.id.radioButton3);
        radioButton4=(RadioButton)findViewById(R.id.radioButton4);

        tv=(TextView)findViewById(R.id.textView2);
        Intent i1=getIntent();
        int get_quest = i1.getIntExtra("getlink", 0);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String [][]questions={{"In which decade was the American Institute of Electrical Engineers(AIEE) founded","1880s","1850s","1880s","1930s","1950s"},
        {"What is part of a Database that holds only one type of information?","Field","Report","Field","Record","File"},
        {"In which decade did the first transatlantic radio broadcast occur?","1900s","1850s","1860s","1870s","1900s"},
        {".MOV extension refers usually to what kind of file?","Animation/Movie File","Image File","Animation/Movie File","Audio File","MS Office File"},
        {"Which is a type of Electrically_Erasable Proramable Read-Only Memory","Flash","Flash","Flange","Fury","FRAM"},
        {"The purpose of choke in tube light is?","To increase the Voltage momentarily","To decrease the current","To increase the current","To decrease the voltage momentarily","To increase the Voltage momentarily"},
        {".MPG extension refers usually to what kind of file","Animation/Movie File","WordPerfect Document file","MS Office document","Animation/Movie File","Image File"},
        {"Who is largely responsible for breaking the German Enigma codes, created a test that provided a foundation for artificial intelligence","Alan Turing","Alan Turing","Jeff Bezos","George Boole","Charles Babbage"},
        {"Who developed Yahoo!?","David Filo and Jerry Yang","Dennis Ritchie and Ken Thompson","David Filo and Jerry Yang","Vint Cerf and Robert Kahn","Steve Case and Jeff Bezos"},
        {"The most common format for a home video recorder is VHS. VHS stands for...?","Video Home System","Video Home System","Very High Speed","Video Horizontal Standard","Voltage House Standard"},
        {"What does VVVF stand for?","Variable Voltage Variable Frequency","Variant Voltage Vile Frequency","Variable Velocity Variable Fun","Very Very Vicious Frequency","Variable Voltage Variable Frequency"},
        {"The first step to getting output from a laser is to excite an active medium. What is this process called","Pumping","Pumping","Exciting","Priming","Raising"},
        {"What does the term PLC stand for?","Programmable Logic Controller","Programmable Lift Computer","Program List Control","Programmable Logic Controller","Piezo Lamp Connector"},
        {"In which year was MIDI(Musical Instrument Digital Interface) introduced?","1983","1987","1983","1973","1977"},
        {".INI extension usually refers to what kind of file?","System File","Image File","System File","Hypertext File","Image Color Matching Profile file"},
        {"http://www.indiabix.com - is an example of what?","An URL","An URL","An access code","A directory","A server"},
        {"What is an FET","Field Effect Transistor","Farad Effect Transformer","Field Effect Transformer","Field Effect Transistor","French Energy Transfer"},
        {"The letters, 'DOS' Stand for...","Disk Operating System","Data Out System","Disk Out System","Disk Operating System","Data Operating System"},
        {"A JPG is","A format for an image file","A Jumper Programmed Graphic","A format for an image file","A Type of hard disk","A unit of measure for memory"},
        {"Hardware devices that are not part of the main computer system and are often added later to the system","Peripheral","Peripheral","Clip Art","Highlight","Execute"}};
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        tv.setText(questions[get_quest][0]);
        radioButton1.setText(questions[get_quest][2]);
        radioButton2.setText(questions[get_quest][3]);
        radioButton3.setText(questions[get_quest][4]);
        radioButton4.setText(questions[get_quest][5]);
//        Toast.makeText(getApplicationContext(),questions[get_quest][1] ,Toast.LENGTH_LONG).show();

//---------------------------------------------------------------------------------------------------
//        JSONParser parser = new JSONParser();
//        try{
//            Object obj = parser.parse(new FileReader(
//                    "question.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//            JSONArray opt = (JSONArray) jsonObject.get("Q0");
//
//            radioButton1.setText(String.valueOf(opt.get(2)));
//            radioButton2.setText(opt.get(3).toString());
//            radioButton3.setText(opt.get(4).toString());
//            radioButton4.setText(opt.get(5).toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        tv.setText("Abhi");
//----------------------------------------------------------------------------------------------------------------------

        go=(Button)findViewById(R.id.button3);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected=radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton)findViewById(selected);
                Intent i2 = getIntent();
                int get_quest = i2.getIntExtra("getlink", 0)+1;

                if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getBaseContext(), "Enter Your Choice",
                            Toast.LENGTH_SHORT).show();
                }else {
                String gettext=(String)radioButton.getText();
                    try {
                        String path = "/sdcard/" + get_quest + ".txt";
                        File myFile = new File(path);
                        myFile.createNewFile();
                        FileOutputStream fOut = new FileOutputStream(myFile);
                        OutputStreamWriter myOutWriter =
                                new OutputStreamWriter(fOut);
                        myOutWriter.append(gettext);
                        myOutWriter.close();
                        fOut.close();
                        Intent i = new Intent(getApplicationContext(), Team_Number.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
