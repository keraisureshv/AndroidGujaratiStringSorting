package com.hjd.gujaratiaccendingorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arkayapps on 06/03/17.
 */

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> studentInfos;
    LayoutInflater inflater;
    private TextView txtName;



    public StudentAdapter(Context c, ArrayList<String> studentInfos) {
        context = c;
        this.studentInfos = studentInfos;

    }

    public int getCount() {
        return studentInfos.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item_student, null);

        txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(""+studentInfos.get(position));

        return convertView;
    }
}
