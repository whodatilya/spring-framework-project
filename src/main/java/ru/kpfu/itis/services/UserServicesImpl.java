package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dtos.RegistrationDto;
import ru.kpfu.itis.dtos.UserDto;
import ru.kpfu.itis.enums.Role;
import ru.kpfu.itis.exceptions.UserAlreadyExistException;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UsersRepository;

import java.util.List;

@Service("userService")
public class UserServicesImpl implements UserService {

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
