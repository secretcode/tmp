package com.tmp.user;

import java.security.MessageDigest;
import java.sql.Connection;



import com.tmp.user.*;

public class UserManager {

	public static String encryptPasswordMDF (String passwd) {
        final String COOKIE_KEY = "LpX5jXsM838s49L3HMOhdbTiec66NWqW9Nfmis9w80sEPIei37HcPFC8";
        
        passwd = COOKIE_KEY + passwd;
        byte[] defaultBytes = passwd.getBytes();
        StringBuffer hexString = new StringBuffer();
    try{
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
                
            
            for (int i=0;i<messageDigest.length;i++) {
                    String hex = Integer.toHexString(0xFF & messageDigest[i]); 
                    if(hex.length()==1)
                    hexString.append('0');

                    hexString.append(hex);
            }
            String foo = messageDigest.toString();                                     
    }catch(Exception e){
    	
    }
    return hexString.toString();
}

	

	public static void empSignUp(Employee emp,String password,Connection con) {
		try {
			System.out.println("in manager ");
			UsersDAO.empSignUp(emp.getName(),emp.getEmail(),password,emp.getMobile(),emp.getAddress(),emp.getCourse(),emp.getExperience(),con);
			System.out.println("back to manager");
		}catch(Exception e) {}
	}
	

	
	public static Users getUserInfo(int uid,int roleId,Connection con){
		Users usr=null;
		try {
			usr=UsersDAO.getUserInfo(uid,roleId,con);
			System.out.println(usr);
		}catch(Exception e) {}
		return usr;
	}

	
	public static Users authenticateUser(String loginName,String passwd,Connection con){
		int roleId = -1;
		Users usr = null;
//		Connection con = null;
		try{
//			con = DBConnection.getConnection();	
			passwd = encryptPasswordMDF(passwd);
			System.out.println("encrypted password is" + passwd);
			usr = UsersDAO.authenticateUser(loginName,passwd,con);			
		}catch(Exception exp){
			System.out.println(" getRoleIdOfAuthenticatedUser exp " + exp);			
		}finally{
			//DBConnection.freeResources(con);
		}
		return usr;	
	}
	
	
}
