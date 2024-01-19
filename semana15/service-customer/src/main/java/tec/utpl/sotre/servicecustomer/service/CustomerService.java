package tec.utpl.sotre.servicecustomer.service;

import tec.utpl.sotre.servicecustomer.entity.Customer;
import tec.utpl.sotre.servicecustomer.entity.Region;

import java.util.List;

public interface CustomerService {
    public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByRegion(Region region);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer (Customer customer);
    public Customer deleteCustomer (Long id);
    public Customer getCustomer(Long id);
}
