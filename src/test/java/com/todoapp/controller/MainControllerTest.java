package com.todoapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javaws.Main;
import com.todoapp.domain.ToDo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MainControllerTest {
//    private MockMvc mockMvc;
//    private ObjectMapper objectMapper = new ObjectMapper();
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
//        this.mockMvc = standaloneSetup(new MainController()).build();
    }

    @Test
    public void testGetAllToDos() throws Exception {

    }

    @Test
    public void testGetSingleToDo() throws Exception {
//        ToDo toDo = new ToDo(0, "Commit changes", true);
//        String toDoJSON = objectMapper.writeValueAsString(toDo);
//        assertTrue(toDoJSON != null);
    }

    @Test
    public void testCreateToDo() throws Exception {

    }

    @Test
    public void testUpdateToDo() throws Exception {

    }

    @Test
    public void testRemoveToDo() throws Exception {

    }
}