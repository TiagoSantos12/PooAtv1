package br.ufpb.dcx.banco;

import java.util.ArrayList;



public class BancoList implements SistemaBanco{
	private String nome;
	private String cnpj;
	private ArrayList<Conta> contas;

	public BancoList(String nome, String cnpj, 
			ArrayList<Conta> contas) {
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.contas = contas;
	}
	
	

	
	
	public void abrirConta(Conta novaConta) {
		this.contas.add(novaConta);
	}
	
	
	
	
	public void transferir(String numContaO, String numAgenciaO, String numContaD, String numAgenciaD, double valor) {
		Conta contaO = null;
		Conta contaD = null;
		for (Conta c: this.contas) {
			if (c.getNumeroAgencia().equals(numAgenciaO) && c.getNumeroConta().equals(numContaO)){
				contaO = c;
			}
			if (c.getNumeroAgencia().equals(numAgenciaD) && c.getNumeroConta().equals(numContaD)){
				contaD = c;
			}
		}
		if (contaO!=null && contaD!=null) {
			contaO.debitar(valor);
			contaD.creditar(valor);
		}
		
	}
	
	
	
	public double consultarSaldoDeConta(String numConta, String numAgencia) {
		double saldo = 0;
		for (Conta c : this.contas) {
			if (c.getNumeroConta().equals(numConta) 
					&& c.getNumeroAgencia().equals(numAgencia)) {
				saldo = c.getSaldo();
			}
		}
		return saldo;
	}


	public boolean sacarDeConta(String numConta, String numAgencia, double valor) {
		for (Conta c: this.contas) {
			if (c.getNumeroAgencia().equals(numAgencia) && c.getNumeroConta().equals(numConta)){
				c.debitar(valor);
				return true;
			}
		}
		return false;
	}

	
	public boolean depositarConta(String numConta, String numAgencia, double valor) {
		for (Conta c: this.contas) {
			if (c.getNumeroAgencia().equals(numAgencia) && c.getNumeroConta().equals(numConta)){
				c.creditar(valor);
				return true;
			}
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	public String consultarCntAg(String cpf) {
		String conta = "";
		String agencia = "";
		for(Conta c : this.contas) {
			if(c.getCpfTitular().equals(cpf)) {
				 conta = c.getNumeroConta();
				 agencia = c.getNumeroAgencia();
				}
			
			
		}
		return "Conta número " + conta + " Agencia número " + agencia;
}
	
	

	public boolean existeCliente(Conta conta) {
		for(Conta q : this.contas) {
			if (q.getCpfTitular().equals(conta.getCpfTitular())) {
				return true;
			}
		}
		return false;
	}
	public boolean cadastraCliente(Conta conta) {
		if (existeCliente(conta)) {
			return false;
		} else {
			this.contas.add(conta);
			return true;
		}
	}
	
	
}