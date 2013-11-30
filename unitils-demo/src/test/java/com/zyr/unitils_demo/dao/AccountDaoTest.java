/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zyr.unitils_demo.dao;

import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit3;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import com.zyr.unitils_demo.domain.Account;

/**
 * @author 周光明
 * @File AccountDaoTest.java Date: Nov 29, 20134:43:59 PM-0400 2013
 * @since 1.0
 */
public class AccountDaoTest extends UnitilsJUnit3 {

    @SpringApplicationContext({ "classpath:testapplication/appContext-common.xml",
            "classpath:testapplication/testDatasource.xml", "classpath:META-INF/spring/applicationContext-*.xml" })
    protected ApplicationContext applicationContext;

    @SpringBeanByType
    private AccountDao accountDao;

    @DataSet("ACCOUNT.xml")
    public void testGetAccount() {
        Account account = accountDao.getAccount("S31993k");
        //TODO
//        System.out.println(JSON.toJSON(account));
        assertEquals(100, account.getBalance());
    }

    @DataSet("ACCOUNT.xml")
    public void testGetAccountNull() {
        Account account = accountDao.getAccount("23");
        assertEquals(null, account);
    }
    @DataSet("ACCOUNT.xml")
    @ExpectedDataSet("ACCOUNT_NEW.xml")
    public void testUpdateAccount() {
        accountDao.updateAccount("S31993k", 35);

    }

}
