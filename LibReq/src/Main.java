import java.util.Scanner;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		
		Sistema sys = new Sistema();
		Scanner sc = new Scanner(System.in);
		ArquivoController ac = new ArquivoController();
		String option = "";		
		Menu m = new Menu();
		
		do {
		
			m.exibir();
			System.out.print("Opção> ");		
			option = sc.nextLine();
			
			switch (option) {
			
			case "C":
				opcaoC(sys, ac);
			break;
			
			case "E":
				opcaoE(sys);
			break;
			
			case "P":
				opcaoP(sys, ac);
			break;	
			
			case "F":
				opcaoF(sys);
			break;				
				}		
	}
	while(!option.equals("S"));
	}
	
	public static void opcaoC(Sistema sys, ArquivoController ac) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome> ");
		String nome = sc.nextLine();
		
		try {
		sys.verificaNome(nome);
		}
		catch(IllegalArgumentException e) {
			System.out.println("O nome não pode ser vazio!");
			opcaoC(sys, ac);
			return; 		
		}
		
		System.out.print("Cartão> ");	
		String cartao = sc.nextLine();
		
		try {
		sys.verificaCartao(cartao);
		}
		catch(IllegalArgumentException e) {
			System.out.println("O CNS deve possuir 15 digitos.");
			opcaoC(sys, ac);
			return; 
		}
		
		System.out.print("Bairro> ");		
		String bairro = sc.nextLine();
		
		System.out.print("Especialidade> ");		
		String especialidade = sc.nextLine();
		
		try {
			sys.verificaEspecialidade(especialidade);
		}
		catch(IllegalArgumentException e) {
			System.out.println("Especialidade inválida, tente novamente." + e);
			opcaoC(sys, ac);
			return; 
		}
		
		System.out.print("Data> ");		
		String data = sc.nextLine();
		
		sys.cadastrarRequisicao(cartao, nome, bairro, especialidade, data);	
		
		System.out.print("CADASTRO REALIZADO! \n");
		salvar(sys, ac);
	}
	
	public static void opcaoP(Sistema sys, ArquivoController ac) throws IOException {
		carregar(sys, ac);
		Scanner sc = new Scanner(System.in);

		System.out.print("Especialidade> ");		
		String especialidade = sc.nextLine();
		
		System.out.print("Cartão> ");		
		String cartao = sc.nextLine();
		
		try {
			sys.verificaCartao(cartao);
			}
		catch(IllegalArgumentException e) {
				System.out.println("O CNS deve possuir 15 digitos.");
				opcaoP(sys, ac);
				return; 
		}
			
		
		System.out.println(sys.procurarRequisicao(especialidade, cartao));
	}
	
	public static void opcaoE(Sistema sys) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Especialidade> ");	
		String especialidade = sc.nextLine();
		
		System.out.print("Cartão> ");	
		String cartao = sc.nextLine();
		
		try {
			sys.verificaCartao(cartao);
			}
		catch(IllegalArgumentException e) {
				System.out.println("O CNS deve possuir 15 digitos.");
				opcaoE(sys);
				return; 
		}
		
		System.out.print("Data do envio> ");		
		String data = sc.nextLine();
		
		sys.enviarRequisicao(especialidade, cartao, data);
		
		System.out.print("REQUISIÇÃO ENVIADA! \n");
	}
	
	public static void opcaoF(Sistema sys) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Especialidade> ");		
		String especialidade = sc.nextLine();
		
		System.out.print("Cartão> ");	
		String cartao = sc.nextLine();
		
		try {
			sys.verificaCartao(cartao);
			}
		catch(IllegalArgumentException e) {
				System.out.println("O CNS deve possuir 15 digitos.");
				opcaoF(sys);
				return; 
		}
		
		System.out.print("Data da finalização> ");		
		String data = sc.nextLine();
		
		sys.finalizarRequisicao(especialidade, cartao, data);	
		
		System.out.print("REQUISIÇÃO FINALIZADA! \n");
	}
	
	public static void salvar(Sistema sys, ArquivoController ac) throws IOException {
		ac.salvaObjeto("Sistema.txt", sys);
	}

	public static void carregar(Sistema sys, ArquivoController ac) throws IOException {
		Sistema sistemaCarregado = (Sistema) ac.carregaObjeto("Sistema.txt");
		sys = sistemaCarregado;
	}

}
