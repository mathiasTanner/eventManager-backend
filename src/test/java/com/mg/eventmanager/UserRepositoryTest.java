package com.mg.eventmanager;

import com.mg.eventmanager.domain.User;
import com.mg.eventmanager.domain.repositories.AdminRepository;
import com.mg.eventmanager.domain.repositories.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventmanagerApplication.class)
@DataJpaTest
public class UserRepositoryTest {
    private User user;

    @Autowired
    UserRepository userRepository;


    @Test
    public void createNewUserTest(){
        emptyRepo();
        user = new User("usr", "userMail", false, "12345678");
        userRepository.save(user);

        List<User> lst = (List<User>) userRepository.findAll();
        assertFalse(lst.size()== 0);
        assertFalse(user.getId()==null);
    }

    @Test
    public void findUserTest(){
        User test = userRepository.findByUsername("usr");
        assertEquals(user, test);
        test = userRepository.findByMail("userMail");
        assertEquals(user, test);
    }

    @Test
    public void deleteUserTest(){
        userRepository.deleteById(user.getId());
        assertThat(userRepository.findById(user.getId())).isEmpty();
    }

    @AfterAll
    public void emptyRepo(){
        userRepository.deleteAll();
    }
}
