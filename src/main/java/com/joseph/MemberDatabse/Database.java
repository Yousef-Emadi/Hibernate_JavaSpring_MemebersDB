package com.joseph.MemberDatabse;
import java.util.List;

/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */



public interface Database {

    //File handling
    void createFile(String path);
    List<Member> downloadFromFile();
    void writeMemberToFile(Member member, String filePath);
    void uploadToFile(List<Member> list, String filePath);
    void deleteFile(String path);

    //member handling
    boolean addMember(Member member);
    Member findMember(int id);
    void removeMember(int id);
}


