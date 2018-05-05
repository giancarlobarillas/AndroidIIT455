package org.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String ListItemsName[] = new String[]{ "Barcelona", "Udaipur",
            "Siem Reap","Rome","Santa Fe","Luang Prabang","Ubud","Cape Town", "Hoi An","Oaxaca",
            "Florence","Kyoto","Chiang Mai","Charleston","San Miguel de Allende"};
    Integer ImageName[] = { R.drawable.barcelona, R.drawable.udaipur,
            R.drawable.siemreap,R.drawable.rome,R.drawable.santafe,R.drawable.luangprabang,R.drawable.lowerubud,
            R.drawable.capetown,R.drawable.hoian, R.drawable.oaxaca,R.drawable.florence,R.drawable.kyoto,R.drawable.chiangmai,
            R.drawable.charleston,R.drawable.sanmiguel};
    String ListItemsInfo[]=new String[]{"Barcelona is located in Spain","Udaipur is located in India","Siem Reap is located in Cambodia","Rome is located in Italy","Santa Fe is located in New Mexico",
    "Luang Prabang is located in Laos","Ubud is located in Indonesia","Cape Town is located in South Africa","Hoi An is located in Vietnam", "Oaxaca is located in Mexico",
    "Florence is located in Italy","Kyoto is located in Japan", "Chiang Mai is located in Thailand", "Charleston is located in South Carolina",
    "San Miguel de Allend is located in Mexico"};
    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.citylist);
        listAdapter = new CustomListAdapter(MainActivity.this,
                ListItemsName, ImageName, ListItemsInfo);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ListItemsName[position],
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}