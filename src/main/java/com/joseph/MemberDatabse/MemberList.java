package com.joseph.MemberDatabse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberList implements Database{

    public static List<Member> currentList = new ArrayList<Member>();
    public static final String DEFAULT_FILE_PATH = "src\\main\\resources\\Database.txt";

    @Override
    public void createFile(String path) {
        try {
            FileWriter myWriter = new FileWriter(path, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    @Override
    public List<Member> downloadFromFile() {
        currentList.clear();
        try {
            File myObj = new File(DEFAULT_FILE_PATH);
            Scanner myReader = new Scanner(myObj);
            System.out.println("\n-- Download from Database file -- ");

            // create a temporary Arraylist to hold client objects will be created by output stream from file
            while (myReader.hasNextLine()) {

                // temporary Array from raw file data to create client objects
                String rawData = myReader.nextLine();
                String[] tempArray = rawData.split(",");

                int id = Integer.parseInt(tempArray[0]);
                String fname = tempArray[1];
                String lname = tempArray[2];
                String phone = tempArray[3];
                String email = tempArray[4];
                String dob = tempArray[5];
                String address = tempArray[6];
                double balance = Double.parseDouble(tempArray[7]);
                Member member = new Member(id, fname, lname, phone, email, dob, address, balance);
                currentList.add(member);

            }
            myReader.close();
            return currentList;
        } catch (FileNotFoundException e) {
            System.out.println(e+"\nsomething is wrong with reading file");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeMemberToFile(Member member, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath, true);
                myWriter.write(
                        member.id + "," +
                                member.name_first + "," +
                                member.name_last + "," +
                                member.phone + "," +
                                member.email + "," +
                                member.dob + "," +
                                member.address + "," +
                                member.balance + "\n"
                );
            myWriter.close();
        } catch (IOException e) {
            System.out.println("something is wrong with file writing");
            e.printStackTrace();
        }
    }


    @Override
    public void uploadToFile(java.util.List<Member> list,String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath, true);
            for (Member member: list
                 ) {
                myWriter.write(
                    member.id + "," +
                        member.name_first + "," +
                        member.name_last + "," +
                        member.phone + "," +
                        member.email + "," +
                        member.dob + "," +
                        member.address + "," +
                        member.balance + "\n"
            );
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("something is wrong with file writing");
            e.printStackTrace();
        }
    }


    @Override
    public void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    @Override
    public void addMember(Member member) {
        currentList.add(member);
    }

    @Override
    public Member findMember(int id) {
        for (Member member: currentList
             ) {
            if (member.id == id) return member;
        }
        return null;
    }

    @Override
    public void removeMember(int id) {
        currentList.remove(findMember(id));
    }
}
