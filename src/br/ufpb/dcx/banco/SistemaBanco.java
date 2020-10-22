package br.ufpb.dcx.banco;
	
public interface SistemaBanco {

	public double consultarSaldoDeConta(String numConta, String numAgencia);
	
	public void transferir(String numContaO, String numAgenciaO, String numContaD, 
		String numAgenciaD, double valor);
	
	public void abrirConta(Conta novaConta);
		
	public boolean sacarDeConta(String numConta, String numAgencia, double valor);
		
	public boolean depositarConta(String numConta, String numAgencia, double valor);

	public String consultarCntAg(String cpf);
		
	}