package com.demianchuk.sis;

import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(com.demianchuk.sis.report.AllTests.suite());
        suite.addTest(com.demianchuk.sis.studentinfo.AllTests.suite());
        suite.addTest(com.demianchuk.sis.summer.AllTests.suite());
        return suite;    
    }
}
