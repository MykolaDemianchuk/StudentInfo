/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demianchuk.sis.studentinfo;

import junit.framework.TestCase;

/**
 *
 * @author Nick
 */
public class PerformanceTest  extends TestCase {
    private static final double tolerance = 0.005;
    public void testAverage(){
        Performance performance = new Performance();
        performance.setNumberOfTests(4);
        performance.set(0, 98);
        performance.set(1, 92);
        performance.set(2, 81);
        performance.set(3, 72);
        assertEquals(92, performance.get(1));
        assertEquals(85.75 , performance.average(), tolerance);
    }   
    
    public void testAverageForNoScore(){
        Performance performance = new Performance();
        assertTrue(Double.isNaN(performance.average()));
    }
}
