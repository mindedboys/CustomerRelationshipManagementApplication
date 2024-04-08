package com.CustomerRelationshipManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//http://localhost:8080/api/customers/insert
	/*{
		"firstName":"varsaa",
		"lastName":"yadav",
		"email":"varsha@gmail.com",
		"mobileNumber":"9248923210",
		"age":30
	}*/
	@PostMapping("/insert")   //insert customer details
	public String insertCustomer(@RequestBody Customer customer){
		
	String msg = customerService.insertCustomer(customer);
	
	return msg;
	}
	
	
	// http://localhost:8080/api/customers
	@GetMapping
	public List<Customer> getCustomerList(){ // get all customers details
	
	List<Customer> list	= customerService.getCustomerList();
	
	return list;
	}
	
	//http://localhost:8080/api/customers/1
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id){//get customer by id
	Customer customer = customerService.getCustomerById(id);
	return customer;
		
	}
	
	//http://localhost:8080/api/customers
	@PutMapping  //update customer details
	public String updateCustomer(@RequestBody Customer customer){
		
		return customerService.updateCustomer(customer);	  
	}
	
	//http://localhost:8080/api/customers/3 
	@DeleteMapping("/{id}")
	public String deleteCustomerById(@PathVariable int id){ // Customer delete by Id
		
		return customerService.deleteCustomerById(id);
	}

	
   	/* //Json array
	[
	  {
	    "firstName": "Abdul",
	    "lastName": "khan",
	    "age": 22,
	    "email": "abdul@gmail.com",
	    "mobileNumber": "9045923002"
	 },
	 {
	    "firstName": "Sohel",
	    "lastName": "Anasari",
	    "age": 27,
	    "email": "Sohel@gmail.com",
	    "mobileNumber": "9925923211"
	},
	{
	    "firstName": "Babita",
	    "lastName": "Fokat",
	    "age": 24,
	    "email": "babita@gmail.com",
	    "mobileNumber": "9714592345"
	}
	]*/
	//http://localhost:8080/api/customers
	@PostMapping             // Insert Multiple Customer
	public String insertMultipleCustomer(@RequestBody List<Customer> customers){
		
		return customerService.insertMultipleCustomer(customers);
	}
	
	
	// http://localhost:8080/api/customers/byname/abdul
     @GetMapping("/byname/{firstName}")  // Get Customer by First name
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName){
		return customerService.getCustomerByFirstName(firstName);
	}
     
     
     // http://localhost:8080/api/customers/bylastname/yadav
     @GetMapping("/bylastname/{lastName}") // Get Customer By LastName
    public List<Customer> getCustomerByLastName(@PathVariable String lastName){
    	return customerService.getCustomerByLastName(lastName);
    }
     
     
     // http://localhost:8080/api/customers/bylessthanage/40
    @GetMapping("/bylessthanage/{age}")  // Get all Customer By Less Than with Age
    public  List<Customer> getCustomerByLessthanAge(@PathVariable int age){
    	
    	return customerService.getCustomerByLessThanAge(age);
    }
    
    
    // http://localhost:8080/api/customers/bygreaterthanage/30
    @GetMapping("/bygreaterthanage/{age}")  // Get all Customer By Greater Than with Age
    public List<Customer> getCustomerByGreaterThanAge(@PathVariable int age){
    	
    	return customerService.getCustomerByGreaterThanAge(age);
    }
    
    
    // http://localhost:8080/api/customers/byequalage/35
    @GetMapping("/byequalage/{age}") // Get all Customer Equal to Age
    public List<Customer> getCustomerByEqualToAge(@PathVariable int age){
    return customerService.getCustomerByEqualToage(age);
    }
    
    
    // http://localhost:8080/api/customers/byemail/sohel@gmail.com
    @GetMapping("/byemail/{email}") // Get Customer By Email
    public List<Customer> getCustomerByEmail(@PathVariable String email){
    	return customerService.getCustomerByEmail(email);
    }
    
    
    // http://localhost:8080/api/customers/bymobile/9714592345
    @GetMapping("/bymobile/{mobileNumber}")  //Get Customer By Mobile Number
    public List<Customer> getCustomerByMobileNumber(@PathVariable String mobileNumber){
    	return customerService.getCustomerByMobileNumber(mobileNumber);
    }

    
    
    /*{
        "firstName": "Farah"
    }*/
    // http://localhost:8080/api/customers/7
    @PutMapping("/{id}")   // update Customer First Name with help of ID
    public String updateCustomerFirstName(@PathVariable int id, @RequestBody Map<String,String> request){
    String firstName = request.get("firstName");
    return customerService.updateCustomerFirstName(id, firstName);
    }
    
    
    /*
    {
        "lastName": "verma"
    }*/
    // http://localhost:8080/api/customers/lastname/1 
    @PutMapping("/lastname/{id}") // update Customer last Name with help of ID
    public String updateCustomerLastName(@PathVariable int id, @RequestBody Map<String, String> request){
    String lastName = request.get("lastName");    
    return	customerService.updateCustomerLastName(id, lastName);
    } 
    
    
    
    /*{
        "email": "farah@gmail.com"
    }*/
    // http://localhost:8080/api/customers/email/7
    @PutMapping("/email/{id}")  // update Customer Email with help of ID
    public String updateCustomerEmail(@PathVariable int id, @RequestBody Map<String, String> request){
    String email = request.get("email");
    return customerService.updateCustomerEmail(id, email);	
    }
    
    
    
    /*{
    	"mobileNumber":"9202557856"
    }*/
    // http://localhost:8080/api/customers/mobilenumber/9
    @PutMapping("/mobilenumber/{id}")  // update Customer mobile Number with help of ID
    public String updateCustomerMobileNumber(@PathVariable int id, @RequestBody Map<String, String> request){   	
    String mobileNumber = request.get("mobileNumber");
    return customerService.updateCustomerMobileNumber(id, mobileNumber);
    }
    
    
    
    /*{
    	"age":27
    }*/
    // http://localhost:8080/api/customers/age/2
    @PutMapping("/age/{id}") // update Customer Age with help of ID
    public String updateCustomerAge(@PathVariable int id,@RequestBody Map<String, Integer> request){
    Integer age	= request.get("age");
    return customerService.updateCustomerAge(id, age);
    }
    
    
    
    // http://localhost:8080/api/customers/firstnames
    @GetMapping("/firstnames") // Get First Name of all Customer
    public List<Customer> getCustomersFirstName(){
    return customerService.getCustomersFirstName();
    }
    
    
   //http://localhost:8080/api/customers/lastnames
    @GetMapping("/lastnames")
    public List<Customer> getCustomersLastName(){	
    List<Customer> list = customerService.getCustomersLastName();
    return list;
    }
   
    
   // http://localhost:8080/api/customers/allemail
   @GetMapping("/allemail")
   public List<Customer> getAllCustomerEmail(){
   List<Customer> list = customerService.getAllCustomersEmail();
   return list;    
   } 
    
   
   // http://localhost:8080/api/customers/allmobilenumber
   @GetMapping("/allmobilenumber")
   public List<Customer> getAllCustomerMobileNumber(){ 
   List<Customer> list = customerService.getAllCustomerMobileNumber();
   return list;
   }
   
}
