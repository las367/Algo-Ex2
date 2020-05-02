package Algo.Ex2.helper;

import Algo.Ex2.data.Student;
import Algo.Ex2.lists.SinglyLinkedList;

public class PrenameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        
        if (o1.getPrename() == null && o2.getPrename() == null) {
            return 0;
        } else if (o1.getPrename() == null) {
            return 1;
        } else if (o2.getPrename() == null) {
            return -1;
        }

        return o1.getPrename().compareTo(o2.getPrename());
    }

    @Override
    public boolean checkIfEqualsString(Student o1, String query) {
        //just compare the prename of both of the students
        System.out.println(o1.getPrename() + " prename");
        System.out.println(query + " query");
        return o1.getPrename().equals(query);
    }

    @Override
    public boolean checkIfEqualsInt(Student o1, int query) {
        // TODO Auto-generated method stub
        return false;
    }
    
}