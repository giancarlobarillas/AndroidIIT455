package org.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by GiancarloDesktop on 4/29/2018.
 */

public class EditDataActivity extends AppCompatActivity {
    private static final String TAG="EditDataActivity";
    private EditText editable_item;
    private Button btnSave,btnDelete;
    DatabaseHelper2 mDataBaseHelper;

    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);
        btnSave=(Button)findViewById(R.id.btnsave);
        btnDelete=(Button)findViewById(R.id.btndelete);
        editable_item=(EditText) findViewById(R.id.editText);
        mDataBaseHelper=new DatabaseHelper2(this);

        Intent reciveIntent=getIntent();
        selectedID=reciveIntent.getIntExtra("id",-1);
        selectedName=reciveIntent.getStringExtra("name");

        editable_item.setText(selectedName);
        final Intent intent=new Intent(EditDataActivity.this,ListDataActivity.class);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item=editable_item.getText().toString();
                if(!item.equals("")){
                    mDataBaseHelper.updateName(item,selectedID,selectedName);
                    startActivity(intent);
                    toastMessage("Data was updated");
                }else{
                    toastMessage("You must enter something");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBaseHelper.deleteName(selectedID,selectedName);
                editable_item.setText("");
                startActivity(intent);
                toastMessage("removed from database");

            }
        });

    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
