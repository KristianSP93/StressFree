package com.example.kristian.stressfree;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
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
    MyEditTextDatePicker datepicker;
    TextView name;
    TextView email;
    TextView password1;
    TextView password2;
    RadioGroup gender;
    TextView birthday;
    Button createUser;

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


        createUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                createAccount(password1.toString(),email.toString());
                finish();
            }
        });

    }

    public void succesfulLogin(FirebaseUser user){
        Toast.makeText(CreateUserActivity.this, "Log ind succesfuld",
                Toast.LENGTH_SHORT).show();
    }

    public void createAccount (String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(CREATEUSERACTIVITY, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            succesfulLogin(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(CREATEUSERACTIVITY, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateUserActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }


    // https://stackoverflow.com/questions/14933330/datepicker-how-to-popup-datepicker-when-click-on-edittext
    // Denne klasse er skrevet af SatanEnglish og rettet af shridutt kothari.
    public class MyEditTextDatePicker  implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
        EditText _editText;
        private int _day;
        private int _month;
        private int _birthYear;
        private Context _context;

        public MyEditTextDatePicker(Context context, int editTextViewID)
        {
            Activity act = (Activity)context;
            this._editText = (EditText)act.findViewById(editTextViewID);
            this._editText.setOnClickListener(this);
            this._context = context;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            _birthYear = year;
            _month = monthOfYear;
            _day = dayOfMonth;
            updateDisplay();
        }
        @Override
        public void onClick(View v) {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

            DatePickerDialog dialog = new DatePickerDialog(_context, this,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dialog.show();

        }

        // updates the date in the birth date EditText
        private void updateDisplay() {

            _editText.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(_day).append("/").append(_month + 1).append("/").append(_birthYear).append(" "));
        }
    }

}


