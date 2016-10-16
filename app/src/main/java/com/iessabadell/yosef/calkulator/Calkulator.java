package com.iessabadell.yosef.calkulator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//TODO TRABAJAR CON NUMERICOS Y OPERACIONES (EVITAR JUGAR CON STRINGS)
public class Calkulator extends AppCompatActivity implements View.OnClickListener {
    TextView op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calckulator);
        ((Button)findViewById(R.id.btn0)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn1)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn2)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn3)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn4)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn5)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn6)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn7)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn8)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn9)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnPlus)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMenus)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMultiplication)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnDivision)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnDeleteAll)).setOnClickListener(this);

        op = (TextView) findViewById(R.id.opertation);
    }

    @Override
    public void onClick(View v) {
        String textToAdd = ((Button) v).getText().toString();
        switch (v.getId()) {
            case  R.id.equal:
                doOperation();
                break;
            case (R.id.btnPlus):
            case (R.id.btnMenus):
            case (R.id.btnMultiplication):
            case (R.id.btnDivision):
                enableOperations(false);
                addToScreen(textToAdd);
                break;
            case (R.id.btnDeleteAll):
                op.setText("0");
                break;
            default:
                enableOperations(true);
                addToScreen(textToAdd);
        }

    }

    private void doOperation() {

    }
    private String trimIfStartWithZero(String str) {
        String result = str;
        if (result.startsWith("0")) {
            result = trimIfStartWithZero(result.substring(1));
        }
        return result;
    }

    private void addToScreen (String textToAdd ) {
        String actual = trimIfStartWithZero(op.getText().toString());
        op.setText(actual.concat(textToAdd));
    }
    private void enableOperations(boolean enable) {
        ((Button)findViewById(R.id.btnPlus)).setEnabled(enable);
        ((Button)findViewById(R.id.btnMenus)).setEnabled(enable);
        ((Button)findViewById(R.id.btnMultiplication)).setEnabled(enable);
        ((Button)findViewById(R.id.btnDivision)).setEnabled(enable);
    }
}
