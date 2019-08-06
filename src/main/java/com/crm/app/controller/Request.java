package com.crm.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crm.app.connection.DbConnectionManager;
import com.crm.app.data.DataManagement;
import com.crm.app.vo.CustomerDetail;
import com.google.gson.Gson;

@RestController
public class Request {

	private static final Logger logger = LoggerFactory.getLogger(Request.class);
	Gson gson = new Gson();

	
	@Autowired
	DataManagement dataManagement;
	
	@RequestMapping(method= RequestMethod.POST, value="add-customer", consumes="application/json")
	public void AddCustomer(@RequestBody CustomerDetail customerDetail, HttpServletRequest request, HttpServletResponse response)
	{
		
		logger.info("***** RECIEVED POST REQUEST *****");
		
		logger.info("Customer Detail: "+ gson.toJson(customerDetail));
		
		dataManagement.InsertNewCustomer(customerDetail);
		
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value="get-customer-list")
	public List<CustomerDetail> GetCustomerList( HttpServletRequest request, HttpServletResponse response)
	{
	
		logger.info("***** RECIEVED GET CUSTOMER LIST REQUEST *****");
		
		List<CustomerDetail> customerList = dataManagement.GetCustomerList();
		
		logger.info("Response customer list: "+ gson.toJson(customerList));
		
		return customerList;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="get-customer")
	public CustomerDetail GetCustomer( HttpServletRequest request, HttpServletResponse response, String customerId)
	{
		
		logger.info("***** RECIEVED GET CUSTOMER REQUEST *****");
		
		logger.info("Customer ID: "+ customerId);
		
		CustomerDetail customerDetail = dataManagement.GetCustomer(customerId);
		
		logger.info("Response: "+ gson.toJson(customerDetail));
		
		return customerDetail;
	}
	
	@RequestMapping(method= RequestMethod.PUT, value="update-customer", consumes="application/json")
	public void GetCustomer( @RequestBody CustomerDetail customerDetail,HttpServletRequest request, HttpServletResponse response)
	{
		logger.info("***** RECIEVED UPDATE CUSTOMER REQUEST *****");
		
		logger.info("Customer Detail: "+ gson.toJson(customerDetail));
		
		dataManagement.UpdateCustomer(customerDetail);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value="delete-customer")
	public void GetCustomer( @RequestBody String[] customerIds,HttpServletResponse response,HttpServletRequest request)
	{
		logger.info("***** RECIEVED DELETE CUSTOMER REQUEST *****");
		
		for(int i=0;customerIds.length>i;i++)
		{
			logger.info("Customer ID: "+ customerIds[i]);
		
			dataManagement.DeleteCustomer(customerIds[i]);
		}
	}
	
	@RequestMapping(method= RequestMethod.GET, value="healthcheck")
	public String HealthCheck( HttpServletRequest request,HttpServletResponse response)
	{
		return "healthy";
	}
}
