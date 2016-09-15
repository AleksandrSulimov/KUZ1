package uz.user;

import java.io.IOException;

import uz.util.PropertyLoader;

public class User {

	private String userName;
	private String userPassword;
	
	public User(){
		try {
			this.userName = PropertyLoader.loadProperty("stand_user");
			this.userPassword = PropertyLoader.loadProperty("stend_password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setUserName(String val){
		this.userName = val;
	}
	public void setUserPassword(String val){
		this.userPassword = val;
	}
	public String getUserName(){
		return userName;
	}
	public String getUserPassword(){
		return userPassword;
	}
}
