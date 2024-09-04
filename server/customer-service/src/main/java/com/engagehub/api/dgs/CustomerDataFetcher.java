package com.engagehub.api.dgs;

import com.engagehub.api.model.Customer;
import com.engagehub.api.repository.CustomerRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class CustomerDataFetcher {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDataFetcher(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @DgsQuery
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @DgsQuery
    public Optional<Customer> customer(@InputArgument Long id) {
        return customerRepository.findById(id);
    }

    @DgsMutation
    public Customer addCustomer(@InputArgument String name, @InputArgument String email, @InputArgument String phoneNumber) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        return customerRepository.save(customer);
    }

    @DgsMutation
    public Customer updateCustomer(@InputArgument Long id, @InputArgument String name, @InputArgument String email, @InputArgument String phoneNumber) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhoneNumber(phoneNumber);
            return customerRepository.save(customer);
        }
        throw new RuntimeException("Customer not found");
    }

    @DgsMutation
    public boolean deleteCustomer(@InputArgument Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            customerRepository.delete(existingCustomer.get());
            return true;
        }
        return false;
    }
}
