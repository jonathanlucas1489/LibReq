import java.util.ArrayList;


public class RequisicaoController {
	private ArrayList<Requisicao> oftalmo;
	private ArrayList<Requisicao> gineco;
	private ArrayList<Requisicao> neuro;
	private ArrayList<Requisicao> endocrino;
	private ArrayList<Requisicao> otorrino;
	
	public RequisicaoController () {
		this.oftalmo = new ArrayList<Requisicao>();
		this.gineco = new ArrayList<Requisicao>();
		this.neuro = new ArrayList<Requisicao>();
		this.endocrino = new ArrayList<Requisicao>();
		this.otorrino = new ArrayList<Requisicao>();

	}
	
	public ArrayList<Requisicao> verificaEspecialidade(String especialidade) {
		if(especialidade.equals("01")) {
			return oftalmo;
		} else if (especialidade.equals("02")) {
			return gineco;
		} else if (especialidade.equals("03")) {
			return neuro;
		} else if (especialidade.equals("04")) {
			return endocrino;
		} else if (especialidade.equals("05")) {
			return otorrino;
		}
		return endocrino;
	}
	
	public void cadastrarRequisicao(String cartao, String nome, String bairro, String especialidade, String data) {
		Requisicao r = new Requisicao(cartao, nome, bairro, especialidade, data);	
		verificaEspecialidade(especialidade).add(r);
	}
	
	public void enviarRequisicao(String especialidade, String cartao, String data) {
		for(int i = 0; i < verificaEspecialidade(especialidade).size(); i++) {
			if(verificaEspecialidade(especialidade).get(i).getPaciente().getCartao().equals(cartao)) {
				verificaEspecialidade(especialidade).get(i).setEstado("Enviado no dia " + data);
			}}
	}
	
	public void finalizarRequisicao(String especialidade, String cartao, String data) {
		for(int i = 0; i < verificaEspecialidade(especialidade).size(); i++) {
			if(verificaEspecialidade(especialidade).get(i).getPaciente().getCartao().equals(cartao)) {
				verificaEspecialidade(especialidade).get(i).setEstado("Finalizado no dia " + data);
			}}
	}
	
	public String procurarRequisicao(String especialidade, String cartao) {
		for(int i = 0; i < verificaEspecialidade(especialidade).size(); i++) {
			if(verificaEspecialidade(especialidade).get(i).getPaciente().getCartao().equals(cartao)) {
				return verificaEspecialidade(especialidade).get(i).toString();
			}
		} 
		return "Requisi��o N�o encontrada.";
	}
	
	
	
	public void verificaNome(String nome) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome n�o pode ser vazio.");
		} 
	}
	
	public void verificaCartao(String cartao) {
		if (cartao.trim().equals("")) {
			throw new IllegalArgumentException("O CNS n�o pode ser vazio.");
		} else if (cartao.length() < 15 || cartao.length() > 15) {
			throw new IllegalArgumentException("O CNS deve possuir 15 digitos.");
		}
	}
	
	public void verificaData(String data) {
		if (data.trim().equals("")) {
			throw new IllegalArgumentException("Data n�o pode ser vazio.");
		} 
	}
	
	public void verificaEspecialidadeValida(String especialidade) {
		if (especialidade.trim().equals("")) {
			throw new IllegalArgumentException("Especialidade n�o pode ser vazio.");
		}
	}
}