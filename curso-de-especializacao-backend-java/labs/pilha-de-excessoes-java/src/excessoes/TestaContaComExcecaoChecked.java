package excessoes;

public class TestaContaComExcecaoChecked {

	public static void main(String[] args) {
		
		Conta c = new Conta();
		try {
			c.getSaldo();
		} catch (MinhaExcecao ex) {
			System.out.println("tratamento da excecao ...");
		}
		
	}

}
