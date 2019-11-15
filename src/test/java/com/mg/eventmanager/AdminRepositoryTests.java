package com.mg.eventmanager;


import com.mg.eventmanager.domain.Admin;
import com.mg.eventmanager.domain.repositories.AdminRepository;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventmanagerApplication.class)
@DataJpaTest
public class AdminRepositoryTests {
    private Admin admin;

    @Autowired
    AdminRepository adminRepository;


    @Test
    public void createNewAdminTest(){
        emptyRepo();
        admin = new Admin( "adm", "mail5",  true, "password");
        adminRepository.save(admin);

        List<Admin> lst = (List<Admin>) adminRepository.findAll();
        assertFalse(lst.size()== 0);
        assertFalse(admin.getId()==null);
    }

    @Test
    public void findAdminTest(){
        Admin test = adminRepository.findByUsername("adm");
        assertEquals(admin, test);
        test = adminRepository.findByMail("mail5");
        assertEquals(admin, test);
    }

    @Test
    public void deleteAdminTest(){
        adminRepository.deleteById(admin.getId());
        assertThat(adminRepository.findById(admin.getId())).isEmpty();
        emptyRepo();
    }


    @AfterAll
    public void emptyRepo(){
        adminRepository.deleteAll();
    }

}
