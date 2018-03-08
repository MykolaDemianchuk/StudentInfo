package com.demianchuk.sis.studentinfo;

import com.demianchuk.sis.studentinfo.DateUtil;
import com.demianchuk.sis.studentinfo.CourseSession;

import java.util.*;

public class CourseSessionTest extends SessionTest{
        
    public void testCourseDates(){
        Date startDate = DateUtil.createDate(2003, 1, 6);
        Session session = createSession(createCourse(), startDate);
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
       
    public void testCount(){
        CourseSession.resetCount();
        createSession(createCourse(), new Date());
        assertEquals(1, CourseSession.getCount());
        createSession(createCourse(), new Date());
        assertEquals(2, CourseSession.getCount());
    }
        
    private Course createCourse(){
        return new Course("ENGL", "101");
    }
    
    protected Session createSession(Course course, Date date){
        return CourseSession.create(course, date);
    }
}
