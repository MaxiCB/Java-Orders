package com.aaroncb.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long paymentid;
    @Column(nullable = false)
    private String type;

    public Payments() {}

    public Payments(String type){
        this.type = type;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentid=" + paymentid +
                ", type='" + type + '\'' +
                '}';
    }
}
