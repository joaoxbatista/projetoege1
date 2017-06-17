/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovas.models;

import geradordeprovas.repositories.Repository;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author João Batista
 */
@Entity
@Table(name = "open_questions")
public class OpenQuestion extends Repository implements Serializable{
    
    @Id @GeneratedValue
    private int id;
    
    @Column(name = "statement", length = 600)
    private String statement;
    
    @Column(name = "comment", length = 255)
    private String comment;
    
    @Column(name = "answare_guide", length = 600)
    private String answare_guide;
    
    public OpenQuestion(){}

    public OpenQuestion(String statement, String comment, String answare_guide) {
        this.statement = statement;
        this.comment = comment;
        this.answare_guide = answare_guide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getAnsware_guide() {
        return answare_guide;
    }

    public void setAnsware_guide(String answare_guide) {
        this.answare_guide = answare_guide;
    }

    @Override
    public String toString() {
        return "OpenQuestion{" + "id=" + id + ", statement=" + statement + ", comment=" + comment + ", answare_guide=" + answare_guide + '}';
    }
    
    
    
}