package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import dtos.RegistrationDto;
import dtos.UserDto;
import enums.Role;
import exceptions.UserAlreadyExistException;
import models.User;
import repositories.UsersRepository;

import java.util.List;

@Service("userService")
public class UsersServicesImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void addUser(UserDto userDto) {
        User user = User.builder()
                .lastName(userDto.getLastName())
                .firstName(userDto.getFirstName())
                .build();
        usersRepository.save(user);
    }

    @Override
    public void signUp(RegistrationDto userDto) {
        if (!usersRepository.existsByNickname(userDto.getNickname())) {
            User user = User.builder()
                    .lastName(userDto.getLastName())
                    .firstName(userDto.getFirstName())
                    .nickname(userDto.getNickname())
                    .passwordHash(passwordEncoder.encode(userDto.getPassword()))
                    .role(Role.ROLE_USER)
                    .build();
            usersRepository.save(user);
        } else {
            throw new UserAlreadyExistException(String.format("Пользователь с nickname=%s уже существует", userDto.getNickname()));
        }
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public int getUserCountByLastName(String lastName) {
        return usersRepository.countUserByLastName(lastName);
    }

    @Override
    public boolean emailDoesntExist(String email) {
        return usersRepository.existsByNickname(email);
    }
}
