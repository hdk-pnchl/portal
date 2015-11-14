package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.InterrogateEntity;
import com.draakasheeshah.dao.InterrogateDAO;

@Repository
public class InterrogateDAOImp
    implements InterrogateDAO
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public InterrogateEntity saveInterrogate(InterrogateEntity interrogate) {
        return (InterrogateEntity)hibernateTemplate.save(interrogate);
    }

    @Override
    public void saveOrUpdateInterrogate(InterrogateEntity interrogate) {
        hibernateTemplate.saveOrUpdate(interrogate);
    }

    @Override
    public InterrogateEntity getInterrogate(long interrogateId) {
        return hibernateTemplate.get(InterrogateEntity.class, interrogateId);
    }

    @Override
    public List<InterrogateEntity> loadAllInterrogate() {
        return hibernateTemplate.loadAll(InterrogateEntity.class);
    }

    @Override
    public void deleteInterrogate(InterrogateEntity interrogate) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteInterrogatePermanently(InterrogateEntity interrogate) {
        hibernateTemplate.delete(interrogate);
    }
}