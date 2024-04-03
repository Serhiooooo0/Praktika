//02.04.2024 Челогузов Сергей Дмитриевич Класс описывает вход в аккаунт
package com.example.session_1_cheliva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity6 extends AppCompatActivity {

    private AppCompatButton log;
    private String emailText;
    private String passText;
    private EditText email;
    private EditText pass;

    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        log = findViewById(R.id.log);
        passText = "";
        emailText = "";

        email = findViewById(R.id.EmailAddress);
        pass = findViewById(R.id.Password);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailText = email.getText().toString();
                passText = pass.getText().toString();
                Validation(emailText, passText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailText = email.getText().toString();
                passText = pass.getText().toString();
                Validation(emailText, passText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void SignUp(View v){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
    public void LogIn(View v){
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }

    public void Forgot(View v){
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }

    public void Validation(String email, String pass){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() & pass.length() != 0){
            log.setEnabled(true);
            int colorB = Color.parseColor("#0560FA");
            log.setBackgroundColor(colorB);
        } else{
            log.setEnabled(false);
            int colorG = Color.parseColor("#A7A7A7");
            log.setBackgroundColor(colorG);
        }
    }

    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity6.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            user = null;
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    private void reload() { }

}


