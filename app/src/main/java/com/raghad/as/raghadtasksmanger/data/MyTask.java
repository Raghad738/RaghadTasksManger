package com.raghad.as.raghadtasksmanger.data;

import java.util.Date;

/**
 * Created by user on 9/8/2016.
 */
public class MyTask
{
    /**
     * rakam almhma
     */
    private String id;
    /**
     * enwaan
     */
    private String title;
    private float prioroty;
    private Date when;
    private String address;
    private String phone;

    public MyTask(String id, int prioroty, String phone, String address, Date when, String title) {
        this.id = id;
        this.prioroty = prioroty;
        this.phone = phone;
        this.address = address;
        this.when = when;
        this.title = title;
    }

    public MyTask() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrioroty() {
        return prioroty;
    }

    public void setPrioroty(float prioroty) {
        this.prioroty = prioroty;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", prioroty=" + prioroty +
                ", when=" + when +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
