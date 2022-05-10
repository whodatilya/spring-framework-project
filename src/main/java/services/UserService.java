package services;

import dtos.RegistrationDto;
import dtos.UserDto;
import models.User;

import java.util.List;

public interface UserService {
    void addUser(UserDto userDto);
    void signUp(RegistrationDto registrationDto);
    List<User> getUsers();
    User getUserById(Long id);
    int getUserCountByLastName(String lastName);
    boolean emailDoesntExist(String email);
}
