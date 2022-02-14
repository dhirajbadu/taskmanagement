package com.taskmanagement.web.controll;

import com.taskmanagement.core.model.EmployeeDTO;
import com.taskmanagement.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        try{
            List<EmployeeDTO> employeeDTOList = employeeService.list();
            return ResponseEntity.ok().body(employeeDTOList);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeDTO employeeDTO){
        try{
           employeeDTO = employeeService.save(employeeDTO);
            return ResponseEntity.ok().body(employeeDTO);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
