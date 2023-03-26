package org.example.expanses;

import java.util.Date;

public class Expans_super {
   private int expenses_id ;
   private String name ;
   private double expenses ;
   private Date date_of_registration ;

    public Expans_super() {
    }

    public Expans_super(int expenses_id, String name, double expenses, Date date_of_registration) {
        this.expenses_id = expenses_id;
        this.name = name;
        this.expenses = expenses;
        this.date_of_registration = date_of_registration;
    }

    public int getExpenses_id() {
        return expenses_id;
    }

    public void setExpenses_id(int expenses_id) {
        this.expenses_id = expenses_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public Date getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(Date date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    @Override
    public String toString() {
        return "Expans_super{" +
                "expenses_id=" + expenses_id +
                ", name='" + name + '\'' +
                ", expenses=" + expenses +
                ", date_of_registration=" + date_of_registration +
                '}';
    }
}
