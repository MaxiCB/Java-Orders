package com.aaroncb.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name="orderspayments")
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderpaymentid;
    @OneToOne
    @JoinColumn(name = "ordernum")
    private Order order;
    @OneToOne
    @JoinColumn(name = "paymentid")
    private Payments payment;

    public OrderPayment() {}

    public OrderPayment(Order order,
                        Payments payment)
    {
        this.order = order;
        this.payment = payment;
    }

    public long getOrderpaymentid() {
        return orderpaymentid;
    }

    public void setOrderpaymentid(long orderpaymentid) {
        this.orderpaymentid = orderpaymentid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderPayment{" +
                "orderpaymentid=" + orderpaymentid +
                ", order=" + order +
                ", payment=" + payment +
                '}';
    }
}
