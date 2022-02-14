package com.taskmanagement.web.controll;

import com.taskmanagement.core.model.EmployeeDTO;
import com.taskmanagement.core.model.TaskGroupDTO;
import com.taskmanagement.core.service.EmployeeService;
import com.taskmanagement.core.service.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskGroup")
public class TaskGroupController {

    @Autowired
    private TaskGroupService taskGroupService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        try{
            List<TaskGroupDTO> taskGroupDTOList = taskGroupService.list();
            return ResponseEntity.ok().body(taskGroupDTOList);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TaskGroupDTO taskGroupDTO){
        try{
           taskGroupDTO = taskGroupService.save(taskGroupDTO);
            return ResponseEntity.ok().body(taskGroupDTO);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
