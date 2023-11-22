package com.example.loginpage;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayCashierData extends AppCompatActivity {

    TextView nameTextView,useridTextView,mobTextView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display_cashier_data);
//    }

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cashier_data);

//        nameTextView = findViewById(R.id.name1);
//        useridTextView = findViewById(R.id.userid1);
//        mobTextView = findViewById(R.id.phone1);


//        String userName = getIntent().getStringExtra("cname");
//        String userId = getIntent().getStringExtra("cuid");
//        String userMob = getIntent().getStringExtra("cmob");

//        nameTextView.setText(userName);
//        nameTextView.setText(userId);
//        nameTextView.setText(userMob);

        tableLayout = findViewById(R.id.table1);

        // Retrieve data if needed immediately when this activity starts
        fetchAllUserData();
    }

    private void fetchAllUserData() {
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");

        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    UserData userData = userSnapshot.getValue(UserData.class);
                    if (userData != null) {
                        addRowToTable(userData);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors here
            }
        });
    }

    private void addRowToTable(UserData userData) {
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        // Add TextViews for each data field
        addTextViewToRow(userData.fname, tableRow);
        addTextViewToRow(userData.userid, tableRow);
        addTextViewToRow(userData.phone, tableRow);
        addTextViewToRow(userData.address, tableRow);
        addTextViewToRow(userData.email, tableRow);

        // Add the TableRow to the TableLayout
        tableLayout.addView(tableRow);
    }

    private void addTextViewToRow(String text, TableRow tableRow) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        tableRow.addView(textView);
    }
}
