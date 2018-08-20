import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class RequisicaoController  implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<Requisicao> oftalmo;
	private ArrayList<Requisicao> gineco;
	private ArrayList<Requisicao> neuro;
	private ArrayList<Requisicao> endocrino;
	private ArrayList<Requisicao> otorrino;
	private ArrayList<Requisicao> nutricio;
	private ArrayList<Requisicao> masto;
	private ArrayList<Requisicao> cardio;
	private ArrayList<Requisicao> gastro;
	private ArrayList<Requisicao> dermato;
	private ArrayList<Requisicao> cirurgiao;
	private ArrayList<Requisicao> angio;
	private ArrayList<Requisicao> alergista;
	private ArrayList<Requisicao> patologia;
	private HashMap<String, ArrayList<Requisicao>> codigos;
	
	public RequisicaoController () {
		this.codigos = new HashMap<String, ArrayList<Requisicao>>();
		this.oftalmo = new ArrayList<Requisicao>();
		codigos.put("01", oftalmo);
		this.gineco = new ArrayList<Requisicao>();
		codigos.put("02", gineco);
		this.neuro = new ArrayList<Requisicao>();
		codigos.put("03", neuro);
		this.endocrino = new ArrayList<Requisicao>();
		codigos.put("04", endocrino);
		this.otorrino = new ArrayList<Requisicao>();
		codigos.put("05", otorrino);
		this.nutricio = new ArrayList<Requisicao>();
		codigos.put("06", nutricio);
		this.masto = new ArrayList<Requisicao>();
		codigos.put("07", masto);
		this.cardio = new ArrayList<Requisicao>();
		codigos.put("08", cardio);
		this.gastro = new ArrayList<Requisicao>();
		codigos.put("09", gastro);
		this.dermato = new ArrayList<Requisicao>();
		codigos.put("10", dermato);
		this.cirurgiao = new ArrayList<Requisicao>();
		codigos.put("11", cirurgiao);
		this.angio = new ArrayList<Requisicao>();
		codigos.put("12", angio);
		this.alergista = new ArrayList<Requisicao>();
		codigos.put("13", alergista);
		this.patologia = new ArrayList<Requisicao>();
		codigos.put("14", patologia);

	}
	

	public void cadastrarRequisicao(String cartao, String nome, String bairro, String especialidade, String data) {
		Requisicao r = new Requisicao(cartao, nome, bairro, especialidade, data);
		codigos.get(especialidade).add(r);
	}
	
	public void enviarRequisicao(String especialidade, String cartao, String data) {
		for(int i = 0; i < codigos.get(especialidade).size(); i++) {
			if(codigos.get(especialidade).get(i).getPaciente().getCartao().equals(cartao)) {
				codigos.get(especialidade).get(i).setEstado("Enviado no dia " + data);
			}}
	}
	
	public void finalizarRequisicao(String especialidade, String cartao, String data) {
		for(int i = 0; i < codigos.get(especialidade).size(); i++) {
			if(codigos.get(especialidade).get(i).getPaciente().getCartao().equals(cartao)) {
				codigos.get(especialidade).get(i).setEstado("Finalizado no dia " + data);
			}}
	}
	
	public String procurarRequisicao(String especialidade, String cartao) {
		for(int i = 0; i < codigos.get(especialidade).size(); i++) {
			if(codigos.get(especialidade).get(i).getPaciente().getCartao().equals(cartao)) {
				return codigos.get(especialidade).get(i).toString();
			}
		} 
		return "Requisição Não encontrada.";
	}
	
	
	
	public void verificaNome(String nome) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome não pode ser vazio.");
		} 
	}
	
	public void verificaCartao(String cartao) {
		if (cartao.trim().equals("")) {
			throw new IllegalArgumentException("O CNS não pode ser vazio.");
		} else if (cartao.length() < 15 || cartao.length() > 15) {
			throw new IllegalArgumentException("O CNS deve possuir 15 digitos.");
		}
	}
	
	public void verificaData(String data) {
		if (data.trim().equals("")) {
			throw new IllegalArgumentException("Data não pode ser vazio.");
		} 
	}
	
	public void verificaEspecialidadeValida(String especialidade) {
		String[] codigos = {"00", "01","02","03","04","05","06","07","08","09"};
		for(int i = 0; i < codigos.length; i++) {
			if(codigos[i].contains(especialidade)) {
				throw new IllegalArgumentException(codigos[i]);
			}
			break;
		}
		if (especialidade.trim().equals("")) {
			throw new IllegalArgumentException("Especialidade não pode ser vazio.");
		}
	}
}