package geradordeprovas.models;

import geradordeprovas.repositories.Repository;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;

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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
    private List<OpenQuestion> open_questions;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
    private List<CloseQuestion> close_questions;

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

    public List<OpenQuestion> getOpen_questions() {
        return open_questions;
    }

    public void setOpen_questions(List<OpenQuestion> open_questions) {
        this.open_questions = open_questions;
    }

    public List<CloseQuestion> getClose_questions() {
        return close_questions;
    }

    public void setClose_questions(List<CloseQuestion> close_questions) {
        this.close_questions = close_questions;
    }

    @Override
    public String toString() {
        return "Questionnaire{" + "id=" + id + ", title=" + title + ", created_at=" + created_at + ", open_questions=" + open_questions + ", close_questions=" + close_questions + '}';
    }
    
    
    
    
    
}
