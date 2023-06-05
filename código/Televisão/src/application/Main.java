package application;
import java.util.Scanner;
import java.util.ArrayList;
import application.Lista;
import televisão.Tv;
import televisão.Smartv;
import televisão.Televisão;
public class Main {
	public static Tv televisoes[] = new Tv[5];
	static Smartv smart[] = new Smartv[5];
	static Televisão televisao[] = new Televisão[5];
	static int quantidadet=1,quantidader=4,quantidadesmart=0,quantidadetotal=0;
	static Lista lista = new Lista();
	
	public static void main(String[] args) {
		int escolha=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1- Acessar o menu");
		System.out.println("2- Sair");
		escolha = sc.nextInt();
		switch(escolha) {
		case 1:
			start(sc);
			break;
		
		case 2:
			break;
		}
		sc.close();
	}
public static void start(Scanner sc) {
	int escolha=0,n=0;
		
	System.out.println("1 - Adicionar TV");
	System.out.println("2-  Remover TV");
	System.out.println("3 - Alterar volume");
	System.out.println("4 - Alterar canal");
	System.out.println("5 - Ligar/Desligar");
	System.out.println("6 - Listagem ");
	System.out.println("7 - Editar Tv");
	System.out.println("8-  Conectar SmartTv");
	System.out.println("9 - Sair");
	escolha = sc.nextInt();
	switch(escolha) {
	
	case 1:
		criartv(sc);
		break;
	case 2:
		System.out.println("Qual o número da televisão?");
		n=sc.nextInt();
		televisoes[n].removertv();
		break;
	case 3:
		System.out.println("Qual o número da televisão?");
		n=sc.nextInt();
		try {
		televisoes[n].setvolume();
		}catch(Exception e) {
			System.out.println("ERRO!");
			System.out.println("Primeiro crie uma Tv");
		}finally{
			System.out.println("");
			start(sc);
			
		}
		break;
	case 4:
		selecionartv(sc);
		break;
	case 5:
		System.out.println("Qual o número da televisão?");
		n=sc.nextInt();
		televisoes[n].alterarstatus();
		start(sc);
		break;
	case 6:
		lista(sc);
		break;
	case 7 :
		editartv(sc);
		break;
	case 8:
		System.out.println("Qual o número da televisão?");
		n=sc.nextInt();
		smart[n].conectar();
	case 9:
		break;
	default: System.out.println("Opção inválida!");
	}
}
public static void criartv(Scanner sc) {
	int aux=0,contador=1,tipo=0;
	System.out.println("Qual o tipo de televisão deseja adicionar?");
	System.out.println("1-SmartTv");
	System.out.println("2-Televisão");
	tipo = sc.nextInt();
	if(tipo==1) {	
	System.out.println("Quantas televisões deseja adicionar?");
	System.out.println("Quantidade restante: "+quantidader);
	aux = sc.nextInt();
	//Condicionais para acesso
	if(aux<=0) {
	start(sc);	
	}
	while(aux>quantidader) {
		System.out.println("A quantidade máxima por residência é de 5 TVs");
		System.out.println("Selecione novamente");
		aux = sc.nextInt();
		
	}
	//fim das condicionais
	while(aux!=0) {
		for(contador=quantidadet;contador<quantidader;contador++) {
			televisoes[contador] = new Smartv("Sem nome", false, 0, 1, 987654, 123456, 1);
			smart[contador] = (Smartv) televisoes[contador];
		}
		
		System.out.println("Qual o nome da SmartTV para cadastro?");
		televisoes[quantidadet].nome = sc.next();
		televisoes[quantidadet].volume=0;
		televisoes[quantidadet].alterarstatus();
		televisoes[quantidadet].status=false;
		televisoes[quantidadet].canal=1;
		smart[quantidadet].modo = 1;
		smart[quantidadet] = (Smartv) televisoes[quantidadet];
		System.out.println(smart[quantidadet].login);
		lista.adicionarSmarttv(smart[quantidadet]);
		aux--;
		quantidadet++;
		quantidader--;
		quantidadetotal++;
		quantidadesmart++;
		if(aux==0) {
			start(sc);
		}
	}
	}
	if(tipo==2) {
		System.out.println("Quantas televisões deseja adicionar?");
		System.out.println("Quantidade restante: "+quantidader);
		aux = sc.nextInt();
		//Condicionais para acesso
		if(aux<=0) {
		start(sc);	
		}
		while(aux>quantidader) {
			System.out.println("A quantidade máxima por residência é de 5 Televisões");
			System.out.println("Selecione novamente");
			aux = sc.nextInt();
			
		}
		//fim das condicionais
		while(aux!=0) {
			for(contador=quantidadet;contador<quantidader;contador++) {
				televisoes[contador] = new Televisão("Sem nome", false, 0, 1);
				televisao[contador] = (Televisão) televisoes[contador];
			}
			System.out.println("Qual o nome da televisão para cadastro?");
			televisoes[quantidadet].nome = sc.next();
			televisoes[quantidadet].volume=0;
			televisoes[quantidadet].alterarstatus();
			televisoes[quantidadet].status=false;
			televisoes[quantidadet].canal=1;
			lista.adicionartv(televisao[quantidadet]);
			aux--;
			quantidadet++;
			quantidader--;
			
			if(aux==0) {
				start(sc);
			}
		}
		
	}
}
	public static void removertv(Scanner sc) {
	
}
	public static void selecionartv(Scanner sc) {
		int tv=0;
		System.out.println("Selecione a Tv");
		tv = sc.nextInt();
		televisoes[tv].alterarcanal();
	}
	public static void vervolume(Scanner sc) {
		int tv=0;
		System.out.println("Qual o n�mero da TV selecionada?");
		tv = sc.nextInt();
		if(televisoes[tv]==null) {
			System.out.println("Sem televis�o!");
		}else {
		televisoes[tv].setvolume();
		}
	}
	public static void lista(Scanner sc) {
		int i=0;
		System.out.println("Quantidade total: "+quantidadet);
		System.out.println("Quantidade restante: "+quantidader);
		System.out.println("Quantide de SmartTvs: "+quantidadesmart);
		for(i=0;i<quantidadet;i++) {
			
			if(televisoes[i] instanceof Smartv) {
				System.out.println("Smartv ");
				System.out.print(smart[i].nome+" ");
				System.out.print("Volume "+smart[i].volume+" ");
				System.out.print("Canal "+smart[i].canal+" ");
				System.out.print("Status "+smart[i].conferirstatus+" ");
				System.out.println("Conexão "+smart[i].conect+" ");
			}else if(televisoes[i] instanceof Televisão) {
			System.out.print("Televisão número "+i+": "); 
			System.out.print(televisoes[i].nome+" ");
			System.out.print("Volume "+televisoes[i].volume+" ");
			System.out.print("Canal "+televisoes[i].canal+" ");
			System.out.print("Status "+televisoes[i].conferirstatus+" ");
			System.out.println(" ");	
			}
		}
		start(sc);
	}
	public static void editartv(Scanner sc) {
		int n,i=0,escolher;
		System.out.println("O que deseja editar?");
		System.out.println("1- Dados da televisão");
		System.out.println("2- Alterar canais válidos");
		i = sc.nextInt();
				switch(i) {
				case 1:
					System.out.println("Selecione o número da Tv para ser editada");
					n = sc.nextInt();
					if(televisoes[n] instanceof Smartv && i==1) {
						System.out.println("1- Alterar nome");
						System.out.println("2- Alterar login e senha");
						escolher=sc.nextInt();
						while(escolher!=1 && escolher!=2) {
							System.out.println("Insira novamente");
							escolher=sc.nextInt();
						}
					if(escolher==1) {
						System.out.println("Qual o novo nome?");
						televisoes[n].nome = sc.next();
						smart[n].nome = televisoes[n].nome;
						start(sc);
					}else if(escolher==2) {
						System.out.println("Qual o novo login?");
						smart[n].login = sc.nextInt();
					}
					}else if(televisoes[n] instanceof Tv && i==1) {
						System.out.println("Qual o novo nome?");
						televisoes[n].nome = sc.next();
					}break;	
			   case 2:
				   System.out.println("Selecione o número da Tv para ser editada");
					n = sc.nextInt();
					while(televisoes[n]== null) {
						System.out.println("Selecione novamente");
						n=sc.nextInt();
					}
					televisoes[n].canal=sc.nextInt();
					
	}
	
}
}