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
public class ScorerTest extends TestCase {
    public void testCaptureScore(){
        Scorer scorer = new Scorer();
        assertEquals(75, scorer.score("75"));
    }

    public void testBadScoreEntered(){
        
        Scorer scorer = new Scorer();
        try{
            scorer.score("sd");
            fail("expected NumberFormatException on bad input");
        }
        catch(NumberFormatException success){}
        
    }

    public void testIsValid(){
        Scorer scorer = new Scorer();
        assertTrue(scorer.isValid("75"));
        assertFalse(scorer.isValid("abd"));
    }
}
