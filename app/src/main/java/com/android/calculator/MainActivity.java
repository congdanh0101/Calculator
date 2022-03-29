package com.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText et_num1,et_num2;
    int num1,num2;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean getNumber(){
        et_num1 = (EditText) findViewById(R.id.et_number1);
        et_num2 = (EditText) findViewById(R.id.et_number2);

        String s1 = et_num1.getText().toString();
        String s2 = et_num2.getText().toString();

        tv_result = (TextView)findViewById(R.id.tv_result);

        if(!s1.isEmpty() && !s2.isEmpty() &&!s1.equals(null) &&!s2.equals(null)){
            num1 = Integer.parseInt(s1) ;
            num2 = Integer.parseInt(s2);
            return true;
        }else{
            String result = "Please enter your number value";
            tv_result.setText(result);
            return false;
        }
    }
    public void doAdd(View v){
        if(getNumber()){
            int result = num1 + num2;
            tv_result.setText(Integer.toString(result));
        }
    }
    public void doSub(View v) {
        if (getNumber()) {
            int result = num1 - num2;
            tv_result.setText(Integer.toString(result));
        }
    }
    public void doMul(View v) {
        if (getNumber()) {
            int result = num1 * num2;
            tv_result.setText(Integer.toString(result));
        }
    }
    public void doDiv(View v){
        if(getNumber()){
            if(num2 == 0){
                tv_result.setText("Please enter number 2 different with 0");
            }else{
                double result = num1 / (num2 * 1.0);
                tv_result.setText(Double.toString(result));
            }
        }
    }
    public void doPow(View v){
        if(getNumber()){
            if(num1 == 0 && num2 ==0){
                tv_result.setText("Please enter number different with 0");
            }else{
                double result = Math.pow(num1,num2);
                tv_result.setText(Double.toString(result));
            }
        }
    }
    public void doFac(View v){
        et_num1 = (EditText) findViewById(R.id.et_number1);

        String s1 = et_num1.getText().toString();

        tv_result = (TextView)findViewById(R.id.tv_result);

        if(!s1.isEmpty() && !s1.equals(null)){
            num1 = Integer.parseInt(s1);
            if(num1 <0) tv_result.setText("Please enter a positive number");
            else if(num1 ==0) tv_result.setText(Integer.toString(1));
            else{
                int result = 1;
                for(int i = 1;i <=num1; i++) result = result*i;
                tv_result.setText(Integer.toString(result));
            }
        }else{
            String result = "Please enter your number value";
            tv_result.setText(result);
        }
    }
}