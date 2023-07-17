import java.time.LocalDate;
import java.time.Month;

public class TesteUsuario {

	public static void main(String[] args) {
		Usuario usuario = new Usuario("Mário", "52902488033", LocalDate.of(2006, Month.JANUARY, 13));
		
		System.out.println(Usuario.validador(usuario));
		
		Usuario usuario2 = new Usuario("Mário", "52902488033", LocalDate.of(2000, Month.JANUARY, 10));
		
		System.out.println(Usuario.validador(usuario2));
	}

}
