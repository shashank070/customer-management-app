package com.crm.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crm.app.connection.DbConnectionManager;

@SpringBootApplication
public class CustomerManagementAppApplication {
	

	@Autowired
	private DbConnectionManager dbConnectionManager;
	

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementAppApplication.class, args);

	}

}
