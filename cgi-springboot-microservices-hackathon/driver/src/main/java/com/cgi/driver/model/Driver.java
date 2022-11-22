package com.cgi.driver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {

    @Id
    private Integer driverid;
    @NotNull
    private String firstname;
    @NotNull
    private Number telephonenumber;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String enginesize;
    @NotNull
    private String quoteamount;

}
