package org.comrades.springtime.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends UserBaseEntity {

    public User() {
    }

    public User(String login, String password) {
        super(login, password);
    }

    public User(String login, String password, String firstname, String secondname, String usergroup, String course) {
        super(login, password);
        this.firstname = firstname;
        this.secondname = secondname;
        this.course = course;
        this.usergroup = usergroup;
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "secondname")
    private String secondname;
    @Column(name = "usergroup")
    private String usergroup;
    @Column(name = "course")
    private String course;
    @Column(name = "phone")
    private String phone;
    @Column(name = "info")
    private String info;
    @Column(name = "vk")
    private String vk;
    @Column(name = "tg")
    private String tg;

    @ManyToOne()
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    @OneToMany(mappedBy = "user")
    private List<Post> postList;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(value = EnumType.STRING)
    private List<Role> roles;

    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(role);
    }
}
