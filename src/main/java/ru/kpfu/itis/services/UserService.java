package ru.kpfu.itis.services;

import ru.kpfu.itis.dtos.RegistrationDto;
import ru.kpfu.itis.dtos.UserDto;
import ru.kpfu.itis.models.User;

import java.util.List;

public interface UserService {
    void addUser(UserDto userDto);
    void signUp(RegistrationDto registrationDto);
    boolean nicknameDoesntExist(String email);
}
