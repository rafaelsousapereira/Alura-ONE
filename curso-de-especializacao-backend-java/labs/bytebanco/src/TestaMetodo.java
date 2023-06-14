
public class TestaMetodo {

	public static void main(String[] args) {
		Conta contaDoJoao = new Conta();
		contaDoJoao.saldo = 100;
		contaDoJoao.deposita(50.0);
		System.out.println(contaDoJoao.saldo);
		
		boolean conseguiuRetirar = contaDoJoao.saca(20);
		System.out.println(contaDoJoao.saldo);
		System.out.println(conseguiuRetirar);
		
		Conta contaDaMaria = new Conta();
		contaDaMaria.deposita(1000);
		
		boolean sucessoTransferencia = contaDaMaria.transfere(3000, contaDoJoao);
		
		if (sucessoTransferencia) {
			System.out.println("tranferencia com sucesso");
		} else {
			System.out.println("faltou dinheiro");
		}
		
		System.out.println(contaDaMaria.saldo);
		System.out.println(contaDoJoao.saldo);
	}

}
