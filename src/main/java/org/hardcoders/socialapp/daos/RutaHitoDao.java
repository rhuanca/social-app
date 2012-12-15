package org.hardcoders.socialapp.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hardcoders.socialapp.core.GenericDaoImpl;
import org.hardcoders.socialapp.model.Rutahito;

public class RutaHitoDao extends GenericDaoImpl<Rutahito>{

	public RutaHitoDao(EntityManager em) {
		this.em =  em;
	}
	
	public List<Rutahito> findAllHitos() {
		StringBuffer queryString = new StringBuffer("SELECT o from Rutahito o order by city, zone");
        Query query = this.em.createQuery(queryString.toString());
		return query.getResultList();
	}
}
