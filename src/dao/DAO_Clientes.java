/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ClientesEma;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u06934922107
 */
public class DAO_Clientes extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction(); // É obrigatorio ter a transação com o hibernate e terminar com commit().
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClientesEma.class);
        criteria.add(Restrictions.eq("idClienteEma", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClientesEma.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

}