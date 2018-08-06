import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String option = "";		
		Menu m = new Menu();
		
		do {
		
			m.exibir();
			System.out.print("Opção> ");		
			option = sc.nextLine();
			
			switch (option) {
			
			case "C":
				
			break;
			
			case "E":
				
			break;
			
			case "P":
				
			break;	
			
			case "F":
				
			break;				
				}
		
	}
	while(!option.equals("S"));

	}

}
