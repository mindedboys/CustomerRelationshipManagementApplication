package com.CustomerRelationshipManagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public String insertCustomer(Customer customer) {// insert customer details
		
	String msg= customerDao.insertCustomer(customer);
		
		return msg;
	}


	@Override // get all customers details
	public List<Customer> getCustomerList() {
		
	List<Customer> list = customerDao.getCustomerList();
		
		return list;
	}


	@Override      // get customer by id
	public Customer getCustomerById(int id) {

	Customer customer	= customerDao.getCustomerById(id);
		
	 return customer;
	}


	@Override // update customer all details
	public String updateCustomer(Customer customer) {

		return customerDao.updateCustomer(customer);		
	}


	@Override // customer delete by Id
	public String deleteCustomerById(int id) {
		
		return customerDao.deleteCustomerById(id);				
	}


	@Override  // inserted Multiple customers
	public String insertMultipleCustomer(List<Customer> customers) {

		return customerDao.insertMultipleCustomer(customers);	
	}


	@Override   // Get All Customer with FirstName
	public List<Customer> getCustomerByFirstName(String firstName) {

		return customerDao.getCustomerByFirstName(firstName);
	}

	
	
	@Override  // Get All Customer with LastName
	public List<Customer> getCustomerByLastName(String lastName) {
		return customerDao.getCustomerByLastName(lastName);
	}

		

	@Override  //Get All Customer with Less Than Age
	public List<Customer> getCustomerByLessThanAge(int age) {

		return customerDao.getCustomersByLessThanAge(age);
		
	}

 
	@Override // Get all Customer By Greater Than with Age
	public List<Customer> getCustomerByGreaterThanAge(int age) {

		return customerDao.getCustomerByGreaterThanAge(age);
	}


	
	@Override // Get all Customer By Equal to Age
	public List<Customer> getCustomerByEqualToage(int age) {
		return customerDao.getCustomerByEqualToAge(age);
	}


	@Override // Get all Customer with his Email
	public List<Customer> getCustomerByEmail(String email) {
		return customerDao.getCustomerByEmail(email);
	}


	@Override // Get all Customer with his mobileNumber
	public List<Customer> getCustomerByMobileNumber(String mobileNumber) {

		return customerDao.getCustomerByMobileNumber(mobileNumber);
	}

	

	@Override // update customer first Name with help of ID
	public String updateCustomerFirstName(int id, String firstName) {
		return customerDao.updateCustomerFirstName(id, firstName);
	}


	
	@Override  // update customer Last Name with help of ID
	public String updateCustomerLastName(int id, String lastName) {
		return customerDao.updateCustomerLastName(id, lastName);
	}


	 
	@Override   // update customer Email with help of ID
	public String updateCustomerEmail(int id, String email) {
		return customerDao.updateCustomerEmail(id, email);
	}


	
	@Override  // update customer Mobile Number with help of ID
	public String updateCustomerMobileNumber(int id, String mobileNumber) {
		return customerDao.updateCustomerMobileNumber(id, mobileNumber);
	}


	
	@Override // update customer Age with help of ID
	public String updateCustomerAge(int id, int age) {
		return customerDao.updateCustomerAge(id, age) ;
	}


	
	@Override // get First Name of all customers 
	public List<Customer> getCustomersFirstName() {
    List<Customer> list = customerDao.getCustomersFirstName();		
	return list;
	}


	
	@Override // get all customers Email
	public List<Customer> getCustomersLastName() {
    List<Customer> list = customerDao.getCustomersLastName();
	return list;
	}


	
	@Override // get all customers email
	public List<Customer> getAllCustomersEmail() {
    List<Customer> list = customerDao.getAllCustomersEmail();     
	return list;
	}


	@Override //Get All Customer Mobile Number
	public List<Customer> getAllCustomerMobileNumber() {
	List<Customer> list = customerDao.getAllCustomerMobileNumber();	
	return list;
	}

       		
}
	
