package com.joseph.MemberDatabse;

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

    public void Configure(UserPanel myUI, Database members) {
        this.myUI = myUI;
        this.members = members;
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
        int id = myUI.getIdToSearch();
        Member foundMember = members.findMember(id);
        if (foundMember != null)
            myUI.showMember(foundMember);
        else
            myUI.memberNotFoundMessage();
    }


    private void doListMembers() {
        members.listMember().forEach(member -> myUI.showMember(member));
    }

    private void doFindAndRemoveMember() {
        int id = myUI.getIdToSearch();
        Member foundMember = members.findMember(id);
        if (foundMember != null){
            members.removeMember(foundMember);
            myUI.memberRemovedMessage(foundMember);
        }
        else
            myUI.memberNotFoundMessage();

    }



    public void doExit(){
        myUI.exitMessage();
        System.exit(0);
    }

}

