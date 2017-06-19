package geradordeprovas.repositories;

import geradordeprovas.models.Course;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class CourseRepository extends Repository{
    
    public void save(Course course){
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            Serializable result = this.session.save(course);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Curso criado com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro ", JOptionPane.WARNING_MESSAGE);
        }   
        finally{
            this.session.close();
        }
    }
    
    public void delete(Course course){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            this.session.delete(course);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Curso removido com sucesso", "Sucesso no Remover ", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro na remoção ", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
    }
    
    public void update(Course course){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            this.session.merge(course);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Curso atualizada com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro na atualização ", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
    }
    
    public Course find(int id){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Course> result;
        Course course = null;
        try {
            Criteria consult = this.session.createCriteria(Course.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if(result.size()>0){
                course = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro na busca", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
        
        return course;
    }
    public List<Course> all(){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Course> result = null;
        try {
            result = this.session.createCriteria(Course.class).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro na busca", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
        
        return result;
    }
    
}
