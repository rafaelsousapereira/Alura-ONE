import enuns.Prioridade;

public class TesteEnuns {

	public static void main(String[] args) {

		Prioridade prioridadeMin = Prioridade.MIN;
		Prioridade prioridadeMax = Prioridade.MAX;
		
		System.out.println("Nome: " + prioridadeMin.name());
		System.out.println("Nome: " + prioridadeMax.name());

		System.out.println("Valor ordinal: " + prioridadeMin.ordinal());
		System.out.println("Valor ordinal: " + prioridadeMax.ordinal());
		
		System.out.println("Valor: " + prioridadeMin.getValor());
		System.out.println("Valor: " + prioridadeMax.getValor());
	}

}
