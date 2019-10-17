/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.persistence.dao;

import static HotelProject.persistence.dao.Dao.entityManager;
import HotelProject.persistence.entities.DadosCartao;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jackson
 */
public class DadosCartaoDao extends Dao implements AbstractDao<DadosCartao> {

    @Override
    public void save(DadosCartao dadosCartao) {
        executeInsideTransaction(entityManager -> entityManager.persist(dadosCartao));
    }

    @Override
    public void delete(DadosCartao dadosCartao) {
        executeInsideTransaction(entityManager -> entityManager.remove(dadosCartao));
    }

    @Override
    public void update(DadosCartao dadosCartao) {
        executeInsideTransaction(entityManager -> entityManager.merge(dadosCartao));
    }

    @Override
    public DadosCartao find(Integer id) {
        return entityManager.find(DadosCartao.class, id);
    }
    
    public DadosCartao findByHospede(Integer idHospede) {
        List<DadosCartao> query = entityManager.createQuery("SELECT t FROM DadosCartao t where t.codigo_hospede = :codigo_hospede")
                        .setParameter("codigo_hospede", idHospede).getResultList();
        
        if (query.size() > 1) {
            return query.get(0);
        }
        return null;
    }
    

    @Override
    public List<DadosCartao> getAll() {
        TypedQuery<DadosCartao> query = entityManager.createQuery("SELECT e FROM DadosCartao e", DadosCartao.class);
        return query.getResultList();
    }

    @Override
    public List<DadosCartao> getList(String qlString, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DadosCartao> getList(String qlString, Object[] params, int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getCount(String qlString, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit(); 
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
