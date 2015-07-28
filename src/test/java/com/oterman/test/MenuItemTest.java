package com.oterman.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oterman.oa.domain.MenuItem;



public class MenuItemTest {
	@Test
	public void addMenuItem(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
/***********************************************************************************/
		/*
		 * 个人办公
		 */
		MenuItem MenuItemitem1 = new MenuItem();
		MenuItemitem1.setMid(1L);
		MenuItemitem1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		MenuItemitem1.setName("办公自动化");
		MenuItemitem1.setPid(0L);
		//MenuItemitem1.setChecked(false);
		MenuItemitem1.setIsParent(true);
		
		MenuItem MenuItem2 = new MenuItem();
		MenuItem2.setMid(2L);
		MenuItem2.setIcon("css/images/MenuIcon/FUNC20001.gif");
		MenuItem2.setName("个人办公");
		//MenuItem2.setChecked(false);
		MenuItem2.setPid(1L);
		MenuItem2.setIsParent(true);
		
		MenuItem MenuItem21 = new MenuItem();
		MenuItem21.setMid(21L);
		MenuItem21.setIcon("css/images/MenuIcon/FUNC20054.gif");
		MenuItem21.setName("个人考勤");
		//MenuItem21.setChecked(false);
		MenuItem21.setPid(2L);
		MenuItem21.setIsParent(false);
		
		
		MenuItem MenuItem22 = new MenuItem();
		MenuItem22.setMid(22L);
		MenuItem22.setIcon("css/images/MenuIcon/FUNC23700.gif");
		MenuItem22.setName("日程安排");
		//MenuItem22.setChecked(false);
		MenuItem22.setPid(2L);
		MenuItem22.setIsParent(false);
		
		MenuItem MenuItem23 = new MenuItem();
		MenuItem23.setMid(23L);
		MenuItem23.setIcon("css/images/MenuIcon/FUNC20069.gif");
		MenuItem23.setName("工作计划");
		//MenuItem23.setChecked(false);
		MenuItem23.setPid(2L);
		MenuItem23.setIsParent(false);
		
		MenuItem MenuItem24 = new MenuItem();
		MenuItem24.setMid(24L);
		MenuItem24.setIcon("css/images/MenuIcon/FUNC20056.gif");
		MenuItem24.setName("工作日记");
		//MenuItem24.setChecked(false);
		MenuItem24.setPid(2L);
		MenuItem24.setIsParent(false);
		
		MenuItem MenuItem25 = new MenuItem();
		MenuItem25.setMid(25L);
		MenuItem25.setIcon("css/images/MenuIcon/time_date.gif");
		MenuItem25.setName("通讯录");
		//MenuItem25.setChecked(false);
		MenuItem25.setPid(2L);
		MenuItem25.setIsParent(false);
/*********************************************************************************/	
		/*
		 * 审批流转
		 */
		MenuItem MenuItem3 = new MenuItem();
		MenuItem3.setMid(3L);
		///MenuItem3.setChecked(false);
		MenuItem3.setIsParent(true);
		MenuItem3.setPid(1L);
		MenuItem3.setName("审批流转");
		MenuItem3.setIcon("css/images/MenuIcon/FUNC20057.gif");
		
		MenuItem MenuItem31 = new MenuItem();
		MenuItem31.setMid(31L);
		//MenuItem31.setChecked(false);
		MenuItem31.setIsParent(false);
		MenuItem31.setPid(3L);
		MenuItem31.setName("审批流程管理");
		MenuItem31.setIcon("css/images/MenuIcon/manager.gif");
		
		MenuItem MenuItem32 = new MenuItem();
		MenuItem32.setMid(32L);
		//MenuItem32.setChecked(false);
		MenuItem32.setIsParent(false);
		MenuItem32.setPid(3L);
		MenuItem32.setName("表单模板管理");
		MenuItem32.setIcon("css/images/MenuIcon/formmodel.gif");
		
		MenuItem MenuItem33 = new MenuItem();
		MenuItem33.setMid(33L);
		MenuItem33.setIsParent(false);
		//MenuItem33.setChecked(false);
		MenuItem33.setPid(3L);
		MenuItem33.setName("发起申请");
		MenuItem33.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		MenuItem MenuItem34 = new MenuItem();
		MenuItem34.setMid(34L);
		MenuItem34.setIsParent(false);
		//MenuItem34.setChecked(false);
		MenuItem34.setPid(3L);
		MenuItem34.setName("审批申请");
		MenuItem34.setIcon("css/images/MenuIcon/FUNC20029.gif");
		
		MenuItem MenuItem35 = new MenuItem();
		MenuItem35.setMid(35L);
		MenuItem35.setIsParent(false);
		//MenuItem35.setChecked(false);
		MenuItem35.setPid(3L);
		MenuItem35.setName("状态查询");
		MenuItem35.setIcon("css/images/MenuIcon/FUNC20029.gif");
/************************************************************************************/
		/*
		 * 知识管理
		 */
		MenuItem MenuItem4 = new MenuItem();
		MenuItem4.setMid(4L);
		MenuItem4.setIsParent(false);
		//MenuItem4.setChecked(false);
		MenuItem4.setPid(1L);
		MenuItem4.setName("知识管理");
		MenuItem4.setIcon("css/images/MenuIcon/FUNC20056.gif");
/*******************************************************************************/
		/*
		 * 综合行政
		 */
		MenuItem MenuItem5 = new MenuItem();
		MenuItem5.setMid(5L);
		MenuItem5.setIsParent(true);
		//MenuItem5.setChecked(false);
		MenuItem5.setPid(1L);
		MenuItem5.setName("管理行政");
		MenuItem5.setIcon("css/images/MenuIcon/manager.gif");
		
		MenuItem MenuItem51 = new MenuItem();
		MenuItem51.setMid(51L);
		MenuItem51.setIsParent(false);
		//MenuItem51.setChecked(false);
		MenuItem51.setPid(5L);
		MenuItem51.setName("考勤管理");
		MenuItem51.setIcon("css/images/MenuIcon/FUNC20070.gif");
		
		MenuItem MenuItem52 = new MenuItem();
		MenuItem52.setMid(52L);
		MenuItem52.setIsParent(false);
		//MenuItem52.setChecked(false);
		MenuItem52.setPid(5L);
		MenuItem52.setName("会议管理");
		MenuItem52.setIcon("css/images/MenuIcon/FUNC20064.gif");
		
		MenuItem MenuItem53 = new MenuItem();
		MenuItem53.setMid(53L);
		MenuItem53.setIsParent(false);
		//MenuItem53.setChecked(false);
		MenuItem53.setPid(5L);
		MenuItem53.setName("车辆管理");
		MenuItem53.setIcon("css/images/MenuIcon/radio_blue.gif");
/**************************************************************************************/
		/*
		 * 人力资源管理
		 * 	档案管理
		 * 	培训记录
		 * 	奖金记录
		 * 	职位变更
		 * 	人事合同
		 * 	薪酬制度
		 */
		MenuItem MenuItem6 = new MenuItem();
		MenuItem6.setMid(6L);
		MenuItem6.setIsParent(true);
		//MenuItem6.setChecked(false);
		MenuItem6.setPid(1L);
		MenuItem6.setName("人力资源");
		MenuItem6.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		MenuItem MenuItem61 = new MenuItem();
		MenuItem61.setMid(61L);
		MenuItem61.setIsParent(false);
		//MenuItem61.setChecked(false);
		MenuItem61.setPid(6L);
		MenuItem61.setName("档案管理");
		MenuItem61.setIcon("css/images/MenuIcon/FUNC20076.gif");
		
		MenuItem MenuItem62 = new MenuItem();
		MenuItem62.setMid(62L);
		MenuItem62.setIsParent(false);
		//MenuItem62.setChecked(false);
		MenuItem62.setPid(6L);
		MenuItem62.setName("培训记录");
		MenuItem62.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		MenuItem MenuItem63 = new MenuItem();
		MenuItem63.setMid(63L);
		MenuItem63.setIsParent(false);
		//MenuItem63.setChecked(false);
		MenuItem63.setPid(6L);
		MenuItem63.setName("奖赏记录");
		MenuItem63.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		MenuItem MenuItem64 = new MenuItem();
		MenuItem64.setMid(64L);
		MenuItem64.setIsParent(false);
		//MenuItem64.setChecked(false);
		MenuItem64.setPid(6L);
		MenuItem64.setName("职位变更");
		MenuItem64.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		MenuItem MenuItem65 = new MenuItem();
		MenuItem65.setMid(65L);
		MenuItem65.setIsParent(false);
		//MenuItem65.setChecked(false);
		MenuItem65.setPid(6L);
		MenuItem65.setName("人事合同");
		MenuItem65.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		MenuItem MenuItem66 = new MenuItem();
		MenuItem66.setMid(66L);
		MenuItem66.setIsParent(false);
		//MenuItem66.setChecked(false);
		MenuItem66.setPid(6L);
		MenuItem66.setName("薪酬制度");
		MenuItem66.setIcon("css/images/MenuIcon/FUNC20001.gif");
/*****************************************************************************************/
		/*
		 * 电子邮件
		 */
		MenuItem MenuItem7 = new MenuItem();
		MenuItem7.setMid(7L);
		MenuItem7.setIsParent(false);
		//MenuItem7.setChecked(false);
		MenuItem7.setPid(1L);
		MenuItem7.setName("电子邮件");
		MenuItem7.setIcon("css/images/MenuIcon/eml.gif");

/*******************************************************************/
		/*
		 * 实用工具
		 * 	车票预定
		 * 	GIS查询
		 * 	邮政编码
		 */
		MenuItem MenuItem8 = new MenuItem();
		MenuItem8.setMid(8L);
		MenuItem8.setIsParent(true);
		//MenuItem8.setChecked(false);
		MenuItem8.setPid(1L);
		MenuItem8.setName("实用工具");
		MenuItem8.setIcon("css/images/MenuIcon/FUNC20076.gif");
		MenuItem MenuItem81 = new MenuItem();
		MenuItem81.setMid(81L);
		MenuItem81.setIsParent(false);
		//MenuItem81.setChecked(false);
		MenuItem81.setPid(8L);
		MenuItem81.setName("车票预定");
		MenuItem81.setIcon("css/images/MenuIcon/FUNC220000.gif");
		MenuItem MenuItem82 = new MenuItem();
		MenuItem82.setMid(82L);
		MenuItem82.setIsParent(false);
		//MenuItem82.setChecked(false);
		MenuItem82.setPid(8L);
		MenuItem82.setName("GIS查询");
		MenuItem82.setIcon("css/images/MenuIcon/search.gif");
		MenuItem MenuItem83 = new MenuItem();
		MenuItem83.setMid(83L);
		MenuItem83.setIsParent(false);
		//MenuItem83.setChecked(false);
		MenuItem83.setPid(8L);
		MenuItem83.setName("邮政编码");
		MenuItem83.setIcon("css/images/MenuIcon/FUNC249000.gif");
/**************************************************************************/
		/*
		 * 个人设置
		 * 		个人信息
		 * 		密码修改
		 */
		MenuItem MenuItem9 = new MenuItem();
		MenuItem9.setMid(9L);
		MenuItem9.setIsParent(true);
		//MenuItem9.setChecked(false);
		MenuItem9.setPid(1L);
		MenuItem9.setName("个人设置");
		MenuItem9.setIcon("css/images/MenuIcon/FUNC20001.gif");
		MenuItem MenuItem91 = new MenuItem();
		MenuItem91.setMid(91L);
		MenuItem91.setIsParent(false);
		//MenuItem91.setChecked(false);
		MenuItem91.setPid(9L);
		MenuItem91.setName("个人信息");
		MenuItem91.setIcon("css/images/MenuIcon/FUNC20001.gif");
		MenuItem MenuItem92 = new MenuItem();
		MenuItem92.setMid(92L);
		MenuItem92.setIsParent(false);
		//MenuItem92.setChecked(false);
		MenuItem92.setPid(9L);
		MenuItem92.setName("密码修改");
		MenuItem92.setIcon("css/images/MenuIcon/FUNC241000.gif");
/***********************************************************************************/
		/*
		 * 系统管理
		 * 	岗位管理
		 * 	部门管理
		 * 	用户管理
		 */
		MenuItem MenuItem10 = new MenuItem();
		MenuItem10.setMid(10L);
		MenuItem10.setIsParent(true);
		//MenuItem10.setChecked(false);
		MenuItem10.setPid(1L);
		MenuItem10.setName("系统管理");
		MenuItem10.setIcon("css/images/MenuIcon/system.gif");
		MenuItem MenuItem101 = new MenuItem();
		MenuItem101.setMid(101L);
		MenuItem101.setIsParent(false);
		//MenuItem101.setChecked(false);
		MenuItem101.setPid(10L);
		MenuItem101.setName("岗位管理");
		MenuItem101.setIcon("css/images/MenuIcon/FUNC20001.gif");
		MenuItem MenuItem102 = new MenuItem();
		MenuItem102.setMid(102L);
		MenuItem102.setIsParent(false);
		//MenuItem102.setChecked(false);
		MenuItem102.setPid(10L);
		MenuItem102.setName("部门管理");
		MenuItem102.setIcon("css/images/MenuIcon/department.gif");
		MenuItem MenuItem103 = new MenuItem();
		MenuItem103.setMid(103L);
		MenuItem103.setIsParent(false);
		//MenuItem103.setChecked(false);
		MenuItem103.setPid(10L);
		MenuItem103.setName("用户管理");
		MenuItem103.setIcon("css/images/MenuIcon/FUNC20001.gif");
/**********************************************************************/
		/*
		 * {
		 * 	1,1
		 * 	2,5
		 * 	3,5
		 * 	4,1
		 * 	5,3
		 * 	6,6
		 * 	7,1
		 * 	8,3
		 * 	9,2
		 * 	10,3
		 * }
		 */
		
		session.save(MenuItemitem1);
		
		session.save(MenuItem2);
		session.save(MenuItem21);
		session.save(MenuItem22);
		session.save(MenuItem23);
		session.save(MenuItem24);
		session.save(MenuItem25);
		
		
		session.save(MenuItem3);
		session.save(MenuItem31);
		session.save(MenuItem32);
		session.save(MenuItem33);
		session.save(MenuItem34);
		session.save(MenuItem35);
		
		session.save(MenuItem4);
		
		session.save(MenuItem5);
		session.save(MenuItem51);
		session.save(MenuItem52);
		session.save(MenuItem53);
		
		session.save(MenuItem6);
		
		session.save(MenuItem61);
		session.save(MenuItem62);
		session.save(MenuItem63);
		session.save(MenuItem64);
		session.save(MenuItem65);
		session.save(MenuItem66);
		
		session.save(MenuItem7);
		
		session.save(MenuItem8);
		session.save(MenuItem81);
		session.save(MenuItem82);
		session.save(MenuItem83);
		
		session.save(MenuItem9);
		session.save(MenuItem91);
		session.save(MenuItem92);
		
		session.save(MenuItem10);
		session.save(MenuItem101);
		session.save(MenuItem102);
		session.save(MenuItem103);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void saveMenuItem_Privilege(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MenuItem MenuItem10 = new MenuItem();
		MenuItem10.setMid(11L);
		MenuItem10.setIsParent(true);
		//MenuItem10.setChecked(false);
		MenuItem10.setPid(1L);
		MenuItem10.setName("权限管理");
		MenuItem10.setIcon("css/images/MenuIcon/system.gif");
		session.save(MenuItem10);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void updateMenuItem_Privilege(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MenuItem MenuItem10 = new MenuItem();
		MenuItem10.setMid(11L);
		MenuItem10.setIsParent(false);
		//MenuItem10.setChecked(false);
		MenuItem10.setPid(1L);
		MenuItem10.setName("权限管理");
		MenuItem10.setIcon("css/images/MenuIcon/system.gif");
		session.update(MenuItem10);
		transaction.commit();
		session.close();
	}
}
