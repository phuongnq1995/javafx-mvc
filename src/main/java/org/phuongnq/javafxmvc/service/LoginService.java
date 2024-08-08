package org.phuongnq.javafxmvc.service;

import org.phuongnq.javafxmvc.dto.UserCredentials;

public class LoginService {
    private static LoginService loginService = null;
    public static LoginService getInstance() {
        if (loginService == null) {
            loginService = new LoginService();
        }
        return loginService;
    }

    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Will show the main application screen.
     */
    public boolean authenticated(UserCredentials userCredentials) {
        try {
            // simulate the delay
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return !userCredentials.getUsername().equals("phuongnq");
    }
}
