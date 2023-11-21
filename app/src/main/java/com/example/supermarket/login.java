package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private Button log, back;
    private EditText username, password;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        back = (Button) findViewById(R.id.back1);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        log = (Button) findViewById(R.id.login_btn);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chackValidInput();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backword();
            }
        });
    }

    private void chackValidInput() {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user.isEmpty() || user.length() < 3) {
            showError(username, "Enter Valid Username");
        } else if (pass.isEmpty() || pass.length() < 2) {
            showError(password, "Password must be 6 character");
        } else {
            signInAdmin(user, pass);
        }

    }

    public void backword() {
        Intent intent = new Intent(login.this, welcome.class);
        startActivity(intent);
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

    private void signInAdmin(String email, String password) {
        // Check if the provided email and password match the admin credentials
        if (email.equals("mirjahangiralli33@gmail.com") && password.equals("Jahangir")) {
            // If the credentials match, sign in the admin
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI or navigate to the next screen
                            Toast.makeText(login.this, "Login successful.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login.this, Admin_Dashboard.class);
                            startActivity(intent);
                            finish();
                            // You can add code to navigate to the next screen or update UI here
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(login.this, "Invalid password/Email.", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            // If the provided credentials don't match the admin credentials
            Toast.makeText(login.this, "Invalid password/Email for admin.", Toast.LENGTH_SHORT).show();
        }
    }
}






