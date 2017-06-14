package com.java.maven.test.example;

import org.mockito.Mockito;
import org.testng.annotations.Test;

public class VerifyInterfaceTest {
     @Test
     public void interfaceTest(){
    	 String respone="xxx.10.0";
    	 VerifyInterface verifyInterface=Mockito.mock(VerifyInterface.class);
    	 VerifyInterface.Account user = Mockito.mock(VerifyInterface.Account.class);
    	 Mockito.when(verifyInterface.externalInterface(user, 0)).thenReturn(respone);
    	 verifyInterface.externalInterface(user,0);
    	 Mockito.verify(verifyInterface).externalInterface(user, 0);
    	 
    	 Mockito.when(verifyInterface.externalInterface(user)).thenReturn(respone);
    	 verifyInterface.externalInterface(user);
    	 Mockito.verify(verifyInterface).externalInterface(user);
     }
}
