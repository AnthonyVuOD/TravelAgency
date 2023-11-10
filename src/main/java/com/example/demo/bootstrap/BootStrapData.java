package com.example.demo.bootstrap;

import com.example.demo.dao.CountryRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.aspectj.runtime.internal.Conversions.longValue;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData (CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer customer1 = new Customer();
        customer1.setFirstName("Tony");
        customer1.setLastName("Vu");
        customer1.setPhone("(123) 123-1234");
        customer1.setAddress("123 Fake St, FL");
        customer1.setPostal_code("94502");
        //customer1.setDivision(4);

        Customer customer2 = new Customer();
        customer2.setFirstName("Mike");
        customer2.setLastName("Vu");
        customer2.setPhone("(123) 123-1235");
        customer2.setAddress("124 Fake St, FL");
        customer2.setPostal_code("94502");
        //customer2.setDivision(California);


        Customer customer3 = new Customer();
        customer3.setFirstName("Jen");
        customer3.setLastName("Vu");
        customer3.setPhone("(123) 123-1236");
        customer3.setAddress("125 Fake St, FL");
        customer3.setPostal_code("94502");
        //customer3.setDivision(4);


        Customer customer4 = new Customer();
        customer4.setFirstName("Ava");
        customer4.setLastName("Patterson");
        customer4.setPhone("(123) 123-1238");
        customer4.setAddress("127 Fake St, FL");
        customer4.setPostal_code("94502");
        //customer4.setDivision(10);


        Customer customer5 = new Customer();
        customer5.setFirstName("Jet");
        customer5.setLastName("Patterson");
        customer5.setPhone("(123) 123-1239");
        customer5.setAddress("129 Fake St, FL");
        customer5.setPostal_code("94502");
        //customer5.setDivision(11);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);


    }
}
