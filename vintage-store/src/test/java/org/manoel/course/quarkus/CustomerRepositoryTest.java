package org.manoel.course.quarkus;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.manoel.course.quarkus.repositories.ArtistRepository;
import org.manoel.course.quarkus.repositories.CustomerRepository;
import org.manoel.quarkus.jdbc.Artist;
import org.manoel.quarkus.jpa.Customer;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CustomerRepositoryTest {

    @Inject
    private CustomerRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAArtist() {
        Customer customer = new Customer("first name", "last name", "email@email.com");
        repository.persist(customer);
        assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("last name", customer.getLastName());
    }
}
