package com.colorlesscube.calculatorprototype;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
    int i, Oper, ResultInt, Oper1;
    float Result = 0, SaveF;

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

    public void onClickListener1(View v) { updateTextView("1"); }

    public void onClickListener2(View v) { updateTextView("2"); }

    public void onClickListener3(View v) { updateTextView("3"); }

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

    public void onClickListenerPlus(View v) { updateTextView("+"); }

    public void onClickListenerMinus(View v) { updateTextView("-"); }

    public void onClickListenerTimes(View v) {updateTextView("*"); }

    public void onClickListenerDiv(View v) { updateTextView("/"); }

    public void onClickListenerDot(View v) {
        updateTextView(".");
    }

    public void onClickListenerEqual(View v) {
        updateTextView("=");
    }

    public void onClickListenerSine(View v) {
        updateTextView("Sin");
    }

    public void onClickListenerCosine(View v) {
        updateTextView("Cos");
    }

    public void onClickListenerTangent(View v) {
        updateTextView("Tan");
    }


    public void TransformResult (float Res){
        if (Res == Math.round(Result)) {
            ResultInt = (int)Res;
            formula.setText(Integer.toString(ResultInt));
        }else{
            formula.setText(Float.toString(Res));
        }
    }
    public void DoOperators (){
        if (Oper == 1) {
            Result = Result + Float.parseFloat(formula.getText().toString());
            TransformResult(Result);
        }
        if (Oper == 2) {
            Result = Result - Float.parseFloat(formula.getText().toString());
            TransformResult(Result);
        }
        if (Oper == 3) {
            if (Result == 0){ Result = 1;}
            Result = Result * Float.parseFloat(formula.getText().toString());
            TransformResult(Result);
        }
        if (Oper == 4) {
            Result = Result / Float.parseFloat(formula.getText().toString());
            TransformResult(Result);
        }
    }

    public void updateTextView(String text) {
        String calc  = history_1.getText().toString();
        String calc1 = formula.getText().toString();

        switch (text) {
            case "+":
                DoOperators();
                history_1.setText(calc + calc1 + text);
                Result = Float.parseFloat(formula.getText().toString());
                Oper = 1;Oper1 = 1;
                break;
            case "-":
                DoOperators();
                history_1.setText(calc + calc1 + text);
                Result = Float.parseFloat(formula.getText().toString());
                Oper = 2;Oper1 = 1;
                break;
            case "*":
                DoOperators();
                history_1.setText(calc + calc1 + text);
                Result = Float.parseFloat(formula.getText().toString());
                Oper = 3;Oper1 = 1;
                break;
            case "/":
                DoOperators();
                history_1.setText(calc + calc1 + text);
                Result = Float.parseFloat(formula.getText().toString());
                Oper = 4;Oper1 = 1;
                break;
            case "=":
                history_1.setText("");
                if (Oper1 == 0) {SaveF = Float.parseFloat(formula.getText().toString());}
                else{SaveF = 0;}
                switch (Oper) {
                    case 1:
                        Result = Result + SaveF;
                        break;
                    case 2:
                        Result = Result - SaveF;
                        break;
                    case 3:
                        Result = Result * SaveF;
                        break;
                    case 4:
                        Result = Result / SaveF;
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


