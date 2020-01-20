package com.aaroncb.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long ordernum;
    private double orderamount;
    private double advanceamount;
    private long customer;
    @ManyToOne
    @JoinColumn(name = "custcode")
    private Customer cust;

    private String orderdescription;

    public Order() {}

    public Order(double ordamount,
                 double advanceamount,
                 long customer,
                 Customer cust,
                 String orderdescription
                ){
        this.orderamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = cust.getCustomerID();
        this.cust = cust;
        this.orderdescription = orderdescription;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    public double getOrdamount() {
        return orderamount;
    }

    public void setOrdamount(double ordamount) {
        this.orderamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Customer getCustomer() {
        return cust;
    }

    public void setCustomer(Customer cust) {
        this.cust = cust;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordernum=" + ordernum +
                ", ordamount=" + orderamount +
                ", advanceamount=" + advanceamount +
                ", customer=" + cust +
                ", orderdescription='" + orderdescription + '\'' +
                '}';
    }
}
