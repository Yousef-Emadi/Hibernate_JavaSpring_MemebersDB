package com.joseph.MemberDatabse.controller;

import com.joseph.MemberDatabse.entity.Member;
import com.joseph.MemberDatabse.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class SpringMvcMemberController {

    // each field requires its own annotation
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/add")
    @ResponseBody
    public String addMember(String name_first, String name_last){

        Member newMember = new Member();
        newMember.setName_first(name_first);
        newMember.setName_last(name_last);
        newMember.setUserName("temp_username");
        newMember.setPassword("temp_password");
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

    @GetMapping("/findOneMember")
    public String findMember(int id, ModelMap model){
        Optional<Member> foundMember = memberRepository.findById(id);

        if (foundMember.isPresent()) {
            Member memberObj = foundMember.get();
            model.addAttribute("members", memberObj);
            return "list_members";
        }else
            return "sorry_DB_page";
    }


    @GetMapping("/updateName")
    @ResponseBody
    public String updateMemberName(int id, String newName){
        Optional<Member> foundMember = memberRepository.findById(id);

        if (foundMember.isPresent()){
            Member memberObj = foundMember.get();
            memberObj.setName_first(newName);
            memberRepository.save(memberObj);
            return "Done!";
        } else return "Failed!";
    }

    /** Drop down list select will create in index.html*/
    @GetMapping("/droplist")
    public String dropListMembers(ModelMap modelMap){
        modelMap.addAttribute("myMembers", memberRepository.findAll());

        return "drop_select_members";
    }

    @GetMapping("/selectedMember")
    @ResponseBody
    public String selectedMember(int memberId) {
        Optional<Member> foundMember = memberRepository.findById(memberId);

        if (foundMember.isPresent()) {
            Member memberObj = foundMember.get();
            return "a member selected";
        }else
            return "member not found";
    }
}
