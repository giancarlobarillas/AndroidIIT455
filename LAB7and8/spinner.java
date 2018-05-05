package org.example.lab7and8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by GiancarloDesktop on 4/10/2018.
 */

public class spinner extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Set<String> set;
    SqlHelper db;
    boolean flag=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        Intent intent=getIntent();
        db=new SqlHelper(this);

        db.addBook(new Books("Professional Android 4 Application Development","Reto Meier","2.0"));
        db.addBook(new Books("Beginning Android 4 Application Development","Wei-Meng Lee","3.0"));
        db.addBook(new Books("Programming Android", "Wallace Jackson","2.5"));
        db.addBook(new Books("Hello, Android", "Wallace Jackson","4.5"));

        Spinner spin;
        spin=(Spinner)findViewById(R.id.spinner1);
        set=db.getTitle();
        List<String> bookList=new ArrayList<String>(set);
        Collections.sort(bookList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        bookList.add(0,"Select title...");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,bookList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapter);
        spin.setWillNotDraw(false);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(flag){
            if(i>0){
                String title=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(this," Author's Name :: " + db.getAuthor(title),Toast.LENGTH_LONG).show();
            }
        }
        flag=true;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
}
