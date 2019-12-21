package com.example.rudapplication.rudlogin;

import com.example.rudapplication.model.User;

public class LoginRepository {

    private static volatile LoginRepository instance;
    private User user;

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        //dataSource.logout();
    }

    public User getLoggedIndUser() {
        return this.user;
    }

    public void setLoggedInUser(User user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}
