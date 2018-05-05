package org.example.adding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClick(View v )
    {
        EditText getCost=(EditText)findViewById(R.id.mealCost);
        EditText getTax=(EditText)findViewById(R.id.taxPercent);
        EditText getTip=(EditText)findViewById(R.id.tipPercent);
        TextView getResult=(TextView)findViewById(R.id.result);

        double cost=Double.parseDouble(getCost.getText().toString());
        double tax=0.01*Double.parseDouble(getTax.getText().toString());//get tax as double
        double tip=0.01*Double.parseDouble(getTip.getText().toString());//get tip as double to simplify sum

        DecimalFormat format=new DecimalFormat("$0.00");
        double sum=cost+cost*tax+cost*tip;
        String output=format.format(sum);
        getResult.setText(output);
    }

}
