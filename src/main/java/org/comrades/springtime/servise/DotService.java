package org.comrades.springtime.servise;

import org.comrades.springtime.module.Dot;
import org.comrades.springtime.module.DotBaseEntity;
import org.comrades.springtime.module.User;

import java.util.List;

public interface DotService {

    List<Dot> getDotsByUser(User user);

    void clearByUser(User user);

    Dot saveDot(Dot dot);
}
