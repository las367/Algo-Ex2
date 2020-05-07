package Algo.Ex2.helper;

import Algo.Ex2.data.Student;

public class CourseComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        //0 == identisch
        //-1 kleiner
        return o1.getCourse() - o2.getCourse();
    }

    @Override
    public boolean checkIfEqualsString(Student o1, String query) {
        return false;
    }

    @Override
    public boolean checkIfEqualsInt(Student o1, int query) {
        return o1.getCourse() == query;
    }
    
}