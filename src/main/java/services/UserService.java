package services;

import forms.LoginForm;
import forms.UserForm;
import models.User;

import javax.servlet.http.Cookie;

public interface UserService {
    User register(UserForm userForm);
    Cookie signIn(LoginForm loginForm);
}
