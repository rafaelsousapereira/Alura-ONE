import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

import anotacoes.IdadeMinima;

public class Usuario {

	private String nome;
	private String cpf;
	@IdadeMinima(valor = 18)
	private LocalDate dataDeNascimento;

	public Usuario(String nome, String cpf, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}

	public boolean usuarioValido(Usuario usuario) {
		if (!usuario.getNome().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")) {
			return false;
		}
		
		if (!usuario.getCpf().matches("[^0-9]+")) {
			return false;
		}
		
		return Period.between(usuario.getDataDeNascimento(), LocalDate.now()).getYears() >= 18;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public static <T> boolean validador(T objeto) {
		
		Class<?> classe = objeto.getClass();
		for (Field field : classe.getDeclaredFields()) {
			if (field.isAnnotationPresent(IdadeMinima.class)) {
				IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);
				try {
					field.setAccessible(true);
					LocalDate dataDeNascimento = (LocalDate) field.get(objeto);
					return Period.between(dataDeNascimento, LocalDate.now()).getYears() >= idadeMinima.valor();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
