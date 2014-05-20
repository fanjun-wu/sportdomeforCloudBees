package org.groept.cloudMigration.service.impl;

import java.util.Comparator;

import org.groept.cloudMigration.model.Court;


public class CourtComparator implements Comparator<Court>{

	@Override
	public int compare(Court arg0, Court arg1) {
		// TODO Auto-generated method stub
		
		return arg0.getName().compareToIgnoreCase(arg1.getName());
				
	}
	
	
	

}
