package com.iessabadell.yosef.calkulator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class Calkulator extends AppCompatActivity {
    TextView op;
    private int operation;
    private String op1;
    private String op2;
    private boolean changeOp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calckulator);

        View.OnClickListener oclb = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                addToScreen(((Button) v).getText().toString());
            }
        };

        ((Button) findViewById(R.id.btn0)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn1)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn2)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn3)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn4)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn5)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn6)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn7)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn8)).setOnClickListener(oclb);
        ((Button) findViewById(R.id.btn9)).setOnClickListener(oclb);


        View.OnClickListener oclo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperation(v);
            }
        };
        ((Button) findViewById(R.id.btnPlus)).setOnClickListener(oclo);
        ((Button) findViewById(R.id.btnMenus)).setOnClickListener(oclo);
        ((Button) findViewById(R.id.btnMultiplication)).setOnClickListener(oclo);
        ((Button) findViewById(R.id.btnDivision)).setOnClickListener(oclo);
        ((Button) findViewById(R.id.btnDeleteAll)).setOnClickListener(oclo);

        op = (TextView) findViewById(R.id.opertation);
    }

    public void onOperation(View v) {
        String textToAdd = ((Button) v).getText().toString();
        switch (v.getId()) {
            case R.id.equal:
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

    private int doOperation() {
        int num = Integer.parseInt(op1);
        int num2 = Integer.parseInt(op2);
        int result = 0;
        switch (operation) {
            case 1:
                result = num + num2;
                break;
            case 2:
                result = num - num2;
                break;
            case 3:
                result = num * num2;
                break;
            case 4:
                result = num / num2;
                break;
        }
        op.setText(result);

        return result;
    }



    private void addToScreen(String textToAdd) {
        String actual = trimIfStartWithZero(op.getText().toString());
        op.setText(actual.concat(textToAdd));

        if (op1 == null || op1.isEmpty()) {
            op1 = textToAdd;
        } else if (op2 == null || op2.isEmpty()){
            op2 = textToAdd;
        } else {
            doOperation();
        }
        op.setText("");
    }
    private String trimIfStartWithZero(String str) {
        String result = str;
        if (result.startsWith("0")) {
            result = trimIfStartWithZero(result.substring(1));
        }
        return result;
    }
    private void enableOperations(boolean enable) {
        ((Button) findViewById(R.id.btnPlus)).setEnabled(enable);
        ((Button) findViewById(R.id.btnMenus)).setEnabled(enable);
        ((Button) findViewById(R.id.btnMultiplication)).setEnabled(enable);
        ((Button) findViewById(R.id.btnDivision)).setEnabled(enable);
    }
}
