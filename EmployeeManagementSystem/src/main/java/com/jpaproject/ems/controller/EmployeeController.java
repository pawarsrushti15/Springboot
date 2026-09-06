package com.jpaproject.ems.controller;

import com.jpaproject.ems.entity.Employee;
import com.jpaproject.ems.model.EmployeeAddRequest;
import com.jpaproject.ems.model.EmployeeAddResponse;
import com.jpaproject.ems.service.EmployeeService;
import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
private EmployeeService service;

    @GetMapping("/check")
   public String check(){
       return "Server is running...";
   }

@PostMapping("/add")
   public EmployeeAddResponse addEmployee(@RequestBody EmployeeAddRequest data) {


    return service.addEmployee(data);
}

@GetMapping("/all")
public List<EmployeeAddResponse> getAllEmployees(){
        return service.getAllEmployees();
}
@GetMapping("/id/{id}")
public EmployeeAddResponse getEmployeebyId(@PathVariable Long id){
        return service.getEmployee(id);
}

@GetMapping("/dept/{department}")
public List<Employee> getEmployeesByDepartment(@PathVariable String department){
return service.getAllEmployeeOfDepartment(department);


}

@PutMapping("/update/{id}")
public Employee updateEmployee(@RequestBody EmployeeAddRequest request,Long id){
return service.updateEmployee(request,id);

}


@DeleteMapping("/delete/{id}")
    public Map<String,String> deleteEmployee(@PathVariable Long id){

        service.removeEmployee(id);
        return Map.of("status","Employee has been deleted");

}
@DeleteMapping("/delete/all")
public Map<String,String >DeleteAllEmployee(){
        service.removeAllEmployees();

        return Map.of("status", "All Employees has been deleted ");
}
}
