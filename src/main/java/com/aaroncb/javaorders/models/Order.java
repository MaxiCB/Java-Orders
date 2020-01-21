package com.aaroncb.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordernum;

    private double orderamount;
    private double advanceamount;
    private String orderdescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnore
    private Customer customer;

    public Order() {}

    public Order(double ordamount,
                 double advanceamount,
                 Customer customer,
                 String orderdescription
                ){
        this.orderamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
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
        return customer;
    }

    public void setCustomer(Customer cust) {
        this.customer = cust;
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
                ", customer=" + customer +
                ", orderdescription='" + orderdescription + '\'' +
                '}';
    }
}
