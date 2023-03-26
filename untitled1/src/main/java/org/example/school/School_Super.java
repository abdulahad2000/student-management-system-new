package org.example.school;

import java.util.Date;

public class School_Super {
    private int school_id;
    private String name , image , office_address;
    private int teacher_id ,student_id;

    private Date date_of_created;


    private int economy_id;

    public School_Super(int school_id, String name, String image, String office_address, int teacher_id, int student_id, Date date_of_created) {
        this.school_id = school_id;
        this.name = name;
        this.image = image;
        this.office_address = office_address;
        this.teacher_id = teacher_id;
        this.student_id = student_id;
        this.date_of_created = date_of_created;
    }



    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOffice_address() {
        return office_address;
    }

    public void setOffice_address(String office_address) {
        this.office_address = office_address;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }


    public Date getDate_of_created() {
        return date_of_created;
    }

    public void setDate_of_created(Date date_of_created) {
        this.date_of_created = date_of_created;
    }

    @Override
    public String toString() {
        return "School_Super{" +
                "school_id=" + school_id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", office_address='" + office_address + '\'' +
                ", teacher_id=" + teacher_id +
                ", student_id=" + student_id +
                ", date_of_created=" + date_of_created +
                '}';
    }

}
