package com.dealfaro.luca.lclicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public String phoneNum = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //place a new number in the text box / string, cannot go over 12 numbers
    public void clickButton(View v) {
        Button b = (Button) v;
        String t = b.getText().toString();
        if(phoneNum.length() < 12){
            phoneNum = phoneNum + t;
        }
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(phoneNum);
    }

    // If the text string has any numbers in it remove the rightmost number
    public void clickDelete(View v) {
        String replace = "";
        if(phoneNum.length()>0){
            for(int i = 0; i<phoneNum.length()-1; i++){
                replace = replace + String.valueOf(phoneNum.charAt(i));
            }
            phoneNum = replace;
        }
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(phoneNum);
    }

    //Remove all numbers from the text view
    public void clickCall(View v) {
        phoneNum = "";
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(phoneNum);
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
}