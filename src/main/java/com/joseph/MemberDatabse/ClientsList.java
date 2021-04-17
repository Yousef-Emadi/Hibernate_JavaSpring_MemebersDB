package com.joseph.MemberDatabse;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ClientsList implements ClientDatabase {

    private List<Member> clientList = new ArrayList<Member>();

    public static final String DEFAULT_FILE_PATH = "src\\main\\resources\\Database.txt";

    @Override
    public boolean addNewClient(Member newClient) {
        return clientList.add(newClient);
    }



//    @Override
//    public Member findClientFromCurrentSession(int id) {
//        for (Member cl : clientList) {
//            if (cl.id == id) return cl;
//        }
//        return null;
//    }

    @Override
    public Member findClientFromDatabaseClientList(int id) {
        for (Member cl : retrieveDatabaseClientList()) {
            if (cl.id == id) return cl;
        }
        return null;
    }


    @Override
    public boolean removeClientFromList(Member client) {
        return clientList.remove(client);
    }


    @Override
    public boolean writeIntoDatabase(Member client, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath, true);
            myWriter.write(
            client.id + ";" +
                client.name_first + ";" +
                client.name_last + ";" +
                client.telephone + ";" +
                client.dob + ";" +
                client.gender + ";" +
                client.balance + "\n"
            );
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("something is wrong with file writing");
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Member> retrieveDatabaseClientList() {
        try {
            File myObj = new File("src\\main\\resources\\Database.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("\n-- Database interaction -- ");

            // create a temporary Arraylist to hold client objects will be created by output stream from file
            List<Member> updateClientList = new ArrayList<Member>();
            while (myReader.hasNextLine()) {

                // temporary Array from raw file data to create client objects
                String rawData = myReader.nextLine();
                String[] tempArray = rawData.split(";");

                int id = Integer.parseInt(tempArray[0]);
                String fname = tempArray[1];
                String lname = tempArray[2];
                String phone = tempArray[3];
                String dob = tempArray[4];
                String gender = tempArray[5];
                double balance = Double.parseDouble(tempArray[6]);
                Member clientToMainList = new Member(id,fname,lname,phone,dob, gender, balance);
                updateClientList.add(clientToMainList);

            }
            myReader.close();
            return updateClientList;
        } catch (FileNotFoundException e) {
            System.out.println("something is wrong with reading boat.txt");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean writeListToDatabaseFile(String newfilePath, List<Member> clientList) {
        for (Member client: clientList
             ) {
            writeIntoDatabase(client, newfilePath);
        }

        return false;
    }

    public void updateDatabaseFile(){

    }

    @Override
    public void deleteDatabaseFile() {
        File myObj = new File("src\\main\\resources\\Database.txt");
        myObj.delete();
    }


} //end of class:ClientsList

*/
