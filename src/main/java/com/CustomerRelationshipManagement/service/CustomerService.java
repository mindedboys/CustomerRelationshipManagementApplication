package com.CustomerRelationshipManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.entity.Customer;


public interface CustomerService {

	 String insertCustomer(Customer customer); // insert customer details	 
	 List<Customer> getCustomerList(); // get customer details	 
	 Customer getCustomerById(int id); // get customer by id	 
	 String updateCustomer(Customer customer);//update customer all details	 
	 String deleteCustomerById(int id); // customer delete by Id	 
	 String insertMultipleCustomer(List<Customer> customers); // insert Multiple Customer
	 
	 
	 List<Customer> getCustomerByFirstName(String firstName); // Get all Customer By FirstName
	 List<Customer> getCustomerByLastName(String lastName); // Get all Customer By LastName	 
	 List<Customer> getCustomerByLessThanAge(int age); // Get all Customer with less then age	 
	 List<Customer> getCustomerByGreaterThanAge(int age); // Get all Customer with Greater then age	 
	 List<Customer> getCustomerByEqualToage(int age); // Get all Customer with Equal to age	 
	 List<Customer> getCustomerByEmail(String email); // Get all Customer with his Email	 
	 List<Customer> getCustomerByMobileNumber (String mobileNumber); //Get all Customer with his mobileNumber

	 
	 String updateCustomerFirstName(int id, String firstName); // update customer first Name with help of ID
   	 String updateCustomerLastName(int id, String lastName); // update customer Last Name with help of ID 
	 String updateCustomerEmail(int id, String email); // update customer Email with help of ID
	 String updateCustomerMobileNumber(int id, String mobileNumber); //update customer Mobile Number with help of ID
	 String updateCustomerAge(int id, int age); // update customer Age with help of ID
      

	 List<Customer> getCustomersFirstName(); // Get First Name of all Customer
	 List<Customer> getCustomersLastName(); // Get Last Name of all Customer
	 List<Customer> getAllCustomersEmail(); // Get all customer Email
	 List<Customer> getAllCustomerMobileNumber();// Get all Customer mobile Number
}
