package com.example.demo1.service;

import com.example.demo1.inter.IStudentDatabase;

import java.util.*;

public class StudentDatabase implements IStudentDatabase {

    private Map<String, List<Float>> scoreMap;
    private Map<String, String> gradeMap;

    public StudentDatabase() {
        this.scoreMap = new HashMap<>();
        this.gradeMap = new HashMap<>();
        scoreMap.put("123", Arrays.asList(40F, 30F, 30F));
        scoreMap.put("456", Arrays.asList(10F, 10F, 30F));
        gradeMap.put("123", "B");
        gradeMap.put("456", "C");
    }

    @Override
    public List<Float> getStudentScores(String studentId) {
        return scoreMap.get(studentId);
    }

    @Override
    public void updateStudentGrade(String studentId, String grade) {
        gradeMap.put(studentId, grade);
    }

    @Override
    public String getStudentGrade(String studentId) {

        return gradeMap.get(studentId);
    }
}
