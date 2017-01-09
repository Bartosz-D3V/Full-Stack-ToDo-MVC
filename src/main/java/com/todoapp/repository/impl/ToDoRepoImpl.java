package com.todoapp.repository.impl;

import com.todoapp.domain.ToDo;
import com.todoapp.repository.ToDoRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ToDoRepoImpl implements ToDoRepo {
    private List<ToDo> toDos = new ArrayList<ToDo>();

    @Override
    public List<ToDo> getToDos() {
        return toDos;
    }

    @Override
    public ToDo getSingleToDo(int id) {
        for (ToDo singleToDo : toDos) {
            if (singleToDo.getId() == id) {
                return singleToDo;
            }
        }
        return null;
    }

    @Override
    public void addToDo(ToDo toDo) {
        Boolean uniqueToDo = true;
        if (toDos.size() > 0) {
            for (ToDo singleToDo : toDos) {
                if (singleToDo.getId() == toDo.getId()) {
                    updateToDo(toDo);
                    uniqueToDo = false;
                    break;
                } else if (singleToDo.getId() == toDos.size()) {
                    uniqueToDo = true;
                }
            }
        }
        if (uniqueToDo) {
            toDos.add(toDo);
        }
    }

    @Override
    public void updateToDo(ToDo toDo) {
        for (ToDo singleToDo : toDos) {
            if (singleToDo.getId() == (toDo.getId())) {
                singleToDo.setId(toDo.getId());
                singleToDo.setTitle(toDo.getTitle());
                singleToDo.setComplete(toDo.isComplete());
            }
        }
    }

    @Override
    public void removeToDo(int id) {
        for (ToDo singleToDo : toDos) {
            if (singleToDo.getId() == id) {
                toDos.remove(singleToDo);
            }
        }
    }
}
