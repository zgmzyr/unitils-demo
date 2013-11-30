/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zyr.unitils_demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zyr.unitils_demo.domain.Account;

/**
 * @author 周光明
 * @File AccountDao.java Date: Nov 29, 20134:14:44 PM-0400 2013
 * @since 1.0
 */
public class AccountDao extends JdbcDaoSupport {

	public Account getAccount(String accountId) {
		List<Account> list = null;

		list = getJdbcTemplate().query("select account_id,balance from tb_account where account_id=?",
				new Object[] { accountId }, new RowMapper<Account>() {

					@Override
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						Account acc = new Account();
						acc.setAccountId(rs.getString("account_id"));
						acc.setBalance(rs.getInt("balance"));
						return acc;
					}
				});
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public int updateAccount(String accountId, int balance) {
		int ret = getJdbcTemplate().update("update tb_account set balance = ? where account_id =?",
				new Object[] { balance, accountId });
		return ret;
	}
}
