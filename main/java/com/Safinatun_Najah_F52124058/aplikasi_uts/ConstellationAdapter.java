package com.Safinatun_Najah_F52124058.aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConstellationAdapter extends BaseAdapter {

    Context context;
    ArrayList<Constellation> constellationList;

    public ConstellationAdapter(Context context, ArrayList<Constellation> constellationList) {
        this.context = context;
        this.constellationList = constellationList;
    }

    @Override
    public int getCount() {
        return constellationList.size();
    }

    @Override
    public Object getItem(int position) {
        return constellationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_constellation, parent, false);
        }

        ImageView imgConstellation = convertView.findViewById(R.id.imgConstellation);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDescription = convertView.findViewById(R.id.txtDescription);
        TextView txtDate = convertView.findViewById(R.id.txtDate);

        Constellation constellation = constellationList.get(position);

        imgConstellation.setImageResource(constellation.image);
        txtName.setText(constellation.name);
        txtDescription.setText(constellation.description);
        txtDate.setText(constellation.date);

        return convertView;
    }
}