package com.demianchuk.sis.studentinfo;
import java.util.*;
import java.util.logging.Logger;

public class Student {
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    static final String TOO_MANY_NAME_PARTS_MSG = 
            "Student '%s' contains more than %d parts";
    static final int MAX_NAME_PARTS = 3;
    static final Logger logger = Logger.getLogger(Student.class.getName());

    public enum Grade {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);
          
        private int points;
    
        Grade(int points){
            this.points = points;
        }
    
        int getPoints(){
            return points;
        }
    }
    
    public enum Flag {
        ON_CAMPUS(1),
        TAX_EXEMPT(2),
        MINOR(4),
        TROUBLEMAKER(8);
        
        private int mask;
        
        Flag(int mask){
            this.mask = mask;
        }
    }
    
    private String firstName = "";
    private String middleName = "";
    private String lastName;
    private int credits;
    private String state = "";
    private String name;
    private List<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private List<Integer> charges = new ArrayList<Integer>();
    private int settings = 0x0;
    private String id;
    
    public Student(String fullName){
        this.name = fullName;
        credits = 0;
        List<String> nameParts = split(fullName);        
        if(nameParts.size() > MAX_NAME_PARTS){
            String message = String.format(TOO_MANY_NAME_PARTS_MSG,
                    fullName, MAX_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }
    
    public static Student findByLastName(String lastName) {
        return new Student(lastName);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }   

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
    
    private void setName(List<String> nameParts){
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if(nameParts.isEmpty())
            this.firstName = name;
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }
    
    private List<String> split(String fullName){
        List<String> results = new ArrayList<String>();
        for (String name : fullName.split(" "))
            results.add(name);
        return results;
    }
    
    private String removeLast(List<String>list){
        if(list.isEmpty())
            return "";
        return list.remove(list.size()- 1);
    }
    
    boolean isFullTime(){
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }
    
    int getCredits(){
        return credits;
    }
    
    void addCredits(int credits){
        this.credits += credits;
    }
    
    void setState(String state){
        this.state = state.toUpperCase();
    }
    
    boolean isInState(){
        return state.equals(Student.IN_STATE);
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }
       
    void addGrade(Grade grade){
        grades.add(grade);
    }
    
    double getGpa(){
        Student.logger.fine("begin GPA " + System.currentTimeMillis());
        if(grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for(Grade grade : grades)
            total += gradingStrategy.getGradePointsFor(grade);
        double result = total / grades.size();
        Student.logger.fine("end GPA " + System.currentTimeMillis());
        return result;
    }
    
    public void addCharge(int charge){
        charges.add(charge);
    }

    public int totalCharges(){
        int total = 0;
         for(int charge : charges)
            total += charge;
        return total;
    }
    
    public void set(Flag... flags){
        for(Flag flag : flags)
            settings |= flag.mask;
    }
    
    public void unset(Flag... flags){
        for(Flag flag : flags)
            settings &= ~flag.mask;
    }
    
    public boolean isOn(Flag flag){
        return (settings & flag.mask) == flag.mask;
    }
    
    public boolean isOff(Flag flag){
        return !isOn(flag);
    }
}
