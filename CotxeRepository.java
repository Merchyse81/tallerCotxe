package serrano.mercedes.taller.model.repository;

import java.util.ArrayList;
import java.util.Iterator;

import serrano.mercedes.taller.model.domain.Cotxe;

public class CotxeRepository {
	
	// Singleton
	private CotxeRepository() {
		 llistaCotxe = new ArrayList<Cotxe>();
	}
	
	public static CotxeRepository getInstance() {
		if(instance == null) {
			instance = new CotxeRepository();
		}
		
		return instance;
	}
	
	private static CotxeRepository instance = null;
	// Fi Singleton
	
	private ArrayList<Cotxe> llistaCotxe;
	
	public void addCotxe(Cotxe cotxe) {
		llistaCotxe.add(cotxe);
	}
	
	public int updateCotxe(Cotxe cotxe) {
				
		int resultat = 0;
		
		for (Cotxe element : llistaCotxe) {
			if(element.getId() == cotxe.getId()){
			element.setMatricula(cotxe.getMatricula());
				element.setMarca(cotxe.getMarca());
				element.setModel(cotxe.getModel());
				resultat++;
				break;			}
		}
		return resultat;
	}
	
	 //Elimina cotxe
	public int deleteCotxe(int id) {
		int resultat = 0;
		
		Iterator<Cotxe> iterador = llistaCotxe.iterator();
		while(iterador.hasNext()) {
			Cotxe element = iterador.next();
			if(element.getId()== id) {
	            llistaCotxe.remove(element);
				resultat++;
				break;
			}
		}
		return resultat;
	}
	
	//mostra la informació sol·licitada per la posició
	public Cotxe retornaUnCotxe(int id) {
		Cotxe resultat = null;
		
		for (Cotxe element: llistaCotxe) {
			if(element.getId() == id) {
	            resultat = element;
				break;
			}
		}
		if (resultat == null) {
			throw new RuntimeException("No hi ha cap cotxe en aquesta posició" + id);
		}
		return resultat;
	}
	
	 //mostra la informació sol·licitada per la matricula
	public Cotxe retornaCotxePerMatricula(String matricula) {
	    for (Cotxe c : llistaCotxe) {
	        if (c.getMatricula().equals(matricula)) {
	            return c;
	        }
	    }
	    return null; 
	}
	
	
	public ArrayList<Cotxe> retornaTotsElsCotxes(){
		return llistaCotxe;
	}

	//mostra el nou model posat i actualitzat
	public int updateModel(int id, String nouModel) {
		for (Cotxe c : llistaCotxe) {
	        if (c.getId() == id) {
	            c.setModel(nouModel);
	            return 1; 
	        }
	    }
		return 0;
	}

	

	
}
