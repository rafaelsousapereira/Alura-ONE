package heranca;

// interfaces definem um contrato, entao quem assina esse contrato, precisa implementar seus metodos.
	// metodo setSenha
	// metodo autentica
public abstract interface Autenticavel {
	
	public abstract void setSenha(int senha);
	
	public abstract boolean autentica(int senha);
	
}
