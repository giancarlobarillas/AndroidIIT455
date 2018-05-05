package org.example.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by GiancarloDesktop on 4/29/2018.
 */

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG="ListDataActivity";
    DatabaseHelper2 mDatabaseHelper;
    private ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.list_layout);
        mListView=(ListView) findViewById(R.id.listView);
        mDatabaseHelper=new DatabaseHelper2(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG,"populateListView: Display data in the ListView");
        String user=getIntent().getStringExtra("username");
        Cursor data=mDatabaseHelper.getDatas(user);
        ArrayList<String> listData=new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=adapterView.getItemAtPosition(i).toString();
                Log.d(TAG,"onItemClick: You clicked on "+name);

                Cursor data=mDatabaseHelper.getItemID(name);
                int itemID=-1;
                while(data.moveToNext()){
                    itemID=data.getInt(0);
                }
                if(itemID>=1){
                    Log.d(TAG,"onItemClick: The id is : "+itemID);
                    Intent editScreenIntent=new Intent(ListDataActivity.this,EditDataActivity.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    startActivity(editScreenIntent);
                }else {
                    toastMessage("No ID associated with that name");
                }
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
