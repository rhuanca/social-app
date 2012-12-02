package org.hardcoders.socialapp.services;

import org.hardcoders.socialapp.daos.ConflictoDao;
import org.hardcoders.socialapp.daos.RutaHitoDao;
import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.model.RutaHito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConflictoService {
	LocalEntityManagerFactoryBean entityManagerFactory;
	
	@Autowired
	public void setEntityManagerFactory( LocalEntityManagerFactoryBean entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public long countAll() {
		ConflictoDao dao = new ConflictoDao(entityManagerFactory.nativeEntityManagerFactory.createEntityManager());
		return dao.countAll(null);
	}
	
	public List<Conflicto> listAll() {
		System.out.println(">>> entityManagerFactory.getPersistenceUnitInfo() = " + entityManagerFactory.getPersistenceUnitInfo());
		ConflictoDao dao = new ConflictoDao(entityManagerFactory.nativeEntityManagerFactory.createEntityManager());
		return dao.listAll(null);
	}

    public long insert(Conflicto conflicto) {
    	
        System.out.println("Inserting conflict...");
        ConflictoDao dao = new ConflictoDao(entityManagerFactory.nativeEntityManagerFactory.createEntityManager());
        return dao.create(conflicto).getId();
    }

    public void update(Conflicto conflicto) {
        System.out.println("Inserting conflict...");
        ConflictoDao dao = new ConflictoDao(entityManagerFactory.nativeEntityManagerFactory.createEntityManager());
        dao.update(conflicto);
    }
    
    //
    // Ruta Hito methods
    //
    public List<RutaHito> listAllRutaHitos(){
    	RutaHitoDao dao = new RutaHitoDao(entityManagerFactory.nativeEntityManagerFactory.createEntityManager());
		return dao.listAll(null);
    }
    
    public RutaHito findRutaById(String id){
    	RutaHitoDao dao = new RutaHitoDao(entityManagerFactory.nativeEntityManagerFactory.createEntityManager());
		return dao.find(Long.parseLong(id, 10));
    }
}
