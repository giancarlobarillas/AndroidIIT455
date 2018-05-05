package org.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity Context;
    private final String[] ListItemsName;


    public CustomListAdapter(Activity context, String[] names) {// 3 Arguments, context which is the activity, array of strings for cityName,integer array for images
        super(context, R.layout.customlayout, names);//create default
        this.Context = context;
        this.ListItemsName = names;
    }
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = Context.getLayoutInflater();
        View ListViewSingle = inflater.inflate(R.layout.customlayout, null, true);
        TextView ListViewItems = (TextView) ListViewSingle.findViewById(R.id.courseinfo);
        ListViewItems.setText(ListItemsName[position]);


        return ListViewSingle;
    };
}
