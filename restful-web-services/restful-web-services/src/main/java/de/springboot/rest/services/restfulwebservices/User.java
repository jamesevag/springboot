package de.springboot.rest.services.restfulwebservices;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Date;

@ApiModel(description = "All user infos")
@Entity
public class User {

    @Id
    @GeneratedValue
    @Positive(message = "Must be positive number")
    private Integer id;

    @Size(min = 2,message = "At least 2 chars")
    private String name;

    @Past(message = "Date must be in the past")
    @ApiModelProperty(notes="can not be in the past")
    private Date date;

    public User(){
    }

    public User(Integer id,String name,Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

}
