package com.example.kristian.stressfree.Views;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kristian.stressfree.Presenters.CreateUserPresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.MyEditTextDatePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.TimeZone;

public class CreateUserActivity extends AppCompatActivity implements CreateUserPresenter.Context {

    //private static final String STATE_NAME = "saveName";
    //private static final String STATE_PASSWORD1 = "savePassword1";
    //private static final String STATE_PASSWORD2 = "savePassword2";
    //private static final String STATE_EMAIL = "saveEmail";

    private CreateUserPresenter presenter;
    private TextView name, email, password1, password2;
    private Button createUser, cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        // Initialising widgets
        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        password1 = findViewById(R.id.editPassword);
        password2 = findViewById(R.id.editRePassword);
        createUser = findViewById(R.id.btCreate);
        cancel = findViewById(R.id.btCancel);
        presenter = new CreateUserPresenter(this);


        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password1.getText().toString().isEmpty() || password2.getText().toString().isEmpty()){
                    Toast.makeText(CreateUserActivity.this, getResources().getString(R.string.UdfyldAlt), Toast.LENGTH_LONG).show();
                } else if (presenter.checkPassword(password1.getText().toString(), password2.getText().toString())) {
                    presenter.createAccount(email.getText().toString(), password1.getText().toString());
                } else {
                    Toast.makeText(CreateUserActivity.this, getResources().getString(R.string.EnsKode),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



    @Override
    public void showAuthError() {
        Toast.makeText(CreateUserActivity.this, getResources().getString(R.string.GodkendelseFejlede),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishAct() {
        finish();
    }

    public String getName(){
        return name.getText().toString();
    }

    //@Override
    //protected void onSaveInstanceState(Bundle outState) {
       // super.onSaveInstanceState(outState);
        //outState.putString(STATE_EMAIL, email.getText().toString());
        //outState.putString(STATE_NAME, name.getText().toString());
        //outState.putString(STATE_PASSWORD1, password1.getText().toString());
        //outState.putString(STATE_PASSWORD2, password2.getText().toString());
    //}
}


