package com.demianchuk.sis.studentinfo;

import java.io.*;
import java.util.*;
import junit.framework.*;

public class StudentUITest extends TestCase {

    static private final String name = "Leo Xerces Schmoo";

    public void testCreateStudent() throws IOException {
        StringBuffer expectedOutput = new StringBuffer();
        StringBuffer input = new StringBuffer();
        setup(expectedOutput, input);
        byte[] buffer = input.toString().getBytes();

        InputStream inputStream = new ByteArrayInputStream(buffer);
        OutputStream outputStream = new ByteArrayOutputStream();

        InputStream consoleIn = System.in;
        PrintStream consoleOut = System.out;
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        try {
//            StudentUI ui = new StudentUI();
//            ui.run();
            StudentUI.main(new String[] {});
            assertEquals(
                    expectedOutput.toString(),
                    outputStream.toString());
            //assertStudents(ui.getAddedStudents());
        } finally {
            System.setIn(consoleIn);
            System.setOut(consoleOut);
        }
    }

    private String line(String input) {
        return String.format("%s%n", input);
    }

    private void assertStudents(List<Student> students) {
        assertEquals(1, students.size());
        Student student = students.get(0);
        assertEquals(name, student.getName());
    }

    private void setup(StringBuffer expectedOutput, StringBuffer input) {
        expectedOutput.append(StudentUI.MENU);
        input.append(line(StudentUI.ADD_OPTION));
        expectedOutput.append(StudentUI.NAME_PROMPT);
        input.append(line(name));
        expectedOutput.append(line(StudentUI.ADDED_MESSAGE));
        input.append(line(StudentUI.ADD_OPTION));
        expectedOutput.append(StudentUI.MENU);
        input.append(line(StudentUI.QUIT_OPTION));
    }
}
