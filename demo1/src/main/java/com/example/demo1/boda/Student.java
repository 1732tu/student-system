package com.example.demo1.boda;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private Integer studId;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String phone;
}
