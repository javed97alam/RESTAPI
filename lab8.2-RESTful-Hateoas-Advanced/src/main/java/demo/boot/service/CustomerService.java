package demo.boot.service;

import java.util.List;

import demo.boot.model.Customer;


public interface CustomerService {

    List<Customer> allCustomers();

    Customer getCustomerDetail(final String id);

}