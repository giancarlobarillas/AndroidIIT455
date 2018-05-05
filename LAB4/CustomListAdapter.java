package org.example.lab4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.lab4.MainActivity;
import org.w3c.dom.Text;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity Context;
    private final String[] ListItemsName;
    private final Integer[] ImageName;//used for images
    private final String[] ListItemInfo;

    public CustomListAdapter(Activity context, String[] content, Integer[] ImageName, String[] listItemInfo) {// 3 Arguments, context which is the activity, array of strings for cityName,integer array for images
        super(context, R.layout.customlayout, content);//create default
        this.Context = context;
        this.ListItemsName = content;
        this.ListItemInfo=listItemInfo;
        this.ImageName = ImageName;//takes argument of ImageName into this data
    }
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = Context.getLayoutInflater();
        View ListViewSingle = inflater.inflate(R.layout.customlayout, null, true);
        TextView ListViewItems = (TextView) ListViewSingle.findViewById(R.id.cityname);
        TextView ListViewInfo=(TextView) ListViewSingle.findViewById(R.id.cityinfo);
        ImageView ListViewImage = (ImageView)
                ListViewSingle.findViewById(R.id.cityicon);
        ListViewItems.setText(ListItemsName[position]);
        ListViewImage.setImageResource(ImageName[position]);
        ListViewInfo.setText(ListItemInfo[position]);

        return ListViewSingle;
    };
}