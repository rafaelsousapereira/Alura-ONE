
public class TestaValores {

	public static void main(String[] args) {
		
		Conta conta = new Conta(1337, 2337);

		System.out.println("agencia: " + conta.getAgencia());
		System.out.println("numero: " + conta.getNumero());
		
		Conta conta2 = new Conta(1337, 2338);
		Conta conta3 = new Conta(7331, 2338);
		
		System.out.println("agencia: " + conta2.getAgencia());
		System.out.println("numero: " + conta2.getNumero());
		System.out.println("agencia: " + conta3.getAgencia());
		System.out.println("numero: " + conta2.getNumero());
		
		System.out.println("total de contas: " + Conta.getTotal());
	}

}
