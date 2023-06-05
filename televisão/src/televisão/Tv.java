package televisão;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import application.Main;

public class Tv {
	public String nome,conferirstatus;
	public boolean status=false;
	public int volume=0,canal,quantidadet=0,quantidader=5;
	Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> canais = new ArrayList<>(Arrays.asList(1,3,5,7,11));
	//Método construtor
	public Tv(String nome, boolean status, int volume, ArrayList<Integer> canais) {
		this.nome= nome;
		this.status=status;
		this.volume=volume;
		this.canais=canais;
		
	}
	//Utilizando para printar na tela do usuário o status
	public void receberstatus() {
		if(status==true) {
			conferirstatus="ligada";
		} else {
			conferirstatus="Desligada";
		}
	}		
		//Alterar volume
		public void diminuirvolume() {
			volume--;
		}
		public void aumentarvolume() {
			volume++;
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
			Main.canais.toString();
			System.out.println("Selecione o canal");
			canal = sc.nextInt();
			if(Main.canais.contains(canal)){
				canal = sc.nextInt();		
			}else {
				System.out.println("Canal inválido");
			}
			}else {
				System.out.println("Ligue a Televisão primeiro");
				
			}	
		}
}
