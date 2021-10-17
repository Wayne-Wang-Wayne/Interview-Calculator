package com.example.interviewcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private TextView resultTv;
    private Button button00;
    private Button button01;
    private Button button02;
    private Button button03;
    private Button button04;
    private Button button05;
    private Button button06;
    private Button button07;
    private Button button08;
    private Button button09;
    private Button buttonDot;
    private Button buttonEqual;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMulti;
    private Button buttonDivide;
    private Button buttonFactorial;
    private Button buttonClear;
    private Button leftBraces;
    private Button rightBraces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);


        resultTv = findViewById(R.id.resultTv);
        resultTv.setShowSoftInputOnFocus(false);

        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button03 = findViewById(R.id.button03);
        button04 = findViewById(R.id.button04);
        button05 = findViewById(R.id.button05);
        button06 = findViewById(R.id.button06);
        button07 = findViewById(R.id.button07);
        button08 = findViewById(R.id.button08);
        button09 = findViewById(R.id.button09);
        buttonDot = findViewById(R.id.buttonDot);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonFactorial = findViewById(R.id.buttonFactorial);
        buttonClear = findViewById(R.id.buttonClear);
        leftBraces = findViewById(R.id.leftBraces);
        rightBraces = findViewById(R.id.rightBraces);

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("0");

            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("1");

            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText("2");

            }
        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText("3");

            }
        });

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText("4");

            }
        });

        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText("5");
            }
        });

        button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText("6");
            }
        });

        button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("7");

            }
        });

        button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("8");

            }
        });

        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("9");

            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(".");

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String expression = resultTv.getText().toString();
                String[] subExpressions = expression.split("[\\+\\-*/()]");

                for (String str : subExpressions) {
                    if (str.contains("!")) {
                        String factString = "factorial(" + str.replace("!", "") + ")";
                        expression = expression.replace(str, factString);
                    }
                }

                webView.evaluateJavascript("function factorial(n){return n==0?1:n*factorial(n-1)} (function() { return " + expression + "; })();", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String s) {
                        Log.d("Answer", s);

                        if (s.equals("null")) {
                            Toast.makeText(CalculatorActivity.this, "打錯了！！！！！", Toast.LENGTH_LONG).show();
                        } else {
                            resultTv.setText(s);
                        }
                    }
                });

            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("+");

            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("-");

            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("*");

            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("/");

            }
        });

        buttonFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("!");

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTv.setText("");

            }
        });

        leftBraces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText("(");

            }
        });

        rightBraces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText(")");

            }
        });


    }

    private void updateText(String stringToAdd) {
        String oldString = resultTv.getText().toString();
        resultTv.setText(oldString += stringToAdd);
    }


}