package com.demianchuk.sis.report;

import junit.framework.*;
import java.util.*;
import com.demianchuk.sis.studentinfo.*;
import static com.demianchuk.sis.report.ReportConstant.NEW_LINE;

/**
 *
 * @author Nick
 */
public class CourseReportTest extends TestCase{
    public void testReport(){
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(create("ENGL", "101", date));
        report.add(create("ITAL", "410", date));
        report.add(create("CZEC", "200", date));
        report.add(create("CZEC", "220", date));
        report.add(create("ITAL", "330", date));
        
        assertEquals(
                "CZEC 200" + NEW_LINE +
                "CZEC 220" + NEW_LINE +
                "ENGL 101" + NEW_LINE +
                "ITAL 330" + NEW_LINE +
                "ITAL 410" + NEW_LINE,
            report.text());               
    }
    
    private Session create(String name, String number, Date date){
        return CourseSession.create(new Course(name, number), date);
    }
    
}
