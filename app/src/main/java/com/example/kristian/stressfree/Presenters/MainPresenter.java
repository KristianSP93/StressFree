package com.example.kristian.stressfree.Presenters;

import com.example.kristian.stressfree.Models.User;
import com.google.firebase.auth.FirebaseAuth;

public class MainPresenter {

    private MainPresenter.Context view;
    private FirebaseAuth mAuth;

    // Constructor
    public MainPresenter(MainPresenter.Context view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
    }

    // Log out the current user
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

    // Interface to the methods in MainActivity
    public interface Context {

    }


}
