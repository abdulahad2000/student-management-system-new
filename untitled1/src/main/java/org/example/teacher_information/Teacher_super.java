package org.example.teacher_information;

import java.util.Date;

public class Teacher_super {
    private  int id;
    private  String first_name;
    private  String last_name;
    private  String birth_date;
    private  boolean gender;
    private  String TC_address;
    private  String phone_number;
    private  String email_address;
    private  String home_address;
    private  double salary;

    private Date date_of_registration;

    public Teacher_super() {
    }

    public Teacher_super(int id, String first_name, String last_name, String birth_date, boolean gender, String TC_address, String phone_number, String email_address, String home_address, double salary, Date date_of_registration) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.TC_address = TC_address;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.home_address = home_address;
        this.salary = salary;
        this.date_of_registration = date_of_registration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getTC_address() {
        return TC_address;
    }

    public void setTC_address(String TC_address) {
        this.TC_address = TC_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(Date date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    @Override
    public String toString() {
        return "Teacher_super{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", gender=" + gender +
                ", TC_address='" + TC_address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email_address='" + email_address + '\'' +
                ", home_address='" + home_address + '\'' +
                ", salary=" + salary +
                ", date_of_registration=" + date_of_registration +
                '}';
    }
}
