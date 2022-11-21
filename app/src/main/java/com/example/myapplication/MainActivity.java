package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean addToText;
    boolean vClear;
    boolean next;

    int prevNumber;
    int nextNumber;
    int last;

    String text;
    String Scr;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addToText = true;
        vClear = false;
        next = false;
        prevNumber = 0;
        nextNumber = 0;
        last = 0;
        text = "";
        Scr = "";
        display = (TextView)findViewById(R.id.Screen);
    }

    public void NumberButton(View view)
    {
        if(vClear)SetClear();
        if(addToText)
        {
            text+= ((Button) view).getText().toString();
            Scr += ((Button) view).getText().toString();
            System.out.println(text);
            display.setText(Scr);
        }
        else
        {
            text = ((Button) view).getText().toString();
            Scr += ((Button) view).getText().toString();
            System.out.println(text);
            display.setText(Scr);
        }
        addToText = true;
    }
    public void SetClear()
    {
        display.setText("");
    }
     public void PlusButton(View view)
     {
         if(next) return;
         if(display.getText().toString().equals("")) return;
         int n = Integer.parseInt(text);
         prevNumber= n;
         last = 1;
         addToText = false;
         next = true;
         text = "";
         Scr += ((Button) view).getText().toString();
         display.setText(Scr);
         System.out.println(prevNumber);
     }
    public void MinusButton(View view)
    {
        if(next) return;
        if(display.getText().toString().equals("")) return;
        int n = Integer.parseInt(text);
        prevNumber= n;
        next = true;
        last = 2;
        addToText = false;
        text = "";
        Scr += ((Button) view).getText().toString();
        display.setText(Scr);
        System.out.println(prevNumber);
    }
    public void MultiButton(View view)
    {
        if(next) return;
        if(display.getText().toString().equals("")) return;
        int n = Integer.parseInt(text);
        prevNumber= n;
        last = 3;
        next = true;
        addToText = false;
        text = "";
        Scr += ((Button) view).getText().toString();
        display.setText(Scr);
        System.out.println(prevNumber);
    }
    public void DivButton(View view)
    {
        if(next) return;
        if(display.getText().toString().equals("")) return;
        int n = Integer.parseInt(text);
        if (n==0) return;
        prevNumber= n;
        last = 4;
        next = true;
        addToText = false;
        text = "";
        Scr += ((Button) view).getText().toString();
        display.setText(Scr);
        System.out.println(prevNumber);
    }

     public void Result(View view)
     {
         if(!addToText)
         {
             display.setText(Integer.toString(prevNumber));
             Scr = Integer.toString(prevNumber);
             return;
         }

         if (last == 0) return;
         if (last == 1)
         {
             int n = Integer.parseInt(text);
             prevNumber+= n;
             Scr = Integer.toString(prevNumber);
             text = Integer.toString(prevNumber);
             display.setText(Integer.toString(prevNumber));
         }
         if (last == 2)
         {
             int n = Integer.parseInt(text);
             prevNumber-= n;
             text = Integer.toString(prevNumber);
             Scr = Integer.toString(prevNumber);
             display.setText(Integer.toString(prevNumber));
         }
         if (last == 3)
         {
             int n = Integer.parseInt(text);
             prevNumber*= n;
             text = Integer.toString(prevNumber);
             Scr = Integer.toString(prevNumber);
             display.setText(Integer.toString(prevNumber));
         }
         if (last == 4)
         {
             if(prevNumber==0) return;
             int n = Integer.parseInt(text);
             if(n==0) return;
             prevNumber/= n;
             text = Integer.toString(prevNumber);
             Scr = Integer.toString(prevNumber);
             display.setText(Integer.toString(prevNumber));
         }
         next = false;
     }

     public void ClearButton(View view)
     {
         addToText = true;
         vClear = false;
         prevNumber = 0;
         nextNumber = 0;
         last = 0;
         text = "";
         Scr = "";
         display.setText("");
         next = false;
     }
}