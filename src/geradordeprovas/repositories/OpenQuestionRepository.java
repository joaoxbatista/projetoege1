package geradordeprovas.repositories;

import geradordeprovas.models.OpenQuestion;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class OpenQuestionRepository extends Repository{
     public void save(OpenQuestion open_question) {
        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            Serializable result = this.session.save(open_question);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Questão aberta criada com sucesso", "Sucesso no Registro", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void delete(OpenQuestion open_question) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.delete(open_question);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Questão aberta  removida com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public void update(OpenQuestion open_question) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            this.session.merge(open_question);
            this.transaction.commit();
            JOptionPane.showMessageDialog(null, "Questão aberta atualizada com sucesso", "Sucesso no Remover", JOptionPane.PLAIN_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }
    }

    public OpenQuestion find(int id) {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<OpenQuestion> result;
       OpenQuestion open_question = null;
        try {
            Criteria consult = this.session.createCriteria(OpenQuestion.class);
            consult.setFirstResult(0);
            consult.setMaxResults(1);
            result = consult.add(Restrictions.eq("id", id)).list();
            if (result.size() > 0) {
                open_question = result.get(0);
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return open_question;
    }

    public List<OpenQuestion> all() {

        this.session = this.factory.openSession();
        this.transaction = this.session.beginTransaction();
        List<OpenQuestion> result = null;
        try {
            result = this.session.createCriteria(OpenQuestion.class).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro encontrado\n" + e.getMessage(), "Erro no Registro", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.session.close();
        }

        return result;
    }
}
