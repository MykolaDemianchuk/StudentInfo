/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demianchuk.sis.studentinfo;

/**
 *
 * @author Nick
 */
public class Performance {
    private int[] tests = {};
    
    public void setNumberOfTests(int numberOfTests){
        tests = new int[numberOfTests];
    }
    
    public void set(int testNumber, int score){
        tests[testNumber] = score;
    }
    
    public int get(int testNumber){
        return tests[testNumber];
    }
    
    public double average(){
        double total = 0.0;
        for(int score : tests)
            total += score;
        return total / tests.length;
    }
}
