package com.demianchuk.sis.studentinfo;

import com.demianchuk.sis.summer.*;

import junit.framework.*;

public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(SummerCourseSessionTest.class);
        suite.addTestSuite(DateUtilTest.class);
        suite.addTestSuite(PerformanceTest.class);
        suite.addTestSuite(BasicGradingStrategyTest.class);
        suite.addTestSuite(HonorsGradingStrategyTest.class);     
        suite.addTestSuite(ScorerTest.class);
        suite.addTestSuite(CourseTest.class);
        suite.addTestSuite(AccountTest.class);
        suite.addTestSuite(StudentUITest.class);
        return suite;
    }   
}
