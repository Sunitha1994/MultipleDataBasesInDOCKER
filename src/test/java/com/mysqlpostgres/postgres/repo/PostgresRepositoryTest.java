package com.mysqlpostgres.postgres.repo;

import com.mysqlpostgres.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostgresRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PostgresRepository postgresRepository;


    @Test
    public void when_gstNumberThenReturnCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("s");
        customer.setType("OTHER");
        customer.setGstNumber("938493HJKIL");
        entityManager.persist(customer);

        Customer found = postgresRepository.findByGstNumber(customer.getGstNumber());

        assertThat(found.getGstNumber(), is(customer.getGstNumber()));
    }

        @Test
        public  void testCustomerSave(){
            Customer customer = new Customer();
            customer.setFirstName("s");
            customer.setType("OTHER");
            customer.setGstNumber("738238JFK344");

            Customer entity = entityManager.persist(customer);
            Customer  from = postgresRepository.getOne(entity.getId());

            assertThat(from ,is(equalTo(entity)));
        }

    }



