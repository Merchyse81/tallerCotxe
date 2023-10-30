package serrano.mercedes.taller.app;

import serrano.mercedes.taller.controller.CotxeController;

public class Main {

	public static void main(String[] args) {
		
		CotxeController cotxeController = CotxeController.getInstance();
		cotxeController.mostraSeparador("Alta vehicle"+"\n");
		cotxeController.altaCotxe();
		cotxeController.mostraSeparador("\n"+"Alta vehicle"+"\n");
		cotxeController.altaCotxe();
		cotxeController.mostraSeparador("\n"+"Alta vehicle"+"\n");
		cotxeController.altaCotxe();
		cotxeController.mostraSeparador("\n"+"Llista completa de vehicles"+"\n");
		cotxeController.demanaTotsElsCotxes();
		cotxeController.mostraSeparador("\n" + "Busca un cotxe: "+"\n");
		cotxeController.buscaCotxe();
		cotxeController.mostraSeparador("\n"+"Modifica el model del segon vehicle"+"\n");
		cotxeController.modificaCotxe();
		cotxeController.mostraSeparador("\n"+"Llista completa de vehicles"+"\n");
		cotxeController.demanaTotsElsCotxes();
		cotxeController.mostraSeparador("\n"+"Elimina el primer vehicle"+"\n");
		cotxeController.eliminaCotxe();
		cotxeController.mostraSeparador("\n"+"Llista completa de vehicles"+"\n");
		cotxeController.demanaTotsElsCotxes();

	}

}
