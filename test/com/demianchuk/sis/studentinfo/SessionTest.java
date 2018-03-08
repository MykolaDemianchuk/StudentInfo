package com.demianchuk.sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import java.net.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


/**
 *
 * @author Nick
 */
public abstract class SessionTest extends TestCase{
    private static final int CREDITS = 3;
    private Session session;
    private Date startDate;
    
    public void setUp(){
        startDate = DateUtil.createDate(2003, 1, 6);    
        session = createSession(new Course("ENGL", "101"), startDate);
        session.setNumberOfCredits(CREDITS);
    }
    
    abstract protected Session createSession(Course course, Date startDate);
        
    public void testCreate(){
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    public void testEnrollStudents(){
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        
        Student student2 = new Student("Coralee DeVaughhn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));        
    }
    
    public void testComparable(){
        final Date date = new Date();
        Session sessionA = CourseSession.create(new Course("CMSC", "101"), date);
        Session sessionB = CourseSession.create(new Course("ENGL", "101"), date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
        
        
        Session sessionC = CourseSession.create(new Course("CMSC", "101"), date);
        assertEquals(0, sessionA.compareTo(sessionC));
        
        Session sessionD = CourseSession.create(new Course("CMSC", "210"), date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);
    }
    
    public void testSessionLength(){
        Session session = createSession(new Course("", ""), new Date());
        assertFalse(session.getSessionLength() == 0);     
    }
    
    public void testAverageGpaForPartTimeStudents(){
        session.enroll(createFullTimeStudent());
        
        Student partTimer1 = new Student("1");
        partTimer1.addGrade(Student.Grade.A);
        session.enroll(partTimer1);
        
        session.enroll(createFullTimeStudent());
        
        Student partTimer2 = new Student("2");
        partTimer2.addGrade(Student.Grade.B);
        session.enroll(partTimer2);
        
        assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);
    } 
    
    private Student createFullTimeStudent(){
        Student student = new Student("a");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }
    
    public void testIterate(){
        enrollStudents(session);
        
        List<Student> results = new ArrayList<Student>();
        for(Student student : session)
            results.add(student);
        
        assertEquals(session.getAllStudents(), results);
        
    }
    
    private void enrollStudents(Session session){
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));
    }
    
    public void testSessionUrl() throws SessionException{
        final String url = "http://course.langrsoft.com/cmsc300";
        session.setUrl(url);
        assertEquals(url, session.getUrl().toString());
    }
    
    public void testInvalidSessionUrl() {
        final String url = "httsp://course.langrsoft.com/cmsc300";
        try{
            session.setUrl(url);
            fail("expected exception due to invalid protocol in URL");
        }
        catch(SessionException expectedException){
            Throwable cause = expectedException.getCause();
            assertEquals(MalformedURLException.class, cause.getClass());
        }
    }
}
