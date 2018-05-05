package org.example.lab7and8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GiancarloDesktop on 4/9/2018.
 */

public class list extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.list);
        Intent intent=getIntent();
        SqlHelper db=new SqlHelper(this);

        List<Books> list=db.getAllBooks();
        ListView bookList=(ListView) findViewById(R.id.list);
        List<Books> books=new ArrayList<Books>();
        books=db.getAllBooks();
        ListAdapter customAdapter = new CustomListAdapter(this,R.layout.customlayout, books);
        bookList.setAdapter(customAdapter);
    }
}
