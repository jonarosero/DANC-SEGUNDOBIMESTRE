package tec.utpl.sotre.servicecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.sotre.servicecustomer.entity.Customer;
import tec.utpl.sotre.servicecustomer.entity.Region;
import tec.utpl.sotre.servicecustomer.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listAllCustomers(@RequestParam(name = "region", required = false) Long regionId){
        List<Customer> customers = new ArrayList<>();
        if (regionId == null){
            customers = customerService.findCustomerAll();

            if(customers.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }

        Region region = new Region();
        region.setId(regionId);
        customers = customerService.findCustomersByRegion(region);

        if(customers.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customers);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.getCustomer(id);

        if(null == customer){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerCreated = customerService.createCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreated);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer customerDB = customerService.getCustomer(id);

        if(null==customerDB){
            return ResponseEntity.notFound().build();
        }

        customer.setId(id);

        customerDB = customerService.updateCustomer(customer);

        return ResponseEntity.ok(customerDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        Customer customerDB = customerService.getCustomer(id);

        if(null==customerDB){
            return ResponseEntity.notFound().build();
        }

        customerDB = customerService.deleteCustomer(id);

        return ResponseEntity.ok("Cliente eliminado");
    }

}
