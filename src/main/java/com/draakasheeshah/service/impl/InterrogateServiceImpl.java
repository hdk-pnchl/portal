package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.InterrogateEntity;
import com.draakasheeshah.dao.InterrogateDAO;
import com.draakasheeshah.service.InterrogateService;

@Service
public class InterrogateServiceImpl
    implements InterrogateService
{
    @Autowired
    InterrogateDAO interrogateDAO;

    @Override
    public InterrogateEntity saveInterrogate(InterrogateEntity interrogate) {
        return interrogateDAO.saveInterrogate(interrogate);
    }

    @Override
    public void saveOrUpdateInterrogate(InterrogateEntity interrogate) {
        interrogateDAO.saveOrUpdateInterrogate(interrogate);
    }

    @Override
    public InterrogateEntity getInterrogate(long interrogateId) {
        return interrogateDAO.getInterrogate(interrogateId);
    }

    @Override
    public List<InterrogateEntity> loadAllInterrogate() {
        return interrogateDAO.loadAllInterrogate();
    }

    @Override
    public void deleteInterrogate(InterrogateEntity interrogate) {
        interrogateDAO.deleteInterrogate(interrogate);
    }

    @Override
    public void deleteInterrogatePermanently(InterrogateEntity interrogate) {
        interrogateDAO.deleteInterrogatePermanently(interrogate);
    }
}