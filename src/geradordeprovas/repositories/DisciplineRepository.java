package geradordeprovas.repositories;

import geradordeprovas.models.Discipline;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class DisciplineRepository extends Repository{
    public void save(Discipline discipline){
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            Serializable result = this.session.save(discipline);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Disciplina criada com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }   
        finally{
            this.session.close();
        }
    }
    
    public void delete(Discipline discipline){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            this.session.delete(discipline);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Discipline removida com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
    }
    
    public void update(Discipline discipline){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            this.session.merge(discipline);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
    }
    
    public Discipline find(int id){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Discipline> result;
        Discipline discipline = null;
        try {
            Criteria consult = this.session.createCriteria(Discipline.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if(result.size()>0){
                discipline = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
        
        return discipline;
    }
    public List<Discipline> all(){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Discipline> result = null;
        try {
            result = this.session.createCriteria(Discipline.class).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
        
        return result;
    }
    
}
