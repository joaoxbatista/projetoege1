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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author João Batista
 */
@Entity
@Table(name = "alternatives")
public class Alternative extends Repository implements Serializable{
    
    @Id @GeneratedValue
    private int id;
    
    @Column(name = "statement", length = 600)
    private String statement;

    @ManyToOne
    @JoinColumn(name = "close_question_id")
    private CloseQuestion close_question;
    
    public Alternative() {
    }

    public Alternative(String statement) {
        this.statement = statement;
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

    public CloseQuestion getClose_question() {
        return close_question;
    }

    public void setClose_question(CloseQuestion close_question) {
        this.close_question = close_question;
    }

    @Override
    public String toString() {
        return "Alternative{" + "id=" + id + ", statement=" + statement + ", close_question=" + close_question + '}';
    }
   
    
}