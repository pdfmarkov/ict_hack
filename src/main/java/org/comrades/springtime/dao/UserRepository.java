package org.comrades.springtime.dao;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByLogin(String login) throws UserNotFoundException;

    User findUserByUID(Long id) throws UserNotFoundException;

    User findUserByRefreshToken(String refreshToken) throws UserNotFoundException;

    User findUserByUsergroup(String usergroup) throws UserNotFoundException;

    User findUserByCourse(String course) throws UserNotFoundException;

    @Modifying
    @Transactional
    @Query("update User u set u.firstname = ?2 where u.UID = ?1")
    void updateUserFirstName(Long id, String firstname);

    @Modifying
    @Transactional
    @Query("update User u set u.secondname = ?2 where u.UID = ?1")
    void updateUserSecondName(Long id, String secondname);

    @Modifying
    @Transactional
    @Query("update User u set u.usergroup = ?2 where u.UID = ?1")
    void updateUserUserGroup(Long id, String usergroup);

    @Modifying
    @Transactional
    @Query("update User u set u.phone = ?2 where u.UID = ?1")
    void updateUserPhone(Long id, String phone);

    @Modifying
    @Transactional
    @Query("update User u set u.course = ?2 where u.UID = ?1")
    void updateUserUserCourse(Long id, String course);

    @Modifying
    @Transactional
    @Query("update User u set u.info = ?2 where u.UID = ?1")
    void updateUserUserInfo(Long id, String info);
}