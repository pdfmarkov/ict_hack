package org.comrades.springtime.dao;

import org.comrades.springtime.module.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamByTeamId(Long teamId);

    List<Team> findTeamsByName(String name);

    Team findTeamByNameAndLogin(String name, String login);


}
