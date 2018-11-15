package com.example.kristian.stressfree.Presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kristian.stressfree.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresenter {

    private User user;
    private Context view;

    private FirebaseAuth mAuth;
    private String LOGINPRESENTER = "LOG IN PRESENTER";

    public LoginPresenter(Context view) {
        this.user = new User();
        this.view = view;
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
        if(!view.getMail().isEmpty()) {
            mAuth.sendPasswordResetEmail(view.getMail())
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

    public void withoutLogin() {
        view.GoMainactivitWithoutLogin();
    }


    public interface Context {
        void showAuthError();

        void forgotPasswordSucces();

        void enterMail();

        void GoMainactivity(FirebaseUser user);

        void GoMainactivitWithoutLogin();

        String getMail();
    }
}
