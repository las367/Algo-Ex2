package Algo.Ex2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Algo.Ex2.data.Student;
import Algo.Ex2.helper.CourseComparator;
import Algo.Ex2.helper.MatriculationNumberComparator;
import Algo.Ex2.helper.PrenameComparator;
import Algo.Ex2.lists.Listable;
import Algo.Ex2.lists.SinglyLinkedList;

public class SinglyLinkedListTest {
    
    Listable<Integer> list = new SinglyLinkedList<Integer>();
    SinglyLinkedList<Student> studentList = new SinglyLinkedList<Student>();
    Student s2 = new Student("SHheldon", "Cooper", 67, 78);
    Student s3 = new Student("Micky", "Maus", 67, 45);

    @Test
    public void getAndSize() {
        list.add(1);
        list.add(2);
        Integer lastAdded = 3;
        list.addLast(lastAdded);

        assertEquals("Last added integer = 3, comparing last added integer with getLast result", lastAdded, list.get(list.size() - 1));
    }
    
    @Test
    public void searchBasedOnString() {

        studentList.add(s2);
        studentList.add(s3);

        Listable<Student> expectedResult = new SinglyLinkedList<Student>();
        expectedResult.add(s3);

        Listable<Student> actualResult = studentList.searchBasedOnString(s3.getPrename(), new PrenameComparator());

        assertEquals("Test on the search functionality based on prename", true, actualResult.equals(expectedResult));
    }

    @Test
    public void searchBasedOnInt() {

        studentList.add(s2);
        studentList.add(s3);

        Listable<Student> expectedResult = new SinglyLinkedList<Student>();
        expectedResult.add(s2);
        expectedResult.add(s3);

        Listable<Student> actualResult = studentList.searchBasedOnInt(s3.getCourse(), new CourseComparator());
        assertEquals("Test on the search functionality based on course num", true, actualResult.equals(expectedResult));
    }

    @Test
    public void bubbleSort() {

        studentList.add(s2);
        studentList.add(s3);

        studentList.bubbleSort(new MatriculationNumberComparator());

        Listable<Student> expected = new SinglyLinkedList<Student>();
        expected.add(s3);
        expected.addLast(s2);

        assertEquals("Test on the sort functionality based on prename", true, studentList.equals(expected));
    }

    @Test
    public void selectionSort() {

        studentList.add(s2);
        studentList.add(s3);

        studentList.selectionSort(new MatriculationNumberComparator());

        Listable<Student> expected = new SinglyLinkedList<Student>();
        expected.add(s3);
        expected.addLast(s2);

        assertEquals("Test on the sort functionality based on prename", true, studentList.equals(expected));
    }

    @Test 
    public void remove () {

        studentList.add(s3);
        studentList.add(s2);

        Listable<Student> expected = new SinglyLinkedList<Student>();
        expected.add(s2);

        studentList.remove(0);

        assertEquals("removed Student on the first posiition!", true, studentList.equals(expected));
    }
}