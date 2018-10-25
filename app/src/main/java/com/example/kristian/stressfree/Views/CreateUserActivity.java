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

    private static final String STATE_NAME = "saveName";
    private static final String STATE_PASSWORD1 = "savePassword1";
    private static final String STATE_PASSWORD2 = "savePassword2";
    private static final String STATE_EMAIL = "saveEmail";

    private CreateUserPresenter presenter;
    private TextView name;
    private TextView email;
    private TextView password1;
    private TextView password2;
    private Button createUser;

    private Spinner theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        password1 = findViewById(R.id.editPassword);
        password2 = findViewById(R.id.editRePassword);
        createUser = findViewById(R.id.btCreate);
        theme = findViewById(R.id.spinnerTheme);
        presenter = new CreateUserPresenter(this);


        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter.checkPassword(password1.getText().toString(), password2.getText().toString())) {
                    presenter.createAccount(email.getText().toString(), password1.getText().toString());
                } else {
                    Toast.makeText(CreateUserActivity.this, getResources().getString(R.string.EnsKode),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //create a list of items for the spinner.
        String[] items = new String[]{"1", "2", "3"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        theme.setAdapter(adapter);


        theme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position == 0){
                    name.setText("Theme 1");
                }
                if(position == 1){
                    getApplication().setTheme(R.style.LightBlue);
                }
                if(position == 2){
                    name.setText("Theme 3");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        if (savedInstanceState != null) {
            email.setText(savedInstanceState.getString(STATE_EMAIL, ""));
            password1.setText(savedInstanceState.getString(STATE_PASSWORD1, ""));
            password2.setText(savedInstanceState.getString(STATE_PASSWORD2, ""));
            name.setText(savedInstanceState.getString(STATE_NAME, ""));
        }
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_EMAIL, email.getText().toString());
        outState.putString(STATE_NAME, name.getText().toString());
        outState.putString(STATE_PASSWORD1, password1.getText().toString());
        outState.putString(STATE_PASSWORD2, password2.getText().toString());
    }
}


