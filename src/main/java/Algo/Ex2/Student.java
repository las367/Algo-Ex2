package Algo.Ex2;

public class Student {

    private String prename;
    private String surname;
    private int course;
    private int matriculationNumber;


    public Student(String prename, String surname, int course, int matriculationNumber) {
        this.prename = prename;
        this.surname = surname;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }


    @Override
    public String toString() {
        return "{" +
            " prename='" + getPrename() + "'" +
            ", surname='" + getSurname() + "'" +
            ", course='" + getCourse() + "'" +
            ", matriculationNumber='" + getMatriculationNumber() + "'" +
            "}";
    }
    

    public String getPrename() {
        return this.prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMatriculationNumber() {
        return this.matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }


}