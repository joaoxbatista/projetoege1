package geradordeprovas.repositories;

import geradordeprovas.models.Alternative;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class AlternativeRepository extends Repository {

    public void save(Alternative alternative) {
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            Serializable result = this.session.save(alternative);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Alternativa criada com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void delete(Alternative alternative) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.delete(alternative);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Alternativa removida com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void update(Alternative alternative) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.merge(alternative);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Alternativa atualizada com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public Alternative find(int id) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Alternative> result;
       Alternative alternative = null;
        try {
            Criteria consult = this.session.createCriteria(Alternative.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if (result.size() > 0) {
                alternative = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return alternative;
    }

    public List<Alternative> all() {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Alternative> result = null;
        try {
            result = this.session.createCriteria(Alternative.class).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return result;
    }

}
