package org.comrades.springtime.servise;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.User;

import java.util.List;


public interface UserService {

    User findByUsername(String login) throws UserNotFoundException;

    User findByUserId(Long id) throws UserNotFoundException;

    User findByRefreshToken(String refreshToken) throws UserNotFoundException;

    void delete(Long id) throws UserNotFoundException;

    User saveUser(User user);

    void updateFirstName(User user, String firstname);

    void updateSecondName(User user, String secondname);

    void updateThirdName(User user, String thirdname);

    void updatePhone(User user, String phone);

    User getCurrentUser();

    List<User> getAll();
}
