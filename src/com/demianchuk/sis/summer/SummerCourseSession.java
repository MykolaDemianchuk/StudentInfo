package com.demianchuk.sis.summer;

import com.demianchuk.sis.studentinfo.*;
import java.util.*;

/**
 *
 * @author Nick
 */
public class SummerCourseSession extends Session{
    public static Session create(Course course, Date startDate){
        return new SummerCourseSession(course, startDate);    
    }
    
    private SummerCourseSession(Course course, Date startDate){
        super(course, startDate);
    }
    
    @Override
    protected int getSessionLength(){
        return 8;
    }
}
