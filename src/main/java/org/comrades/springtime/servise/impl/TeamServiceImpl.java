package org.comrades.springtime.servise.impl;

import org.comrades.springtime.dao.TeamRepository;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.Team;
import org.comrades.springtime.module.User;
import org.comrades.springtime.servise.TeamService;

import java.util.List;

public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Override
    public List<Post> getPostsByUser(User user) {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }

    @Override
    public void clearByUser(User user) {

    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
}
