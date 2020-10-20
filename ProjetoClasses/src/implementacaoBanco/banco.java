package implementacaoBanco;

import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

import classesBanco.contaBancaria;

import classesBanco.contaCorrente;

import classesBanco.contaEmpresa;

import classesBanco.contaEspecial;

import classesBanco.contaPoupanca;

public class banco {

	public static final int LIMITE = 10;
	
	public static Scanner leia = new Scanner(System.in);
	public static Random Random = new Random();
	public static Date data = new Date();
	public static Calendar calendario = Calendar.getInstance();
	
	public static contaBancaria Poupanca[] = new contaPoupanca[LIMITE];
	public static contaBancaria Corrente[] = new contaCorrente[LIMITE];
	public static contaBancaria Empresa[] = new contaEmpresa[LIMITE];
	public static contaCorrente Especial[] = new contaEspecial[LIMITE];

	public static char opcaoConta = ' ';
	public static char opcaoCad = ' ';
	public static char cadastroConta = ' ';
	public static char tipoConta = ' ';
	public static char operacaoDesejada = ' ';
	
	public static String cadastroNome = " ";
	public static String cadastroSenha = " ";
	public static String senhaTentativa;
	
	public static int numeroConta;
	public static int numeroSorteado;
	public static int numConta;
	public static int x = 0;
	public static int y = 0;
	public static int z = 0;
	public static int i = 0;
	public static int indice = 0;
	public static int erro = 1;
	public static int primeiroCad = 0;
	public static int numTentativa = 3;
	
	public static double valorDebite;
	public static double valorCredite;
	
	public static Date dataCriacao;
	
