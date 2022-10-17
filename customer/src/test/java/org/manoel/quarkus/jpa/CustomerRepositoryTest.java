package org.manoel.quarkus.jpa;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerRepositoryTest {
    @Inject CustomerRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomer() {
        Customer customer = new Customer("name", "last name", "email");
        repository.persist(customer);
        assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("last name", customer.getLastName());

    }
}
