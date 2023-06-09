package sintaxe_variaveis_e_fluxos;

public class TestaVariaveis {

	public static void main(String[] args) {
		System.out.println("ola novo teste...");
		
		int idade = 20;
		System.out.printf("A idade eh = %d anos\n", idade);
		
		idade = 20 + 10;
		System.out.printf("A idade agora eh = %d anos\n", idade);
		
		idade = (7 * 2) + 2;
		System.out.println("A idade agora eh = " + idade + " anos");
		
	}
}
