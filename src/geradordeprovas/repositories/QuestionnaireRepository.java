
package geradordeprovas.repositories;

import geradordeprovas.models.Questionnaire;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class QuestionnaireRepository extends Repository{
     public void save(Questionnaire questionnaire) {
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            Serializable result = this.session.save(questionnaire);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Prova criada com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void delete(Questionnaire questionnaire) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.delete(questionnaire);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Prova  removida com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void update(Questionnaire questionnaire) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.merge(questionnaire);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Prova atualizada com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public Questionnaire find(int id) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Questionnaire> result;
       Questionnaire questionnaire = null;
        try {
            Criteria consult = this.session.createCriteria(Questionnaire.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if (result.size() > 0) {
                questionnaire = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return questionnaire;
    }

    public List<Questionnaire> all() {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<Questionnaire> result = null;
        try {
            result = this.session.createCriteria(Questionnaire.class).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return result;
    }
}
