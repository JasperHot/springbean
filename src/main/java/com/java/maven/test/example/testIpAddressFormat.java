package com.java.maven.test.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testIpAddressFormat {
	public static void main(String[] args) {
		String ip1 = "1080:0:0:0:8:800:200C:417A";
		String ip2 = "1080::8:800:200c:417a";
		String ip3 = "10.0.12.12";
		String ip4 = "10.0.12.120";
		try {

			InetAddress address1 = InetAddress.getByName(ip1);
			InetAddress address2 = InetAddress.getByName(ip2);
			System.out.println("ip1==ip2? " + address1.equals(address2));

			InetAddress address3 = InetAddress.getByName(ip3);
			InetAddress address4 = InetAddress.getByName(ip4);
			System.out.println("ip3==ip4? " + address3.equals(address4));

			System.out.println("ip1==ip3? " + address3.equals(address1));
			System.out.println("ip2==ip4? " + address2.equals(address4));

			System.out.println("ip2 host: " + address2.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
