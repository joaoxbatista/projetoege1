/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovas.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "university_classes")
public class UniversityClass implements Serializable{
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "code", length = 10)
    private String code;
    
    @Column(name = "year")
    private int year;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    public UniversityClass(){}

    public UniversityClass(String code, int year) {
        this.code = code;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "UniversityClass{" + "id=" + id + ", code=" + code + ", year=" + year + '}';
    }
    
    
    
}
