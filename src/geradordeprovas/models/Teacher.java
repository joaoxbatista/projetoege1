package geradordeprovas.models;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id @GeneratedValue
    private int id;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @Column(name = "email", length = 255)
    private String email;
    
    @Column(name = "password", length = 255)
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Questionnaire> questionnaires;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "disciplines_teachers",
        joinColumns = @JoinColumn(
            name = "teacher_id"    
        ),
        inverseJoinColumns = @JoinColumn(
            name = "discipline_id"
        )
    )
    private List<Discipline> disciplines;

    public Teacher(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.questionnaires = new ArrayList<Questionnaire>();
        this.disciplines = new ArrayList<Discipline>();
    }

    public void addQuestionnaire(Questionnaire questionnaire){
        this.questionnaires.add(questionnaire);
    }
    
    public void addDiscipline(Discipline discipline){
        this.disciplines.add(discipline);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", questionnaires=" + questionnaires + ", disciplines=" + disciplines + '}';
    }
    
    
    
}
