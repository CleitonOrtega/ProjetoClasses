package classesBanco;

import java.util.Calendar;
import java.util.Date;


public class contaPoupanca extends contaBancaria{

	public static Calendar calendario = Calendar.getInstance();

	private double juros = 2;
	private double correcaoMonetaria = 5;
	private Date mesAniversario = calendario.getTime();
	
	public contaPoupanca() {
		
	}
	
	public contaPoupanca(int numConta) {
		super(numConta);
	}
	
	public contaPoupanca(int numConta,String nomeConta,String senhaConta, char tipoConta) {
		super(numConta,nomeConta,senhaConta,tipoConta);
	}
	
	public contaPoupanca(int numConta,String nomeConta,String senhaConta, char tipoConta,Date mesAniversario) {
		super(numConta,nomeConta,senhaConta,tipoConta,mesAniversario);
	}

	public double getJuros() {
		return juros = this.getSaldoConta() + ((this.juros/100)*this.getSaldoConta());
	}

	public double getCorrecaoMonetaria() {
		return correcaoMonetaria = this.getJuros() + ((this.correcaoMonetaria/100)*this.getJuros());
	}

	public void aniversarioMes() {
		System.out.println("Conta criada na data: "+ this.mesAniversario + ",Proximo aniversário da conta é: ");
	}
	
	@Override
	public void emiteExtrato() {
		System.out.println("### Extrato da Conta ###");
		System.out.println();
		System.out.println("N° da Conta:\t\t\t"+ this.getNumConta());
		separador();
		System.out.println("\nSaldo:\t\t\t"+ this.getSaldoConta());
		System.out.println("Saldo com Juros:\t\t\t"+ this.getJuros());
		System.out.println("Saldo com Juros + Correção monetaria:\t\t\t"+ this.getCorrecaoMonetaria());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Juros gerados com base no seu saldo.");
		System.out.println("Correção monetaria gerada com juros + 5%");
	}
	
}
