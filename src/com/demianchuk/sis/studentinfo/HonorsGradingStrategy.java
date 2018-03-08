package com.demianchuk.sis.studentinfo;

/**
 *
 * @author Nick
 */
public class HonorsGradingStrategy extends BasicGradingStrategy{

    @Override
    public int getGradePointsFor(Student.Grade grade) {
        int points = super.getGradePointsFor(grade);
        if(points > 0)
            points++;
        return points;
    }
}
