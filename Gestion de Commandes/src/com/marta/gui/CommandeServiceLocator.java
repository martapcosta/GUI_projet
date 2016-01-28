package com.marta.gui;

import com.marta.services.CommandeService;
import com.marta.services.CommandeServiceImpl;

public class CommandeServiceLocator {

	private static CommandeService service = new CommandeServiceImpl();

	public static CommandeService getService() {
		return service;
	}
}
