package org.manoel.course.quarkus.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.manoel.quarkus.jpa.Customer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
}
