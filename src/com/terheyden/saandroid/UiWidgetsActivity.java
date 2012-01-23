package com.terheyden.saandroid;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class UiWidgetsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
       // Be sure to call the super class.
       super.onCreate(savedInstanceState);

       // See assets/res/any/layout/hello_world.xml for this
       // view layout definition, which is being set here as
       // the content of our screen.
       setContentView(R.layout.ui_widgets_activity);

       //////////////////////////////////////////////////
       // Spinner widget!

       List<String> colorList = new LinkedList<String>();
       colorList.add("red");
       colorList.add("green");
       colorList.add("blue");

       Spinner s1 = (Spinner) findViewById(R.id.spinner1);

       ArrayAdapter<String> adapter = new ArrayAdapter<String>(
           this,
           android.R.layout.simple_spinner_dropdown_item,
           colorList);

       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       s1.setAdapter(adapter);
       s1.setOnItemSelectedListener(new OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {
               Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
