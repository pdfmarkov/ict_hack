package org.comrades.springtime.dao;

import org.comrades.springtime.module.Dot;
import org.comrades.springtime.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DotRepository extends JpaRepository<Dot, Long> {

    List<Dot> findDotsByUser(User user);
}
