package com.cgi.insurance.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Insurance {

    @Id
    private int insuranceid;

    private String type;

    private List<Plan> plan;

    public int getInsuranceid() {
        return insuranceid;
    }

    public void setInsuranceid(int insuranceid) {
        this.insuranceid = insuranceid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Plan> getPlan() {
        return plan;
    }

    public void setPlan(List<Plan> plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "Insurance [insuranceid=" + insuranceid + ", type=" + type + ", plan=" + plan + "]";
    }

    public Insurance(int insuranceid, String type, List<Plan> plan) {
        super();
        this.insuranceid = insuranceid;
        this.type = type;
        this.plan = plan;
    }

    public Insurance() {
        super();
    }


}
