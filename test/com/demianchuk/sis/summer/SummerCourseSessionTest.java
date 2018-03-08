package com.demianchuk.sis.summer;

import com.demianchuk.sis.studentinfo.*;
import java.util.*;
import junit.framework.TestCase;

/**
 *
 * @author Nick
 */
public class SummerCourseSessionTest extends TestCase {
    public void testEndDate(){
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = 
                createSession(new Course("ENGL", "200"), startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeeksOut, session.getEndDate());
    }
    
    protected Session createSession(Course course, Date date){
        return SummerCourseSession.create(course, date);
    }
    
}
