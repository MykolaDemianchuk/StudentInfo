package com.demianchuk.sis.studentinfo;

import com.demianchuk.sis.studentinfo.DateUtil;
import junit.framework.*;
import java.util.*;

public class DateUtilTest extends TestCase{
    
    public void testCreate(){
        Date date = DateUtil.createDate(2000,1,1);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        assertEquals(2000, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }   
}
