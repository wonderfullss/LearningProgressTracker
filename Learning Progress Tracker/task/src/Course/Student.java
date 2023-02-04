package Course;

public class Student {
    private String name, surname, email;
    private int java, spring, DSA, DB;

    public Student(String name, String surname, String email) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.DB = 0;
        this.spring = 0;
        this.DSA = 0;
        this.java = 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public int getDSA() {
        return DSA;
    }

    public void setDSA(int DSA) {
        this.DSA = DSA;
    }

    public int getDB() {
        return DB;
    }

    public void setDB(int DB) {
        this.DB = DB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
