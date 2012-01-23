package com.terheyden.saandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class ExpandListActivity extends ExpandableListActivity {

    private List<Map<String, String>> colorList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Optional, can set custom layout:
        setContentView(R.layout.expand_list);

        // A group = a group of child items.
        // Our groups are going to be: Colors, Numbers
        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();

        // These use maps so you can have a "name" value and a "description" value.
        // Just for fun, we'll have our groups only show names (no descriptions)
        // and the children will show both a name and description.

        Map<String, String> colorMap = new HashMap<String, String>();
        colorMap.put("name", "Colors");
        groupData.add(colorMap);

        Map<String, String> numberMap = new HashMap<String, String>();
        numberMap.put("name", "Numbers");
        groupData.add(numberMap);

        // Child data for each group:
        // Our child data: red, green, blue, and one, two, three
        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();

        colorList = new ArrayList<Map<String,String>>();

        Map<String, String> red = new HashMap<String, String>();
        red.put("name", "red");
        red.put("desc", "the color red");
        colorList.add(red);

        Map<String, String> green = new HashMap<String, String>();
        green.put("name", "green");
        green.put("desc", "the color green");
        colorList.add(green);

        Map<String, String> blue = new HashMap<String, String>();
        blue.put("name", "blue");
        blue.put("desc", "the color blue");
        colorList.add(blue);

        List<Map<String, String>> numberList = new ArrayList<Map<String,String>>();

        Map<String, String> one = new HashMap<String, String>();
        one.put("name", "one");
        one.put("desc", "the number one");
        numberList.add(one);

        Map<String, String> two = new HashMap<String, String>();
        two.put("name", "two");
        two.put("desc", "the number two");
        numberList.add(two);

        Map<String, String> three = new HashMap<String, String>();
        three.put("name", "three");
        three.put("desc", "the number three");
        numberList.add(three);

        // Add the lists to the child list:
        childData.add(colorList);
        childData.add(numberList);

        // Set up our adapter.
        // simple_expandable_list_item_1 only shows names (not descriptions)
        // and uses the standard ID android.R.id.text1.
        //
        // simple_expandable_list_item_2 supports two fields (names and description in our case).
        // It's IDs are android.R.id.text1 and android.R.id.text2, as you can see below.
        //
        // Peek inside the source code for more info.
        // Or copy the source code and make custom row layouts.
        // See: expand_row.xml

        ExpandableListAdapter adapter = new SimpleExpandableListAdapter(
            this,
            groupData,
            android.R.layout.simple_expandable_list_item_1,
            new String[] { "name" },
            new int[] { android.R.id.text1 },
            childData,
            android.R.layout.simple_expandable_list_item_2,
            new String[] { "name", "desc" },
            new int[] { android.R.id.text1, android.R.id.text2 }
            );
        setListAdapter(adapter);
    }

    /**
     * Clicking any child adds the color "yellow"
     * but must collapse / re-expand color list to see the change.
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
        int childPosition, long id) {

        Map<String, String> yellow = new HashMap<String, String>();
        yellow.put("name", "yellow");
        yellow.put("desc", "the color yellow");
        colorList.add(yellow);

        return true;
    }


}
