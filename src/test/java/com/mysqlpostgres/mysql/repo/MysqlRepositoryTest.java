package com.mysqlpostgres.mysql.repo;

import com.mysqlpostgres.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MysqlRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MysqlRepository mysqlRepository;

    @Test
    public void when_gstNumberThenReturnCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("s");
        customer.setType("OTHER");
        customer.setGstNumber("938493HUJIK");
        entityManager.persist(customer);

        Customer found = mysqlRepository.findByGstNumber(customer.getGstNumber());

        assertThat(found.getGstNumber(), is(customer.getGstNumber()));
    }

    @Test
    public  void testCustomerSave(){
        Customer customer = new Customer();
        customer.setFirstName("s");
        customer.setType("Corpo");
        customer.setGstNumber("738238JFK344");

        Customer entity = entityManager.persist(customer);
        Customer  from = mysqlRepository.getOne(entity.getId());

        assertThat(from ,is(equalTo(entity)));
    }
}
