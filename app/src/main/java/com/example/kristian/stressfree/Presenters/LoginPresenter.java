package com.example.kristian.stressfree.Presenters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;

import com.example.kristian.stressfree.Models.User;
import com.example.kristian.stressfree.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresenter {

    private Context view;
    private String forgot_password = "";
    private Activity activity;
    private FirebaseAuth mAuth;
    private final String LOGINPRESENTER = "LOG IN PRESENTER";

    public LoginPresenter(Context view) {
        this.view = view;
        activity = (Activity) view;

        mAuth = FirebaseAuth.getInstance();
    }

    public void signin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(LOGINPRESENTER, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            view.GoMainactivity(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(LOGINPRESENTER, "signInWithEmail:failure", task.getException());
                            view.showAuthError();
                        }

                        // ...
                    }
                });
    }

    public void forgotPassword() {

        // Created from https://stackoverflow.com/questions/10903754/input-text-dialog-android with the comment from Aaron.
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(R.string.IndtastEmail));


        final EditText input = new EditText(activity);

        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton(activity.getResources().getString(R.string.Send), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                forgot_password = input.getText().toString();
                if(!forgot_password.isEmpty()) {
                    mAuth.sendPasswordResetEmail(forgot_password)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        view.forgotPasswordSucces();
                                    } else {
                                        view.enterMail();
                                    }
                                }
                            });
                } else{
                    view.enterMail();
                }
            }
        });
        builder.setNegativeButton(activity.getResources().getString(R.string.Annuller), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                forgot_password = "";
                dialog.cancel();
            }
        });

        builder.show();


    }

    public void withoutLogin() {
        view.GoMainactivitWithoutLogin();
    }


    public interface Context {
        void showAuthError();

        void forgotPasswordSucces();

        void enterMail();

        void GoMainactivity(FirebaseUser user);

        void GoMainactivitWithoutLogin();

    }
}
