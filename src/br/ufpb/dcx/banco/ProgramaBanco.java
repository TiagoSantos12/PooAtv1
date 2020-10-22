package br.ufpb.dcx.banco;

import java.util.ArrayList;

public class ProgramaBanco {
	public static void main(String[] args) {
			SistemaBanco meuBanco = new BancoList("Tiago", "123/321", 
					new ArrayList<Conta>());
			Conta contaTiago = new ContaSimples("000.000.000-00", "111-1", 
					"222-2", 300.00);
			Conta contaJoao = new ContaSimples("111.111.111-11", "333-3", "444-4", 500.00);
			//AbrirConta
			meuBanco.abrirConta(contaJoao);
			meuBanco.abrirConta(contaTiago);
			meuBanco.sacarDeConta("111-1", "222-2", 200);
			meuBanco.depositarConta("111-1", "222-2", 200.00);
			meuBanco.depositarConta("333-3", "444-4", 300.00);
			meuBanco.transferir("111-1", "222-2", "333-3","444-4", 100);
			System.out.println(meuBanco.consultarCntAg("111.111.111-11"));
			System.out.println(meuBanco.consultarCntAg("000.000.000-00"));
			System.out.println("Saldo:" + meuBanco.consultarSaldoDeConta(
					"111-1", "222-2"));
			System.out.println("Saldo:" + meuBanco.consultarSaldoDeConta(
					"333-3", "444-4"));
			}
		}
	
				  
				  
				  
				  
				  
				  
				  
				  
				  

			
			
			
			
			

			
			
			
			
			
	