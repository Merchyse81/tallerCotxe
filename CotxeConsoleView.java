package serrano.mercedes.taller.view;

import java.util.ArrayList;
import java.util.Scanner;

import serrano.mercedes.taller.model.domain.Cotxe;

public class CotxeConsoleView extends BaseConsoleView{

    // Singleton

    private CotxeConsoleView() {

    }

    public static CotxeConsoleView getInstance() {
        if(instance == null) {
            instance = new CotxeConsoleView();
        }

        return instance;
    }

    private static CotxeConsoleView instance = null;
    // Fi singleton

    public Cotxe getData() {
    	Cotxe cotxe = new Cotxe();
    	
    	 cotxe.setId(this.getIdCotxe());
    	    cotxe.setMatricula(this.getMatriculaCotxe());
    	    String marcaModel = this.getMarcaModelCotxe();
    	    String[] partes = marcaModel.split(" ");
    	    cotxe.setMarca(partes[0]);
    	    cotxe.setModel(partes[1]);
    	    
    	    return cotxe;    	
    }
    
    public int getIdCotxe() {
        int id = -1; 
        
        do {
            try {
                id = this.getInt("Introdueix posició del vehicle");
                validaId(id); 
            } catch (Exception ex) {
                mostraMissatge(ex.getMessage(), true);
            }
        } while (id < 1); // segueix demana la posició si no es positiva
        
        return id;
    }

    private void validaId(int id) {
        if (id < 1) {
            throw new RuntimeException("\n" + "La posició ha de ser major a 0" + "\n");
        }
    }
    
    //Busca un nou vehicle
    public int getOpcioBusqueda() {
        int opcio = 0;
        while (opcio < 1 || opcio > 2) {
            opcio = this.getInt("Selecciona una opció (1 - Buscar per Posició, 2 - Buscar per Matrícula): ");
        }
        return opcio;
    }

	public String getMatriculaCotxe() {
        return this.getString("Introdueix la matricula del vehicle: ");
    }

    public String getMarcaModelCotxe() {
        return this.getString("Introdueix la marca i model del vehicle: ");
    }
    
    public void mostrarDades(ArrayList<Cotxe> cotxes) {
        if (cotxes != null) {
            for (Cotxe c : cotxes) {
                mostrarDades(c);
            }
        }
    }

    public void mostrarDades(Cotxe cotxe) {
        System.out.println(cotxe.toString());
    }

    //demana el nou model a posar 
	public String getNouModel() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introdueix el nou model: ");
		return scanner.nextLine();
	}
}
