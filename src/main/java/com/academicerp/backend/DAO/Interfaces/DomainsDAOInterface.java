package com.academicerp.backend.DAO.Interfaces;
import com.academicerp.backend.Bean.Domains;

import java.util.List;

public interface DomainsDAOInterface {
    boolean addDomain(Domains d);
    boolean updateDomian(Domains d,Integer id);

    List<Domains> getAllDomains();

}
