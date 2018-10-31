package com.example.kristian.stressfree.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kristian.stressfree.R;


public class MainActivity extends AppCompatActivity {


Button btnSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSound = findViewById(R.id.btnSound);

        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SoundActivity.class);
                startActivity(intent);
            }
        });






    }




    private void test()
    {
        int i = 1+1;
    }
    private void test2() {int k = 1+4;}
    private void test3() {int a = 1;}


}
