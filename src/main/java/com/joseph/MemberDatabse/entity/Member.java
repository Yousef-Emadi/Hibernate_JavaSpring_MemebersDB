package com.joseph.MemberDatabse.entity;
import com.joseph.MemberDatabse.entity.Purchase;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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
    public int id = 0;
    public String userName;
    public String password;
    public String name_first;
    public String name_last;
    public String phone;
    public String email;
    public String dob;
    public String address;
    public double balance;

    @OneToMany
    List<Purchase> purchases;

    public Member() {
    }

    public Member(String userName, String password, String name_first, String name_last, String phone, String email, String dob, String address, double balance) {
        this.userName = userName;
        this.password = password;
        this.name_first = name_first;
        this.name_last = name_last;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.balance = balance;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName_first() {
        return name_first;
    }

    public void setName_first(String name_first) {
        this.name_first = name_first;
    }

    public String getName_last() {
        return name_last;
    }

    public void setName_last(String name_last) {
        this.name_last = name_last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}