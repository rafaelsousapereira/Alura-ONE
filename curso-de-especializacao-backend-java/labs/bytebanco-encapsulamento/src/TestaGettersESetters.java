
public class TestaGettersESetters {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
//		conta.numero = 4321;
		conta.setNumero(4321);
		conta.setAgencia(12);
		
		System.out.println("Número da Conta: " + conta.getNumero());
		System.out.println("Número da Agência: " + conta.getAgencia());
	}

}
