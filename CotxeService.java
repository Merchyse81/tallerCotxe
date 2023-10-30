package serrano.mercedes.taller.model.service;

import java.util.ArrayList;

import serrano.mercedes.taller.model.domain.Cotxe;
import serrano.mercedes.taller.model.repository.CotxeRepository;

public class CotxeService {
	
	//Singleton
	private CotxeService() {
		
	}
	
	public static CotxeService getInstance() {
		if (instance == null) {
			instance = new CotxeService();
		}
		return instance;
	}
	
	private static CotxeService instance = null;
	
	// Fi Singleton

	CotxeRepository cotxeRepository = CotxeRepository.getInstance();
	
	public void addCotxe(Cotxe cotxe) {
		validaId(cotxe.getId());
		validaMatricula(cotxe.getMatricula());
		validaMarca(cotxe.getMarca());
		validaModel(cotxe.getModel());
		
		cotxeRepository.addCotxe(cotxe);
	}

	
	public int updateCotxe(Cotxe cotxe) {
		validaId(cotxe.getId());
		validaMatricula(cotxe.getMatricula());
		validaMarca(cotxe.getMarca());
		validaModel(cotxe.getModel());
		
		return cotxeRepository.updateModel(cotxe.getId(), cotxe.getModel());	
	}
	
	
	public int deleteCotxe(int id) {
		validaId(id);
		
		return cotxeRepository.deleteCotxe(id);
	}
	
	 public Cotxe retornaUnCotxe(int id, String nouModel) {
		 Cotxe cotxe = cotxeRepository.retornaUnCotxe(id);
		 
		 if(cotxe != null) {
			 cotxe.setModel(nouModel);
			 return cotxe;
		 }else {
			 throw new IllegalArgumentException("No s'ha trobat cap cotxe amb aquest model");
		 }
	 }
	 
	 public ArrayList<Cotxe> retornaTotsElsCotxes(){
		 return cotxeRepository.retornaTotsElsCotxes();
	 }

	 private void validaId(int id) {
		 if(id <= 0) {
			 throw new RuntimeException("La posició ha de ser major a 0");
		 }
	 }
	 
	 private void validaMatricula(String matricula) {
			if(matricula.length()!= 7) {
				throw new RuntimeException("La matricula ha de tenir 7 caracters");
			}
		}
	 
	private void validaModel(String model) {
		if (model == null || model.isEmpty()) {
			throw new RuntimeException("El model ha d'anar acompanyat de la marca del vehicle");
		}
	}

	private void validaMarca(String marca) {
        if (marca == null || marca.length() < 2) {
            throw new RuntimeException("La longitud ha de ser superior a 2 caracters.");
        }
    }
	
	//Els dos métodes següents es per buscar un vehicle de la llista, per la posició o per la matricula
	public Cotxe retornaCotxePerPosicio(int posicio) {
	    for (Cotxe c : cotxeRepository.retornaTotsElsCotxes()) {
	        if (c.getId() == posicio) {
	            return c;
	        }
	    }
	    throw new IllegalArgumentException("No s'ha trobat cap cotxe en aquesta posició");
	}
	
	public Cotxe retornaCotxePerMatricula(String matricula) {
	    Cotxe cotxe = cotxeRepository.retornaCotxePerMatricula(matricula);

	    if (cotxe != null) {
	        return cotxe;
	    } else {
	        throw new IllegalArgumentException("No s'ha trobat cap cotxe amb aquesta matrícula");
	    }
	}
}
