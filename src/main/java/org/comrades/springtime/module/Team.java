package org.comrades.springtime.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "team")
public class Team{

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<User> userList;
}
