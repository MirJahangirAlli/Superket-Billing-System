package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.OutputStream;
import java.util.ArrayList;

public class CashierDashboard extends AppCompatActivity {
    private ArrayList<String > data=new ArrayList<String>();
    private ArrayList<String > data1=new ArrayList<String>();
    private ArrayList<String > data2=new ArrayList<String>();
    private ArrayList<String > data3=new ArrayList<String>();

    private TableLayout table;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button b1;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_dashboard);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);


        ed4 = findViewById(R.id.txtsub);
        ed5 = findViewById(R.id.txtpay);
        ed6 = findViewById(R.id.txtbal);
        b1 = findViewById(R.id.btn1);


        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int subtotal = Integer.parseInt(ed4.getText().toString());
                int pay = Integer.parseInt(ed5.getText().toString());
                int bal = pay - subtotal;

                ed6.setText(String.valueOf(bal));
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();

            }
        });


    }
    public void add()
    {
        int tot;
        String productname=ed1.getText().toString();
        int price=Integer.parseInt(ed2.getText().toString());
        int  qty=Integer.parseInt(ed3.getText().toString());
        tot=price*qty;
        data.add(productname);
        data1.add(String.valueOf(price));
        data2.add(String.valueOf(qty));
        data3.add(String.valueOf(tot));





        TableLayout table=(TableLayout) findViewById(R.id.tb1);
        TableRow row=new TableRow(this);
        TextView t1=new TextView(this);
        TextView t2=new TextView(this);
        TextView t3=new TextView(this);
        TextView t4=new TextView(this);

        String total;
        int sum=0;
        for(int i=0;i<data.size();i++)
        {
            String pname=data.get(i);
            String prc=data1.get(i);
            String quantity=data2.get(i);
            total=data3.get(i);

            t1.setText(pname);
            t2.setText(prc);
            t3.setText(quantity);
            t4.setText(total);

            sum=sum+Integer.parseInt(data3.get(i).toString());


        }
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        table.addView(row);

        ed4.setText(String.valueOf(sum));
        ed1.setText((""));
        ed2.setText((""));
        ed3.setText((""));
        ed1.requestFocus();



    }
}