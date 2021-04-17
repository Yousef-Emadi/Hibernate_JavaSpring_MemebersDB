package com.joseph.MemberDatabse;

import java.io.File;
import java.util.List;

public class Controller {

    //new objects
    private UserPanel myUI;
    private Database members;

    public void Configure(UserPanel myUI, Database members) {
        this.myUI = myUI;
        this.members = members;
    }

    public void mainController(){
        userChoice myUserChoice = myUI.userMenu();
        switch (myUserChoice) {
            case SETUP -> {doSetup();}
            case ADD -> {doAdd();}
            case FIND -> {doFindAndShowMember();}
            case REMOVE -> {doFindAndRemoveMember();}
            case LIST -> {doListMembers();}
            case BACKUP -> {doBackupFile();}
            case EXIT -> {doExit();}
        }
    }

    private void doSetup() {
        members.createFile(MemberList.DEFAULT_FILE_PATH);
    }


    private void doAdd() {
        MemberList.currentList = members.downloadFromFile();
        Member newMember = myUI.getNewMember();
        members.addMember(newMember);
        members.writeMemberToFile(newMember, MemberList.DEFAULT_FILE_PATH);
    }

    private void doFindAndShowMember() {
        MemberList.currentList = members.downloadFromFile();
        int id = myUI.getIdToSearch();
        Member foundMember = members.findMember(id);
        myUI.showMember(foundMember);
    }


    private void doFindAndRemoveMember() {
        MemberList.currentList = members.downloadFromFile();
        int id = myUI.getIdToSearch();
        Member foundMember = members.findMember(id);
        members.removeMember(id);
        System.out.println(foundMember.name_first +" "+foundMember.name_last+" removed.");
        doSetup();
        members.uploadToFile(MemberList.currentList, MemberList.DEFAULT_FILE_PATH);
    }


    private void doListMembers() {
        MemberList.currentList = members.downloadFromFile();
        for (Member item: MemberList.currentList
             ) {
            myUI.showMember(item);
        }
    }


    private void doBackupFile() {
        String path = myUI.getFilePath();
        List<Member> currentList = members.downloadFromFile();
        members.createFile(path);
        members.uploadToFile(currentList, path);
    }


    public void doExit(){
        myUI.exitMessage();
        System.exit(0);
    }
}

