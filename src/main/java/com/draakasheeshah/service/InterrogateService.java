package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.InterrogateEntity;

public interface InterrogateService {
    // -----Interogate

    InterrogateEntity saveInterrogate(InterrogateEntity interrogate);

    void saveOrUpdateInterrogate(InterrogateEntity interrogate);

    InterrogateEntity getInterrogate(long interrogateId);

    List<InterrogateEntity> loadAllInterrogate();

    void deleteInterrogate(InterrogateEntity interrogate);

    void deleteInterrogatePermanently(InterrogateEntity interrogate);
}
