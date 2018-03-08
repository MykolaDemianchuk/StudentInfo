package com.demianchuk.sis.report;

import com.demianchuk.sis.studentinfo.*;
import junit.framework.*;
import java.io.*;
import static com.demianchuk.sis.report.ReportConstant.*;
import static junit.framework.TestCase.assertEquals;

public class RosterReporterTest extends TestCase{
    private Session session;
    
    protected void setUp(){
        session = 
                CourseSession.create(
                        new Course("ENGL", "101"),
                        DateUtil.createDate(2003, 1, 6));
        
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
    }
    
    
    
    public void testRosterReporter() throws IOException {
        Writer writer = new StringWriter();
        new RosterReporter(session).writeReport(writer);
        assertReportContents(writer.toString());
    }
    
    private void assertReportContents(String rosterReport){
        assertEquals(
            String.format(ROSTER_REPORT_HEADER 
                    + "A%n" 
                    + "B%n" 
                    + ROSTER_REPORT_FOOTER, session.getNumberOfStudents()),
            rosterReport);
    }
    
    public void testFileReport() throws IOException {
        final String filename = "testFiledReport.txt";
        
        try{
            delete(filename);

            new RosterReporter(session).writeReport(filename);

            StringBuffer buffer = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                buffer.append(String.format(line + "%n"));
            }
            reader.close();

            assertReportContents(buffer.toString());
        }
        finally {
            delete(filename);
        }
    }
    
    private void delete(String filename) {
        File file = new File(filename);
        if(file.exists())
            assertTrue("unable to delete " + filename, file.delete());
    }
}
