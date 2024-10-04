package it.unibo.composition;

import java.util.Arrays;

public class Exam {
    final int id;
    final int maxStudents;
    int registeredStudents;
    final String courseName;
    Professor professor;
    ExamRoom room;
    Student[] students;
    
    public Exam(int id, int maxStudents, String courseName, Professor professor, ExamRoom room) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = new Student[maxStudents];
        this.registeredStudents = 0;
    }

    public void registerStudent(final Student student) {
        if (registeredStudents < maxStudents) {
            students[registeredStudents] = student;
            registeredStudents++;
        }
    }

    public int getId() {
        return id;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ExamRoom getRoom() {
        return room;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Exam [id=" + id + ", maxStudents=" + maxStudents + ", registeredStudents=" + registeredStudents
                + ", courseName=" + courseName + ", professor=" + professor + ", room=" + room + ", students="
                + Arrays.toString(students) + "]";
    }

    
}
