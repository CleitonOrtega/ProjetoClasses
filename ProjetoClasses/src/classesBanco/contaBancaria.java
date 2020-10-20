package classesBanco;

import java.util.Date;

import java.util.Calendar;

public abstract class contaBancaria {

	public static Calendar calendario = Calendar.getInstance();
	
	private int numConta ;
	private String nomeConta;
	private String senhaConta;
	private char tipoConta;
	private double saldoConta;

	private Date mesAniversario = calendario.getTime();
	
	public contaBancaria() {
		
	}
	
	public contaBancaria(int numConta) {
		this.numConta = numConta;
	}
	
	public contaBancaria(int numConta,String nomeConta,String senhaConta, char tipoConta) {
		this.numConta = numConta;
		this.nomeConta = nomeConta;
		this.senhaConta = senhaConta;
		this.tipoConta = tipoConta;
	}
	
	public contaBancaria(int numConta,String nomeConta,String senhaConta, char tipoConta, Date mesAniversario) {
		this.numConta = numConta;
		this.nomeConta = nomeConta;
		this.senhaConta = senhaConta;
		this.tipoConta = tipoConta;
		this.mesAniversario = mesAniversario;
	}
	
	public Date getMesAniversario() {
		return this.mesAniversario;
	}
	
	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}



	public String getSenhaConta() {
		return senhaConta;
	}



	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}



	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		
	}

	public double getSaldoConta() {
		return saldoConta;
	}
	
	public void settipoConta(char cadastroConta) {
		this.tipoConta = cadastroConta;
	}
	
	public char gettipoConta() {
		return this.tipoConta;
	}
	
	
	
	public double credite(double valorCreditado) {
		return this.saldoConta = saldoConta + valorCreditado;
	}
	
	public double debite(double valorDebitado) {
		return this.saldoConta = saldoConta - valorDebitado;
	}
	
	public abstract void emiteExtrato(); 
	
	
	public void aniversarioMes() {
		System.out.println("Conta criada na data: "+ this.mesAniversario + ",Proximo aniversário da conta é: ");
	}
	
	
	public void separador() {
		 for(int x = 0; x < 20;x++) {
			 System.out.print("_-_-");
		 }
	 }
}
