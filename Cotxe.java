package serrano.mercedes.taller.model.domain;

public class Cotxe {
	
	public Cotxe() {
		
	}
	private int id;
    private String matricula;
    private String marca;
    private String model;
    

    // Length
    public Cotxe(String matricula, String marca, String model, int id) {
        if (validarLongitudMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new IllegalArgumentException("La matrícula debe tener 7 caracteres entre números y letras.");
        }
        this.id = id;
        this.marca = marca;
        this.model = model;
    }

    private boolean validarLongitudMatricula(String matricula) {
        return matricula.length() == 7;
    }

    public void setMatricula(String matricula) {
        if (validarLongitudMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new IllegalArgumentException("La matrícula debe tener 7 caracteres entre números y letras.");
        }
    }
    //Fi length

    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id =id;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    //split
    public String getMarca() {
        return marca + " " + model;
    }
    
    public void setModel(String model) {
    	this.model = model;
    }
    
    public String getModel() {
    	return model;
    }
    


	@Override
	public String toString() {
		return "Cotxe [id: " + id + ", marca: "+ marca + ", model: " + model + ",matricula:"+ matricula +"]";
	}
}