	public static void main(String[] args) throws InterruptedException {
		
		//Variaveis
		
		
		do {
			mensagemCadELogin();
			opcaoCad = leia.next().toUpperCase().charAt(0);
			if(opcaoCad != '1' && opcaoCad != '2' && opcaoCad != '3') {
				erroGeral(opcaoCad, 3);
			}
			
			if(opcaoCad == '1') {
				do {
				System.out.println("Cadastro");
				dataCriacao =  calendario.getTime();
				
				System.out.print("Digite o seu Nome: ");
				cadastroNome = leia.next();
				System.out.print("Digite a sua senha(Pode haver letras e numeros!): ");
				cadastroSenha = leia.next();
				System.out.print("Digite o modelo de conta\n1- Conta Poupança\n2 - Conta Corrente\n 3 - Conta Empresa\nModelo escolhido: ");
				cadastroConta = leia.next().charAt(0);
				if(cadastroConta != '1' && cadastroConta != '2' && cadastroConta != '3') {
					erroGeral(cadastroConta, 3);
				}
				Thread.sleep(1500);
				
				confirmacoesInformacoes();
				opcaoCad = leia.next().charAt(0);
				if(opcaoCad != '1' && opcaoCad != '2') {
					erroGeral(opcaoCad, 2);
				}
				
				else if(opcaoCad == '1') {
					numeroSorteado = aleatorioConta();
					
					if(x == 0) {
						Poupanca[x] = new contaPoupanca(numeroSorteado);
					}
					if(y == 0) {
						Corrente[y] = new contaCorrente(numeroSorteado);
					}
					if(z == 0) {
						Empresa[z] = new contaEmpresa(numeroSorteado);
					}
					
					if(primeiroCad > 1) {
					do {
					for(int i = 0;i < LIMITE;i++) {
						if(Poupanca[i].getNumConta() == numeroSorteado ||  Corrente[i].getNumConta() == numeroSorteado || Empresa[i].getNumConta() == numeroSorteado) {
							numeroSorteado = aleatorioConta();
							erro = 1;
						}
						else if (i+1 ==LIMITE) {
							erro = 2;
						}
					}
					}while(erro == 1);
					}
					switch (cadastroConta) {
					
					
						case '1': 
								  
								  Poupanca[x] = new contaPoupanca(numeroSorteado,cadastroNome,cadastroSenha,cadastroConta,dataCriacao);			  
								  System.out.println("Anote as suas informações!");
								  System.out.println("N° da sua conta: "+ Poupanca[x].getNumConta());
								  System.out.println("Nome do titular: "+ Poupanca[x].getNomeConta());
								  System.out.println("Senha da conta: "+Poupanca[x].getSenhaConta());
								  System.out.println("A sua conta é conta Poupança!");
								  System.out.println("Você criou esta conta no dia: "+Poupanca[x].getMesAniversario());
								  Thread.sleep(10000);
								  limpaTela();
								  x++;
								break;
						case '2': 
							      
								  Corrente[y] = new contaCorrente(numeroSorteado,cadastroNome,cadastroSenha,cadastroConta,1);
								  Especial[y] = new contaEspecial(0);
								  System.out.println("N° da sua conta: "+ Corrente[y].getNumConta());
								  System.out.println("Nome do titular: "+ Corrente[y].getNomeConta());
								  System.out.println("Senha da conta: "+Corrente[y].getSenhaConta());
								  System.out.println("A sua conta é conta Corrente!");
								  Thread.sleep(7000);
								  limpaTela();
						  		  y++;
						  		  break;
						case '3': 
								  
								  Empresa[z] = new contaEmpresa(numeroSorteado,cadastroNome,cadastroSenha,cadastroConta, 5000);
								  System.out.println("N° da sua conta: "+ Empresa[z].getNumConta());
								  System.out.println("Nome do titular: "+ Empresa[z].getNomeConta());
								  System.out.println("Senha da conta: "+ Empresa[z].getSenhaConta());
								  System.out.println("A sua conta é conta Empresarial!");
								  Thread.sleep(7000);
								  limpaTela();
				  		  		  z++;
				  		  		  break;
					}
					
				}
				
				
				primeiroCad ++;
				System.out.println("Deseja sair do cadastro e ir para o login?\n1 - Cadastrar outros dados, 2 - Sair para Login\nOpção escolhida: ");
				opcaoCad = leia.next().charAt(0);
				if(opcaoCad != '1' && opcaoCad != '2') {
					erroGeral(opcaoCad, 2);
				}
				}while(opcaoCad != '2');
			}
			limpaTela();
			if(opcaoCad == '2') {
				if(x == 0) {
					Poupanca[x] = new contaPoupanca(numeroSorteado);
				}
				if(y == 0) {
					Corrente[y] = new contaCorrente(numeroSorteado);
				}
				if(z == 0) {
					Empresa[z] = new contaEmpresa(numeroSorteado);
				}
				System.out.println("Login");
				System.out.println();
				System.out.print("Digite o número da sua conta: ");
				numeroConta = leia.nextInt();
				System.out.print("Digite o modelo de conta\n1- Conta Poupança\n2 - Conta Corrente\n3 - Conta Empresa\nO modelo de Conta é: ");
				tipoConta = leia.next().charAt(0);
				if(tipoConta != '1' && tipoConta != '2' && tipoConta != '3') {
					erroGeral(tipoConta, 3);
				}
				
				for (i = 0;i < LIMITE; i++) {
					
					if((numeroConta == Poupanca[i].getNumConta() && tipoConta == '1') || (numeroConta == Corrente[i].getNumConta() && tipoConta == '2') || (numeroConta == Empresa[i].getNumConta() && tipoConta == '3')) {
					
							indice = i;
							break;
					}
				
					else {
						System.out.println("Conta não cadastrada! Tente novamente!");
						System.out.print("Digite o numero da sua conta: ");
						numeroConta = leia.nextInt();
					}
					
				}
				
				if(tipoConta == '1') {
					
						
					while(numTentativa > 0) {
						numTentativa = numTentativa - 1;
						System.out.println();
						System.out.println("Digite sua senha: ");
						senhaTentativa = leia.next();
						if(!senhaTentativa.equals(Poupanca[indice].getSenhaConta())) {
							System.out.println("Senha incorreta você tem "+ numTentativa +" tentativas restantes!");
						}
						else {
							break;
						}
						
					}
					if(numTentativa == 0) {
						System.out.println("Limite de tentativas alcançado tente novamente mais tarde!");
						break;
					}
					
					if(senhaTentativa.equals(Poupanca[indice].getSenhaConta())) {
							
								System.out.println("Bem vindo a sua conta Poupança " + Poupanca[indice].getNomeConta());
								System.out.println();
								
								do {
								System.out.println("Digite a operação desejada\n1-Saldo\t\t\t-2-Emitir Extrato\n3-Depositar dinheiro\t\t\t4-Sacar dinheiro\n5-Sair da conta");
								operacaoDesejada = leia.next().charAt(0);
								if(operacaoDesejada == '1') {
									System.out.println("O saldo atual é:" + Poupanca[indice].getSaldoConta());
									Thread.sleep(5000);
								}
								else if(operacaoDesejada == '2') {
									Poupanca[indice].emiteExtrato();
								}
								else if(operacaoDesejada == '3') {
									System.out.print("Digite a quantidade a ser Creditada: ");
									valorCredite = leia.nextDouble();
									Poupanca[indice].credite(valorCredite);
								}
								else if(operacaoDesejada == '4') {
									System.out.print("Digite a quantidade a ser Debitada: ");
									valorDebite = leia.nextDouble();
									Poupanca[indice].debite(valorDebite);
								}
								else if(operacaoDesejada == '5') {
									System.out.println("Saindo da sua conta\nAguarde...");
									Thread.sleep(3500);
								}
								}while(operacaoDesejada != '5');
							}
					}
				else if(tipoConta == '2') {
					while(numTentativa > 0) {
						numTentativa = numTentativa - 1;
						System.out.println();
						System.out.println("Digite sua senha: ");
						senhaTentativa = leia.next();
						if(!senhaTentativa.equals(Corrente[indice].getSenhaConta())) {
							System.out.println("Senha incorreta você tem "+ numTentativa +" tentativas restantes!");
						}
						else {
							break;
						}
						
					}
					if(numTentativa == 0) {
						System.out.println("Limite de tentativas alcançado tente novamente mais tarde!");
						break;
					}
					
					if(senhaTentativa.equals(Corrente[indice].getSenhaConta())) {
							
								System.out.println("Bem vindo a sua conta Corrente " + Corrente[indice].getNomeConta());
								System.out.println();
								
								do {
									if(Corrente[indice].getSaldoConta() < 3000) {
									System.out.println("Digite a operação desejada\n1-Saldo\t\t\t-2-Emitir Extrato\n3-Depositar dinheiro\t\t\t4-Sacar dinheiro\n5-Emitir Talonario\t\t\t6-Sair da conta");
									operacaoDesejada = leia.next().charAt(0);
									if(operacaoDesejada == '1') {
										System.out.println("O saldo atual é:" + Corrente[indice].getSaldoConta());
										System.out.println("Com os juros selic é: "+ (Corrente[indice].getSaldoConta()+((1.4/100)*Corrente[indice].getSaldoConta())));
										Thread.sleep(5000);
									}
									else if(operacaoDesejada == '2') {
										Corrente[indice].emiteExtrato();
									}
									else if(operacaoDesejada == '3') {
										System.out.print("Digite a quantidade a ser Creditada: ");
										valorCredite = leia.nextDouble();
										Corrente[indice].credite(valorCredite);
									}
									else if(operacaoDesejada == '4') {
										System.out.print("Digite a quantidade a ser Debitada: ");
										valorDebite = leia.nextDouble();
										Corrente[indice].debite(valorDebite);
									}
									else if(operacaoDesejada == '5') {
										if(Especial[indice].getTalonario() < 5) {
										Especial[indice].emiteTalonario();
										System.out.println("Quantidade de talonarios pedidos: "+Especial[indice].getTalonario());
										System.out.println("Você tem direito a mais "+ (5 -Especial[indice].getTalonario()) +" Talonarios!");
										}
										else {
											System.out.println("Limite de talonarios alcançado! entre em contato com o seu gerente!");
										}
									}
									else if(operacaoDesejada == '6') {
										System.out.println("Saindo da sua conta\nAguarde...");
										Thread.sleep(3500);
										break;
									}
									}
									else {
										System.out.println("Cliente Especial! seu saldo é superior a R$3000!");
										System.out.println("Digite a operação desejada\n1-Saldo\t\t\t-2-Emitir Extrato\n3-Depositar dinheiro\t\t\t4-Sacar dinheiro\n5-Emitir Talonario\t\t\t6-Sair da conta");
										operacaoDesejada = leia.next().charAt(0);
										if(operacaoDesejada == '1') {
											System.out.println("O saldo da conta é: " + Corrente[indice].getSaldoConta());
											System.out.println("Com os juros selic é: "+ (Corrente[indice].getSaldoConta()+((1.4/100)*Corrente[indice].getSaldoConta())));
											Thread.sleep(5000);
										}
										else if(operacaoDesejada == '2') {
											Corrente[indice].emiteExtrato();
										}
										else if(operacaoDesejada == '3') {
											System.out.print("Digite a quantidade a ser Creditada: ");
											valorCredite = leia.nextDouble();
											Corrente[indice].credite(valorCredite);
										}
										else if(operacaoDesejada == '4') {
											System.out.print("Digite a quantidade a ser Debitada: ");
											valorDebite = leia.nextDouble();
											Corrente[indice].debite(valorDebite);
										}
										else if(operacaoDesejada == '5') {
											
											if(Especial[indice].getTalonario() < 10) {
												Especial[indice].emiteTalonario();
												System.out.println("Quantidade de talonarios pedidos: "+Especial[indice].getTalonario());
												System.out.println("Você tem direito a mais "+(10- Especial[indice].getTalonario()) +" Talonarios!");
												}
											else {
												System.out.println("Limite de talonarios alcançado! entre em contato com o seu gerente!");
											}
										}
										else if(operacaoDesejada == '6') {
											System.out.println("Saindo da sua conta\nAguarde...");
											Thread.sleep(3500);
											break;
										}
									}
									
								}while(operacaoDesejada != '6');
							}
					}
				}
				else if(tipoConta == '3') {
					if(senhaTentativa.equals(Empresa[indice].getSenhaConta())) {
						
						while(numTentativa > 0) {
							numTentativa = numTentativa - 1;
							System.out.println();
							System.out.println("Digite sua senha: ");
							senhaTentativa = leia.next();
							if(!senhaTentativa.equals(Empresa[indice].getSenhaConta())) {
								System.out.println("Senha incorreta você tem "+ numTentativa +" tentativas restantes!");
							}
							else {
								break;
							}
							
						}
						if(numTentativa == 0) {
							System.out.println("Limite de tentativas alcançado tente novamente mais tarde!");
							break;
						}
						
						if(senhaTentativa.equals(Empresa[indice].getSenhaConta())) {
								
									System.out.println("Bem vindo a sua conta Empresarial " + Empresa[indice].getNomeConta());
									System.out.println();
									
									do {
									System.out.println("Digite a operação desejada\n1-Saldo\t\t\t2-Emitir Extrato\n3-Depositar dinheiro\t\t\t4-Sacar dinheiro\n5-Limite Emprestimo\t\t\t6-Sair da conta");
									operacaoDesejada = leia.next().charAt(0);
									if(operacaoDesejada == '1') {
										System.out.println("O saldo atual é:" + Empresa[indice].getSaldoConta());
										Thread.sleep(5000);
									}
									else if(operacaoDesejada == '2') {
										Empresa[indice].emiteExtrato();
									}
									else if(operacaoDesejada == '3') {
										System.out.print("Digite a quantidade a ser Creditada: ");
										valorCredite = leia.nextDouble();
										Empresa[indice].credite(valorCredite);
									}
									else if(operacaoDesejada == '4') {
										System.out.print("Digite a quantidade a ser Debitada: ");
										valorDebite = leia.nextDouble();
										Empresa[indice].debite(valorDebite);
									}
									else if(operacaoDesejada == '5') {
										System.out.println("Limite atual para emprestimo: "+(Empresa[indice].getSaldoConta()*2));
										
									}
									else if(operacaoDesejada == '6') {
										System.out.println("Saindo da sua conta\nAguarde...");
										Thread.sleep(3500);
									}
									}while(operacaoDesejada != '6');
								}
					}
				
			}else {
				System.out.println("Saindo do Aplicativo...");
				Thread.sleep(5000);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			do {
			
			//System.out.println("Deseja continuar na conta " + Corrente.getNumConta() +"\n1 - Sim, 2 - Não ou 3 - Sair da Aplicação");
			opcaoConta = leia.next().toUpperCase().charAt(0);
			if(opcaoConta != '1' && opcaoConta != '2' && opcaoConta != '3') {
			erroGeral(opcaoConta, 3);
			}
			System.out.println(opcaoConta);
		}while(opcaoConta == '1');
		
			
			
			
			
			
			
			
		
		}while(opcaoConta == '1');
	}
	
	
	
	
	
public static int procuraCadastro() {
		
	int i;
	do {
	numeroSorteado = aleatorioConta();
	System.out.println(numeroSorteado);
		for (i = 0; i < LIMITE; i++) {
			System.out.println(Poupanca[i].getNumConta());
			if (Poupanca[i].getNumConta() == (numeroSorteado)) {
				return i = -1;
			}
			
		}
	}while(i < 0);
	return numeroSorteado;
	}
	
public static void mensagemCadELogin() {
	System.out.println("Deseja se cadastrar no OrtegaUnion, ou o Sr(a) já tem uma conta?");
	System.out.println("Digite 1 para Cadastro");
	System.out.println("Digite 2 para em uma conta já existente");
	System.out.println("Digite 3 para sair do OrtegaUnion");
	System.out.print("Opção escolhida foi: ");
}
	
	
public static int aleatorioConta() {
	return Random.nextInt(1000);
}
	
public static void limpaTela() {
	for(x = 0 ; x < 40; x++) {
		System.out.println();
	}
}

public static void confirmacoesInformacoes() {
	System.out.println("Confirmação de informações!");
	System.out.println();
	System.out.println("Nome completo: " + cadastroNome);
	System.out.println("Senha escolhida: " + cadastroSenha);
	System.out.println("Modelo de conta escolhido: " + cadastroConta);
	
	System.out.println();
	System.out.println("Deseja confirmar os dados listados?");
	System.out.println("Opções 1 - Sim,2 - Não(Digite o numero): ");
}

public static char erroGeral(char opcao,int numOpcao) {
	if(numOpcao == 2) {
		while (opcao != '1' && opcao != '2') {
			System.out.print("Opção inválida tente novamente!: ");
			opcao = leia.next().charAt(0);
			}
	}else {
	while (opcao != '1' && opcao != '2' && opcao != '3') {
		System.out.print("Opção inválida tente novamente!: ");
		opcao = leia.next().charAt(0);
		}
	}
	cadastroConta = opcao;
	opcaoCad = opcao;
	return opcaoConta = opcao;
	}
}

