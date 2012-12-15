package org.hardcoders.socialapp.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hardcoders.socialapp.core.GenericDaoImpl;
import org.hardcoders.socialapp.model.Conflicto;

public class ConflictoDao extends GenericDaoImpl<Conflicto>{

	public ConflictoDao(EntityManager em) {
		this.em =  em;
	}

	public List<Conflicto> findRecentConflicts(Date date) {
		StringBuffer queryString = new StringBuffer("SELECT o from Conflicto o where hora > ?1 order by city, zone");
        Query query = this.em.createQuery(queryString.toString());
        query.setParameter(1, date);
		return query.getResultList();
	}
}
