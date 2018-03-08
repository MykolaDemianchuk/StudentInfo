package com.demianchuk.sis.studentinfo;

import junit.framework.TestCase;

/**
 *
 * @author Nick
 */
public class BasicGradingStrategyTest extends TestCase {
    public void testGetGradePoints(){
        GradingStrategy strategy = new BasicGradingStrategy();
        assertEquals(4, strategy.getGradePointsFor(Student.Grade.A));
        assertEquals(3, strategy.getGradePointsFor(Student.Grade.B));
        assertEquals(2, strategy.getGradePointsFor(Student.Grade.C));
        assertEquals(1, strategy.getGradePointsFor(Student.Grade.D));
        assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
    }
}
