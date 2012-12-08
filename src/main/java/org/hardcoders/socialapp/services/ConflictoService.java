package org.hardcoders.socialapp.services;

import org.hardcoders.socialapp.daos.ConflictoDao;
import org.hardcoders.socialapp.daos.RutaHitoDao;
import org.hardcoders.socialapp.daos.UserrouteDao;
import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.model.Rutahito;
import org.hardcoders.socialapp.model.Userroute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

@Component
public class ConflictoService {
	EntityManager entityManager;
	
	@Autowired
	public void setEntityManagerFactory( LocalEntityManagerFactoryBean entityManagerFactory) {
		this.entityManager = entityManagerFactory.nativeEntityManagerFactory.createEntityManager();
	}

	public long countAll() {
		ConflictoDao dao = new ConflictoDao(entityManager);
		return dao.countAll(null);
	}
	
	public List<Conflicto> listAll() {
		
		ConflictoDao dao = new ConflictoDao(entityManager);
		return dao.listAll(null);
	}

    public long insert(Conflicto conflicto) {
        ConflictoDao dao = new ConflictoDao(entityManager);
        return dao.create(conflicto).getId();
    }

    public void update(Conflicto conflicto) {
        ConflictoDao dao = new ConflictoDao(entityManager);
        dao.update(conflicto);
    }
    
    //
    // Ruta Hito methods
    //
    public List<Rutahito> listAllRutaHitos(){
    	RutaHitoDao dao = new RutaHitoDao(entityManager);
		return dao.findAllHitos();
    }
    
    public Rutahito findRutaById(String id){
    	RutaHitoDao dao = new RutaHitoDao(entityManager);
		return dao.find(Long.parseLong(id, 10));
    }
    
    public Rutahito findRutaById(long id){
    	RutaHitoDao dao = new RutaHitoDao(entityManager);
		return dao.find(id);
    }

	public long insertAlert(Userroute userroute) {
		UserrouteDao dao = new UserrouteDao(entityManager);
		return dao.create(userroute).getId();
	}

    public Conflicto findById(Long id) {
        ConflictoDao dao = new ConflictoDao(entityManager);
        return dao.find(id);

    }

	public List<Conflicto> findLastConflict(Date date) {
        ConflictoDao dao = new ConflictoDao(entityManager);
        return dao.findRecentConflicts(date);
	}
}
