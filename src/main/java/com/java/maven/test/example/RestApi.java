package com.java.maven.test.example;

import java.lang.reflect.Method;

public abstract class RestApi {

	public void wrapper(Resource res) throws NoSuchMethodException, SecurityException {
		Method getHost = res.getClass().getMethod("getHost",null);
		Method getIpv6Host = res.getClass().getMethod("getIpv6Host",null);
		return;
	}
}
