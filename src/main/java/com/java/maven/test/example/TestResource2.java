package com.java.maven.test.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestResource2 {

	public static final String CLOUD_CONFIG = "/test/cloud_config.txt";

	// public static final String CLOUD_CONFIG = "TestFile.xml";
	public static Class getOwnClass() {
		Class cl = null;
		try {
			cl = Class.forName("com.java.maven.test.example.TestResource2");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return cl;
	}

	public static void main(String[] args) {
		if (getOwnClass() != null) {
			System.out.println("branch 1");
			try (InputStream is = getOwnClass().getResourceAsStream(
					CLOUD_CONFIG); /* support runable jar & eclipse both */
					BufferedReader br = new BufferedReader(
							new InputStreamReader(is));) {
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("branch 2");
			try (InputStream is = ClassLoader
					.getSystemResourceAsStream(CLOUD_CONFIG);
					BufferedReader br = new BufferedReader(
							new InputStreamReader(is));) {
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
