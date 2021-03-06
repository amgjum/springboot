package com.example.demo;

import com.example.demo.util.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		

		String name="aj"; 


		String h4="h4";
		String h5;

		String s = "{\"name\":\"amgjum\",\"pwd\":\"123\"}";
		try {

			String develop ="develop";
			String develop2 ="develop2";
			User user = (new ObjectMapper()).readValue(s,User.class);
			Map m = (new ObjectMapper()).readValue(s,Map.class);
			System.out.println(m);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpringApplication.run(DemoApplication.class, args);
	}

}

