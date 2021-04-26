package com.joseph.MemberDatabse;

import javax.persistence.GeneratedValue;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */


public class UserPanel {
    //variables
    Scanner input = new Scanner(System.in);

    //methods
    public userChoice userMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPlease, enter an option number");
        System.out.print("\n   1. Add a new member");
        System.out.print("\n   2. Find a member");
        System.out.print("\n   3. List members");
        System.out.print("\n   4. Remove a member");
        System.out.print("\n   0. Exit from application\n");

        int choiceNumber = getNumberFromUser(0,4);

        switch (choiceNumber) {
            case 1 -> {
                return userChoice.ADD;
            }
            case 2 -> {
                return userChoice.FIND;
            }
            case 3 -> {
                return userChoice.LIST;
            }
            case 4 -> {
                return userChoice.REMOVE;
            }
            case 0 -> {
                return userChoice.EXIT;
            }
            default -> {
                return userChoice.NONE;
            }
        }
    }



    public Member getNewMember() {
        int id = 0;
        System.out.print("Press \"Enter\" to continue\n");input.nextLine(); //to consume left-over line after nextInt
        System.out.print("Please enter member first name: ");
        String fname = input.nextLine();

        System.out.print("Please enter member last name: ");
        String lname = input.nextLine();


        Member member = new Member(id, fname, lname, "(438) 654-7898", fname + "@gmail.com", "2000-01-01", "6500 Forest Hill", 0);
        return member;
    }

    public int getIdToSearch() {
        System.out.print("\nPlease enter member id: ");
        int id = input.nextInt();
        return id;
    }

    public void showMember(Member mmbr) {
        System.out.println(
                "\nid: " + mmbr.id +
                "\nfirst name: " + mmbr.name_first +
                "\nlast name: " + mmbr.name_last +
                "\nphone: " + mmbr.phone +
                "\nemail: " + mmbr.email +
                "\nDOB: " + mmbr.dob +
                "\naddress: " + mmbr.address +
                "\nbalance: " + mmbr.balance+
                "\n------------------------------------------"
        );
    }

    public void memberNotFoundMessage(){  System.out.println("\n <<<<<   Member not found   >>>>>");}
    public void memberRemovedMessage(Member mmbr){  System.out.println("\n <<<<<   " + mmbr.name_first + " with ID number "+ mmbr.id + " removed from your database   >>>>>");}
    public void exitMessage() {System.out.println("<<<<<   Thank you and Good luck :)  >>>>> \n" );}


    // Method to get number from user and handles InputMismatchException and logical expressions
    public int getNumberFromUser(int min, int max){
        Scanner scanner = new Scanner(System.in);
        while(true)
            try {
                int userChoice = scanner.nextInt();
                if (!(userChoice >= min && userChoice <= max)) {
                    System.out.println(">>>>>    Please enter an valid option number including ");
                    for (int i = min; i <= max; i++){
                        if (i == max-1) {
                            System.out.print(i);
                            break;
                        }
                        System.out.print(i+", ");
                    }
                    continue;
                }
                return userChoice;

            } catch (InputMismatchException ime) {
                System.out.println(">>>>>   Please enter an valid option number including ");
                for (int i = min; i <= max; i++){
                    if (i == max-1) {
                        System.out.print(i);
                        break;
                    }
                    System.out.print(i+", ");
                }
                scanner.nextLine();
                continue;
            } // end catch
    } // end method getNumberFromUser

//    public String getFilePath() {
//        System.out.println("Please enter a full path including file name. Default: src\\main\\resources\\Database.txt");
//        String path = input.next();
//        return path;
//    }


}


