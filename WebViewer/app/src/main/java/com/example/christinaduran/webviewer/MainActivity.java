package com.example.christinaduran.webviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //start intent to see these three different news providers when button is clicked.
    public void onClick1(View v){
        Intent intent = new Intent(MainActivity.this, ActivityView.class);
        String url = "http://mobile.nytimes.com";
        intent.putExtra("URL",url);
        startActivity(intent);
    }

    public void onClick2(View v){
        Intent intent = new Intent(MainActivity.this, ActivityView.class);
        String url = "http://www.mercurynews.com";
        intent.putExtra("URL",url);
        startActivity(intent);
    }

    public void onClick3(View v){
        Intent intent = new Intent(MainActivity.this, ActivityView.class);
        String url = "http://www.santacruzsentinel.com";
        intent.putExtra("URL",url);
        startActivity(intent);
    }
}
