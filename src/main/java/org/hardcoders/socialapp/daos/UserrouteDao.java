package org.hardcoders.socialapp.daos;

import javax.persistence.EntityManager;

import org.hardcoders.socialapp.core.GenericDaoImpl;
import org.hardcoders.socialapp.model.Userroute;

public class UserrouteDao extends GenericDaoImpl<Userroute>{
	public UserrouteDao(EntityManager em) {
		this.em = em;
	}
}
