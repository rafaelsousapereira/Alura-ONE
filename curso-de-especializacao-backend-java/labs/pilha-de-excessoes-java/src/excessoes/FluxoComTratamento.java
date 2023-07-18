package excessoes;

public class FluxoComTratamento {

	public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
        	metodo1();
        } catch (ArithmeticException | NullPointerException | MinhaExcecao ex) {
        	String mensagem = ex.getMessage();
			System.out.println("Exception " + mensagem);
			ex.printStackTrace();
		}
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);
    	metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        
        throw new MinhaExcecao("Deu ruim mano");
    }
}
