package com.joseph.MemberDatabse;
import java.util.List;

/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */



public class Controller {

    //new objects
    private UserPanel myUI;
    private Database members;
    private IdGenerator idGen;

    public void Configure(UserPanel myUI, Database members, IdGenerator idGen) {
        this.myUI = myUI;
        this.members = members;
        this.idGen = idGen;
    }

    public void mainController(){
        userChoice myUserChoice = myUI.userMenu();
        switch (myUserChoice) {
            case ADD -> {doAdd();}
            case FIND -> {doFindAndShowMember();}
            case REMOVE -> {doFindAndRemoveMember();}
            case LIST -> {doListMembers();}
            case EXIT -> {doExit();}
        }
    }



    private void doAdd() {
        Member newMember = myUI.getNewMember();
        members.addMember(newMember);
    }

    private void doFindAndShowMember() {
//        MemberList.currentList = members.downloadFromFile();
//        int id = myUI.getIdToSearch();
//        Member foundMember = members.findMember(id);
//        if (foundMember == null)
//            myUI.userNotFoundMessage();
//        else
//            myUI.showMember(foundMember);
    }


    private void doFindAndRemoveMember() {
//        MemberList.currentList = members.downloadFromFile();
//        int id = myUI.getIdToSearch();
//        Member foundMember = members.findMember(id);
//        if (foundMember == null)
//            myUI.userNotFoundMessage();
//        else {
//            members.removeMember(id);
//            System.out.println(foundMember.name_first +" "+foundMember.name_last+" removed.");
////            doSetup();
//            members.uploadToFile(MemberList.currentList, MemberList.DEFAULT_FILE_PATH);
//        }

    }


    private void doListMembers() {
//        MemberList.currentList = members.downloadFromFile();
//        for (Member item: MemberList.currentList
//             ) {
//            myUI.showMember(item);
//        }
    }


    public void doExit(){
        myUI.exitMessage();
        System.exit(0);
    }

//    private void doSetup() {
//
//        members.createFile(MemberList.DEFAULT_FILE_PATH);
//        idGen.createIDFile();
//        idGen.writeId(0);
//    }
//
//    private void doBackupFile() {
//        String path = myUI.getFilePath();
//        List<Member> currentList = members.downloadFromFile();
//        members.createFile(path);
//        members.uploadToFile(currentList, path);
//    }

}

