package org.comrades.springtime.servise.impl;

import org.comrades.springtime.dao.TeamRepository;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.Team;
import org.comrades.springtime.module.User;
import org.comrades.springtime.servise.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Post> getPostsByUser(User user) {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }

    @Override
    public List<Team> findByName(String name) {
        return teamRepository.findTeamsByName(name);
    }

    @Override
    public void clearByUser(String name, String login) {
        teamRepository.delete(teamRepository.findTeamByNameAndLogin(name, login));
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team findByTeamId(Long teamId) {
        return teamRepository.findTeamByTeamId(teamId);
    }
}
