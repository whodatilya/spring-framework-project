package ru.kpfu.itis.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UsersRepository;

import java.util.Optional;

@Service("customUserDetailsImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findUserByNickname(nickname);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserDetailsImpl(user);
        } else {
            throw new SecurityException("User with email <" + nickname + "> not found");
        }
    }
}
