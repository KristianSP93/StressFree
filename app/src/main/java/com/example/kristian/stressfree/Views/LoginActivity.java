package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kristian.stressfree.Presenters.LoginPresenter;
import com.example.kristian.stressfree.Presenters.SoundPresenter;
import com.example.kristian.stressfree.R;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.Context {

    private LoginPresenter presenter;
    private static final String STATE_EMAIL = "saveEmail";
    private static final String STATE_PASSWORD = "savePassword";
    private TextView email, kodeord;
    private Button logind, createUser, withoutlogin, forgotpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter(this);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.loginMail);
        kodeord = findViewById(R.id.loginKode);
        logind = findViewById(R.id.btLogin);
        createUser = findViewById(R.id.btCreateuser);
        withoutlogin = findViewById(R.id.btWithoutLogin);
        forgotpassword = findViewById(R.id.btForgotPassword);


        logind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString() == "" || kodeord.getText().toString() == ""){

                } else {
                    presenter.signin(email.getText().toString(), kodeord.getText().toString());
                }
            }
        });
/*
        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SoundPresenter.CreateUserActivity.class);
                startActivity(intent);
            }
        });
        */

        withoutlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.withoutLogin();
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.forgotPassword();
            }
        });

        if (savedInstanceState != null) {
            email.setText(savedInstanceState.getString(STATE_EMAIL, ""));
            kodeord.setText(savedInstanceState.getString(STATE_PASSWORD, ""));
        }


        // HUSK AT SLETTE!!!!
        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        email.setText("test10@gmail.com");
        kodeord.setText("Test123");
        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void GoMainactivity(FirebaseUser user){
        kodeord.setText("");
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("userLogIn",user);
        startActivity(intent);
    }

    public void GoMainactivitWithoutLogin(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void enterMail(){
        Toast.makeText(LoginActivity.this, getResources().getString(R.string.Korrektmail),
                Toast.LENGTH_SHORT).show();
    }


    public void forgotPasswordSucces(){
        Toast.makeText(LoginActivity.this, getResources().getString(R.string.KodeMailSendt),
                Toast.LENGTH_SHORT).show();
    }

    public void showAuthError(){
        Toast.makeText(LoginActivity.this, getResources().getString(R.string.ForkertEmailKode),
                Toast.LENGTH_SHORT).show();
    }

    public String getMail(){
        return email.getText().toString();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_EMAIL, email.getText().toString());
        outState.putString(STATE_PASSWORD, kodeord.getText().toString());
    }
}
