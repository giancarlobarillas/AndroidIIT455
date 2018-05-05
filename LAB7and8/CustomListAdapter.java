package org.example.lab7and8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by GiancarloDesktop on 4/8/2018.
 */

public class CustomListAdapter extends ArrayAdapter<Books>{

    private List<Books>listElements;

    public CustomListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    public CustomListAdapter(@NonNull Context context, int resource, @NonNull List<Books> objects) {
        super(context, resource, objects);
        this.listElements=objects;
    }
    public View getView(int index, View changeView, ViewGroup parent)
    {
        View v=changeView;
        if(v==null){
            LayoutInflater layoutInflater;
            layoutInflater=LayoutInflater.from(getContext());
            v=layoutInflater.inflate(R.layout.customlayout,null);
        }
        Books books=getItem(index);
        if(books!=null){
            TextView tid=(TextView) v.findViewById(R.id.id);
            TextView ttitle=(TextView) v.findViewById(R.id.title);
            TextView tauthor=(TextView) v.findViewById(R.id.author);
            RatingBar rate=(RatingBar) v.findViewById(R.id.ratingBar);

            if(tid!=null){
                tid.setText(""+books.getId());
            }
            if(ttitle!=null){
                ttitle.setText(""+books.getTitle());
            }
            if(tauthor!=null){
                tauthor .setText(""+books.getAuthor());
            }
            if(rate!=null){
                float rating=Float.parseFloat(books.getRating());
                rate.setRating(rating);
            }
        }
        return v;
    }

}
