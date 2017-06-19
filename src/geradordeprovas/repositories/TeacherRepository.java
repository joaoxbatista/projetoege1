package geradordeprovas.repositories;

import geradordeprovas.models.Teacher;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class TeacherRepository extends Repository {

    public void save(Teacher teacher) {
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            Serializable result = this.session.save(teacher);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Professor criado com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void delete(Teacher teacher) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.delete(teacher);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Professor removido com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Remover", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void update(Teacher teacher) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.merge(teacher);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso", "Sucesso na atualização", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro na atualização", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public Teacher find(int id) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Teacher> result;
       Teacher teacher = null;
        try {
            Criteria consult = this.session.createCriteria(Teacher.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if (result.size() > 0) {
                teacher = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro na busca", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return teacher;
    }

    public List<Teacher> all() {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Teacher> result = null;
        try {
            result = this.session.createCriteria(Teacher.class).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro na busca", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return result;
    }

}
