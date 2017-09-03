package com.java.maven.test.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
	public class Handler implements InvocationHandler {

		private Object delegate;

		public Object bind(Object delegate) {
			this.delegate = delegate;
			return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
					delegate.getClass().getInterfaces(), this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			Object result = null;
			System.out.println("before method");
			if (method.getName().equals("size")) {
				result = new Integer("1998");
			}
			// Object result = method.invoke(obj, args);
			System.out.println("after method");
			return result;
		}

	}
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		Class<?> c = Class.forName("java.lang.String");
		Constructor<?> cons = c.getConstructor(new Class[]{String.class});
		Object t = cons.newInstance(new Object[]{"XXX"});
		System.out.println("t=" + t);
		// 获取所有的属性?
		Field[] fs = c.getDeclaredFields();

		// 定义可变长的字符串，用来存储属性
		StringBuffer sb = new StringBuffer();
		// 通过追加的方法，将每个属性拼接到此字符串中
		// 最外边的public定义
		sb.append(Modifier.toString(c.getModifiers()) + " class "
				+ c.getSimpleName() + "{\n");
		// 里边的每一个属性
		for (Field field : fs) {
			sb.append("\t");// 空格
			sb.append(Modifier.toString(field.getModifiers()) + " ");// 获得属性的修饰符，例如public，static等等
			sb.append(field.getType().getSimpleName() + " ");// 属性的类型的名字
			sb.append(field.getName() + ";\n");// 属性的名字+回车
		}

		sb.append("}");
		System.out.println(sb);

		String s = "YYY";
		List delegate = new ArrayList<>();
		delegate.add(t);
		delegate.add(s);
		ReflectTest test = new ReflectTest();
		List proxy = (List) test.new Handler().bind(delegate);

		System.out.println("t=" + proxy.size());

	}
}
