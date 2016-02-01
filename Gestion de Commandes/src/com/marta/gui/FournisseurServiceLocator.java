package com.marta.gui;


import com.marta.services.FournisseurService;
import com.marta.services.FournisseurServiceImpl;

public class FournisseurServiceLocator {

	private static FournisseurService service = new FournisseurServiceImpl();

	public static FournisseurService getService() {
		return service;
	}

	
}

