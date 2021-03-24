package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplicationTesting;
import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import com.lambdaschool.usermodel.models.Useremail;
import com.lambdaschool.usermodel.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplicationTesting.class, properties = { "command.line.runner.enabled=false"})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplUnitTestNoDB
//public class UserServiceImplUnitTestNoDB
{
    @Autowired
    public UserService userService;

    @MockBean
    public UserRepository userrepos;

    public List<User> userList = new ArrayList<>();

    @Before
    public void setUp() throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1.setRoleid(1);
        r2.setRoleid(2);
        r3.setRoleid(3);

        // admin, data, user
        User u1 = new User("test admin",
                "password",
                "admin@lambdaschool.local");
        u1.setUserid(1);
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));
        u1.getRoles().add(new UserRoles(u1, r3));
        u1.getUseremails().add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails().add(new Useremail(u1, "admin@mymail.local"));
        userList.add(u1);

        // data, user
        User u2 = new User("test cinnamon", "1234567", "cinnamon@lambdaschool.local");
        u1.setUserid(2);
        u2.getRoles().add(new UserRoles(u2, r2));
        u2.getRoles().add(new UserRoles(u2, r3));
        u2.getUseremails().add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails().add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails().add(new Useremail(u2, "bunny@email.local"));
        userList.add(u2);

        // user
        User u3 = new User("test barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local");
        u1.setUserid(3);
        u3.getRoles().add(new UserRoles(u3, r2));
        u3.getUseremails().add(new Useremail(u3, "barnbarn@email.local"));
        userList.add(u3);

        User u4 = new User("test puttat", "password", "puttat@school.lambda");
        u1.setUserid(4);
        u4.getRoles().add(new UserRoles(u4, r2));
        userList.add(u4);

        User u5 = new User("test misskitty", "password", "misskitty@school.lambda");
        u1.setUserid(5);
        u5.getRoles().add(new UserRoles(u5, r2));
        userList.add(u5);

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception { }

    @Test
    public void findUserById()
    {
        Mockito.when(userrepos.findById(1L)).thenReturn(Optional.of(userList.get(0)));
        assertEquals("test admin", userService.findUserById(1).getUsername());
//        List<User> blah = userService.findAll();
//        System.out.println(blah);
//        assertEquals("blah", "blah");
    }

    @Test
    public void findByNameContaining()
    {
    }

    @Test
    public void findAll()
    {
    }

    @Test
    public void delete()
    {
    }

    @Test
    public void findByName()
    {
//  Mockito.when(userrepos.findByUsername("whatever")).thenReturn(userList);
//  assertEquals(3, userService.findByName("test miss kitty"));

    }

    @Test
    public void save()
    {
    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteAll()
    {
    }
}