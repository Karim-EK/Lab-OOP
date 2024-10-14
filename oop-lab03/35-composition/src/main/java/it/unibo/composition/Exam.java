package it.unibo.composition;

import java.util.Arrays;

public class Exam {
    private final int id;
    private final int maxStudents;
    private int registeredStudents;
    private final String courseName;
    private final Professor professor;
    private final ExamRoom room;
    private final Student[] students;
    
    public Exam(final int id, final int maxStudents, final String courseName, final Professor professor, final ExamRoom room) {
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
