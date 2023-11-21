package com.example.loginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Dashboard extends AppCompatActivity {
    private Button btn;
    private CardView card1,card2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        btn=(Button) findViewById(R.id.logout1);
        card1=(CardView)findViewById(R.id.cardView);
        card2=(CardView)findViewById(R.id.cardView2);

        //Add cashier
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Admin_Dashboard.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Admin_Dashboard.this,DisplayCashierData.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an AlertDialog
                Alert();
            }
        });
    }


    private void Alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin_Dashboard.this);
        builder.setTitle("Are you sure you want to Logout?");

        // Add positive button - Yes, user wants to logout
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Perform logout action
                Intent intent = new Intent(Admin_Dashboard.this, welcome.class);
                startActivity(intent);
            }
        });

        // Add negative button - No, user doesn't want to logout
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Dismiss the dialog, do nothing
            }
        });

        // Show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    public void onBackPressed() {
       Alert();
    }
}