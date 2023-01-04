package com.example.demo1.controller;

import com.example.demo1.inter.IStudentDatabase;

import java.util.List;

public class StudentReportGenerator {
    public IStudentDatabase studentDatabase;

    public StudentReportGenerator(IStudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public String calculateStudentGrade(String studentId) {

        String grade;

// check if grade is already there in database  
        grade = studentDatabase.getStudentGrade(studentId);
        if (grade != null && !grade.isEmpty()) {
            return grade;
        }

        List<Float> scoreList = studentDatabase.getStudentScores(studentId);

        Float totalScore = 0F;

        if (scoreList != null)
            totalScore = scoreList.stream().reduce(0F, (a, b) -> a + b);

        if (totalScore > 90) {
            grade = "A";
        } else if (totalScore > 80) {
            grade = "B";
        } else {
            grade = "C";
        }

// update the calculated grade in database  
        studentDatabase.updateStudentGrade(studentId, grade);

        return grade;
    }
}
