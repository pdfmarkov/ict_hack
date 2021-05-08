package org.comrades.springtime.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "team")
public class Team{

    public Team() {}

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;

    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "role")
    private String role;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
