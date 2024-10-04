class TestStudent {

    public static void main(String[] args) {
        Student alex = new Student();
        alex.build("Alex", "Balducci", 1015, 2019);
        alex.printStudentInfo();
		
		Student angel = new Student();
        angel.build("Angel", "Bianchi", 1016, 2018);
        angle.printStudentInfo();
		
		Student andrea = new Student();
        andrea.build("Andrea", "Bracci", 1017, 2017);
        andrea.printStudentInfo();
    }
}
