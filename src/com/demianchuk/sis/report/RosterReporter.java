package com.demianchuk.sis.report;

import java.io.*;
import com.demianchuk.sis.studentinfo.*;
import static com.demianchuk.sis.report.ReportConstant.*;

public class RosterReporter {
        
    private Session session;
    private Writer writer;
    
    RosterReporter(Session session){
        this.session = session;        
    }
    
    void writeReport(Writer writer) throws IOException {
        this.writer = writer;
        writeHeader();
        writeBody();
        writeFooter();        
    }
    
    void writeReport(String filename) throws IOException {
        Writer bufferedWriter = new BufferedWriter(new FileWriter(filename));
        try{
            writeReport(bufferedWriter);
        }
        finally{
            bufferedWriter.close();
        }
    }
       
    void writeHeader() throws IOException {
        writer.write(String.format(ROSTER_REPORT_HEADER));
    }
    
    void writeBody() throws IOException {
        for(Student student : session.getAllStudents())
            writer.write(String.format(student.getName() + "%n"));
    }
    
    void writeFooter() throws IOException {
        writer.write(
            String.format(ROSTER_REPORT_FOOTER,
                          session.getAllStudents().size()));
    }
}
