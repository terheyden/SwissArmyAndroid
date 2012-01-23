package com.terheyden.saandroid;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SimpleListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            R.array.colors
            ));
    }
}
