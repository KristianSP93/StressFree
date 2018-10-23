package com.example.kristian.stressfree.Views;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.MyEditTextDatePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.TimeZone;

public class CreateUserActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String CREATEUSERACTIVITY = "CREATE USER ACTIVITY";
    private MyEditTextDatePicker datepicker;
    private TextView name;
    private TextView email;
    private TextView password1;
    private TextView password2;
    private RadioGroup gender;
    private TextView birthday;
    private Button createUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        mAuth = FirebaseAuth.getInstance();
        datepicker = new MyEditTextDatePicker(CreateUserActivity.this, R.id.editBirthday);
        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        password1 = findViewById(R.id.editPassword);
        password2 = findViewById(R.id.editRePassword);
        createUser = findViewById(R.id.btCreate);


        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkPassword(password1.getText().toString(), password2.getText().toString())){
                    createAccount(email.getText().toString(), password1.getText().toString());
                } else{
                    Toast.makeText(CreateUserActivity.this, getResources().getString(R.string.EnsKode),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkPassword(String p1, String p2){
        return p1.equals(p2);
    }

    // Creates the user with all the information from the fields in the acitivity.
    public void createUser(){

    }


    public void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(CREATEUSERACTIVITY, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();



                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(CREATEUSERACTIVITY, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateUserActivity.this, getResources().getString(R.string.GodkendelseFejlede),
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }
}


