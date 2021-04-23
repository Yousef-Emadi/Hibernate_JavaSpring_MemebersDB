package com.joseph.MemberDatabse;
/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IdGenerator {

    //attribs
    int id = 1;
    int lastUsedId;
    final String DEFAULT_ID_FILE_PATH  = "src\\main\\resources\\Id.txt";
    ArrayList<Integer> idList = new ArrayList<Integer>();

    //methods
    public void createIDFile() {
        try {
            FileWriter myWriter = new FileWriter(DEFAULT_ID_FILE_PATH, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
    public int id(){
        idList = lastUsedIdList();
        lastUsedId = idList.get(idList.size()-1);
        id = lastUsedId+1;
        return id;
    }

    public ArrayList<Integer> lastUsedIdList() {
        idList.clear();
        try {
            File myObj = new File(DEFAULT_ID_FILE_PATH);
            Scanner myReader = new Scanner(myObj);

            // create a temporary Arraylist to hold id array
            while (myReader.hasNextLine()) {

                // temporary Array from raw file data to create client objects
                String rawData = myReader.nextLine();
                String[] tempArray = rawData.split("\n");

                int id = Integer.parseInt(tempArray[0]);
                idList.add(id);

            }
            myReader.close();
            return idList;
        } catch (FileNotFoundException e) {
            System.out.println(e+"\nsomething is wrong with reading file");
            e.printStackTrace();
        }
        return null;
    }


    public void writeId(int usedId) {
        try {
            FileWriter myWriter = new FileWriter(DEFAULT_ID_FILE_PATH, true);
            myWriter.write(
                    usedId + "\n"
            );
            myWriter.close();
        } catch (IOException e) {
            System.out.println("something is wrong with file writing");
            e.printStackTrace();
        }
    }




}



