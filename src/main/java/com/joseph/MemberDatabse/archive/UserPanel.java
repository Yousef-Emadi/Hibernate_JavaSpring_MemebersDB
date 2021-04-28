package com.joseph.MemberDatabse.archive;

import com.joseph.MemberDatabse.entity.Member;

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
        System.out.print("\n   4. Update a member");
        System.out.print("\n   5. Remove a member");
        System.out.print("\n   0. Exit from application\n");

        int choiceNumber = getNumberFromUser(0,5);

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
                return userChoice.UPDATE;
            }
            case 5 -> {
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


        Member member = new Member(id,
                fname,
                lname,

                "(438) 654-7898",
                fname + "@gmail.com",
                "2000-01-01",
                "6500 Forest Hill",
                0);
        return member;
    }

    public int getIdToSearch() {
        System.out.print("\nPlease enter member id: ");
        int id = input.nextInt();
        return id;
    }
    public void showMemberLineStyle(Member mmbr) {
        System.out.println(
                "{ " + mmbr.id +
                ": name: " + mmbr.name_first +" "+ mmbr.name_last +
                ", phone: " + mmbr.phone +
                ", email: " + mmbr.email +
                ", DOB: " + mmbr.dob +
                ", address: " + mmbr.address +
                ", balance: " + mmbr.balance+
                " }"
        );
    }

    public void showMemberVerticalStyle(Member mmbr) {
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
    public void updateMemberMessage(Member oldMember, Member newMember){  System.out.println("\n <<<<<   " + oldMember.name_first + " with ID number "+ oldMember.id + " updated and stored into a new record with member ID number "+ newMember.id +" >>>>>");}
    public void exitMessage() {System.out.println("<<<<<   Thank you and Good luck :)  >>>>> \n" );}


    // Method to get number from user and handles InputMismatchException and logical expressions
    public int getNumberFromUser(int min, int max){
        Scanner scanner = new Scanner(System.in);
        while(true)
            try {
                int userChoice = scanner.nextInt();
                if (!(userChoice >= min && userChoice <= max)) {
                    System.out.print(">>>>>    Please enter an valid option number including ");
                    System.out.print(min);
                    for (int i = min+1; i < max; i++){
                        System.out.print(", " + i);
                    }
                    System.out.print(" and " + max + "\n");

                    continue;
                }
                return userChoice;

            } catch (InputMismatchException ime) {
                System.out.print(">>>>>   Please enter an valid option number including ");
                System.out.print(min);
                for (int i = min+1; i < max; i++){
                    System.out.print(", " + i);
                }
                System.out.print(" and " + max+ "\n");
                scanner.nextLine();
                continue;
            } // end catch
    } // end method getNumberFromUser


}


