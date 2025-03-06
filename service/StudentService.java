package service;

import java.time.LocalDate;

import model.Course;
import model.person.Student;

public class StudentService extends Student {
     public boolean addCourse(Course course) {
        if (course == null || this.getCourses().contains(course)) {
            return false; 
        } else {
            this.getCourses().add(course);
            return true;
        }
    }

    StudentService(int id, String fullName, LocalDate dateOfBirth){
        super(id, fullName, dateOfBirth);
    }

    // Can be moved to StudentService.java
    public boolean withdrawFromCourse(int courseId) {
        return this.getCourses().removeIf(course -> course.getCourseCode() == courseId);
    }

    public double getCGPA() {
        double sum = 0;
        for (double GPA : this.getGPAs()) { sum += GPA; }
        return sum / this.getGPAs().size();
    }
}
