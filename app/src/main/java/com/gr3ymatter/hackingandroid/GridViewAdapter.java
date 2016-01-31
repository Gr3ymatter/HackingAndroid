package com.gr3ymatter.hackingandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Afzal on 1/30/16.
 */
public class GridViewAdapter extends BaseAdapter {


    public class Concepts{

        Integer image;
        String label;
        String demoActivityName;
        String detailActivityName;

        public Concepts(Integer image, String label)
        {
            this.image = image;
            this.label = label;
            this.demoActivityName = label.replaceAll("\\s","") + "Demo";
            this.detailActivityName = label.replaceAll("\\s","") + "Notes";
        }
    }


    ArrayList<Concepts> conceptArraylist;

    Context mContext;
    private Integer[] mThumbIm = {
            R.drawable.grid_camera
    };

    private String[] mThumbTxt ={
            "Camera Api"
    };


    public GridViewAdapter(Context c) {
        super();
        mContext = c;

       conceptArraylist = new ArrayList<>();
        populateArrayList();

    }

    private void populateArrayList(){

        Concepts camera = new Concepts(R.drawable.grid_camera, "Camera Api");

        conceptArraylist.add(camera);
    }


    @Override
    public int getCount() {
        return mThumbIm.length;
    }

    @Override
    public Object getItem(int position) {
        return conceptArraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.single_gridview, null);

        } else {
            grid = (View) convertView;
        }
        ImageView image =  (ImageView) grid.findViewById(R.id.image_view);
        TextView text = (TextView) grid.findViewById(R.id.textView);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setPadding(8, 8, 8, 8);
        image.setImageResource(conceptArraylist.get(position).image);
        text.setText(conceptArraylist.get(position).label);
        return grid;
    }
}
