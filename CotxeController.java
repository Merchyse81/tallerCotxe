package serrano.mercedes.taller.controller;

import java.util.ArrayList;

import serrano.mercedes.taller.model.domain.Cotxe;
import serrano.mercedes.taller.model.service.CotxeService;
import serrano.mercedes.taller.view.CotxeConsoleView;

public class CotxeController {

	// singleton
	
	private CotxeController() {
		
	}
	
	public static CotxeController getInstance() {
		if(instance == null) {
			instance = new CotxeController();
		}
		return instance;
	}
	
	private static CotxeController instance = null;
	
	// fi singleton
	
	private CotxeConsoleView cotxeConsoleView = CotxeConsoleView.getInstance();
	private CotxeService cotxeService = CotxeService.getInstance();
	
	public void mostraSeparador(String missatge) {
		try {
			Thread.sleep(500);
			cotxeConsoleView.mostraMissatge(missatge, true);
			Thread.sleep(500);
		}catch(InterruptedException e) {
			cotxeConsoleView.mostraMissatge(e.getMessage(), true);
		}
	}
	
	public void altaCotxe() {
	    boolean altaCorrecta = false;
	    
	    do {
	        try {
	            Cotxe cotxe = cotxeConsoleView.getData();
	            validaId(cotxe.getId()); 
	            validaMatriculaUnica(cotxe.getMatricula());
	            validaMarcaModel(cotxe.getMarca(), cotxe.getModel());
	            cotxeService.addCotxe(cotxe);
	            cotxeConsoleView.mostraMissatge("Cotxe afegit!", false);
	            altaCorrecta = true; 
	        } catch (Exception ex) {
	            cotxeConsoleView.mostraMissatge(ex.getMessage(), true);
	        }
	    } while (!altaCorrecta);
	}

	private void validaId(int id) {
	    if (id <= 0) {
	        throw new RuntimeException("La posició ha de ser major a 0");
	    }
	}

	private void validaMatriculaUnica(String matricula) {
	    for (Cotxe c : cotxeService.retornaTotsElsCotxes()) {
	        if (c.getMatricula().equals(matricula)) {
	            throw new RuntimeException("Ja existeix un cotxe amb aquesta matrícula");
	        }
	    }
	}
	
	private void validaMarcaModel(String marca, String model) {
	    if (marca == null || marca.isEmpty() || model == null || model.isEmpty()) {
	        throw new RuntimeException("La marca i el model han de ser informats");
	    }
	}
	

	public void buscaCotxe() {
	    try {
	        int opcio = cotxeConsoleView.getOpcioBusqueda(); // demana la opció

	        if (opcio == 1) {
	            //busca per posició
	            int posicio = cotxeConsoleView.getIdCotxe(); 
	            Cotxe cotxe = cotxeService.retornaCotxePerPosicio(posicio);
	            cotxeConsoleView.mostrarDades(cotxe);
	        } else if (opcio == 2) {
	            // busca per matricula
	            String matricula = cotxeConsoleView.getMatriculaCotxe(); 
	            Cotxe cotxe = cotxeService.retornaCotxePerMatricula(matricula);
	            cotxeConsoleView.mostrarDades(cotxe);
	        }else {
	            cotxeConsoleView.mostraMissatge("Opció no vàlida.", true);
	        }
	    } catch (Exception ex) {
	        cotxeConsoleView.mostraMissatge(ex.getMessage(), true);
	    }
	}


	public void modificaCotxe() {
	    try {
	    	
	    	 int id = cotxeConsoleView.getIdCotxe();
	         String nouModel = cotxeConsoleView.getNouModel();
	         Cotxe cotxe = cotxeService.retornaUnCotxe(id, nouModel);
	         
	         if(cotxe != null) {
	        	 cotxe.setModel(nouModel);
	             cotxeService.updateCotxe(cotxe);
	             cotxeConsoleView.mostraMissatge("Cotxe modificat! ", false);
	             
	             cotxeConsoleView.mostrarDades(cotxe);
	         } else {
	             cotxeConsoleView.mostraMissatge("No s'ha trobat cap cotxe amb la marca i model indicats ", true);
	         }
	
	    } catch (Exception ex) {
	        cotxeConsoleView.mostraMissatge(ex.getMessage(), true);
	    }
	}

	
	public void eliminaCotxe() {
		try {
			int id = cotxeConsoleView.getIdCotxe();
			Cotxe cotxe = cotxeService.retornaUnCotxe(id, null);
			int afectats = cotxeService.deleteCotxe(cotxe.getId());
			cotxeConsoleView.mostraMissatge(afectats + " Cotxes eliminat", false);
		}catch(Exception ex) {
			cotxeConsoleView.mostraMissatge(ex.getMessage(), true);
		}
	}
	
	public void demanaUnCotxe() {
		try {
			int id = cotxeConsoleView.getIdCotxe();
			Cotxe cotxe = cotxeService.retornaUnCotxe(id, null);
			cotxeConsoleView.mostraMissatge(cotxe.toString(), false);
		}catch(Exception ex) {
			cotxeConsoleView.mostraMissatge(ex.getMessage(), true);
		}
	}
	
	public void demanaTotsElsCotxes() {
		try {
			ArrayList<Cotxe> cotxes = cotxeService.retornaTotsElsCotxes();
			cotxeConsoleView.mostrarDades(cotxes);
		} catch (Exception ex) {
			cotxeConsoleView.mostraMissatge(ex.getMessage(), true);
		}
	}
	
}