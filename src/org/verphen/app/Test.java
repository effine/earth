/**
 * @author VerpHen
 * @date 2013-10-17  上午10:09:41
 */

package org.verphen.app;

import java.sql.Timestamp;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.verphen.bean.Member;

public class Test {

	// 获得时间
	public static Timestamp getCurrentTime() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.println(c.getTime().getTime());
		Timestamp time = new Timestamp(c.getTime().getTime());
		return time;
	}

	public static void main(String[] args) {

		// 应用程序或资源的资源文件，无法继承此类
		Configuration cfg = new Configuration().configure();

		// 使用hibernate.cfg.properties作为配置文件：未通过
		/*
		 * Configuration cfg = new Configuration()
		 * .configure("hibernate.cfg.properties");
		 */

		// Hibernate的核心接口，SessionFactroy接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Member m = new Member();
			m.setUsername("zhangsan");
			m.setPassword("123");
			m.setBirthday(getCurrentTime());

			session.save(m);
			ts.commit();
		} catch (Exception e) {
			if (null != ts) {
				ts.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
			sf.close();
		}
	}
}
