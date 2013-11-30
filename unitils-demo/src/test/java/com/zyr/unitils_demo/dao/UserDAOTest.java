/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zyr.unitils_demo.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;

import com.zyr.unitils_demo.domain.User;

/**
 * @author 周光明
 * @File UserDAOTest.java Date: Nov 28, 20135:08:21 PM-0400 2013
 * @since 1.0
 */

@DataSet
public class UserDAOTest extends UnitilsJUnit4  {
	//TODO
	private UserDao userDao = new UserDao();
	@Test
    public void testFindByName() {
        User result = userDao.findByName("doe", "john");
//        assertPropertyLenientEquals("userName", "jdoe", result);
    }

    @Test
    //TODO
    @DataSet("UserDAOTest.testFindByMinimalAge.xml")
    public void testFindByMinimalAge() {
        List<User> result = userDao.findByMinimalAge(18);        
//        assertPropertyLenientEquals("firstName", Arrays.asList("jack"), result);
    }
}
