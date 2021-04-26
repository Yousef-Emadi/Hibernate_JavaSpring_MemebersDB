package com.joseph.MemberDatabse;
import java.util.List;

/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */



public interface Database {

    //member handling
    boolean addMember(Member member);
    Member findMember(int id);
    Iterable<Member> listMember();
//    boolean updateMember(Member member);
    void removeMember(Member member);
}


