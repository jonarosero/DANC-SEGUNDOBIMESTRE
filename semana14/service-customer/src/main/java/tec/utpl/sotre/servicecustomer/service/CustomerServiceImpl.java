package tec.utpl.sotre.servicecustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.sotre.servicecustomer.entity.Customer;
import tec.utpl.sotre.servicecustomer.entity.Region;
import tec.utpl.sotre.servicecustomer.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomersByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDB = customerRepository.findById(customer.getId()).orElse(null);

        if(customerDB !=null){
            return customerDB;
        }

        customer.setState("CREATED");
        customerDB = customerRepository.save(customer);

        return customerDB;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = customerRepository.findById(customer.getId()).orElse(null);

        if(customerDB ==null){
            return null;
        }

        customerDB.setFirstName(customer.getFirstName());
        customerDB.setLastName(customer.getLastName());
        customerDB.setEmail(customer.getEmail());
        customerDB.setPhotoUrl(customer.getPhotoUrl());

        return customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDB = customerRepository.findById(id).orElse(null);

        if(customerDB==null){
            return null;
        }

        customerRepository.delete(customerDB);

        return customerDB;
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
