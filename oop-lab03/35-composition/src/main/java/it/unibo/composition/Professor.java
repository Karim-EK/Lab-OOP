package it.unibo.composition;

public class Professor implements User {
    @SuppressWarnings("unused")
    private final int id;
    private final String name;
    private final String surname;
    private final String password;
    private String[] corses;

    public Professor(final int id, final String name, final String surname) {
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
