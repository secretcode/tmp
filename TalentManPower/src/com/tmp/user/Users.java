package com.tmp.user;

import java.io.Serializable;

public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int id;
	
	protected String loginName;
	
	protected int roleId;

	protected String password=null;

	protected String Email=null;
	public int getId()
	{
		return id;
	}
	public String getLoginName()
	{
		return loginName;
	}
	public String getPassword()
	{
		return password;
	}
	public int getRoleId() {
		return roleId;
	}
	public String getEmail(){
		return Email;
	}
	
	
	public void setId(int id)
	{
		this.id = id;
	}
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}
	public void setEmail(String Email)
	{
		this.Email = Email;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
		if (id != _cast.id) {
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
		_hashCode = 29 * _hashCode + id;
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
		ret.append( "id=" + id );
		ret.append( ", loginName=" + loginName );
		ret.append( ", password=" + password );
		return ret.toString();
	}

}
