package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Member;
import com.mg.eventmanager.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserProfileController {
    @Autowired
    MemberService memberService;

    @GetMapping(value = "/api/users/user/{id}",produces = "application/json")
    public Member getUserDetail(@PathVariable Long id){
        return memberService.findById(id);
    }
}
