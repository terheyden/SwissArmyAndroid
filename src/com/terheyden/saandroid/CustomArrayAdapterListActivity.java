package com.terheyden.saandroid;

import java.util.LinkedList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomArrayAdapterListActivity extends ListActivity {

    private final List<User> users = new LinkedList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        users.add(new User("luke", 29));
        users.add(new User("laura", 29));

        setListAdapter(new ArrayAdapter<User>(
            this,
            android.R.layout.simple_list_item_1,
            users) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    // If you open up simple_list_item_1, you'll see it's a TextView.
                    TextView textView = (TextView) super.getView(position, convertView, parent);
                    textView.setText(users.get(position).getName());
                    return textView;
                }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        User selectedUser = users.get(position);
        Toast.makeText(this, String.format("User: %s, age: %d", selectedUser.getName(), selectedUser.getAge()), Toast.LENGTH_SHORT).show();
    }
}
