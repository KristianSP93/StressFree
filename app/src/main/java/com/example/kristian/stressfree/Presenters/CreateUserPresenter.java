package com.example.kristian.stressfree.Presenters;

import com.example.kristian.stressfree.Models.User;

public class CreateUserPresenter {

    private User user;
    private View view;

    public CreateUserPresenter(View view) {
        this.view = view;
    }



    public interface View{
        void createAccount(String email, String password);
    }

}
