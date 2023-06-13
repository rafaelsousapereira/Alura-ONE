package sintaxe_variaveis_e_fluxos;

public class TesteIR {

	public static void main(String[] args) {
		System.out.println("Calculo IRRF...");

		// Abaixo de 1903.99
		// De 1903.99 até 2826.65 o IR é de 7.5% e pode deduzir R$ 142.80
		// De 2826.65 até 3751.06 o IR é de 15% e pode deduzir R$ 354.80
		// De 3751.07 até 4664.68 o IR é de 22.5% e pode deduzir R$ 636.13
		// Acima de 4664.68

		double salario = 3300.0;
		
		if (salario >= 1903.99 && salario <= 2826.65) {
			double valorFixoAliquota = 142.80;
			double aliquota = 0.075 * 100;
			calcularImpostoDeRendaIRRF(salario, valorFixoAliquota, aliquota);
			
		} else if (salario >= 2826.65 && salario <= 3751.06) {

			double valorFixoAliquota = 354.80;
			double aliquota = 0.15 * 100;
			calcularImpostoDeRendaIRRF(salario, valorFixoAliquota, aliquota);

		} else if (salario >= 3751.06 && salario <= 4664.68) {

			double valorFixoAliquota = 636.13;
			double aliquota = 0.225 * 100;
			calcularImpostoDeRendaIRRF(salario, valorFixoAliquota, aliquota);

		} else if (salario > 4664.68) {

			double valorFixoAliquota = 869.36;
			double aliquota = 0.275 * 100;
			calcularImpostoDeRendaIRRF(salario, valorFixoAliquota, aliquota);
		} else {
			if (salario < 1903.99)
				System.out.println("Isento de impostos!");
		}
	}

	private static void calcularImpostoDeRendaIRRF(double salario, double valorFixoAliquota, double aliquota) {
		double imposto = (salario * aliquota) - valorFixoAliquota;

		System.out.printf("O seu IRRF (Imposto de Renda) é de = %2.1f%%%n", aliquota);
		System.out.printf("Valor da Declaracao IRRF = R$ %2.2f", imposto);
	}

}
