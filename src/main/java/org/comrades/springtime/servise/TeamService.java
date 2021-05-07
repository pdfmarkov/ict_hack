package org.comrades.springtime.servise;

import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.Team;
import org.comrades.springtime.module.User;

import java.util.List;

public interface TeamService {

    List<Post> getPostsByUser(User user);

    List<Post> getPosts();

    void clearByUser(User user);

    Team saveTeam(Team team);
}
