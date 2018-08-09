import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		
		Sistema sys = new Sistema();
		Scanner sc = new Scanner(System.in);
		
		String option = "";		
		Menu m = new Menu();

		do {
		
			m.exibir();
			System.out.print("Op��o> ");		
			option = sc.nextLine();
			
			switch (option) {
			
			case "C":
				opcaoC(sys);
			break;
			
			case "E":
				opcaoE(sys);
			break;
			
			case "P":
				opcaoP(sys);
			break;	
			
			case "F":
				opcaoF(sys);
			break;				
				}		
	}
	while(!option.equals("S"));
	}
	
	public static void opcaoC(Sistema sys) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome> ");
		String nome = sc.nextLine();
		
		try {
		sys.verificaNome(nome);
		}
		catch(IllegalArgumentException e) {
			System.out.println("O nome n�o pode ser vazio!");
			opcaoC(sys);
			return; 		
		}
		
		System.out.print("Cart�o> ");	
		String cartao = sc.nextLine();
		
		try {
		sys.verificaCartao(cartao);
		}
		catch(IllegalArgumentException e) {
			System.out.println("O CNS deve possuir 15 digitos.");
			opcaoC(sys);
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
			System.out.println("Especialidade inv�lida, tente novamente." + e);
			opcaoC(sys);
			return; 
		}
		
		System.out.print("Data> ");		
		String data = sc.nextLine();
		
		sys.cadastrarRequisicao(cartao, nome, bairro, especialidade, data);	
		
		System.out.print("CADASTRO REALIZADO! \n");
	}
	
	public static void opcaoP(Sistema sys) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Especialidade> ");		
		String especialidade = sc.nextLine();
		
		System.out.print("Cart�o> ");		
		String cartao = sc.nextLine();
		
		try {
			sys.verificaCartao(cartao);
			}
		catch(IllegalArgumentException e) {
				System.out.println("O CNS deve possuir 15 digitos.");
				opcaoP(sys);
				return; 
		}
			
		
		System.out.println(sys.procurarRequisicao(especialidade, cartao));
	}
	
	public static void opcaoE(Sistema sys) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Especialidade> ");	
		String especialidade = sc.nextLine();
		
		System.out.print("Cart�o> ");	
		String cartao = sc.nextLine();
		
		try {
			sys.verificaCartao(cartao);
			}
		catch(IllegalArgumentException e) {
				System.out.println("O CNS deve possuir 15 digitos.");
				opcaoP(sys);
				return; 
		}
		
		System.out.print("Data do envio> ");		
		String data = sc.nextLine();
		
		sys.enviarRequisicao(especialidade, cartao, data);
		
		System.out.print("REQUISI��O ENVIADA! \n");
	}
	
	public static void opcaoF(Sistema sys) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Especialidade> ");		
		String especialidade = sc.nextLine();
		
		System.out.print("Cart�o> ");	
		String cartao = sc.nextLine();
		
		try {
			sys.verificaCartao(cartao);
			}
		catch(IllegalArgumentException e) {
				System.out.println("O CNS deve possuir 15 digitos.");
				opcaoP(sys);
				return; 
		}
		
		System.out.print("Data da finaliza��o> ");		
		String data = sc.nextLine();
		
		sys.finalizarRequisicao(especialidade, cartao, data);	
		
		System.out.print("REQUISI��O FINALIZADA! \n");
	}

}
