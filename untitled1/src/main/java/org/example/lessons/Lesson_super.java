package org.example.lessons;

import java.sql.Time;
import java.util.Date;

public class Lesson_super {
    private int id ;
    private String name;
    private int teacher_id;
    private Time start_time;
    private Time end_time;

    public Lesson_super() {
    }

    public Lesson_super(int id, String name, int teacher_id, Time start_time, Time end_time) {
        this.id = id;
        this.name = name;
        this.teacher_id = teacher_id;
        this.start_time =  start_time;
        this.end_time =  end_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time =  start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time =  end_time;
    }

    @Override
    public String toString() {
        return "Lesson_super{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher_id=" + teacher_id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
