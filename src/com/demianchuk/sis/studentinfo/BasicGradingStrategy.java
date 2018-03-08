package com.demianchuk.sis.studentinfo;

/**
 *
 * @author Nick
 */
public class BasicGradingStrategy implements GradingStrategy{
    
    public int getGradePointsFor(Student.Grade grade){
        return grade.getPoints();
    }
}
