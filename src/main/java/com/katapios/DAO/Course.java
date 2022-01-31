package com.katapios.DAO;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name="courses")
public class Course implements Serializable {
    private int id;
    private String title;
    private int length;
    private String description;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column (name = "title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Column (name = "length")
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    @Column (name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public String toString() {
//        return String.format("%-3d %-50s %4d",
//                getId(), getTitle(), getLength());
//    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", description='" + description + '\'' +
                '}';
    }

}
