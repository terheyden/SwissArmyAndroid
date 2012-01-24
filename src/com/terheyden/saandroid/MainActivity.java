package com.terheyden.saandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Demonstrates a simple ListActivity.
 * Is also our main activity.
 * See also: http://developer.android.com/resources/tutorials/views/hello-listview.html
 */
public class MainActivity extends ListActivity {

    private static final String[] mainItems = {
                    "Simple activity",
                    "Expandable list",
                    "Custom ArrayAdapter list",
                    "Custom 2-line list",
                    "UI Widgets",
                    "Dialogs",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, mainItems));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = mainItems[position];

                if (selectedItem.equals("Simple activity")) {

                    startActivity(new Intent(getApplicationContext(), SimpleActivity.class));

                } else if (selectedItem.equals("Expandable list")) {

                    startActivity(new Intent(getApplicationContext(), ExpandListActivity.class));

                } else if (selectedItem.equals("Custom ArrayAdapter list")) {

                    startActivity(new Intent(getApplicationContext(), CustomArrayAdapterListActivity.class));

                } else if (selectedItem.equals("Custom 2-line list")) {

                    startActivity(new Intent(getApplicationContext(), CustomTwoLineListActivity.class));

                } else if (selectedItem.equals("UI Widgets")) {

                    startActivity(new Intent(getApplicationContext(), UiWidgetsActivity.class));

                } else if (selectedItem.equals("Dialogs")) {

                    startActivity(new Intent(getApplicationContext(), DialogActivity.class));

                } else {
                    // Else just show what they clicked on.
                    Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
