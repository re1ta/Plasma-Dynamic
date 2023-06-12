package Plasma.Dynamics.Service;

import Plasma.Dynamics.Dto.Role;
import Plasma.Dynamics.Dto.User;
import Plasma.Dynamics.Dto.UserDto;
import Plasma.Dynamics.Service.Details.UserInfoDetails;
import Plasma.Dynamics.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserInfoDetails(userRepo.findByUsername(username));
    }

    @Transactional
    public void createUser(UserDto users) {
        User user = new User();
        user.setUsername(users.getUsername());
        user.setPassword(passwordEncoder.encode(users.getPassword()));
        user.setRoles(Collections.singleton(Role.ADMIN));
        userRepo.save(user);
    }
}
