package com.colorlesscube.calculatorprototype;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button9;
    Button buttonEquals;
    Button buttonClr;
    private prototypeEditText formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        formula = (prototypeEditText) findViewById(R.id.formula);
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

    public void onClickListener0(View v) {
        updateTextView("0");
    }

    public void onClickListener1(View v) {
        updateTextView("1");
    }

    public void onClickListener2(View v) {
        updateTextView("2");
    }

    public void onClickListener3(View v) {
        updateTextView("3");
    }

    public void onClickListener4(View v) {
        updateTextView("4");
    }

    public void onClickListener5(View v) {
        updateTextView("5");
    }

    public void onClickListener6(View v) {
        updateTextView("6");
    }

    public void onClickListener7(View v) {
        updateTextView("7");
    }

    public void onClickListener8(View v) {
        updateTextView("8");
    }

    public void onClickListener9(View v) {
        updateTextView("9");
    }

    public void onClickListenerClr(View v) {
        formula.setText("");
    }

    public void updateTextView(String text) {
        int length = text.length();

        String calc = formula.getText().toString();

        calc = calc + text;
        formula.setText(calc);
    }
}