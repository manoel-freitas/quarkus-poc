package org.manoel.course.quarkus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_line")
public class OrderLine extends PanacheEntity {

    public Integer quantity;

    @JoinColumn(name = "purchase_order_fk")
    @ManyToOne
    public PurchaseOrder purchaseOrder;
}
