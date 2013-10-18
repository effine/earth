/**
 * @author VerpHen
 * @date 2013-10-16  ÏÂÎç11:38:06
 */

package org.verphen.bean;

import java.sql.Timestamp;

public class Member {
	private int id;
	private String username;
	private String password;
	private Timestamp birthday;

	public Member() {
	}

	public Member(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

}
