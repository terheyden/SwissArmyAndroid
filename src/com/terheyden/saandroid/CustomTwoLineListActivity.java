package com.terheyden.saandroid;

import java.util.LinkedList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomTwoLineListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final List<String[]> colorList = new LinkedList<String[]>();
        colorList.add(new String[] { "Red", "the color red" });
        colorList.add(new String[] { "Green", "the color green" });
        colorList.add(new String[] { "Blue", "the color blue" });

        // Note - we're specifying android.R.id.text1 as a param, but it's ignored
        // because we override getView(). That param usually tells ArrayAdapter
        // where to find the one TextView entity in a complex layout.
        // If our layout was a simple TextView (like android.R.layout.simple_list_item_1),
        // we wouldn't need that param.
        setListAdapter(new ArrayAdapter<String[]>(
            this,
            android.R.layout.simple_list_item_2,
            android.R.id.text1,
            colorList) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                // Must always return just a View.
                View view = super.getView(position, convertView, parent);

                // If you look at the android.R.layout.simple_list_item_2 source, you'll see
                // it's a TwoLineListItem with 2 TextViews - text1 and text2.
                //TwoLineListItem listItem = (TwoLineListItem) view;
                String[] entry = colorList.get(position);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text1.setText(entry[0]);
                text2.setText(entry[1]);
                return view;
            }
        });
    }
}
