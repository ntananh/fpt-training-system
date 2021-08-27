/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fts.entities;

import java.sql.Date;

/**
 *
 * @author Tan Anh
 */
public class Course {

    private int id;
    private String name;
    private String thumbnail;
    private Date start_date;
    private Date end_date;
    private Date created_date;
    private String content;
    private String description;
    private String enroll_code;
    private int cate_id;
    private int topic_id;

    public Course() {
    }

    public Course(int id, int cate_id, int topic_id, String name, Date start_date, Date end_date, Date created_date, String description) {
        this.id = id;
        this.cate_id = cate_id;
        this.topic_id = topic_id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_date = created_date;
        this.description = description;
    }

    public Course(int id, int cate_id, int topic_id, String name, String thumbnail, Date start_date, Date end_date, Date created_date, String content, String description, String enroll_code) {
        this.id = id;
        this.cate_id = cate_id;
        this.topic_id = topic_id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_date = created_date;
        this.content = content;
        this.description = description;
        this.enroll_code = enroll_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnroll_code() {
        return enroll_code;
    }

    public void setEnroll_code(String enroll_code) {
        this.enroll_code = enroll_code;
    }

}
