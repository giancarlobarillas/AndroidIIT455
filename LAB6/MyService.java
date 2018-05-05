package org.example.lab6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    IBinder iBinder=new DemoBinder();
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MyService.this,"Service Bind",Toast.LENGTH_SHORT).show();
        return iBinder;
    }

    class DemoBinder extends Binder{
        public MyService getServiceInstance(){
            return MyService.this;
        }
    }
    public void showMessage(String message){
        Toast.makeText(MyService.this,"Testing :",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(MyService.this,"Service Unbind",Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}
