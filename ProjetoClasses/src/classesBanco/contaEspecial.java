package classesBanco;

public class contaEspecial extends contaCorrente{

	private double limite;

	public contaEspecial() {
		
	}
	
	public contaEspecial(int talonario) {
		super(talonario);
	}
	
	public contaEspecial(double limite) {
		this.limite = limite;
	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public double calculaJuros() {
		return super.getSaldoConta()*1.4;
	}
	
	@Override 
	public void emiteTalonario() {
		this.getTalonario();
		this.setTalonario(this.getTalonario()+1);
	}
	
	@Override
	public void emiteExtrato() {
		System.out.println("### Extrato da Conta ###");
		System.out.println();
		System.out.println("N° da Conta:\t\t\t"+ this.getNumConta());
		separador();
		System.out.println("Saldo:\t\t\t"+ this.getSaldoConta());
	}
	
}
