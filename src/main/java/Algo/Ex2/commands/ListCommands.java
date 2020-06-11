package Algo.Ex2.commands;

import Algo.Ex2.data.Student;
import Algo.Ex2.helper.CourseComparator;
import Algo.Ex2.helper.MatriculationNumberComparator;
import Algo.Ex2.helper.PrenameComparator;
import Algo.Ex2.helper.SurnameComparator;
import Algo.Ex2.lists.Listable;

public class ListCommands implements ICommand {
    
    private Listable<Student> list;
    private Console in = new Console();

    private final String MENU_TEXT = "\nConsole Menu\n" +
                                    "1. Add Student to the end of this list." +"\n" +
                                    "2. Inserts the Student at the specified position in this list." +"\n" +
                                    "3. Inserts the Student at the beginning of this list." +"\n" +
                                    "4. Appends the Student to the end of this list." +"\n" +
                                    "5. Returns the Student at the specified position in this list." +"\n" +
                                    "6. Print all students to console from list." +"\n" +
                                    "7. Returns the number of Students in this list." +"\n" +
                                    "8. Removes the Student at the specified position in this list." +"\n" +
                                    "9. Removes all of the Students from this list." +"\n" +
                                    "10. Search for student(s) by different characteristics." +"\n" +
                                    "11. Sort list by different properties." +"\n" +
                                    "0. Exit" +"\n\n" +
                                    "Please enter a number for an option:" +"\n";

    private final String SEARCH_TEXT = "Select a property to search for the student: " + "\n" + 
                                        "1. Search by prename?"  + "\n" + 
                                        "2. Search by surname?"  + "\n" + 
                                        "3. Search by course number?"  + "\n" + 
                                        "4. Search by matriculation number?"  + "\n\n" + 
                                        "Please enter a number for an option:\n";

    private final String SORT_TEXT = "Select a sorting method for sorting:" + "\n" +
                                    "1. Bubblesort?"  + "\n" +
                                    "2. Selectionsort?"  + "\n\n" +
                                    "Please enter a number for an option:\n";

    private final String FALSE_INPUT = "Please enter another number\n";

    public ListCommands(Listable<Student> list) {

        this.list = list;
    }

    private Student createStudent() {

        String prename = in.inpuString("Please enter Prename: \n");
        String surname = in.inpuString("Please enter surname: \n");
        int course = in.inputInt("Please enter course number: \n");
        int matNumber = in.inputInt("Please enter matriculation number: \n");

        return new Student(prename, surname, course, matNumber);
    }

    private String searchTextFormatter(String text) { return "Please enter " + text + " for the search: \n"; }

    private String sortTextFormatter(boolean doBubbleSort) {
        String algo;
        if ( doBubbleSort ) algo = "Bubblesort";
        else algo = "Insertionsort";

        return "Please select a property for sorting with the" + algo + "algorithm: " + "\n" +
                "1. Sort by course?"  + "\n" +
                "2. Sort by matriculation number?"  + "\n" +
                "Please enter a number for an option: \n";
    }

    private void search() {

        int userChoice = in.inputInt(SEARCH_TEXT);
        boolean falseInput = true;

        while ( falseInput ) {
            switch ( userChoice ) {

                case 1:
                    list.searchBasedOnString( in.inpuString(searchTextFormatter("prename")), new PrenameComparator() ).printAll();
                    falseInput = false;
                    break;
    
                case 2:
                    list.searchBasedOnString( in.inpuString(searchTextFormatter("surname")), new SurnameComparator() ).printAll();
                    falseInput = false;
                    break;

                case 3:
                    list.searchBasedOnInt( in.inputInt(searchTextFormatter("course number")), new CourseComparator()).printAll();
                    falseInput = false;
                    break;

                case 4:
                    list.searchBasedOnInt( in.inputInt(searchTextFormatter("matriculation number")), new MatriculationNumberComparator()).printAll();
                    falseInput = false;
                    break;
    
                default:
                    userChoice = in.inputInt(FALSE_INPUT);
                    falseInput = true;
                    break;
            }
        }
    }

    private void sort () {

        int userChoice = in.inputInt(SORT_TEXT);
        boolean falseInput = true;

        while ( falseInput ) {

            switch ( userChoice ) {

                case 1:
                    sortAlgorithm(true);
                    falseInput = false;
                    break;

                case 2:
                    sortAlgorithm(false);
                    falseInput = false;
                    break;
                
                default:
                    userChoice = in.inputInt(FALSE_INPUT);

            }
        }
    }

    private void sortAlgorithm ( boolean doBubbleSort ) {

        int userChoice = in.inputInt(sortTextFormatter(doBubbleSort));
        boolean falseInput = true;

        while ( falseInput ) {

            switch ( userChoice ) {

                case 1:
                    if ( doBubbleSort ) list.bubbleSort( new CourseComparator() );
                    else list.selectionSort(new CourseComparator());
                    falseInput = false;
                    break;

                case 2:
                    if ( doBubbleSort ) list.bubbleSort( new MatriculationNumberComparator() );
                    else list.selectionSort(new MatriculationNumberComparator());
                    falseInput = false;
                    break;

                default:
                    userChoice = in.inputInt(FALSE_INPUT);
                    break;
            }
        }
    }

    @Override
    public void execute() {

        int userChoice = 12;
        
        while ( userChoice != 0 ) {

            userChoice = in.inputInt(MENU_TEXT);
            switch ( userChoice ) {

                case 0:
                    break;

                case 1:
                    list.add(createStudent());
                    break;
                
                case 2:
                    list.add(
                        in.inputInt("Please insert the specified position\n"), 
                        createStudent()
                    );
                    break;
                
                case 3:
                    list.addFirst(createStudent());
                    break;
                
                case 4:
                    list.addLast(createStudent());
                    break;

                case 5:
                    System.out.println(
                        list.get( in.inputInt("Please insert the specified position\n") )
                    );

                    break;

                case 6:
                    list.printAll();
                    break;

                case 7:
                    System.out.println("size: " + list.size());
                    break;

                case 8:
                    list.remove(in.inputInt("Please insert the specified position\n"));
                    break;

                case 9: 
                    list.clear();
                    break;

                case 10:
                    search();
                    break;
                
                case 11:
                    sort();
                    break;

                default:
                    userChoice = in.inputInt(FALSE_INPUT);
                    break;

            }
        }
    }   
}