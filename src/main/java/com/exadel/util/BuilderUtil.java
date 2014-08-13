package com.exadel.util;

import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.Technology;

import java.text.SimpleDateFormat;
import java.util.Set;

public final class BuilderUtil {
	public static final String emptyField="empty";
    public static String nullCheck(Object o){
        if(o!=null)
            return o.toString();
        return emptyField;
    }

    public static String dateConvert(Student stud){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if(stud.getWork()!=null)
            if(stud.getWork().getWorkStartDate()!=null)
                return dateFormat.format(stud.getWork().getWorkStartDate().getTime());
        return emptyField;
    }

    public static String convertTechnologySet(Set<Technology> tech){
        StringBuilder result= new StringBuilder();
        if(tech!=null){
            for(Technology item : tech){
                result.append(item.getName());
                result.append(" ");
            }
            if(!result.toString().equals(""))
                return result.toString();
        }
        return BuilderUtil.emptyField;
    }
}
