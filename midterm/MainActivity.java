package org.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    String defualtpassword="work";
    String password;
    String susername;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClick(View v){
        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        password=(String) pass.getText().toString();
        susername=(String)user.getText().toString();
        if(password.equals(defualtpassword)){
            //buttonclick
            //Toast.makeText(getApplicationContext(),"Working", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),secondjava.class);
            intent.putExtra("getUser",susername);
            startActivity(intent);
        }
        else{
            counter++;
            Toast.makeText(getApplicationContext(),"Error:"+counter, Toast.LENGTH_LONG).show();
        }
    }
}
