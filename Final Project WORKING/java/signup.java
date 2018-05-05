package org.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by GiancarloDesktop on 4/20/2018.
 */

public class signup extends Activity{
    DatabaseHelper helper=new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v){
        if(v.getId()==R.id.btnaccount)
        {
            EditText name=(EditText)findViewById(R.id.name);
            EditText user=(EditText)findViewById(R.id.username);
            EditText pass=(EditText)findViewById(R.id.password);
            EditText confirmpass=(EditText)findViewById(R.id.confirmpass);

            String strname=name.getText().toString();
            String struser=user.getText().toString();
            String strpass=pass.getText().toString();
            String strconfirmpass=confirmpass.getText().toString();

            if(!strpass.equals(strconfirmpass))
            {
                toastMessage("Passwords Dont Match");
            }
            else{
                contact c=new contact();
                c.setName(strname);
                c.setUsername(struser);
                c.setPassword(strpass);
                helper.insertContact(c);
                toastMessage("YOUR ACCOUNT WAS CREATED!");
                Intent intent=new Intent(signup.this,MainActivity.class);
                startActivity(intent);

            }
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
