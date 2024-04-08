package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity.Customer;

@Repository
public class CustomerDao {
 
	@Autowired
	SessionFactory sessionFactory;
	
	public String insertCustomer(Customer customer){// insert single customer details
	
	Session session = sessionFactory.openSession();
	// insert,update,delete-> you need to use Transaction
	Transaction transaction = session.beginTransaction();
	session.save(customer);
	transaction.commit();
	session.close();
	return "Customer insert Successfully";
	}
	
	
	//get all customer details
	public List<Customer> getCustomerList(){
	Session session= sessionFactory.openSession();
	return session.createQuery("from Customer",Customer.class).list(); //HQL query Customer(class name)
	
	}
	
	
	//get one customer by id
	public Customer getCustomerById(int id){
		
	Session session	= sessionFactory.openSession();
    Customer customer=session.get(Customer.class, id);
    
	return customer;
	}
	
	
	public String updateCustomer(Customer customer){ // update customer all details
		
	Session session = sessionFactory.openSession();	
	Transaction transaction = session.beginTransaction();	
	session.update(customer);	
	transaction.commit();
	session.close();
		
	return "Customer update Sucessfully...!!";
	}
	
	
	public String deleteCustomerById(int id){ // delete customer by ID
		
	Session session	= sessionFactory.openSession(); 
	Transaction transaction = session.beginTransaction();
	Customer customer= session.get(Customer.class, id);
	session.delete(customer);
	transaction.commit();
	session.close();
	return "Customer Delete sucessfully....!!!";
	}

	
	public String insertMultipleCustomer( List<Customer> customers){ 
	//	insert into Multiple Customer	
	Session session =sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	for(Customer customer:customers) 
	{
	   session.save(customer);
	}
	transaction.commit();
	session.close();
	return "Customer are inserted Successfully ....!!";
	}

	
    // Get All Customer By FirstName	
	public List<Customer> getCustomerByFirstName(String firstName){
	Session session = sessionFactory.openSession();
    Query<Customer> customers = session.createQuery("from Customer c where c.firstName =: firstName",Customer.class);
	customers.setParameter("firstName", firstName); // table column name , current class variable
	List<Customer> list = customers.list();
	return list;
	}
 	
	
	// Get All Customer By Last Name
	public List<Customer> getCustomerByLastName(String lastName){
     Session session = sessionFactory.openSession(); 
     Query<Customer> customers= session.createQuery("from Customer c where c.lastName =: lastName", Customer.class);
     customers.setParameter("lastName", lastName);
     List<Customer> list = customers.list();
     return list;
	}
	
	
	
	// Get all Customers with Less Than Age
	public List<Customer> getCustomersByLessThanAge(int age){ 		
	Session session	= sessionFactory.openSession();
	Query<Customer> customers = session.createQuery("from Customer c where c.age<:age",Customer.class );
	customers.setParameter("age", age);
	List<Customer> list = customers.list();
	return list;
	}
	
	
	// Get all Customers with greater Than Age 	
	 public List<Customer> getCustomerByGreaterThanAge(int age){
	 Session session =	sessionFactory.openSession();
	 Query<Customer> customers = session.createQuery("from Customer c where c.age>:age", Customer.class);
	 customers.setParameter("age", age);
	 List<Customer> list = customers.list();	
	 return list;
	}
	 
	 
	// Get all Customers with Equal to Age 	
	public List<Customer> getCustomerByEqualToAge(int age){
	 Session session = sessionFactory.openSession();
	 Query<Customer> customers = session.createQuery("from Customer c where c.age=:age", Customer.class);
	 customers.setParameter("age", age);
	 List<Customer> list = customers.list();
	 return list;
	}  
	
	
	// Get all Customers with his email 	
	    public List<Customer> getCustomerByEmail( String email ){
		Session session = sessionFactory.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.email=:email",Customer.class);
	    customers.setParameter("email", email);
	    List<Customer> list = customers.list();
	    return list;
	    }

	    
	 // Get all Customers with his mobileNumber
	public List<Customer> getCustomerByMobileNumber(String mobileNumber){
	Session session = sessionFactory.openSession();
    Query<Customer> customers = session.createQuery("from Customer c where c.mobileNumber=:mobileNumber",Customer.class);		
    customers.setParameter("mobileNumber", mobileNumber);
    List<Customer> list = customers.list();
    return list; 
	}
	
	
	//update customer first Name with help of ID
	public String updateCustomerFirstName(int id, String firstName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customers = session.get(Customer.class, id);
		customers.setFirstName(firstName);
		transaction.commit();
		session.close();
		return "Customer first Name Updated Successfully ....!!";
	}
	
	
	
	//update customer Last Name with help of ID
	public String updateCustomerLastName(int id, String lastName){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customers = session.get(Customer.class, id);
		customers.setLastName(lastName);
		transaction.commit();
		session.close();
		return "Customer Last Name Updated Successfuly....!!";
	}
	
	
	
	//update customer Email with help of ID
	public String updateCustomerEmail(int id, String email) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customers = session.get(Customer.class, id);
		customers.setEmail(email);
		transaction.commit();
		session.close();
		return "Customer Email Successfully.......!!!";
	}
	
	
	//update customer Email with help of ID
	public String updateCustomerMobileNumber(int id, String mobileNumber) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customers = session.get(Customer.class, id);
		customers.setMobileNumber(mobileNumber);
		transaction.commit();
		session.close();
		return "update Customer Email Successfully ..... !!!";
	}

	
	//update customer Age with help of ID
	public String updateCustomerAge(int id, int age ){
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();	
	Customer customers = session.get(Customer.class, id);
	customers.setAge(age);
	transaction.commit();
	session.close();
	return"Customer Age updated Successfully ...... !!";
	}
	
	
	
	//get all customer First Name 
	public List<Customer> getCustomersFirstName(){
	Session session = sessionFactory.openSession();
	Query<Customer> customers = session.createQuery("select c.firstName from Customer c",Customer.class);
	List<Customer> list = customers.list();
	return list;
	}

	
	
	//get all customer Last Name 
	public List<Customer> getCustomersLastName(){
    Session session = sessionFactory.openSession();
	Query<Customer> customers = session.createQuery("select c.lastName from Customer c", Customer.class);
	List<Customer> list = customers.list();	
	return list;
	}
		
	//get all customer Email
	public List<Customer> getAllCustomersEmail(){
	Session	session = sessionFactory.openSession();
	Query<Customer> customers = session.createQuery("select c.email from Customer c",Customer.class);
	List<Customer> list = customers.list();
	return list;
	}

	
	//get all customer mobile Number
	public List<Customer> getAllCustomerMobileNumber(){
	Session session = sessionFactory.openSession();
	Query<Customer> customers = session.createQuery("select c.mobileNumber from Customer c",Customer.class);
	List<Customer> list = customers.list();
	return list;
	}
	
	
}
	
	
	

