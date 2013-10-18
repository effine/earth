/**
 * @author VerpHen
 * @date 2013-10-17  ����10:09:41
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

	// ���ʱ��
	public static Timestamp getCurrentTime() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.println(c.getTime().getTime());
		Timestamp time = new Timestamp(c.getTime().getTime());
		return time;
	}

	public static void main(String[] args) {

		// Ӧ�ó������Դ����Դ�ļ����޷��̳д���
		Configuration cfg = new Configuration().configure();

		// ʹ��hibernate.cfg.properties��Ϊ�����ļ���δͨ��
		/*
		 * Configuration cfg = new Configuration()
		 * .configure("hibernate.cfg.properties");
		 */

		// Hibernate�ĺ��Ľӿڣ�SessionFactroy�ӿڸ����ʼ��Hibernate�����䵱���ݴ洢Դ�Ĵ��������𴴽�Session����
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
