package geradordeprovas.repositories;

import geradordeprovas.models.CloseQuestion;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class CloseQuestionRepository extends Repository{
     public void save(CloseQuestion close_question) {
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            Serializable result = this.session.save(close_question);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Questão fechada criada com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void delete(CloseQuestion close_question) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.delete(close_question);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Questão fechada  removida com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void update(CloseQuestion close_question) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.merge(close_question);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Questão fechada atualizada com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public CloseQuestion find(int id) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<CloseQuestion> result;
       CloseQuestion close_question = null;
        try {
            Criteria consult = this.session.createCriteria(CloseQuestion.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if (result.size() > 0) {
                close_question = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return close_question;
    }

    public List<CloseQuestion> all() {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<CloseQuestion> result = null;
        try {
            result = this.session.createCriteria(CloseQuestion.class).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return result;
    }
}
