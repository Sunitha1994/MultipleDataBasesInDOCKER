package com.mysqlpostgres.service;

import com.mysqlpostgres.domain.Customer;
import com.mysqlpostgres.mysql.repo.MysqlRepository;
import com.mysqlpostgres.postgres.repo.PostgresRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private PostgresRepository postgresRepository;

    @MockBean
    private MysqlRepository mysqlRepository;

    @Test
    public void testCustomer() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("s");
        customer.setType("OTHER");
        customer.setGstNumber("672HGSTDKJ5434");

        if(customer.getType().equals("Corpo")){
            Mockito.when(mysqlRepository.save(customer)).thenReturn(customer);
        }else{
            Mockito.when(postgresRepository.save(customer)).thenReturn(customer);
        }
        assertThat(customerService.saveDetails(customer), is(equalTo(customer)));
    }

    @Test
    public void testGetCustomer() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("s");
        customer.setType("OTHER");
        customer.setGstNumber("672HGSTDKJ5434");

        if(customer.getType().equals("Corpo")){
            Mockito.when(mysqlRepository.findByGstNumber(customer.getGstNumber())).thenReturn(customer);
        }else{
            Mockito.when(postgresRepository.findByGstNumber(customer.getGstNumber())).thenReturn(customer);
        }
        assertThat(customerService.getDetails(customer.getGstNumber()), is(equalTo(customer)));
    }
}