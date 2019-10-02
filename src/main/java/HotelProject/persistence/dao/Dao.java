/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.persistence.dao;

import javax.persistence.EntityManager;

/**
 *
 * @author Jackson
 */
public class Dao {
    
    protected static EntityManager entityManager = HotelProject.persistence.ConnectionFactory.getEntityManager();
}
