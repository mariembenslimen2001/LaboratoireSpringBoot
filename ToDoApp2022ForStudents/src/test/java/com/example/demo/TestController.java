package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.ToDo;

import com.example.demo.service.ToDoService;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class TestController {

    @MockBean
    private ToDoService service;
// si on enlève le mockservice , ça devient un test d'intégration(TestController fait appel à TestService qui fera appelTestRepository)
    @Autowired 
    private MockMvc mockMvc; 

    @Test
    @DisplayName("GET /todos success")
    void testGetTodosSuccess() throws Exception {
        // Setup our mocked service
        ToDo todo1 = new ToDo(1, "todoName1", true);
        ToDo todo2 = new ToDo(2, "todoName2", false);
        List lsttodo=new ArrayList();
        lsttodo.add(todo1);
        lsttodo.add(todo2);
        doReturn(lsttodo).when(service).getAllToDo();

        // Execute the GET request
        mockMvc.perform(get("/todo"))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate headers
                //.andExpect(header().string(HttpHeaders.LOCATION, "/todo"))

                // Validate the returned fields
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].text", is("todoName1")))
                .andExpect(jsonPath("$[0].completed", is(true)))
             
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].text", is("todoName2")))
                .andExpect(jsonPath("$[1].completed", is(false)));
    }

    @Test
    @DisplayName("GET /todo/1")
    void testGetTodoById() throws Exception {
        // Setup our mocked service
        ToDo todo1 = new ToDo(1, "todoname",true);
        doReturn(todo1).when(service).getToDoById(1);

        // Execute the GET request
        mockMvc.perform(get("/todo/{id}", 1L))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.text", is("todoname")))
                .andExpect(jsonPath("$.completed", is(true)));
        
        
    }

   
}
