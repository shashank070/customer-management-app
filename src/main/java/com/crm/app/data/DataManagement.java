package com.crm.app.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.app.connection.DbConnectionManager;
import com.crm.app.vo.Address;
import com.crm.app.vo.CustomerDetail;

@Service
public class DataManagement {

	@Autowired
	DbConnectionManager dbConnectionManager;
	
	public void InsertNewCustomer(CustomerDetail customer)
	{
		Connection conn= dbConnectionManager.getDbConnection();
		String insertCustomerQuery="insert into customer values ("
				+ "'"+customer.getCustomerNumber()+"',"
				+ "'"+customer.getFirstName()+"',"
				+ "'"+customer.getMiddleName()+"',"
			    + "'"+customer.getLastName()+"',"
			    + "'"+customer.getDateOfBirth()+"',"
			    + "'"+customer.getMobileNumber()+"',"
			    + "'"+customer.getGender()+"',"
			    + "'"+customer.getCountryOfBirth()+"',"
			    + "'"+customer.getCountryOfResidence()+"',"
			    + "'"+customer.getCustomerSegmant()+"')";
		
		Address homeAddress= customer.getAddresses().get(0);
		Address officeAddress= customer.getAddresses().get(1);
		
		
		String insertHomeAddress="insert into address values ("
				+ "'"+customer.getCustomerNumber()+"',"
				+ "'"+homeAddress.getType()+"',"
				+ "'"+homeAddress.getAddrLine1()+"',"
				+ "'"+homeAddress.getAddrLine2()+"',"
				+ "'"+homeAddress.getAddrLine3()+"',"
			    + "'"+homeAddress.getAddrLine4()+"',"
			    + "'"+homeAddress.getCountryCode()+"',"
			    + "'"+homeAddress.getZip()+"',"
			    + "'"+homeAddress.getState()+"',"
			    + "'"+homeAddress.getCity()+"')";
		
		String insertOfficeAddress="insert into address values ("
				+ "'"+customer.getCustomerNumber()+"',"
				+ "'"+officeAddress.getType()+"',"
				+ "'"+officeAddress.getAddrLine1()+"',"
				+ "'"+officeAddress.getAddrLine2()+"',"
				+ "'"+officeAddress.getAddrLine3()+"',"
				+ "'"+officeAddress.getAddrLine4()+"',"
				+ "'"+officeAddress.getCountryCode()+"',"
				+ "'"+officeAddress.getZip()+"',"
				+ "'"+officeAddress.getState()+"',"
				+ "'"+officeAddress.getCity()+"')";
		
		
		Statement stm=null;
		try {
			stm= conn.createStatement();
			stm.executeUpdate(insertCustomerQuery);
			stm.executeUpdate(insertHomeAddress);
			stm.executeUpdate(insertOfficeAddress);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			dbConnectionManager.closeStm(stm);
		}
		
	}
	
	public void UpdateCustomer(CustomerDetail customer)
	{
		Connection conn= dbConnectionManager.getDbConnection();
		
		String deleteCustomer="delete from customer where customernumber='"+customer.getCustomerNumber()+"'";
		
		String deleteCustomerHomeAddress="delete from address where customernumber='"+customer.getCustomerNumber()+"'";
		
		Statement stm=null;
		try {
			stm= conn.createStatement();
			stm.executeUpdate(deleteCustomer);
			stm.executeUpdate(deleteCustomerHomeAddress);
			InsertNewCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			dbConnectionManager.closeStm(stm);
		}
	}
	
	public void DeleteCustomer(String customerId)
	{
		Connection conn= dbConnectionManager.getDbConnection();
		
		String deleteCustomer="delete from customer where customernumber='"+customerId+"'";
		
		String deleteCustomerHomeAddress="delete from address where customernumber='"+customerId+"'";
		
		Statement stm=null;
		try {
			stm= conn.createStatement();
			stm.executeUpdate(deleteCustomer);
			stm.executeUpdate(deleteCustomerHomeAddress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			dbConnectionManager.closeStm(stm);
		}
	}
	
	public CustomerDetail GetCustomer(String customerId)
	{
		Connection conn= dbConnectionManager.getDbConnection();
		
		String getCustomer="select * from customer where customernumber='"+customerId+"'";
		
		String getCustomerHomeAddress="select * from address where customernumber='"+customerId+"'";
		
		CustomerDetail customer=null ;
		
		Statement stm=null;
		ResultSet rs=null;
		Statement stm2=null;
		ResultSet rs2=null;
		try {
			stm= conn.createStatement();
			stm2= conn.createStatement();
			rs=stm.executeQuery(getCustomer);
			while(rs.next())
			{
				
				List<Address> addrList= new ArrayList<Address>();
				
				rs2=stm2.executeQuery(getCustomerHomeAddress);
				while(rs2.next()) {
					addrList.add(new Address(rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8), rs2.getString(9), rs2.getString(10)));
				}
					
				customer= new CustomerDetail(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(1), rs.getString(8), rs.getString(9), rs.getString(10), addrList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			dbConnectionManager.closeStmRs(stm2, rs2);
			dbConnectionManager.closeStmRs(stm, rs);
		}
		return customer;
	}
	
	public List<CustomerDetail> GetCustomerList()
	{
		Connection conn= dbConnectionManager.getDbConnection();
		
		String getCustomer="select * from customer";
		
		List<CustomerDetail> customerList = new ArrayList<CustomerDetail>();
		CustomerDetail customer=null ;
		
		Statement stm=null;
		ResultSet rs=null;
		Statement stm2=null;
		ResultSet rs2=null;
		try {
			stm= conn.createStatement();
			
			rs=stm.executeQuery(getCustomer);
			while(rs.next())
			{
				stm2= conn.createStatement();
				String getCustomerHomeAddress="select * from address where customernumber='"+rs.getString(1)+"'";

				List<Address> addrList= new ArrayList<Address>();
				
				rs2=stm2.executeQuery(getCustomerHomeAddress);
				while(rs2.next()) {
					addrList.add(new Address(rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8), rs2.getString(9), rs2.getString(10)));
				}
					
				customer= new CustomerDetail(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(1), rs.getString(8), rs.getString(9), rs.getString(10), addrList);
				customerList.add(customer);
				dbConnectionManager.closeStmRs(stm2, rs2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
		
			dbConnectionManager.closeStmRs(stm, rs);
		}
		return customerList;
	}
	
}
