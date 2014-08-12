package com.exadel.util;

public final class BuilderUtil {
	public static final String emptyField="empty";
    public static String nullCheck(Object o){
        if(o!=null)
            return o.toString();
        return emptyField;
    }
}
