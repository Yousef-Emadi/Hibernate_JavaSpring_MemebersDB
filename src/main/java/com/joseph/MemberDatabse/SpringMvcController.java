package com.joseph.MemberDatabse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringMvcController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/add")
    @ResponseBody
    public String addMember(String name_first, String name_last){

        Member newMember = new Member();
        newMember.setName_first(name_first);
        newMember.setName_last(name_last);
        newMember.setPhone("(438)-5454-3232");
        newMember.setEmail("info@example.com");
        newMember.setDob("2010-01-01");
        newMember.setAddress("5500 Park Avenue");
        newMember.setBalance(0);

        memberRepository.save(newMember);


        return "New member added to repo";

    }
}
