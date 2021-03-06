package org.comrades.springtime.servise.impl;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.dao.UserRepository;
import org.comrades.springtime.module.User;
import org.comrades.springtime.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String login) throws UserNotFoundException {
        User user;

        try {
            user = userRepository.findUserByLogin(login);
        } catch (UserNotFoundException ex) {
            //TODO: log UserNotFoundException
            throw new UserNotFoundException(ex.getMessage());
        }
        if (user == null) throw new UserNotFoundException("User not found.");
        return user;
    }

    @Override
    public User findByUserId(Long id) throws UserNotFoundException {
        User user;

        try {
            user = userRepository.findUserByUID(id);
        } catch (UserNotFoundException ex) {
            //TODO: log UserNotFoundException
            throw new UserNotFoundException(ex.getMessage());
        }

        if (user == null) throw new UserNotFoundException("");

        return user;
    }

    @Override
    public User findByRefreshToken(String refreshToken) throws UserNotFoundException {
        User user;

        try {
            user = userRepository.findUserByRefreshToken(refreshToken);
        } catch (UserNotFoundException ex) {
            //TODO: log UserNotFoundException
            throw new UserNotFoundException(ex.getMessage());
        }

        if (user == null) throw new UserNotFoundException("");

        return user;
    }

    @Override
    public Long findIdByLogin(String login) throws UserNotFoundException {
        User user;

        try {
            user = userRepository.findUserByLogin(login);
        } catch (UserNotFoundException ex) {
            //TODO: log UserNotFoundException
            throw new UserNotFoundException(ex.getMessage());
        }
        if (user == null) throw new UserNotFoundException("User not found.");
        return user.getUID();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByUsergroup(String usergroup) {
        User user = new User();

        user.setUsergroup(usergroup);
        Example<User> userExample = Example.of(user);
        return userRepository.findAll(userExample);
    }

    @Override
    public List<User> getUsersByCourse(String course) {
        User user = new User();

        user.setCourse(course);
        Example<User> userExample = Example.of(user);
        return userRepository.findAll(userExample);
    }

    @Override
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public void updateFirstName(User user, String firstname) {
        user.setFirstname(firstname);
        userRepository.updateUserFirstName(user.getUID(), firstname);

    }

    @Override
    public void updateSecondName(User user, String secondname) {
        user.setSecondname(secondname);
        userRepository.updateUserSecondName(user.getUID(), secondname);
    }

    @Override
    public void updateGroup(User user, String group) {
        user.setUsergroup(group);
        userRepository.updateUserUserGroup(user.getUID(), group);
    }

    @Override
    public void updatePhone(User user, String phone) {
        user.setPhone(phone);
        userRepository.updateUserPhone(user.getUID(), phone);

    }

    @Override
    public void updateCourse(User user, String course) {
        user.setCourse(course);
        userRepository.updateUserUserCourse(user.getUID(), course);
    }

    @Override
    public void updateInfo(User user, String info) {
        user.setInfo(info);
        userRepository.updateUserUserInfo(user.getUID(), info);
    }

    @Override
    public void updateVk(User user, String vk) {
        user.setInfo(vk);
        userRepository.updateUserUserInfo(user.getUID(), vk);
    }

    @Override
    public void updateTg(User user, String tg) {
        user.setInfo(tg);
        userRepository.updateUserUserInfo(user.getUID(), tg);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = null;

        try {
            user = userRepository.findUserByLogin(userName);
        } catch (UserNotFoundException ignored) {
        }

        return user;
    }

    @Override
    public void delete(Long id) throws UserNotFoundException {
        User user;
        try {
            user = findByUserId(id);
        } catch (UserNotFoundException ex) {
            //TODO: log UserNotFoundException
            throw new UserNotFoundException(ex.getMessage());
        }

        userRepository.delete(user);
    }
}
