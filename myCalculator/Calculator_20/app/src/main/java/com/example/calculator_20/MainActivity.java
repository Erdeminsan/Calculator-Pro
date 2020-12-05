package com.example.calculator_20;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText resault;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resault = findViewById(R.id.resaultText);
    }
    String number=null;
    int firstnumber =0;
    int  lastNumber=0;
    boolean operator=false;
    String statuts =null;
    public void clear(View view){
        number=null;
        firstnumber =0;
        lastNumber=0;
        resault.setText(String.valueOf(0));
    }
    public void delete(View view){
        if(!(resault.getText().toString().equals("")))
        {
            String copyScreen = resault.getText().toString();
            copyScreen=copyScreen.substring(0,copyScreen.length()-1);
            resault.setText(copyScreen);
        }
    }
    public void click(View view){
        if(number==null){
            number=view.getTag().toString();
        }else{
            number=number+view.getTag().toString();
        }

        operator=true;
        resault.setText(number);
    }
    public void addition(){
        lastNumber=Integer.parseInt(resault.getText().toString());
        firstnumber = firstnumber +lastNumber;
        resault.setText(""+ firstnumber);
    }
    public void sum(View view){
        if ("Multiplication".equals(statuts)) {
            if (operator)
                multiply();
        } else if ("Division".equals(statuts)) {
            if (operator)
                divide();
        } else if ("Extraction".equals(statuts)) {
            if (operator)
                extract();
        } else {
            if (operator) {
                addition();
            }
        }
        statuts ="Sum";
        number=null;
        operator =false;
    }
    public void multiply(){
        lastNumber=Integer.parseInt(resault.getText().toString());
        firstnumber = firstnumber *lastNumber;
        resault.setText(""+ firstnumber);
    }
    public void multiplication(View view){
        if ("Sum".equals(statuts)) {
            if (operator)
                addition();
        } else if ("Division".equals(statuts)) {
            if (operator)
                divide();
        } else if ("Extraction".equals(statuts)) {
            if (operator)
                extract();
        } else {
            if (operator) {
                multiply();
            }
        }
        statuts ="Multiplication";
        number=null;
        operator =false;
    }
    public void divide(){
        lastNumber=Integer.parseInt(resault.getText().toString());
        firstnumber = firstnumber /lastNumber;
        resault.setText(""+ firstnumber);
    }
    public void division(View view){
        if ("Multiplication".equals(statuts)) {
            if (operator)
                multiply();
        } else if ("Sum".equals(statuts)) {
            if (operator)
                addition();
        } else if ("Extraction".equals(statuts)) {
            if (operator)
                extract();
        } else {
            if (operator) {
                divide();
            }
        }
        statuts ="Division";
        number=null;
        operator =false;
    }
    public void extract(){
        lastNumber=Integer.parseInt(resault.getText().toString());
        firstnumber = firstnumber -lastNumber;
        resault.setText(""+ firstnumber);
    }
    public void extraction(View view){

        if(statuts =="Multiplication"){

            if(operator)
                multiply();
        }else if(statuts =="Division"){
            if(operator)
                divide();
        }else if (statuts =="Sum"){

            if(operator)
                addition();
        } else {
            if (operator){
                extract();
            }
        }
        statuts ="Extraction";
        number=null;
        operator =false;
    }
     public void equals(View view){
        if(operator==true){
            if (statuts =="Sum"){
                firstnumber = firstnumber +Integer.parseInt(resault.getText().toString());
            }  if (statuts =="Extraction"){
                firstnumber = firstnumber -Integer.parseInt(resault.getText().toString());
            }
            if (statuts =="Division"){
                firstnumber = firstnumber /Integer.parseInt(resault.getText().toString());
            }
            if (statuts =="Multiplication"){
                firstnumber = firstnumber *Integer.parseInt(resault.getText().toString());
              }
                resault.setText(""+ firstnumber);
            }
        operator=false;
       }
}