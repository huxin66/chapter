package com.itheima.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

	public void mainTest() {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		jdbcTemplate.execute("create table account("+
							"id int primary key auto_increment,"+
							"username varchar(50),"+
							"balance double)");
		System.out.println("账户表account创建成功！");
		((ConfigurableApplicationContext) applicationContext).close();
	}
	
	public void addAccountTest() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		Account account = new Account();
		account.setUsername("陈新毅");
		account.setBalance(1000.00);
		int num = accountDao.addAccount(account);
		if(num>0) {
			System.out.println("成功插入了" + num + "条数据");
		}else {
			System.out.println("插入操作执行失败了！");
		}
		((ConfigurableApplicationContext) applicationContext).close();
	}
	
	public void updateAccountTest() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		Account account = new Account();
		account.setId(1);
		account.setUsername("陈新毅");
		account.setBalance(2000.00);
		int num = accountDao.updateAccount(account);
		if(num>0) {
			System.out.println("成功修改了" + num + "条数据");
		}else {
			System.out.println("修改操作执行失败了！");
		}
		((ConfigurableApplicationContext) applicationContext).close();
	}
	
	public void deleteAccountTest() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		int num = accountDao.deleteAccount(1);
		if(num>0) {
			System.out.println("成功删除了" + num + "条数据");
		}else {
			System.out.println("删除操作执行失败了！");
		}
		((ConfigurableApplicationContext) applicationContext).close();
	}
	
	public void findAccountByIdTest() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		Account account =accountDao.findAccountById(4);
		System.out.println(account);
		((ConfigurableApplicationContext) applicationContext).close();
	}
	@Test
	public void findAllAccountTest() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		List<Account> account =accountDao.findAllAccount();
		for(Account act : account) {
			System.out.println(act);
		}
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
