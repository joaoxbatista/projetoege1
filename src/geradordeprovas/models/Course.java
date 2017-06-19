/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovas.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    
    @Id @GeneratedValue
    private int id;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @Column(name = "description", length = 600)
    private String description;
    
    @Column(name = "area", length = 255)
    private String area;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<UniversityClass> univerty_classes; 
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "courses_disciplines",
        joinColumns = @JoinColumn(
            name = "course_id"    
        ),
        inverseJoinColumns = @JoinColumn(
            name = "discipline_id"
        )
    )
    private List<Discipline> disciplines;

    public void addDiscipline(Discipline discipline){
        this.disciplines.add(discipline);
    }
    public Course(String name, String description, String area) {
        this.name = name;
        this.description = description;
        this.area = area;
        this.disciplines = new ArrayList<Discipline>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<UniversityClass> getUniverty_classes() {
        return univerty_classes;
    }

    public void setUniverty_classes(List<UniversityClass> univerty_classes) {
        this.univerty_classes = univerty_classes;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", description=" + description + ", area=" + area + ", univerty_classes=" + univerty_classes + ", disciplines=" + disciplines + '}';
    }
    
    
    
    
}
