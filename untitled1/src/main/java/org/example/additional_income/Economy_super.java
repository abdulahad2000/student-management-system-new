package org.example.additional_income;

import java.sql.Date;

public class Economy_super {
    private int  additional_income_id;
    private String name;
    private double additional_income ;
    private Date date_of_registration;


    public Economy_super(int additional_income_id, String name, double additional_income, Date date_of_registration) {
        this.additional_income_id = additional_income_id;
        this.name = name;
        this.additional_income = additional_income;
        this.date_of_registration = date_of_registration;
    }


    public int getAdditional_income_id() {
        return additional_income_id;
    }

    public void setAdditional_income_id(int additional_income_id) {
        this.additional_income_id = additional_income_id;
    }

    public double getAdditional_income() {
        return additional_income;
    }

    public void setAdditional_income(double additional_income) {
        this.additional_income = additional_income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Date getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(Date date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    @Override
    public String toString() {
        return "Economy_super{" +
                "additional_income_id=" + additional_income_id +
                ", name='" + name + '\'' +
                ", additional_income=" + additional_income +
                ", date_of_registration=" + date_of_registration +
                '}';
    }
}
