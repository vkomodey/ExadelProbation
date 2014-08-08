package com.exadel.dao;

import java.util.List;

public interface EmailDao{
    public List<String> getAllEmailsById(List<Long> listId);
}
