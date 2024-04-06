//Класс является окном для регистрации сделан 02 04 2024 Челогузов Сергей Дмитриевич
package com.example.session_1_cheliva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


import com.example.session_1_cheliva.MainActivity6;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity5 extends AppCompatActivity {

    private AppCompatButton login;
    private CheckBox terms;
    private String fioText;
    private String phoneText;
    private String emailText;
    private String passText;
    private String confText;
    private EditText email;
    private EditText fio;
    private EditText phone;
    private EditText pass;
    private EditText conf;

    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.button3);
        fioText = "";
        phoneText = "";
        emailText = "";
        passText = "";
        confText = "";

        email = findViewById(R.id.EmailAddres);
        fio = findViewById(R.id.editTextText2);
        phone = findViewById(R.id.TextPhoned);
        pass = findViewById(R.id.Password);
        conf = findViewById(R.id.Password2);
        terms = findViewById(R.id.checkBox);



        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailText = email.getText().toString();
                Validation(emailText, terms);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        terms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                emailText = email.getText().toString();
                Validation(emailText, terms);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fioText = fio.getText().toString();
                phoneText = phone.getText().toString();
                passText = pass.getText().toString();
                confText = conf.getText().toString();
                emailText = email.getText().toString();




                if(fioText.length() != 0 & Patterns.PHONE.matcher(phoneText).matches() & passText.length() != 0 & confText.length() != 0 & passText.equals(confText) == true){
                    createAccount(emailText, passText);
                    if(user != null) {
                        Intent intent = new Intent(MainActivity5.this, MainActivity11.class);
                        startActivity(intent);
                    }
                }
                if(fioText.length() == 0) {
                    fio.setBackground(getDrawable(R.drawable.okno2));
                } else {
                    fio.setBackground(getDrawable(R.drawable.okno));
                }
                if(Patterns.PHONE.matcher(phoneText).matches()) {
                    phone.setBackground(getDrawable(R.drawable.okno));
                } else {
                    phone.setBackground(getDrawable(R.drawable.okno2));
                }
                if(passText.length() == 0 || passText.equals(confText) == false) {
                    pass.setBackground(getDrawable(R.drawable.okno2));
                } else {
                    pass.setBackground(getDrawable(R.drawable.okno));
                }
                if(confText.length() == 0 || passText.equals(confText) == false) {
                    conf.setBackground(getDrawable(R.drawable.okno2));
                } else {
                    conf.setBackground(getDrawable(R.drawable.okno));
                }
            }

        });




    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    public void Validation(String email, CheckBox view){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() & view.isChecked() == true){
            login.setEnabled(true);
            login.setBackgroundColor(getColor(R.color.blue));
        } else{
            login.setEnabled(false);
            login.setBackgroundColor(getColor(R.color.gray));
        }
    }

    public void LogIn(View v){
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

    private void reload() { }



    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity5.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


}

