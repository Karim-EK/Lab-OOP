package it.unibo.composition;

public class Professor implements User {

    final int id;
    final String name;
    final String surname;
    String password;
    String[] corses;

    

    public Professor(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = "password";
        corses = new String[10];
    }

    public void replaceCourse(final String corse, final int i) {
        this.corses[i] = corse;
    }

    public void replaceAllCourses(final String[] newCourses) {
        this.corses = newCourses;
    }

    @Override
    public String getUsername() {
        return this.name + " " + this.surname;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getDescription() {
        return this.toString();
    }
}
