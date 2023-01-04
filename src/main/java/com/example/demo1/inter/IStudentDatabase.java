package com.example.demo1.inter;

import java.util.List;

public interface IStudentDatabase {
    List<Float> getStudentScores(String studentId);

    void updateStudentGrade(String studentId, String grade);

    String getStudentGrade(String studentId);
}  
