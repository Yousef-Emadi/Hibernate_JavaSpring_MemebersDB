package com.joseph.MemberDatabse;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */

@Entity
public class Member {
    // Fields:
    @Id

    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    int id = 0;
    String name_first;
    String name_last;
    String phone;
    String email;
    String dob;
    String address;
    double balance;


    public Member(int id, String name_first, String name_last, String phone, String email, String dob, String address, double balance) {
        this.id = id;
        this.name_first = name_first;
        this.name_last = name_last;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.balance = balance;
    }


    public Member() {
    }

    @Override
    public String toString() {
        return "\n-------------------------------------" +
                "\nid: " + id +
                "\nfirst name: " + name_first +
                "\nlast name: " + name_last +
                "\nphone: " + phone +
                "\nemail: " + email +
                "\nDOB: " + dob +
                "\naddress: " + address +
                "\nbalance: " + balance ;
    }


}