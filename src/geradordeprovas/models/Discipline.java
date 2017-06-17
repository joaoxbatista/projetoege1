
package geradordeprovas.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplines")
public class Discipline implements Serializable {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "title", length = 50)
    private String title;
    
    @Column(name = "description", length = 255)
    private String description;
    
    public Discipline(){}

    public Discipline(String title, String description) {
        this.title = title;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Discipline{" + "id=" + id + ", title=" + title + ", description=" + description + '}';
    }
    
    
    
}
