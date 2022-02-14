package com.taskmanagement.web.controll;

import com.taskmanagement.core.model.EmployeeDTO;
import com.taskmanagement.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emplyee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDTO>> list(){
        try{
            List<EmployeeDTO> employeeDTOList = employeeService.list();
            return ResponseEntity.ok().body(employeeDTOList);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
