public class Sistema {
	
	RequisicaoController rc = new RequisicaoController();
	
	public void cadastrarRequisicao(String cartao, String nome, String bairro, String especialidade, String data) {
		rc.cadastrarRequisicao(cartao, nome, bairro, especialidade, data);
	}
	
	public String procurarRequisicao(String especialidade, String cartao) {
		return rc.procurarRequisicao(especialidade, cartao);
	}
	
	public void enviarRequisicao(String especialidade, String cartao, String data) {
		rc.enviarRequisicao(especialidade, cartao, data);
	}
	
	public void finalizarRequisicao(String especialidade, String cartao, String data) {
		rc.finalizarRequisicao(especialidade, cartao, data);	
	}
}
