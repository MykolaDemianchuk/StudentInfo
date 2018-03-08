package com.demianchuk.sis.report;

import com.demianchuk.sis.studentinfo.Student;
import java.util.Objects;

public class Entry {
    private Student.Grade grade;
    private String message;
    Entry(Student.Grade grade, String message){
        this.grade = grade;
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.grade);
        hash = 97 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entry other = (Entry) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (this.grade != other.grade) {
            return false;
        }
        return true;
    }
}
