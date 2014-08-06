package com.exadel.dao;


import java.util.List;

import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

public interface CuratorDao extends GenericLivingDao<Curator> {
    public List<Student> getSupervised(long curatorId);
    public List<Curator> getActive();
}
