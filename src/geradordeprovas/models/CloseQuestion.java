/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovas.models;

import geradordeprovas.repositories.Repository;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "close_questions")
public class CloseQuestion implements Serializable{
    
    @Id @GeneratedValue
    private int id;
    
    @Column(name = "statement", length = 600)
    private String statement;
    
    @Column(name = "comment", length = 255)
    private String comment;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "close_question")
    private List<Alternative> alternatives;
    
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;
    
    public CloseQuestion() {
    }

    public CloseQuestion(String statement, String comment, List<Alternative> alternatives) {
        this.statement = statement;
        this.comment = comment;
        this.alternatives = alternatives;
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

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    
    @Override
    public String toString() {
        return "CloseQuestion{" + "id=" + id + ", statement=" + statement + ", comment=" + comment + ", alternatives=" + alternatives + '}';
    }
    
    
}
