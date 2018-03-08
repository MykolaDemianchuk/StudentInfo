package com.demianchuk.sis.studentinfo;

/**
 *
 * @author Nick
 */
public interface GradingStrategy {
    int getGradePointsFor(Student.Grade grade);    
}
