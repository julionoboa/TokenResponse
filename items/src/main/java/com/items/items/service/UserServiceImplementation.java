package com.items.items.service;

import com.items.items.model.User;
import com.items.items.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository = new UserRepository();

    @Override
    public boolean createUser(User user) {
        if (hasDesireLength(user) && !hasSpace(user) && !hasSpecialCharacter(user.getUsername()) && hasACapitalAndANumber(user) && user.getPassword().equals(user.getConfirmPassword())) {
            user.setPassword(encryptPassword(user.getPassword()));
            user.setConfirmPassword(user.getPassword());
            userRepository.addUser(user);
            return true;
        }
        System.out.println(user.getUsername() + user.getPassword() + user.getConfirmPassword());
        throw new RuntimeException("El usuario es invalido");
    }

    @Override
    public User getUserByUsername(String user) {
        return userRepository.getUserByUsername(user);
    }

    private boolean hasSpace(User user) {
        int validateUsername = 0;
        int validatePassword = 0;
        for (char actualChar : user.getUsername().toCharArray()) {
            if (Character.isWhitespace(actualChar)) {
                validateUsername = validateUsername + 1;
            }
        }
        for (char actualChar : user.getPassword().toCharArray()) {
            if (Character.isWhitespace(actualChar)) {
                validatePassword = validatePassword + 1;
            }
        }

        if (validatePassword == 0 && validateUsername == 0){
            return false;
        }
        System.out.println("El usuario o la contraseña posee un espacio.");
        return true;
    }

    private boolean hasSpecialCharacter(String string) {
        Pattern sPattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher sMatcher = sPattern.matcher(string);

        if (!sMatcher.matches()) {
            System.out.println("Posee caracteres especiales o un espacio en blanco.");
            return true;
        }
        return false;
    }

    private boolean hasDesireLength(User user) {
        if (user.getUsername().length() < 4 || user.getUsername().length() > 10) {
            System.out.println("El usuario tiene menos de 4 o más de 10 caracteres.");
            return false;
        }
        if (user.getPassword().length() < 6) {
            System.out.println("La contraseña tiene menos de 6 caracteres.");
            return false;
        }
        return true;
    }

    private boolean hasACapitalAndANumber(User user) {
        int capitalValidator = 0;
        int numberValidator = 0;
        char[] password = user.getPassword().toCharArray();

        for (char actualChar : password) {
            if (Character.isUpperCase(actualChar)) {
                capitalValidator = capitalValidator + 1;
            }
        }

        for (char actualChar : password) {
            if (Character.isDigit(actualChar)) {
                numberValidator = numberValidator + 1;
            }
        }

        if (numberValidator >= 1 && capitalValidator >= 1) {
            return true;
        }
        return false;
    }

    public static String encryptPassword(String string){
        char[] encryptedPassword = string.toCharArray();

        for (int i = 0; i < encryptedPassword.length; i++){
            encryptedPassword[i] = (char)(encryptedPassword[i] + (char) 6);
        }

        return String.valueOf(encryptedPassword);
    }

    public static String decryptPassword(String string){
        char[] decryptedPassword = string.toCharArray();

        for (int i = 0; i < decryptedPassword.length; i++){
            decryptedPassword[i] = (char)(decryptedPassword[i] - (char) 6);
        }

        return String.valueOf(decryptedPassword);
    }
}
