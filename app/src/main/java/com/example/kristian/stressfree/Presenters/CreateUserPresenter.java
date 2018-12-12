package com.example.kristian.stressfree.Presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kristian.stressfree.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class CreateUserPresenter {

    private Context view;
    private FirebaseAuth mAuth;
    private final String CREATEUSERPRESENTER = "CREATE USER PRESENTER";

    public CreateUserPresenter(Context view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
    }

    public boolean checkPassword(String p1, String p2) {
        return p1.equals(p2);
    }


    public void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    // This is can be optimized since it will now run on the main thread instead of the activity thread.
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(CREATEUSERPRESENTER, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user != null){
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(view.getName())
                                        .build();
                                user.updateProfile(profileUpdates);
                            }
                            view.finishAct();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(CREATEUSERPRESENTER, "createUserWithEmail:failure", task.getException());
                            view.showAuthError();
                        }
                        // ...
                    }
                });
    }


    public interface Context {
        void showAuthError();
        void finishAct();
        String getName();
    }

}


