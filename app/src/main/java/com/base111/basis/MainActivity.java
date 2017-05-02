package com.base111.basis;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end of on create method

    //launch basic activity
    public void launchBasic(View view){
        Intent basic = new Intent(MainActivity.this,BasicActivity.class);
        startActivity(basic);
    }

    //launch advance activity
    public void launchAdvance(View view){
        //
    }

    //options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    // define click events
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.main_about:
                Intent aboutmain = new Intent(MainActivity.this,AboutMain.class);
                startActivity(aboutmain);
                return true;
            case R.id.main_web_search:
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://www.google.com"));
                startActivity(web);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
