/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.topdanmark.area.controller;

import dk.topdanmark.area.entity.Square;
import javax.ejb.Stateless;

/**
 *
 * @author jpq
 */
@Stateless
public class SquareCalculator {
    
    public Square calculateArea(double side){
        Square square = new Square();
        square.area = side * side;
        return square;
    }
    
}
