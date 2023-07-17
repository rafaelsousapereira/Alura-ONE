
public class TesteTributaveis {

	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente(222, 111);
		contaCorrente.deposita(100.0);
		
		SeguroDeVida seguroDeVida = new SeguroDeVida();
		
		CalculadorDeImposto imposto = new CalculadorDeImposto();
		imposto.registra(contaCorrente);
		imposto.registra(seguroDeVida);
		
		System.out.println(imposto.getValorImposto());

	}

}
