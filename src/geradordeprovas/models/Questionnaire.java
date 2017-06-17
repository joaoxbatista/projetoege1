/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovas.models;

import geradordeprovas.repositories.Repository;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author João Batista
 */
@Entity
@Table(name = "questionnaires")
public class Questionnaire extends Repository implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "created_at")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created_at;

    public Questionnaire() {
    }

    public Questionnaire(String title, Date created_at) {
        this.title = title;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Questionnaire{" + "id=" + id + ", title=" + title + ", created_at=" + created_at + '}';
    }
    
    
}
