package televisão;

import java.util.ArrayList;
import java.util.Scanner;

import application.Main;

public class Smartv extends Tv {
	public String nome,conect = "Desconectado",modo;
	public boolean status=false;
	public int volume=0,canal,quantidadet=0,quantidader=5,senha,login;
	Scanner sc = new Scanner(System.in);
	//Método construtor
	public Smartv(String nome, boolean status, int volume,int senha, int login, String modo, ArrayList<Integer> canais) {
		super(nome, status, volume, canais);
		this.senha=senha;
		this.login=login;
		this.modo=modo;
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
		//Conectar a Smartv
		public void conectar() {
			System.out.println("Insira o Login");
			this.login= sc.nextInt();
			System.out.println("Insira a senha");
			this.senha = sc.nextInt();
			if(this.login==login && this.senha==senha && modo == "Smartv") {
				System.out.println("Conectado");
				conect = "Conectado";
				modo = "SmartTv";
				Main.start(sc);
			}
		}
		public void desconectar() {
			conect = "Desconectado";
			modo = "Tv";
		}
		//Alterar o modo de funcionamento para Tv ou SmartTv
		public void alterarmodo() {
			if(modo=="SmartTv" && conect=="Conectado") {
				modo="Tv";
			}else if(modo=="Tv" && conect=="Desconectado") {
				modo="Smartv";
			}
		}
}