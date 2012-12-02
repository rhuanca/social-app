package org.hardcoders.socialapp.daos;

import javax.persistence.EntityManager;

import org.hardcoders.socialapp.core.GenericDaoImpl;
import org.hardcoders.socialapp.model.Conflicto;

public class ConflictoDao extends GenericDaoImpl<Conflicto>{

	public ConflictoDao(EntityManager em) {
		this.em =  em;
	}

}
