package com.exadel.service;


import java.util.List;

import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

public interface CuratorService extends GenericLivingService<Curator> {
    public List<Student> getSupervised(long curatorId);

    public Curator find(String login);


}