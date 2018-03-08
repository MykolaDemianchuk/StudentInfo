package com.demianchuk.sis.studentinfo;

import java.util.*;

public class CourseSession extends Session{
    private static int count;
    
    public static Session create(Course course, Date startDate){
        incrementCount();
        return new CourseSession(course, startDate);
    }
    
    protected CourseSession(Course course, Date startDate){
        super(course, startDate);
    }

    private static void incrementCount(){
        ++count; 
    }
    
    static void resetCount(){
        count = 0;
    }
            
    static int getCount(){
        return count;
    }
    
    @Override
    protected int getSessionLength(){
        return 16;
    }
}
