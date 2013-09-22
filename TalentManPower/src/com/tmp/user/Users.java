
package com.tmp.user;


import java.io.Serializable;
import java.util.*;

public class Users implements Serializable{
	/** 
	 * This attribute maps to the column uid in the users table.
	 */
	protected int uid;
	
	private int roleId;
	
	private String fullName = null;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/** 
	 * This attribute maps to the column login_name in the users table.
	 */
	protected String loginName;

	/** 
	 * This attribute maps to the column password in the users table.
	 */
	protected String password;

		public Users()
	{
	}

	public int getUid()
	{
		return uid;
	}

	public void setUid(int uid)
   {
		this.uid = uid;
	}
	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof Users)) {
			return false;
		}
		
		final Users _cast = (Users) _other;
		if (uid != _cast.uid) {
			return false;
		}
		
		if (loginName == null ? _cast.loginName != loginName : !loginName.equals( _cast.loginName )) {
			return false;
		}
		
		if (password == null ? _cast.password != password : !password.equals( _cast.password )) {
			return false;
		}
		
			return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + uid;
		if (loginName != null) {
			_hashCode = 29 * _hashCode + loginName.hashCode();
		}
		
		if (password != null) {
			_hashCode = 29 * _hashCode + password.hashCode();
		}
		return _hashCode;
	}
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.mycompany.users.dto.Users: " );
		ret.append( "uid=" + uid );
		ret.append( ", loginName=" + loginName );
		ret.append( ", password=" + password );
		return ret.toString();
	}

}
