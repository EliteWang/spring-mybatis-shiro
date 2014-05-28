package com.easyjob.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easyjob.utils.URLUtils;

public class ProjectTest {
	
	@Test
	public void springTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		
	}
	
	@Test
	public void urlTest2() throws UnknownHostException {
		InetAddress[]   inetAdds   =   InetAddress.getAllByName(InetAddress.getLocalHost().getHostName()); 
	    for(int i = 0 ; i < inetAdds.length; i++){
	        System.out.print(inetAdds[i].getHostName()+ ":\t");
	        System.out.println(inetAdds[i].getHostAddress());
	    }
	}

}
