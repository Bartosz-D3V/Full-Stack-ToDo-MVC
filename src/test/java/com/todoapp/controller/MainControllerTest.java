package com.todoapp.controller;

import com.todoapp.domain.ToDo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MainControllerTest {
    private final MockMvc mockMvc = standaloneSetup(new MainController()).build();

    private ToDo toDo;
    final static String url = "/todo";

    @Before
    public void setUp() throws Exception {
        toDo = new ToDo(0, "Use MockMVC", true);
        mockMvc.perform(post(url)
                .param("id", String.valueOf(toDo.getId()))
                .param("title", toDo.getTitle())
                .param("complete", String.valueOf(toDo.isComplete())));
    }

    @Test
    public void testGetAllToDos() throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void testGetSingleToDo() throws Exception {
        mockMvc.perform(get(url + "/{id}", 0))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(toDo.getId()))
                .andExpect(jsonPath("$.title").value(toDo.getTitle()))
                .andExpect(jsonPath("$.complete").value(toDo.isComplete()));
    }

    @Test
    public void testCreateToDo() throws Exception {
        mockMvc.perform(post(url)
                .param("id", String.valueOf(toDo.getId()))
                .param("title", toDo.getTitle())
                .param("completed", String.valueOf(toDo.isComplete())))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateToDo() throws Exception {
        toDo.setTitle("Deploy application to Heroku");
        toDo.setComplete(false);

        mockMvc.perform(put(url)
                .param("id", String.valueOf(toDo.getId()))
                .param("title", toDo.getTitle())
                .param("completed", String.valueOf(toDo.isComplete())))
                .andExpect(status().isOk());
        mockMvc.perform(get(url + "/{id}", 0))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(toDo.getId()))
                .andExpect(jsonPath("$.title").value(toDo.getTitle()))
                .andExpect(jsonPath("$.complete").value(toDo.isComplete()));
    }

    @Test
    public void testRemoveToDo() throws Exception {

    }
}