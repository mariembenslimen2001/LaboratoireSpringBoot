package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.ToDoRepository;
import com.example.demo.service.ToDoService;
@SpringBootTest
class TestService {
	@Autowired
    private ToDoService todoService;
	
	//création du Mock

	@MockBean 
	private ToDoRepository todoRepository;

 @BeforeEach
public void setUp() throws Exception {
 ToDo t1 = new ToDo(1,"Deploy BD",true);
 when(todoRepository.findById(1L)).thenReturn(Optional.of(t1));


 }
 @Test
	public void whenValidID_thengetTodo() {
		ToDo found = todoService.getToDoById(1);
		assertThat(found.getText(), equalTo("Deploy BD"));
	}

	@Test
	public void whensaveToDo() {
		ToDo t2 = new ToDo(2, "clean code", false);
		when(todoRepository.save(t2)).thenReturn(t2);
		ToDo result = todoService.saveToDo(t2);
		assertThat(result.getId(), equalTo(2L));
		assertThat(result.getText(), equalTo("clean code"));
		assertThat(result.isCompleted(), equalTo(false));
	}
 
 
	@Test
	public void whenremoveToDo(){
		//Todo
		ToDo toDo = new ToDo(2, "ToDo Sample 8", true);
		todoService.removeToDo(toDo);
		verify(todoRepository, times(1)).delete(toDo);
		
	}



}
