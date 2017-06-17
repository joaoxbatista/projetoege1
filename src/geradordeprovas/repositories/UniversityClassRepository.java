package geradordeprovas.repositories;

import geradordeprovas.models.UniversityClass;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class UniversityClassRepository extends Repository{
    
    public void save(UniversityClass university_class){
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            Serializable result = this.session.save(university_class);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }   
        finally{
            this.session.close();
        }
    }
    
    public void delete(UniversityClass university_class){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            this.session.delete(university_class);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Turma removida com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
    }
    
    public void update(UniversityClass university_class){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            this.session.merge(university_class);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
    }
    
    public UniversityClass find(int id){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<UniversityClass> result;
        UniversityClass uc = null;
        try {
            Criteria consult = this.session.createCriteria(UniversityClass.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if(result.size()>0){
                uc = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n"+e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        }
        finally{
            this.session.close();
        }
        
        return uc;
    }
    public List<UniversityClass> all(){
        
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<UniversityClass> result = null;
        try {
            result = this.session.createCriteria(UniversityClass.class).list();
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
