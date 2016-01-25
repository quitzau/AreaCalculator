/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.topdanmark.area.controller;

import dk.topdanmark.area.entity.Circle;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jimmy
 */
public class CircleCalculatorTest {
    
    private static final CircleCalculator INSTANCE = new CircleCalculator();
    
    public CircleCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DefaultPersistenceUnit");
        INSTANCE.em = emf.createEntityManager();
        EntityTransaction trx = INSTANCE.em.getTransaction();
        trx.begin();

    }
    
    @After
    public void tearDown() {
        EntityTransaction trx = INSTANCE.em.getTransaction();
        trx.commit();

    }

    /**
     * Test of calculateArea method, of class CircleCalculator.
     */
    @org.junit.Test
    public void testCalculateArea() throws Exception {
        System.out.println("calculateArea");
        double radius = 20.0;
        
        Circle expResult = new Circle();
        expResult.area = Math.PI * radius * radius;
        Circle result = INSTANCE.calculateArea(radius);
        assertEquals(expResult.area, result.area, 1e-15);  
    }
    
    @Test
    public void testCalculateAreaNullRadius() throws Exception {
        double radius = 0;
        
        Circle expResult = new Circle();
        expResult.area = 0;
        Circle result = INSTANCE.calculateArea(radius);
        assertEquals(expResult.area, result.area, 1e-15);  
    }
    
    @Test
    public void testSaveCircle() throws Exception {
        
        Circle circle = new Circle();
        circle.area = 10;
        INSTANCE.saveCircle(circle);
       
    }
    
    
    
    
}
