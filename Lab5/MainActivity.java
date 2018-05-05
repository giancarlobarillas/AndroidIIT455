package org.example.lab5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    SeekBar seekbar;
    TextView textView;
    int progress;
    Button myButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar=(SeekBar)findViewById(R.id.seekBar3);
        seekbar.setMax(30);
        seekbar.setProgress(progress);

        myButton = (Button) findViewById(R.id.changeb);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        secondactivityjava.class);
                intent.putExtra("getcurrentProgress",progress);
                startActivity(intent);
            }
        });





        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress=i;
                DecimalFormat format=new DecimalFormat("0.00");
                textView=(TextView)findViewById(R.id.farenheitValue);
                textView.setText(""+progress+" Seconds");
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