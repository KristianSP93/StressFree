package com.example.kristian.stressfree.Presenters;

import com.example.kristian.stressfree.Models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SettingsPresenter {

    private User user;
    private SettingsPresenter.Context view;

    private FirebaseAuth mAuth;
    private String SETTINGSPRESENTER = "SETTINGS PRESENTER";

    public SettingsPresenter(SettingsPresenter.Context view) {
        this.user = new User();
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
        view.updateUI(mAuth.getCurrentUser().getDisplayName(), mAuth.getCurrentUser().getEmail());
    }

    public boolean checkPassword(String p1, String p2) {
        return p1.equals(p2);
    }


    public void saveInfo() {
        FirebaseUser fu = mAuth.getCurrentUser();
        user = view.getUser();
        if (user.getEmail() != fu.getEmail()) {
            mAuth.getCurrentUser().updateEmail(user.getEmail());
        }
        if (user.getName() != fu.getDisplayName()) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(user.getName()).build();
            mAuth.getCurrentUser().updateProfile(profileUpdates);
        }
        if(user.getPassword().isEmpty()){

        } else{
            mAuth.getCurrentUser().updatePassword(user.getPassword());
        }
    }

    public interface Context {
        User getUser();
        void updateUI(String Name, String Email);
    }
}
