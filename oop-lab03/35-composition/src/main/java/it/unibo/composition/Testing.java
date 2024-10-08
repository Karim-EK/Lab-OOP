package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        Student stud1 = new Student(1, "Mario", "Rossi", "null", 2017);
        Student stud2 = new Student(2, "Giorgio", "Mastrota", "null", 2018);
        Student stud3 = new Student(3, "Diego", "Tigri", "null", 2015);
        // 2)Creare 2 docenti a piacere
        Professor prof1 = new Professor(1, "Mario", "Draghi");
        Professor prof2 = new Professor(2, "Don", "Giorgio");
        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom room1 = new ExamRoom(100, "null", false, false);
        ExamRoom room2 = new ExamRoom(100, "null", false, false);
        // 4) Creare ue esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        Exam exam1 = new Exam(1, 10, "Finanza", prof1, room2);
        Exam exam2 = new Exam(2, 2, "Sacralità", prof2, room1);
        // 5) Iscrivere tutti e 3 gli studenti agli esami
        exam1.registerStudent(stud1);
        exam2.registerStudent(stud1);
        exam1.registerStudent(stud2);
        exam2.registerStudent(stud2);
        exam1.registerStudent(stud3);
        
        exam2.registerStudent(stud3);
        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(exam1.toString());
        System.out.println(exam2.toString());
    }
}
