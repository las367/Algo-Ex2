package Algo.Ex2.commands;

import Algo.Ex2.data.Student;
import Algo.Ex2.lists.DoublyLinkedList;
import Algo.Ex2.lists.SinglyLinkedList;

public class SelectionCommand implements ICommand {

    private final String FALSE_INPUT = "Please enter another number";
    private final String MENU_TEXT = "Select list type before starting the main menu:" + "\n" +
                                    "1. SinglyLinkedList" + "\n" +
                                    "2. DoublyLinkedList"  + "\n\n" +
                                    "Please enter a number for an option: ";

    private Console in = new Console();
    ListCommands command;

    @Override
    public void execute() {

        int userChoice = in.inputInt(MENU_TEXT);
        boolean falseInput = true;

        while ( falseInput ) {

            switch ( userChoice ) {

                case 1:
                    command = new ListCommands(new SinglyLinkedList<Student>());
                    command.execute();
                    falseInput = false;
                    break;

                case 2:
                    command = new ListCommands(new DoublyLinkedList<Student>());
                    command.execute();
                    falseInput = false;
                    break;

                default:
                    userChoice = in.inputInt(FALSE_INPUT);
                    break;
            }
        }
    }
    
}