package televisão;
import application.Main;

import java.util.Scanner;
public class Controle {
	public void aumentarvolume(Tv televisoes[], int i) {
		if(televisoes[i].volume<100) {
			televisoes[i].volume++;
			}
	}
	public void aumentarvolumesmart(Tv televisoes[], int i) {
		if(((Smartv)televisoes[i]).volume<100) {
			((Smartv)televisoes[i]).volume++;
			}
	}
	public void diminuirvolume(Tv televisoes[], int i) {
		if(televisoes[i].volume>0) {
			televisoes[i].volume--;
			}
	}
	public void diminuirvolumesmart(Tv televisoes[], int i) {
		if(((Smartv)televisoes[i]).volume>0) {
			((Smartv)televisoes[i]).volume--;
			}
	}
	public void ligar(Tv televisoes[], int i) {
		if(televisoes[i].status==false) {
			televisoes[i].status=true;
			televisoes[i].conferirstatus="ligada";
		} else {
			televisoes[i].status=false;
			televisoes[i].conferirstatus="Desligada";
		}
	}
	public void ligarsmart(Tv televisoes[], int i) {
		if(((Smartv)televisoes[i]).status==false) {
			((Smartv)televisoes[i]).status=true;
			((Smartv)televisoes[i]).conferirstatus="ligada";
		} else {
			((Smartv)televisoes[i]).status=false;
			((Smartv)televisoes[i]).conferirstatus="Desligada";
		}
	}
	public void alterarcanal(Tv televisoes[], int i, int canal) {
		if(televisoes[i].status==true && Main.canais.contains(canal)){
		televisoes[i].canal = canal;
	}
	}
	public void alterarcanalsmart(Tv televisoes[], int i, int canal) {
		if(((Smartv)televisoes[i]).status==true && Main.canais.contains(canal)){
			((Smartv)televisoes[i]).canal = canal;
		}
		
	}
	public void conectarsmart(Tv televisoes[], int i, String conect, int login, int senha, Scanner sc) {
		System.out.println("Login");
		login = sc.nextInt();
		System.out.println("Senha");
		senha = sc.nextInt();
		if(login==((Smartv)televisoes[i]).login && senha==((Smartv)televisoes[i]).senha) {
		((Smartv)televisoes[i]).conect="Conectado";
		}
}
	public void desconectarsmart(Tv televisoes[], int i, String conect, int login, int senha, Scanner sc) {
		((Smartv)televisoes[i]).conect="Desconectado";
	}
}