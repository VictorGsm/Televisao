package televis�o;

import java.util.Scanner;

import application.Main;

public abstract class Tv {
	public String nome,conferirstatus;
	public boolean status=false;
	public int volume=0,canal,quantidadet=0,quantidader=5;
	Scanner sc = new Scanner(System.in);
	
	//M�todo construtor
	public Tv(String nome, boolean status, int volume, int canal) {
		this.nome= nome;
		this.status=status;
		this.volume=volume;
		this.canal=canal;
	}
		//Remover Tv
		public void removertv() {
			
		}
		
		//Alterar volume
		public void setvolume() {
			int opc;
			if(status==true) {
			System.out.println("Deseja aumentar ou abaixar?");
			System.out.println("1- Aumentar");
			System.out.println("2- Abaixar");
			opc = sc.nextInt();
			switch(opc) {
			case 1:
				if(volume<100) {
				volume++;
				} else {
					System.out.println("O volume j� est� no m�ximo");
				}
				break;
			case 2:
				if(volume>0) {
				volume--;
				}else { 
					System.out.println("O volume j� est� no m�nimo");
				}
				break;
				default: System.out.println("Op��o inv�lida");
		}
		}else{
			
		}
		}
		//Alterar status
		public void alterarstatus() {
			if(status==false) {
				status=true;
				conferirstatus="ligada";
			} else {
				status=false;
				conferirstatus="Desligada";
			}
			
		}
		//Alterar canal
		public void alterarcanal() {
			if(status==true) {
			System.out.println("Canais v�lidos");
			System.out.println("(1, 3, 5, 7 e 11 )");
			System.out.println("Selecione o canal");
			canal = sc.nextInt();
			while (canal != 1 || canal != 3 || canal != 5 || canal != 7 || canal != 11 ) {
				System.out.println("Canal inv�lido, digite novamente");
				canal = sc.nextInt();		
			}
			}else {
				System.out.println("Ligue a Televis�o primeiro");
				
			}	
		}
}
