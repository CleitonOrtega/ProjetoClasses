package classesBanco;

public class contaCorrente extends contaBancaria{

	private int talonario = 0;
	
	public contaCorrente() {
		
	}
	
	public contaCorrente(int numConta) {
		super(numConta);
	}
	
	public contaCorrente(int numConta,String nomeConta,String senhaConta, char tipoConta, int talonario) {
		super(numConta,nomeConta,senhaConta,tipoConta);
		this.talonario = talonario;
	}

	public int getTalonario() {
		return talonario;
	}

	public void setTalonario(int talonario) {
		this.talonario = talonario;
	}

	public void emiteTalonario() {
		this.talonario ++;
		System.out.println("Limite de 5 talonarios!");
	}
	
	@Override
	public void emiteExtrato() {
		System.out.println("### Extrato da Conta ###");
		System.out.println();
		System.out.println("N° da Conta:\t\t\t"+ this.getNumConta());
		separador();
		System.out.println("\nSaldo:\t\t\t"+ this.getSaldoConta());
		System.out.println("Talonarios requisitados:\t\t\t"+this.talonario);
	}
	
}
