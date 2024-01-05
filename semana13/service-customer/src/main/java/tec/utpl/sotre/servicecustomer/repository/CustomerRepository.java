package tec.utpl.sotre.servicecustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.sotre.servicecustomer.entity.Customer;
import tec.utpl.sotre.servicecustomer.entity.Region;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    // public Customer findByNumberID(String numberId);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByRegion(Region region);
}
