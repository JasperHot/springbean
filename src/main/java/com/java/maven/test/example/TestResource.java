package com.java.maven.test.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class TestResource {

	private static final String CLOUD_CONFIG = TestResource.class
			.getResource("/test/cloud_config.txt")
			.getPath();/* support non-jar file fetching, e.g from eclipse */
	// private static final String CLOUD_CONFIG = TestResource.class
	// .getResource("TestFile.xml").getPath();
	// static URL cloudfile = Thread.currentThread().getContextClassLoader()

	public static void main(String[] args) {
		URL cloudfile = TestResource.class.getResource("TestFile.xml");
		System.out.println(cloudfile.toString());
		System.out.println(CLOUD_CONFIG);
		File file = new File(CLOUD_CONFIG);

		// InputStream inputStream =
		// TestBeanFile.class.getResourceAsStream("/test/cloud_config.txt");
		try (BufferedReader reader = new BufferedReader(
				new FileReader(file));) {
			String tmpString = null;
			while ((tmpString = reader.readLine()) != null) {
				System.out.println(tmpString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
