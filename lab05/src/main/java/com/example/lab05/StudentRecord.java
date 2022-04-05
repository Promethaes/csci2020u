package com.example.lab05;

public class StudentRecord {

    public StudentRecord(String id, float mid, float assignment, float exam) {
        StudentID = id;
        Midterm = mid;
        Assignments = assignment;
        Finalexam = exam;

        FinalMark = (Assignments * 0.2f) + (Midterm * 0.3f) + (Finalexam * 0.5f);
        FinalMark = (float) Math.floor((double)FinalMark);
        SetLetterGrade();
    }

    String StudentID;
    float Midterm;
    float Assignments;
    float Finalexam;
    float FinalMark;
    String LetterGrade = "";

    public String getStudentID() {
        return StudentID;
    }

    public float getMidterm() {
        return Midterm;
    }

    public float getAssignments() {
        return Assignments;
    }

    public float getFinalexam() {
        return Finalexam;
    }

    public float getFinalMark() {
        return FinalMark;
    }

    public String getLetterGrade() {
        return LetterGrade;
    }

    public void SetLetterGrade() {
        if (FinalMark >= 80 && FinalMark <= 100) {

            LetterGrade = "A";
        } else if (FinalMark >= 70 && FinalMark <= 79) {

            LetterGrade = "B";
        } else if (FinalMark >= 60 && FinalMark <= 69) {

            LetterGrade = "C";
        }else if (FinalMark >= 50 && FinalMark <= 59) {

            LetterGrade = "D";
        }else if (FinalMark >= 0 && FinalMark <= 49) {

            LetterGrade = "F";
        }
    }
}
