package com.demianchuk.sis.report;

import junit.framework.*;

public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(CourseReportTest.class);
        suite.addTestSuite(ReportCardTest.class);
        return suite;
    }
}
