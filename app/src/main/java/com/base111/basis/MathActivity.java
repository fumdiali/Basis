package com.base111.basis;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MathActivity extends AppCompatActivity {

    ListView listView;
    String[] topics = {"Math - Overview", "History of Math",
            "Math - Basic Syntax", "Math - Operators & Operations",
            "Maths - Mnemonics"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        listView = (ListView) findViewById(R.id.mathListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,topics);
        listView.setAdapter(adapter);

        //click listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Learn about "+topics[i],Toast.LENGTH_SHORT).show();
            }
        });
    }//end of on create method

    //options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.math_activity_menu, menu);
        return true;
    }

    // define click events
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mathquiz:
                Intent mathquiz = new Intent(getApplicationContext(),MathQuiz.class);
                startActivity(mathquiz);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}//end of class