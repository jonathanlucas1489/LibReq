import java.io.Serializable;

public class Paciente  implements Serializable {
	
	private String cartao;
	private String nome;
	private String bairro;
	private static final long serialVersionUID = 1L;

	public Paciente(String cartao, String nome, String bairro) {
		
		this.cartao = cartao;
		this.nome = nome;
		this.bairro = bairro;
	}

	public String getCartao() {
		return cartao;
	}

	public String getNome() {
		return nome;
	}

	public String getBairro() {
		return bairro;
	}
	
	

	

	
	
}
