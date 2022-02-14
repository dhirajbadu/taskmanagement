package com.taskmanagement.web.controller;

import com.taskmanagement.core.entity.EmployeeEntity;
import com.taskmanagement.core.entity.TaskEntity;
import com.taskmanagement.core.entity.TaskGroupEntity;
import com.taskmanagement.core.enumconstant.TaskStatus;
import com.taskmanagement.core.repository.EmployeeRepository;
import com.taskmanagement.core.repository.TaskGroupRepository;
import com.taskmanagement.core.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@AutoConfigureMockMvc
public class TaskControllerSpec {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void saveWithOutSubTask() throws Exception{
        EmployeeEntity employeeEntity = employeeRepository.save(new EmployeeEntity("Dhiraj"));
        TaskGroupEntity taskGroup = taskGroupRepository.save(new TaskGroupEntity("Test"));
        String data = "{\"name\":\"Dhiraj\",\"description\":\"Test description\",\"taskGroup\":{\"id\":"+taskGroup.getId()+"},\"assignee\":{\"id\":"+employeeEntity.getId()+"},\"status\":\"PENDING\",\"timeSpend\":0}";

        String baseUrl = "http://localhost:" + port + "/task/save";
        this.mvc.perform(post(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data)
                .characterEncoding("utf-8")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("{\"id\":3,\"name\":\"Dhiraj\",\"description\":\"Test description\",\"taskGroup\":{\"id\":2,\"name\":\"Test\"},\"assignee\":{\"id\":1,\"name\":\"Dhiraj\"},\"status\":\"PENDING\",\"timeSpend\":0,\"subTask\":null}"));
    }

    @Test
    void saveWithSubTask() throws Exception{
        EmployeeEntity employeeEntity = employeeRepository.save(new EmployeeEntity("Dhiraj"));
        TaskGroupEntity taskGroup = taskGroupRepository.save(new TaskGroupEntity("Test"));
        TaskEntity subTask = taskRepository.save(new TaskEntity("Sub Task", "Desc", taskGroup, employeeEntity, TaskStatus.COMPLETED, 10));
        String data = "{\"name\":\"Dhiraj\",\"description\":\"Test description\",\"taskGroup\":{\"id\":"+taskGroup.getId()+"},\"assignee\":{\"id\":"+employeeEntity.getId()+"},\"status\":\"PENDING\",\"timeSpend\":0,\"subTask\":{\"id\":"+subTask.getId()+"}}";

        String baseUrl = "http://localhost:" + port + "/task/save";
        this.mvc.perform(post(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data)
                        .characterEncoding("utf-8")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("{\"id\":4,\"name\":\"Dhiraj\",\"description\":\"Test description\",\"taskGroup\":{\"id\":2,\"name\":\"Test\"},\"assignee\":{\"id\":1,\"name\":\"Dhiraj\"},\"status\":\"PENDING\",\"timeSpend\":0,\"subTask\":{\"id\":3,\"name\":\"Sub Task\",\"description\":\"Desc\",\"taskGroup\":{\"id\":2,\"name\":\"Test\"},\"assignee\":{\"id\":1,\"name\":\"Dhiraj\"},\"status\":\"COMPLETED\",\"timeSpend\":10,\"subTask\":null}}"));
    }

    @Test
    void list() throws Exception{
        String baseUrl = "http://localhost:" + port + "/task/list";
        this.mvc.perform(get(baseUrl)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void listWithData() throws Exception{
        EmployeeEntity employeeEntity = employeeRepository.save(new EmployeeEntity("Dhiraj"));
        TaskGroupEntity taskGroup = taskGroupRepository.save(new TaskGroupEntity("Test"));
        TaskEntity subTask = taskRepository.save(new TaskEntity("Sub Task", "Desc", taskGroup, employeeEntity, TaskStatus.COMPLETED, 10));
        String baseUrl = "http://localhost:" + port + "/task/list";
        this.mvc.perform(get(baseUrl)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":3,\"name\":\"Sub Task\",\"description\":\"Desc\",\"taskGroup\":{\"id\":2,\"name\":\"Test\"},\"assignee\":{\"id\":1,\"name\":\"Dhiraj\"},\"status\":\"COMPLETED\",\"timeSpend\":10,\"subTask\":null}]"));
    }

}
