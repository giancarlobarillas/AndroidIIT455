package org.example.lab6;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button buttonBind;
    private Button buttonUnbind;
    private MyService myService;
    private boolean isBind;
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.DemoBinder demoBinder=(MyService.DemoBinder)iBinder;
            myService=demoBinder.getServiceInstance();
            myService.showMessage("Welcome to Bound Service");
            isBind=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBind=false;
        }
    };

    private int millseconds;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonBind=(Button)findViewById(R.id.startservicebutton);
        buttonUnbind=(Button)findViewById(R.id.stopservicebutton);
        buttonBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
            }
        });
        buttonUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(isBind){
                   unbindService(serviceConnection);
                   isBind=false;
               }
            }
        });
        if(savedInstanceState!=null){
            running=savedInstanceState.getBoolean("running");
            millseconds=savedInstanceState.getInt("milliseconds");
        }
        runTimer();

    }

    public void onStartClick(View V){
        running=true;
    }
    public void onResetClick(View V){
        running=false;
        millseconds=0;
    }
    public void onStopClick(View V){
        running=false;
    }

    public void onSaveInstatnceState(Bundle savedInstanceState){
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putInt("milliseconds",millseconds);
    }

    public void runTimer(){
        final TextView textView=(TextView)findViewById(R.id.displaytext);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=(millseconds/(1000*60*60)%24);
                int minutes=(millseconds/(1000*60)%60);
                int seconds=(millseconds/(100)%60);
                int milli=millseconds%100;
                String time=String.format("%02d:%02d:%02d:%02d",hours,minutes,seconds,milli);
                textView.setText(time);
                if(running){
                    millseconds++;
                }
                handler.postDelayed(this,1);
            }
        });
    }
}
