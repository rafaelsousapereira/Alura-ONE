package heranca;

public class TesteReferencia {

	public static void main(String[] args) {
		
		Gerente gerente = new Gerente();
		gerente.setSalario(5000.0);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setSalario(2000.0);
		
		EditorDeVideo editorDeVideo = new EditorDeVideo();
		editorDeVideo.setSalario(2500.0);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(gerente);
		controle.registra(funcionario);
		controle.registra(editorDeVideo);
		
		System.out.println(controle.getSoma());
	}

}
