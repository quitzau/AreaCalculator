/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.topdanmark.area.controller;

import dk.topdanmark.area.entity.Square;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpq
 */
@Stateless
public class SquareCalculator {
    
    @PersistenceContext()
    EntityManager em;
    
    public Square calculateArea(double side){
        Square square = new Square();
        square.area = side * side;
        return square;
    }
    
    public void saveSquare(Square square){
        em.persist(square);
    }
    
}
