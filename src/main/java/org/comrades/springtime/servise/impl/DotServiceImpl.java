package org.comrades.springtime.servise.impl;

import org.comrades.springtime.dao.DotRepository;
import org.comrades.springtime.module.Dot;
import org.comrades.springtime.module.DotBaseEntity;
import org.comrades.springtime.module.User;
import org.comrades.springtime.servise.DotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotServiceImpl implements DotService {
    
    private DotRepository dotRepository;

    @Autowired
    public DotServiceImpl(DotRepository dotRepository) {this.dotRepository = dotRepository; }

    @Override
    public List<Dot> getDotsByUser(User user) {
        return dotRepository.findDotsByUser(user);
    }

    @Override
    public void clearByUser(User user) {
//        return dotRepository.deleteAllByUser(user);
        for(Dot dot : user.getDotList()) {
            dotRepository.delete(dot);
//            dotRepository.removeByDotId(dot.getDotId());
        }
    }


    @Override
    public Dot saveDot(Dot dot) {
        return dotRepository.save(dot);
    }
}
