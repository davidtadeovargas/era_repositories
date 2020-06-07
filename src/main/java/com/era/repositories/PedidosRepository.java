/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Pedidos;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class PedidosRepository extends Repository {

    public PedidosRepository() {
        super(Pedidos.class);
    }
    
    final public void liberaPedido(final int vta) throws Exception{
        this.updateSQL("UPDATE pedidos SET vta = 0,  estad = 'PE' WHERE vta  = " + vta);
    }
    
    final public List<Pedidos> getAllByVta(final int vta) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Pedidos where vta = :vta";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("vta", vta);        
        List<Pedidos> pedidos = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return pedidos;
    }
    
    @Override
    final public List<Pedidos> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Pedidos> items = (List<Pedidos>) this.getAllLike(likes, search);
        
        return items;
    }
}
