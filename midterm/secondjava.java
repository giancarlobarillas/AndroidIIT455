package org.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by GiancarloDesktop on 3/5/2018.
 */
public class secondjava extends AppCompatActivity{


    TextView usernameSecond;
    String secondUsername;
    String[] Mycourse={"ITMD:361 Fundamentals of Web Development","ITMD:455 Intelligent Device Apps Android","Math:230 Discrete Mathematics",
            "IMTD:411 Intermediate Software Development","LIT:380 Latino Lives"};
    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        usernameSecond=(TextView)findViewById(R.id.usernamesecond);
        Bundle currentUsername=getIntent().getExtras();
        if(currentUsername==null) {
            return;
        }else{
            secondUsername=currentUsername.getString("getUser");
        }
        usernameSecond.setText(secondUsername);
        listView=(ListView)findViewById(R.id.courselist);
        listAdapter=new CustomListAdapter(secondjava.this,Mycourse);
        listView.setAdapter(listAdapter);
    }

}
