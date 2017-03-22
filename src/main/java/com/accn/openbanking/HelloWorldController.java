package com.accn.openbanking;

import com.accn.openbanking.entity.Employee;
import com.accn.openbanking.entity.EmployeeRepository;
import com.accn.openbanking.entity.Greeting;
import com.datastax.driver.core.utils.UUIDs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by richard.barnes-webb on 21/03/2017.
 */
@RestController
public class HelloWorldController {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private EmployeeRepository repository;


    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name)
    {
        return new Greeting(0, String.format("Hello %s", name));
    }

    @RequestMapping("/getAllEmps")
    public List<Employee> getAll()
    {
        log.info("Getting all...");
        List<Employee> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target;
    }

    @RequestMapping("/getEmp")
    public Employee getEmp(@RequestParam(value="id") String id)
    {
        log.info("Looking employee with ID: "+id);
        return repository.findOne(UUID.fromString(id));
    }

    @RequestMapping(value = "/delEmp", method = RequestMethod.DELETE)
    public void delEmp(@RequestParam(value="id") String id)
    {
        Employee emp = getEmp(id);
        log.info("Deleting employee: "+emp);
        repository.delete(emp);
    }

    @RequestMapping(value = "/newEmp", method = RequestMethod.PUT)
    public @ResponseBody Employee newEmp(@RequestBody Employee emp){
        log.info("Creating new employee: "+emp);
        emp.setId(emp.getId()!=null?emp.getId():UUIDs.timeBased());
        return repository.save(emp);
    }

}
