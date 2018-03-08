package com.demianchuk.sis.report;

import java.util.*;
import static com.demianchuk.sis.report.ReportConstant.NEW_LINE;
import com.demianchuk.sis.studentinfo.*;

/**
 *
 * @author Nick
 */
public class CourseReport {
    private List<Session> sessions = 
            new ArrayList<Session>();
    
    public void add(Session session){
       sessions.add(session);
    }
    
    public String text(){
        Collections.sort(sessions);
        StringBuilder builder = new StringBuilder();
        for(Session session : sessions)
            builder.append(session.getDepartment() + " " +
                           session.getNumber() + NEW_LINE);
        return builder.toString();
    }
}
