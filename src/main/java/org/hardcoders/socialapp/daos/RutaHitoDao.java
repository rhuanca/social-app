package org.hardcoders.socialapp.daos;

import javax.persistence.EntityManager;

import org.hardcoders.socialapp.core.GenericDaoImpl;
import org.hardcoders.socialapp.model.RutaHito;

public class RutaHitoDao extends GenericDaoImpl<RutaHito>{

	public RutaHitoDao(EntityManager em) {
		this.em =  em;
	}
}
