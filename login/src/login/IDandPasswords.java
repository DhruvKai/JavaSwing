package login;

import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		logininfo.put("Bro", "pizza");
		logininfo.put("Brometius", "passwrord");
		logininfo.put("BroCode", "pizza123");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}
