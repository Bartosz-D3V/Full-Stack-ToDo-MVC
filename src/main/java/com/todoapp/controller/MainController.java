package com.todoapp.controller;

import com.todoapp.domain.ToDo;
import com.todoapp.service.ToDoService;
import com.todoapp.service.impl.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping(value = "/todo")
public class MainController {

    private ToDoService toDoService;

    public MainController() {
        this.toDoService = new ToDoServiceImpl();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ToDo> getAllToDos() {
        return toDoService.getToDos();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ToDo getSingleToDo(@PathVariable int id) {
        return toDoService.getSingleToDo(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createToDo(@ModelAttribute @Valid ToDo toDo) {
        toDoService.addToDo(toDo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateToDo(@ModelAttribute ToDo toDo) {
        toDoService.updateToDo(toDo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeToDo(@PathVariable int id) {
        toDoService.removeToDo(id);
    }
}