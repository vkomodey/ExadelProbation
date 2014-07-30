package com.exadel.dao;


import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

import java.util.List;

public interface CuratorDao extends GenericLivingDao<Curator> {
    public List<Student> getSupervised(long curatorId);
}
