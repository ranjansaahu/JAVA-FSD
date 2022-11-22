package com.cgi.insurance.model;


public class Plan {


    private String planid;
    private String planname;
    private int period;
    private int amount;

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Plan [planid=" + planid + ", planname=" + planname + ", period=" + period + ", amount=" + amount + "]";
    }

    public Plan(String planid, String planname, int period, int amount) {
        super();
        this.planid = planid;
        this.planname = planname;
        this.period = period;
        this.amount = amount;
    }

    public Plan() {
        super();
    }


}
