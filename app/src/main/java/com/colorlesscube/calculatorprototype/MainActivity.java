package com.colorlesscube.calculatorprototype;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
    int i, Oper, ResultInt, Oper1;
    float Result = 0;
    String[] SaveRes = new String[100];
    String token;

    private prototypeEditText formula;
    private prototypeEditText history_1;
    private prototypeEditText history_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        formula = (prototypeEditText) findViewById(R.id.formula);
        history_1 = (prototypeEditText) findViewById(R.id.history_1);
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
        history_1.setText("");
        history_2.setText("");
        Result = 0;
    }

    public void onClickListenerPlus(View v) {
        updateTextView("+");
    }

    public void onClickListenerMinus(View v) {
        updateTextView("-");
    }

    public void onClickListenerTimes(View v) {
        updateTextView("*");
    }

    public void onClickListenerDiv(View v) {
        updateTextView("/");
    }

    public void onClickListenerDot(View v) {
        updateTextView(".");
    }

    public void onClickListenerEqual(View v) {
        updateTextView("=");
    }

    public void TransformResult (float Res){
        if (Res == Math.round(Result)) {
            ResultInt = (int)Res;
            formula.setText(Integer.toString(ResultInt));
        }else{
            formula.setText(Float.toString(Res));
        }
    }

    public void updateTextView(String text) {
        String calc  = history_1.getText().toString();
        String calc1 = formula.getText().toString();

        switch (text) {
            case "+":

                //You should do the result here. Let's imagine that the user picks a 7 and then a +
                // The function below will try to do the following operation:
                // Result + TextInserted = 0 + "7+"
                // This is an invalid operation.
                Result = Result + Float.parseFloat(formula.getText().toString());
                history_1.setText(calc + calc1 + text);
                TransformResult(Result);
                Oper = 1;Oper1 = 1;
                break;
            case "-":
                Result = Result - Float.parseFloat(formula.getText().toString());
                history_1.setText(calc + calc1 + text);
                TransformResult(Result);
                Oper = 2;Oper1 = 1;
                break;
            case "*":
                Result = Result * Float.parseFloat(formula.getText().toString());
                history_1.setText(calc + calc1 + text);
                TransformResult(Result);
                Oper = 3;Oper1 = 1;
                break;
            case "/":
                Result = Result / Float.parseFloat(formula.getText().toString());
                history_1.setText(calc + calc1 + text);
                TransformResult(Result);
                Oper = 4;Oper1 = 1;
                break;
            case "=":
                history_1.setText("");
                switch (Oper) {
                    case 1:
                        Result = Result + Float.parseFloat(formula.getText().toString());
                        break;
                    case 2:
                        Result = Result - Float.parseFloat(formula.getText().toString());
                        break;
                    case 3:
                        Result = Result * Float.parseFloat(formula.getText().toString());
                        break;
                    case 4:
                        Result = Result / Float.parseFloat(formula.getText().toString());
                        break;
                }
                TransformResult(Result);
                Oper = 5; Result = 0;Oper1 = 1;
                break;
            default:
                if (Oper1 != 0) {
                    formula.setText("");
                    calc1 = formula.getText().toString();
                }
                formula.setText(calc1 + text);
                Oper1 = 0;
                break;
        }
    }
}
