package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Cashier_Login extends AppCompatActivity {

    private Button log,back;
    private EditText username,password;
    private TextView forgotpas;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_login);
        back=(Button) findViewById(R.id.back1);
        username=(EditText) findViewById(R.id.user);
        password=(EditText) findViewById(R.id.password);
        log=(Button) findViewById(R.id.login_btn);
        forgotpas=(TextView)findViewById(R.id.forgot);
        mAuth = FirebaseAuth.getInstance();
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
        forgotpas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cashier_Login.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
    }

    private void chackValidInput() {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user.isEmpty() || user.length() < 3) {
            showError(username, "Enter Valid Email");
        } else if (pass.isEmpty() || pass.length() < 6) {
            showError(password, "Password must be 6 character");
        }else{
            signInCashier(user, pass);

            }

    }
    public void backword(){
        Intent intent=new Intent(Cashier_Login.this,welcome.class);
        startActivity(intent);
    }
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

    private void signInCashier(String email, String password) {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI or navigate to the next screen
                            Toast.makeText(Cashier_Login.this, "Login successful.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Cashier_Login.this,DisplayCashierData.class);
                            startActivity(intent);
                            finish();
                            // You can add code to navigate to the next screen or update UI here
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Cashier_Login.this, "Invalid password/Email.", Toast.LENGTH_SHORT).show();
                        }
                    });
    }
}
