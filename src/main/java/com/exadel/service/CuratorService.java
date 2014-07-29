package com.exadel.service;


import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

import java.util.List;

public interface CuratorService extends GenericLivingService<Curator> {
    public List<Student> getSupervised(long curatorId);

    public Curator find(String login);


}
