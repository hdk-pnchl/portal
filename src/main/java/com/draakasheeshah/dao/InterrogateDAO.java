package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.InterrogateEntity;

public interface InterrogateDAO {

    // -----Interogate

    InterrogateEntity saveInterrogate(InterrogateEntity interrogate);

    void saveOrUpdateInterrogate(InterrogateEntity interrogate);

    InterrogateEntity getInterrogate(long interrogateId);

    List<InterrogateEntity> loadAllInterrogate();

    void deleteInterrogate(InterrogateEntity interrogate);

    void deleteInterrogatePermanently(InterrogateEntity interrogate);
}
