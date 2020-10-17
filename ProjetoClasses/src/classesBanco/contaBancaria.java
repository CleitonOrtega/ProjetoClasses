package classesBanco;

public abstract class contaBancaria {

	private int numConta;
	private double saldoConta;
	
	public contaBancaria(int numConta) {
		super();
		this.numConta = numConta;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldoConta() {
		return saldoConta;
	}
	
	public void emiteExtrato() {
		System.out.println("Saldo atual \t\t\t" + this.saldoConta);
	}
	
	public double credite(double valorRetirado) {
		return this.saldoConta = saldoConta - valorRetirado;
	}
	
	public double debite(double valorDebitado) {
		return this.saldoConta = saldoConta + valorDebitado;
	}
	
}
