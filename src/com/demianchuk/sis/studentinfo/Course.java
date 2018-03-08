package com.demianchuk.sis.studentinfo;
 
import java.util.Objects;

public class Course {
    private String department;
    private String number;

    public Course(String department, String number) {
        this.department = department;
        this.number = number;
    }
    
    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null || !(object instanceof Course))
            return false;
        Course that = (Course)object;
        return 
            this.department.equals(that.department) &&
            this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        final int hashMultiplier = 41;
        int hash = 7;
        hash = hashMultiplier * hash + department.hashCode();
        hash = hashMultiplier * hash + number.hashCode();
        return hash;
    }
}
