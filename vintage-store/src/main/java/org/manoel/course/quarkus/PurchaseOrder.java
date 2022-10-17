package org.manoel.course.quarkus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.manoel.quarkus.jpa.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_purchase_order")
public class PurchaseOrder  extends PanacheEntity {

    public LocalDate date;

    @JoinColumn(name = "customer_fk")
    @ManyToOne
    public Customer customer;

    @OneToMany(mappedBy = "purchaseOrder",
    cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public List<OrderLine> orderLine;

}
