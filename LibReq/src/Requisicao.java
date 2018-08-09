import java.util.ArrayList;
import java.util.HashMap;

public  class Requisicao {
	
	private Paciente paciente;
	private String estado;
	private String especialidade;
	private String data;
	
	public Requisicao(String cartao, String nome, String bairro, String especialidade, String data) {
		Paciente p = new Paciente(cartao, nome, bairro);
		this.paciente = p;
		this.estado = "Arquivado!";
		this.data = data;
		
		if(especialidade.equals("01")) {
			this.especialidade = "Oftalmologista";
		} else if (especialidade.equals("02")) {
			this.especialidade = "Ginecologista";
		} else if (especialidade.equals("03")) {
			this.especialidade = "Neurologista";
		} else if (especialidade.equals("04")) {
			this.especialidade = "Endocrinologista";
		} else if (especialidade.equals("05")) {
			this.especialidade = "Otorrinolargingologista";
		}
	}

	
	public Paciente getPaciente() {
		return paciente;
	}


	public String getEstado() {
		return estado;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getData() {
		return data;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return  "Estado: " + this.estado + "\n" +
			    "Especialidade: " + especialidade + "\n" +
			    "Cartão do SUS: " + this.paciente.getCartao() + "\n" + 
			    "Nome: " + this.paciente.getNome() + "\n" +
			    "Bairro: " + this.paciente.getBairro() + "\n";
	}
}
