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
@Table(name = "close_questions")
public class CloseQuestion extends Repository implements Serializable{
    
    @Id @GeneratedValue
    private int id;
    
    @Column(name = "statement", length = 600)
    private String statement;
    
    @Column(name = "comment", length = 255)
    private String comment;

    public CloseQuestion() {
    }

    public CloseQuestion(String statement, String comment) {
        this.statement = statement;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CloseQuestion{" + "id=" + id + ", statement=" + statement + ", comment=" + comment + '}';
    }
    
    
}
