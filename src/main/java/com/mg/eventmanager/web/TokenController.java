package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Member;
import com.mg.eventmanager.services.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("passwordHash") final String password){
        String token= memberService.login(username,password);
        if(StringUtils.isEmpty(token)){
            return "no token found";
        }
        return token;
    }


    @PostMapping("/register")
    public Member register(@RequestParam("username") final String username, @RequestParam("mail") final String mail, @RequestParam("hasCar") final boolean hasCar, @RequestParam("passwordHash") final String password){
        Member member = new Member(username, mail, hasCar, password);
        member = memberService.register(member);
        String token = memberService.login(member.getUsername(), member.getPasswordHash());
        member.setToken(token);
        return member;
    }

}
