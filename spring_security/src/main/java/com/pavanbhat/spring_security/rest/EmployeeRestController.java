package com.pavanbhat.spring_security.rest;


import com.pavanbhat.spring_security.entity.Employee;
import com.pavanbhat.spring_security.service.EmployeeService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // method 2: with service
//    define field
    private EmployeeService employeeService;


//    inject service into the constructor
    public EmployeeRestController(EmployeeService theEmployeeService){

        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a data
    @GetMapping("/employees")
    public List<Employee> findAll(){

        return  employeeService.findAll();
    }


    // method 1: without service
//    private EmployeeDAO employeeDAO;


    //quick and dirty: inject employee
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }

    //expose "/employees" and return a list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll(){
//        return  employeeDAO.findAll();
//    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //set id to 0 to force a save of new item..instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return  dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception to check employee

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id: " + employeeId;
    }
}
