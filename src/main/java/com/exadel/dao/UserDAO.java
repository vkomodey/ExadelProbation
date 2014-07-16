package com.exadel.dao;


import com.exadel.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    public void addUser(User user) throws SQLException;   //добавить студента
    public void updateUser(User user) throws SQLException;//обновить студента
    public User getUserById(Long id) throws SQLException;    //получить стедента по id
    public List getAllUsers() throws SQLException;              //получить всех студентов
    public void deleteUser(User user) throws SQLException;//удалить студента

}
