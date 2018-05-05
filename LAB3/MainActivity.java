package org.example.lab3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    TextView textView;//for farenheit
    TextView textView2;//for celsius
    TextView textView3;//for feeling
    ImageView imageView;
    int progress;
    double dProgress;
    double converstion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar=(SeekBar)findViewById(R.id.seekBar3);
        seekbar.setMax(200);
        seekbar.setProgress(progress);




        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress=i;
                dProgress=i;//needed a double to make celsius double calulation
                converstion=(5)*(dProgress-32)/9;
                DecimalFormat format=new DecimalFormat("0.00");
                textView=(TextView)findViewById(R.id.farenheitValue);
                textView.setText(""+progress);
                textView2=(TextView) findViewById(R.id.celsiusValue);
                textView2.setText(""+format.format(converstion));
                textView3=(TextView)findViewById(R.id.feeling);
                imageView=(ImageView)findViewById(R.id.chicagoImage);
                if(i<=40)
                {
                    textView3.setText("Too Cold");
                    textView3.setBackgroundColor(Color.BLUE);
                    imageView.setImageResource(R.drawable.winter);
                }
                else if(i>40&&i<=90)
                {
                    textView3.setText("Just Right");
                    textView3.setBackgroundColor(Color.GREEN);
                    imageView.setImageResource(R.drawable.spring);
                }
                else if(i>90)
                {
                    textView3.setText("Hot!");
                    textView3.setBackgroundColor(Color.RED);
                    imageView.setImageResource(R.drawable.summer);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
