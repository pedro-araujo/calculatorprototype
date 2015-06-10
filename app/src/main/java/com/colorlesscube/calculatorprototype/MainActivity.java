package com.colorlesscube.calculatorprototype;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
    int i, Oper;
    float Result = 0;
    String[] SaveRes = new String[100];
    String token;

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
        formulaUP.setText("");
        formulaDOWN.setText("");
    }

    public void onClickListenersum(View v) {
        updateTextView("+");
    }

    public void onClickListenerminus(View v) {
        updateTextView("-");
    }

    public void onClickListenerdiv(View v) {
        updateTextView("/");
    }

    public void onClickListenermulti(View v) {
        updateTextView("*");
    }

    public void onClickListenerpoint(View v) {
        updateTextView(".");
    }

    public void updateTextView(String text) {
        String calc = formulaDOWN.getText().toString();
        switch (text) {
            case "+":
                formulaUPsetText(calc + text);
                Result = Result + Float.parseFloat(formulaDOWN.getText().toString());
                Oper = 1;
                break;
            case "-":
                formulaUPsetText(calc + text);
                Result = Result - Float.parseFloat(formulaDOWN.getText().toString());
                Oper = 2;
                break;
            case "*":
                formulaUPsetText(calc + text);
                Result = Result * Float.parseFloat(formulaDOWN.getText().toString());
                Oper = 3;
                break;
            case "/":
                formulaUPsetText(calc + text);
                Result = Result / Float.parseFloat(formulaDOWN.getText().toString());
                Oper = 4;
                break;
            case "=":
                formulaUPsetText("");
                Result = Result / Float.parseFloat(formulaDOWN.getText().toString());
                formulaDOWN.setText(Result);
                Oper = 5;
                break;
            default:
                formulaDOWN.setText(calc + text);
                break;
        }
    }
}