package com.accn.openbanking.entity;

/**
 * Created by richard.barnes-webb on 22/03/2017.
 */

import com.accn.openbanking.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID>{ }
