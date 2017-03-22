package com.accn.openbanking.entity;

/**
 * Created by richard.barnes-webb on 22/03/2017.
 */

import lombok.Setter;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Table("employees")
@Data
public class Employee {

    private static final long serialVersionUID = 1L;

    @PrimaryKey @Setter
    private UUID id;
    private final String name;
    private final String email;

}
