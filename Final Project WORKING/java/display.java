package org.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by GiancarloDesktop on 4/23/2018.
 */

public class display extends Activity{

    DatabaseHelper2 mDataBaseHelper;

    private Button btnAdd, btnViewData;
    private EditText editText;

    private EditText userText;
    public String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        editText=(EditText)findViewById(R.id.editText);
        btnAdd=(Button) findViewById(R.id.btndelete);
        btnViewData=(Button) findViewById(R.id.btnView);
        mDataBaseHelper=new DatabaseHelper2(this);
        userText=(EditText) findViewById(R.id.name);

        String username=getIntent().getStringExtra("Username");
        user=username;
        TextView welcomemessage=(TextView)findViewById(R.id.welcome);
        welcomemessage.setText("Welcome To the Groceries APP: "+username);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry= editText.getText().toString();
                if(newEntry.length()!=0&&user.length()!=0){
                    addData(newEntry,user);
                    editText.setText("");//reset text

                }else{
                    toastMessage("You need ot put something into the text fields");
                }
            }
        });
        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(display.this,ListDataActivity.class);
                intent.putExtra("username",user);
                toastMessage("View based on: "+user);
                startActivity(intent);
            }
        });



    }

    public void addData(String newEntry,String user){
        boolean insertData=mDataBaseHelper.addDatas(newEntry,user);

        if(insertData){
            toastMessage("Data Inserted!");
        }else{
            toastMessage("Something went wrong");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
