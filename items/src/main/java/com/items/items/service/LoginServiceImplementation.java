package com.items.items.service;

import com.items.items.model.Login;
import com.items.items.model.User;
import com.items.items.repository.LoginRepository;
import com.items.items.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation implements LoginService {
    @Autowired
    private UserRepository userRepository = new UserRepository();
    @Autowired
    private UserService userService = new UserServiceImplementation();
    @Autowired
    private LoginRepository loginRepository = new LoginRepository();

    @Override
    public boolean validateLogin(Login login) {
        User user = userService.getUserByUsername(login.getUsername());
        if (userRepository.getUserByUsername(login.getUsername()) != null &&
                UserServiceImplementation.decryptPassword(user.getPassword()).equals(login.getPassword())) {
            return true;
        }
        return false;
    }


}
