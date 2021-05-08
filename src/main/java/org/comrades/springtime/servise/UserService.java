package org.comrades.springtime.servise;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.User;

import java.util.List;


public interface UserService {

    User findByUsername(String login) throws UserNotFoundException;

    User findByUserId(Long id) throws UserNotFoundException;

    User findByRefreshToken(String refreshToken) throws UserNotFoundException;

    Long findIdByLogin(String login) throws UserNotFoundException;

    void delete(Long id) throws UserNotFoundException;

    User saveUser(User user) throws UserNotFoundException;

    void updateFirstName(User user, String firstname) throws UserNotFoundException;

    void updateSecondName(User user, String secondname) throws UserNotFoundException;

    void updateGroup(User user, String usergroup) throws UserNotFoundException;

    void updatePhone(User user, String phone) throws UserNotFoundException;

    void updateCourse(User user, String course) throws UserNotFoundException;

    void updateInfo(User user, String info) throws UserNotFoundException;

    void updateVk(User user, String vk) throws UserNotFoundException;

    void updateTg(User user, String tg) throws UserNotFoundException;

    User getCurrentUser() throws UserNotFoundException;

    List<User> getAllUsers() throws UserNotFoundException;

    List<User> getUsersByUsergroup(String usergroup) throws UserNotFoundException;

    List<User> getUsersByCourse(String course) throws UserNotFoundException;
}
