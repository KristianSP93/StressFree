package com.example.kristian.stressfree.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kristian.stressfree.Models.User;
import com.example.kristian.stressfree.Presenters.CreateUserPresenter;
import com.example.kristian.stressfree.Presenters.SettingsPresenter;
import com.example.kristian.stressfree.R;

public class SettingsActivity extends AppCompatActivity implements SettingsPresenter.Context {

    private SettingsPresenter presenter;
    private TextView name, email, password1, password2;
    private Button save, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialising widgets
        name = findViewById(R.id.settingsName);
        email = findViewById(R.id.settingsEmail);
        password1 = findViewById(R.id.settingsPassword);
        password2 = findViewById(R.id.settingsRePassword);
        save = findViewById(R.id.btSaveSettings);
        cancel = findViewById(R.id.btCancelSettings);
        presenter = new SettingsPresenter(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter.checkPassword(password1.getText().toString(), password2.getText().toString())) {
                    presenter.saveInfo();
                    finish();
                } else {
                    Toast.makeText(SettingsActivity.this, getResources().getString(R.string.EnsKode),
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

    public void updateUI(String Name, String Email){
        if(Name != null){
            name.setText(Name);
        }
        if(Email != null){
            email.setText(Email);
        }
    }

    public User getUser(){
        User h = new User();
        h.setName(name.getText().toString());
        h.setEmail(email.getText().toString());
        h.setPassword(password1.getText().toString());
        return h;
    }


}
