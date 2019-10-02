/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject;

import HotelProject.persistence.entities.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jackson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Creating entity information...");
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("hotel");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();

        EntityTransaction et = entityManager.getTransaction();
        
        et.begin();
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Jackson");
        funcionario.setEndereco("Rua André Gomes Brandão");
 
        entityManager.persist(funcionario);

        et.commit();
        
        entityManager.close();
 
        entitiManagerFactory.close();

    }
    
}
