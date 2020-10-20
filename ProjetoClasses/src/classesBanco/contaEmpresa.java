package classesBanco;

public class contaEmpresa extends contaBancaria{

	private double limiteEmpresa;
	private double limiteEmprestimoEmpressarial;
	
	public contaEmpresa() {
		
	}
	
	public contaEmpresa(int numConta) {
		super(numConta);
	}
	
	public contaEmpresa(int numConta,String nomeConta,String senhaConta, char tipoConta, int limiteEmpresa) {
		super(numConta,nomeConta,senhaConta,tipoConta);
		this.limiteEmpresa = limiteEmpresa;
	}
	
	public double getLimiteEmpresa() {
		return limiteEmpresa;
	}

	public void setLimiteEmpresa(double limiteEmpresa) {
		this.limiteEmpresa = limiteEmpresa;
	}

	public double getLimiteEmprestimoEmpressarial() {
		return limiteEmprestimoEmpressarial;
	}

	public void setLimiteEmprestimoEmpressarial(double limiteEmprestimoEmpressarial) {
		this.limiteEmprestimoEmpressarial = limiteEmprestimoEmpressarial;
	}

	public void emprestimoEmpressarial() {
		this.limiteEmprestimoEmpressarial = this.limiteEmpresa * 2;
	}
	
	@Override
	public void emiteExtrato() {
		System.out.println("### Extrato da Conta ###");
		System.out.println();
		System.out.println("N° da Conta:\t\t\t"+ this.getNumConta());
		separador();
		System.out.println("\nSaldo:\t\t\t"+ this.getSaldoConta());
	}
	
}
