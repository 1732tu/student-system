package com.example.demo1.boda.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable {
    private Integer id;
    private String name;
    private String brand;
    private double price;
}
