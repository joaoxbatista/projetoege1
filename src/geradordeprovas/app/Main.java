package geradordeprovas.app;

import geradordeprovas.models.Alternative;
import geradordeprovas.models.Discipline;
import geradordeprovas.models.UniversityClass;
import geradordeprovas.repositories.AlternativeRepository;
import geradordeprovas.repositories.DisciplineRepository;
import geradordeprovas.repositories.UniversityClassRepository;
import geradordeprovas.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        /*==============================
         * Operações com turmas
         *==============================
        
        //Criar uma instancia de turma
        UniversityClass cc2014 = new UniversityClass("cc2014", 2014);
        UniversityClass bio2005 = new UniversityClass("bio2005", 2005);
        
        //Criando a classe que ira manipular os objetos no banco de dados utilizando o padrão repository
         UniversityClassRepository unRepository = new UniversityClassRepository();
         
        //Salvando turmas
        unRepository.save(cc2014);
        unRepository.save(bio2005);
       
        //Removendo turmas
        unRepository.delete(bio2005);
        
        //Atualizando turmas
        cc2014.setCode("cc2014.1");
        unRepository.update(cc2014);
        
        //Listando todas as turmas
        List<UniversityClass> turmas = unRepository.all();
        
        System.out.println("Listagem de turmas");
        for(UniversityClass turma : turmas){
            System.out.print("Codigo: "+turma.getCode());
            System.out.print(" Ano: "+turma.getYear()+"\n");
        }
        
        //Busca de turmas
        UniversityClass cc2014copy = unRepository.find(8);
        System.out.println(cc2014);

         */
 /*==============================
         * Operações com disciplinas
         *==============================
        //Criar uma instancia de turma
        Discipline mat_discreta = new Discipline("Matemática discreta", "Alguma descrição aqui");
        Discipline eg_soft1 = new Discipline("Engenharia de Software 1", "Alguma descrição aqui");
        
        //Criando a classe que ira manipular os objetos no banco de dados utilizando o padrão repository
         DisciplineRepository dsRepository = new DisciplineRepository();
         
        //Salvando turmas
        dsRepository.save(mat_discreta);
        dsRepository.save(eg_soft1);
       
        //Removendo turmas
        dsRepository.delete(mat_discreta);
        
        //Atualizando turmas
        eg_soft1.setDescription("Máteria que aborda o desenvolvimento de software");
        dsRepository.update(eg_soft1);
        
        //Listando todas as turmas
        List<Discipline> disciplines = dsRepository.all();
        
        System.out.println("Listagem de turmas");
        for(Discipline discipline : disciplines){
            System.out.print("Title: "+discipline.getTitle());
            System.out.print(" Description: "+discipline.getDescription()+"\n");
        }
        
        //Busca de turmas
        Discipline eg1 = dsRepository.find(2);
        System.out.println(eg1);
         */
 /*==============================
         * Operações com alternativas
         *============================== 
        //Criar uma instancia de turma
        Alternative alta = new Alternative("Macaco");
        Alternative altb = new Alternative("Urso");

        //Criando a classe que ira manipular os objetos no banco de dados utilizando o padrão repository
        AlternativeRepository altRepository = new AlternativeRepository();

        //Salvando turmas
        altRepository.save(alta);
        altRepository.save(altb);

        //Removendo turmas
        altRepository.delete(alta);

        //Atualizando turmas
        altb.setStatement("Leão");
        altRepository.update(altb);

        //Listando todas as turmas
        List<Alternative> alternatives = altRepository.all();

        System.out.println("Listagem de turmas");
        for (Alternative alternative : alternatives) {
            System.out.print("Id: " + alternative.getId());
            System.out.print(" Enunciado: " + alternative.getStatement() + "\n");
        }

        //Busca de turmas
        Alternative alter2 = altRepository.find(2);
        System.out.println(alter2);*/
 
        System.exit(0);

    }
}
