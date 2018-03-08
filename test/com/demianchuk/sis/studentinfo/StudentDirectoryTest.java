package com.demianchuk.sis.studentinfo;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;

public class StudentDirectoryTest extends TestCase{
    private Map<String, Student> students = new HashMap<String, Student>();
    
    public void add(Student student){
        //students.put(student.getId(), student);
    }
    
    public Student findById(String id){
        return students.get(id);
    }
}
