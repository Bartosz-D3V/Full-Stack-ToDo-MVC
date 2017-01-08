package com.todoapp.repository.impl;

import com.todoapp.domain.ToDo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ToDoRepoImplTest {
    @Mock
    private ToDo toDo1, toDo2, toDo3;
    private ToDoRepoImpl toDoRepo;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        toDoRepo = new ToDoRepoImpl();
        when(toDo1.getId()).thenReturn(1);
        when(toDo2.getId()).thenReturn(2);
        when(toDo3.getId()).thenReturn(3);

        when(toDo1.getTitle()).thenReturn("Test 1");
        when(toDo2.getTitle()).thenReturn("Test 2");
        when(toDo3.getTitle()).thenReturn("Test 3");

        when(toDo1.isComplete()).thenReturn(false);
        when(toDo2.isComplete()).thenReturn(true);
        when(toDo3.isComplete()).thenReturn(true);

        toDoRepo.addToDo(toDo1);
        toDoRepo.addToDo(toDo2);
        toDoRepo.addToDo(toDo3);
    }

    @Test
    public void getToDos() throws Exception {
        assertEquals(3, toDoRepo.getToDos().size());
        for (int i = 1; i <= toDoRepo.getToDos().size(); i++) {
            assertThat(toDoRepo.getSingleToDo(i), instanceOf(ToDo.class));
        }
    }

    @Test
    public void getSingleToDo() throws Exception {
        assertEquals(toDo1, toDoRepo.getSingleToDo(1));
        assertEquals(toDo2, toDoRepo.getSingleToDo(2));
        assertEquals(toDo3, toDoRepo.getSingleToDo(3));
    }

    @Test
    public void addToDo() throws Exception {
        int currentSize = toDoRepo.getToDos().size();
        ToDo toDo = new ToDo(4, "Write tests", true);
        toDoRepo.addToDo(toDo);
        assertEquals(currentSize + 1, toDoRepo.getToDos().size());
    }


    @Test
    public void updateToDo() throws Exception {
        toDo1.setComplete(true);
        toDo1.setTitle("Write tests using Mock MVC");
        toDoRepo.updateToDo(toDo1);
        assertEquals(toDo1, toDoRepo.getSingleToDo(1));
    }

    @Test
    public void updateToDoById() throws Exception {

    }

    @Test
    public void removeToDo() throws Exception {

    }

}