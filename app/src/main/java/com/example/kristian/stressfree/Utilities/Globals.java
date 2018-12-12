package com.example.kristian.stressfree.Utilities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Views.LoginActivity;
import com.example.kristian.stressfree.Views.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Globals {

    private FirebaseAuth mAuth;
    private Context mContext;

    // constructor
    public Globals(Context context) {
        this.mContext = context;
        mAuth = FirebaseAuth.getInstance();
    }

    public void LogOutDialog(){
        if(IsUserLoggedIn()) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            // Yes button clicked
                            LogOut();
                            //((Activity) c).finish();
                            Intent intent = new Intent(mContext, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            mContext.startActivity(intent);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setMessage(R.string.LogafTekst).setPositiveButton(R.string.Ja, dialogClickListener)
                    .setNegativeButton(R.string.Nej, dialogClickListener).show();
        } else{

        }
    }

    public String getEmail(){
        return mAuth.getCurrentUser().getEmail();
    }



    public void LogOut() {
        mAuth.signOut();
    }


    // Check if there is currently a user logged in
    public Boolean IsUserLoggedIn(){
        if(mAuth.getCurrentUser() != null){
            return true;
        } else{
            return false;
        }
    }

}

