package com.aaroncb.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long custcode;
    @Column(nullable = false)
    private String custname;
    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double receiveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    @OneToOne
    @JoinColumn(name = "agentcode")
    private Agent agent;

    public Customer() {}

    public Customer(String custname,
                    String custCity,
                    String workingArea,
                    String custCountry,
                    String grade,
                    Double openAmt,
                    Double recAmt,
                    Double payAmt,
                    Double outAmt,
                    String phone,
                    Agent agent) {
        this.custname = custname;
        this.custcity = custCity;
        this.workingarea = workingArea;
        this.custcountry = custCountry;
        this.grade = grade;
        this.openingamt = openAmt;
        this.receiveamt = recAmt;
        this.paymentamt = payAmt;
        this.outstandingamt = outAmt;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCustomerID() {
        return custcode;
    }

    public void setCustomerID(long custcode) {
        this.custcode = custcode;
    }

    public String getCustName() {
        return custname;
    }

    public void setCustName(String custName) {
        this.custname = custName;
    }

    public String getCustCity() {
        return custcity;
    }

    public void setCustCity(String custCity) {
        this.custcity = custCity;
    }

    public String getWorkingArea() {
        return workingarea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingarea = workingArea;
    }

    public String getCustCountry() {
        return custcountry;
    }

    public void setCustCountry(String custCountry) {
        this.custcountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpenAmt() {
        return openingamt;
    }

    public void setOpenAmt(double openAmt) {
        this.openingamt = openAmt;
    }

    public double getRecAmt() {
        return receiveamt;
    }

    public void setRecAmt(double recAmt) {
        this.receiveamt = recAmt;
    }

    public double getPayAmt() {
        return paymentamt;
    }

    public void setPayAmt(double payAmt) {
        this.paymentamt = payAmt;
    }

    public double getOutAmt() {
        return outstandingamt;
    }

    public void setOutAmt(double outAmt) {
        this.outstandingamt = outAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgentDetails() {
        return this.agent;
    }

    public void setAgentDetails(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString()
    {
        return ", custcode=" + custcode + ", name=" + custname + ", city=" + custcity + ", working=" + workingarea + ", country=" + custcountry + ", grade=" + grade
                + ", open=" + openingamt + ", rec " + receiveamt + ", pay " + paymentamt + ", out " + outstandingamt + ", phone " + phone + "\n";
    }
}
