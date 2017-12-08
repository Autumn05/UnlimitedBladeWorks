package com.zhong717.service;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhong717.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void testHasMatchUser() throws Exception {
    boolean b1 = userService.hasMatchUser("admin", "123456");
    boolean b2 = userService.hasMatchUser("admin", "1111");
    assertTrue(b1);
    assertTrue(!b2);
  }

  @Test
  public void testFindUserByUserName() throws Exception {
    User user = userService.findUserByUserName("admin");
    assertEquals(user.getUserName(), "admin");
  }

  @Test
  public void testAddLoginLog() throws Exception {
    User user = userService.findUserByUserName("admin");
    user.setUserId(1);
    user.setUserName("admin");
    user.setLastIp("192.168.12.7");
    user.setLastVisit(new Date());
    userService.loginSuccess(user);
  }

}