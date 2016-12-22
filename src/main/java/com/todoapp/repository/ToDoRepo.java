package com.todoapp.repository;

import com.todoapp.domain.ToDo;

import java.util.List;

/**
 * Created by User on 16/06/2016.
 */
public interface ToDoRepo {
    List<ToDo> getToDos();

    ToDo getSingleToDo(int id);

    void addToDo(ToDo toDo);

    void updateToDo(ToDo toDo);

    void updateToDoById(int id, ToDo toDo);

    void removeToDo(int id);
}
