package com.joseph.MemberDatabse.archive;
import com.joseph.MemberDatabse.entity.Member;

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
    void removeMember(Member member);
}


