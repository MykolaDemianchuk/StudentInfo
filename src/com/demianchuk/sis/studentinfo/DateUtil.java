package com.demianchuk.sis.studentinfo;

import java.util.*;

public class DateUtil {
    
    private DateUtil(){}
    
    public static Date createDate(int year, int month, int date){
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, date);
        return calendar.getTime();
    }
    
}
