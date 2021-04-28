package com.joseph.MemberDatabse.controller;

import com.joseph.MemberDatabse.entity.Member;
import com.joseph.MemberDatabse.entity.Purchase;
import com.joseph.MemberDatabse.repository.MemberRepository;
import com.joseph.MemberDatabse.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class SpringMvcPurchaseController {

    @Autowired//each field one Autowired
    private MemberRepository memberRepo;

    @Autowired //each field one Autowired
    private PurchaseRepository purchaseRepo;

    @GetMapping("/addPurchase")
    @ResponseBody
    public String addPurchaseToMember(int id, String item, double price){

        //finding member
        Optional<Member> foundMember = memberRepo.findById(id);


        if (foundMember.isPresent()) {

            //creating purchase instance
            Purchase newPurchase = new Purchase();
            newPurchase.setItemDescription(item);
            newPurchase.setItemPrice(price);

            //add that purchase to that customer
            Member memberObj = foundMember.get();
            memberObj.getPurchases().add(newPurchase);

            //save new info into database (repositories)
            purchaseRepo.save(newPurchase); //add
            memberRepo.save(memberObj); //update

            return "purchase added";
        }else
            return "member not found";
    }


}
