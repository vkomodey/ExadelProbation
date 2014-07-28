package com.exadel.service.impl;

import com.exadel.dao.CuratorDao;
import com.exadel.model.entity.government.Curator;
import com.exadel.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuratorServiceImpl extends GenericLivingServiceImpl<Curator> implements CuratorService {
    @Autowired
    CuratorDao curatorDao;

    @Transactional
    public Curator find(String login) {
        return curatorDao.find(login);
    }
}
