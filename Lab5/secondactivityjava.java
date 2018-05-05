package org.example.lab5;

import android.app.Activity;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by GiancarloDesktop on 2/25/2018.
 */

public class secondactivityjava extends AppCompatActivity{

    private Handler myHandler=new Handler();

    private Runnable mRunnalbe=new Runnable() {
        @Override
        public void run() {
            if(counter>=10)
            {
                textView.setText(titleArray[0]);
                textview2.setText(descriptionArray[0]);
                images.setImageResource(ImagesArray[0]);
            }
            else{
                textView.setText(titleArray[counter]);
                textview2.setText(descriptionArray[counter]);
                images.setImageResource(ImagesArray[counter]);
                myHandler.postDelayed(mRunnalbe,progress);
                counter++;
            }
        }
    };

    String titleArray[]=new String[]{"10. India", "9. Turkey", "8. Thailand", "7. New Zealand", "6. Australia","5. Greece",
    "4. America", "3. Spain","2. France","1. Italy"};

    String descriptionArray[]=new String[]{"Shampooing is an Indian concept","Turkey has one of the worlds oldest and biggest malls","Thailand was never colonised","The official languages of New Zeland are English and Maori",
            "Australia is as wide as the distance between London to Moscow","Greece is beautiful but is also the most in debt","In America we sell enough pizza every day to cover 100 acres","The currency of spain is Euro","France is the worlds most popular tourist destination","Italy has the best restaurant in the world: Osteria Francescana"};

    Integer ImagesArray[]={R.drawable.ind,R.drawable.turk,R.drawable.thai,R.drawable.newland,R.drawable.aus,R.drawable.gree,R.drawable.ame,R.drawable.spa,R.drawable.fran,R.drawable.ital};
    int counter=0;
    Timer timer;
    int mainCount=0;

    TextView textView;
    TextView textview2;
    ImageView images;
    int progress;//contains the number of seconds for each slide
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        textView=(TextView)findViewById(R.id.title);
        textview2=(TextView)findViewById(R.id.description);
        images=(ImageView)findViewById(R.id.imageView2);

        Bundle currentprogress=getIntent().getExtras();
        if(currentprogress==null) {
            return;
        }else{
            progress=currentprogress.getInt("getcurrentProgress");
        }
        progress=progress*1000;
        //textView.setText(""+progress);
        mRunnalbe.run();


    }

}
