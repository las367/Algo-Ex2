package Algo.Ex2.helper;

import Algo.Ex2.data.Student;

public class MatriculationNumberComparator implements Comparator<Student> {
    
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getMatriculationNumber() - o2.getMatriculationNumber();
    }

    @Override
    public boolean checkIfEqualsString(Student o1, String query) {
        return false;
    }

    @Override
    public boolean checkIfEqualsInt(Student o1, int query) {
        return o1.getMatriculationNumber() == query;
    }
}