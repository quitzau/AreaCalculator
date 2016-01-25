/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.topdanmark.area.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jpq
 */
@Entity
public class Circle extends Area{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
}
