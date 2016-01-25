/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.topdanmark.area.controller;

import dk.topdanmark.area.entity.Circle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpq
 */
@Stateless
public class CircleCalculator {
    
    @PersistenceContext()
    EntityManager em;
    
    
    public Circle calculateArea(double radius){
        Circle circle = new Circle();
        circle.area = (Math.PI * Math.pow(radius, 2)); 
        return circle;
    }
    
    public void saveCircle(Circle circle){
        em.persist(circle);
    }
    
    
}
