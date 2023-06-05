package televisão;

import java.util.Scanner;

import application.Main;

public class Smartv extends Tv {
	public String nome,conferirstatus,conect = "Desconectado";
	public boolean status=false;
	public int volume=0,canal,quantidadet=0,quantidader=5,senha,login,modo;
	Scanner sc = new Scanner(System.in);
	
	//Método construtor
	public Smartv(String nome, boolean status, int volume, int canal, int senha, int login, int modo) {
		super(nome, status, volume, canal);
		this.senha=senha;
		this.login=login;
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
					System.out.println("O volume já está no máximo");
				}
				break;
			case 2:
				if(volume>0) {
				volume--;
				}else { 
					System.out.println("O volume já está no mínimo");
				}
				break;
				default: System.out.println("Opção inv�lida");
		}
		}else {
			
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
			System.out.println("Canais válidos");
			System.out.println("(1, 3, 5, 7 e 11 )");
			System.out.println("Selecione o canal");
			canal = sc.nextInt();
			while (canal != 1 || canal != 3 || canal != 5 || canal != 7 || canal != 11 ) {
				System.out.println("Canal inv�lido, digite novamente");
				canal = sc.nextInt();		
			}
			}else {
				System.out.println("Ligue a Televisão primeiro");
				Main.start(sc);
			}	
		}
		public void conectar() {
			System.out.println("Insira o Login");
			this.login= sc.nextInt();
			System.out.println("Insira a senha");
			this.senha = sc.nextInt();
			if(this.login==login && this.senha==senha) {
				System.out.println("Conectado");
				conect = "Conectado";
			}
		}
		public void alterarmodo(int modo) {
			if(modo==1 && conect=="Conectado") {
				modo=2;
			}else if(modo==2 && conect=="Conectado") {
				modo=1;
			}
		}
}