package com.taskmanagement.web.controll;

import com.taskmanagement.core.model.TaskDTO;
import com.taskmanagement.core.model.TaskGroupDTO;
import com.taskmanagement.core.service.TaskGroupService;
import com.taskmanagement.core.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        try{
            List<TaskDTO> taskDTOList = taskService.list();
            return ResponseEntity.ok().body(taskDTOList);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TaskDTO taskDTO){
        try{
           taskDTO = taskService.save(taskDTO);
            return ResponseEntity.ok().body(taskDTO);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody TaskDTO taskDTO){
        try{
            if(taskDTO == null || taskDTO.getId() == null){
                return ResponseEntity.badRequest().build();
            }

            if(taskService.getById(taskDTO.getId()) == null){
                return ResponseEntity.notFound().build();
            }
            taskDTO = taskService.update(taskDTO);
            return ResponseEntity.ok().body(taskDTO);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("taskId") Long taskId){
        try{
            if(taskId == null){
                return ResponseEntity.badRequest().build();
            }
            TaskDTO taskDTO = taskService.getById(taskId);
            if(taskDTO == null){
                return ResponseEntity.notFound().build();
            }
            taskService.delete(taskId);
            return ResponseEntity.ok().build();
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
