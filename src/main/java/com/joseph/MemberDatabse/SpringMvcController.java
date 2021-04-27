package com.joseph.MemberDatabse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Optional;

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

    @GetMapping("/list")
    public String listMembers(ModelMap modelMap){
        modelMap.addAttribute("members", memberRepository.findAll());

        return "list_members";
    }

    @RequestMapping("/find")
    public String findMember(int id){

       Optional<Member> foundMember = memberRepository.findById(id);
       ModelMap model = new ModelMap();
       model.addAttribute("members", foundMember);

       return "list_members";
    }
}
