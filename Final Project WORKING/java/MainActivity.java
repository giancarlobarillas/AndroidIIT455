package org.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
       if(view.getId()==R.id.btnlogin)
       {
           EditText name=(EditText)findViewById(R.id.username);
           String getNameText=name.getText().toString();
           EditText pass=(EditText)findViewById(R.id.password);
           String getPasswordText=pass.getText().toString();

           //CHECK USER
           String password = helper.searchPass(getNameText);
           if(getPasswordText.equals(password)){
               Intent intent=new Intent(MainActivity.this,display.class);
               intent.putExtra("Username",getNameText);
               startActivity(intent);
           }
           else{
               toastMessage("Password does not match! ");
           }

       }
       if(view.getId()==R.id.btnsignup){
           Intent intent=new Intent(MainActivity.this,signup.class);
           startActivity(intent);
       }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
