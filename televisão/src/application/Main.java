package application;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import application.Lista;
import televisão.Controle;
import televisão.Tv;
import televisão.Smartv;
public class Main {
	public static Tv televisoes[] = new Tv[3];
	static Smartv smart[] = new Smartv[3];
	static int quantidadet=0,quantidader=3,quantidadesmart=0,quantidadetotal=0;
	private static ArrayList<Tv> lista = new ArrayList<>();
	public static ArrayList<Integer> canais = new ArrayList<>(Arrays.asList(1,3,5,7,11));
	public static void main(String[] args) {
		int escolha=0,i;
		Scanner sc = new Scanner(System.in);
		System.out.println("1- Acessar o menu");
		System.out.println("2- Acessar menu-controle");
		System.out.println("3- Sair");
		escolha = sc.nextInt();
		switch(escolha) {
		case 1:
			start(sc);
			break;
		case 2:
			for(i=0;i<quantidader;i++) {
				if(televisoes[i]!=null) {
					start_controle(sc);
				}else {
					System.out.println("Sem televisão");
					main(args);
				}
			}
		case 3:
			break;
		}
		sc.close();
	}
public static void start_controle(Scanner sc) {
	int escolha=0,i=0;
	//Simulando butões do controle
	Controle controleremoto = new Controle();
	System.out.println("Qual o número da tv?");
	i=sc.nextInt();
	System.out.println("1 - Aumentar volume");
	System.out.println("2-  Diminuir volume");
	System.out.println("3 - Alterar canal");
	System.out.println("4 - Ligar/Desligar");
	System.out.println("5 - Alterar conexão");
	System.out.println("6 - Voltar");
	escolha = sc.nextInt();
	switch(escolha) {
	case 1:
		if(televisoes[i].status==true && televisoes[i]!=null) {
		controleremoto.aumentarvolume(televisoes, i);
		start_controle(sc);
		}else if(((Smartv)televisoes[i]).status==true && ((Smartv)televisoes[i])!=null) {
			controleremoto.aumentarvolumesmart(televisoes, i);
			start_controle(sc);
		}else {
			//Tv desligada
			start_controle(sc);
		}
		break;
	case 2:
		if(televisoes[i].status==true && televisoes[i]!=null) {
		controleremoto.diminuirvolume(televisoes, i);
		start_controle(sc);
		}else if(((Smartv)televisoes[i]).status==true && ((Smartv)televisoes[i])!=null) {
			controleremoto.diminuirvolumesmart(televisoes, i);
			start_controle(sc);
		}else {
			//Tv desligada
			start_controle(sc);
		}
		break;
	case 3:
		if(televisoes[i].status==true && televisoes[i]!=null) {
		controleremoto.alterarcanal(televisoes, i, i);
		start_controle(sc);
		}else if(((Smartv)televisoes[i]).status==true && ((Smartv)televisoes[i])!=null) {
			controleremoto.alterarcanalsmart(televisoes, i, i);
			start_controle(sc);
		}else {
			//Tv desligada
			start_controle(sc);
		}
		break;
	case 4:
		if(televisoes[i]!=null) {
		controleremoto.ligar(televisoes, i);
		start_controle(sc);
		}else if(((Smartv)televisoes[i])!=null) {
			controleremoto.ligarsmart(televisoes, i);
			start_controle(sc);
		}else{
			//Tv desligada
			start_controle(sc);
		}
		break;
	case 5:
		if(((Smartv)televisoes[i]).conect=="Desconectado" && ((Smartv)televisoes[i]).modo=="Smartv") {
		controleremoto.conectarsmart(televisoes, i, null, i, i, sc);
		start_controle(sc);
		}else if(((Smartv)televisoes[i]).conect=="Conectado" && ((Smartv)televisoes[i]).modo=="Smartv") {
			controleremoto.desconectarsmart(televisoes, i, null, i, i, sc);
			start_controle(sc);
		}else {
			start_controle(sc);
		}
		break;
	case 6:
		main(new String[]{});
		default:
			start_controle(sc);
	}
}
public static void start(Scanner sc) {
	int escolha=0,n=0,volume=0;
		
	System.out.println("1 - Adicionar TV");
	System.out.println("2 - Alterar volume");
	System.out.println("3 - Alterar canal");
	System.out.println("4 - Ligar/Desligar");
	System.out.println("5 - Listagem ");
	System.out.println("6 - Editar Tv");
	System.out.println("7 - Conectar SmartTv");
	System.out.println("8 - Acessar controle");
	System.out.println("9 - Sair");
	escolha = sc.nextInt();
	switch(escolha) {
	
	case 1:
		criartv(sc);
		break;
	case 2:
		try {
			System.out.println("1- Aumentar");
			System.out.println("2- Abaixar");
			volume = sc.nextInt();
			System.out.println("Qual o número da televisão?");
			n=sc.nextInt();
			if(televisoes[n].status==false) {
				System.out.println("Ligue a televisão");
				start(sc);
			}
			if(televisoes[n] instanceof Smartv && volume==1 && ((Smartv)televisoes[n]).volume<100 && ((Smartv)televisoes[n]).status==true ) {
				((Smartv)televisoes[n]).aumentarvolume();
			}else if(volume==1 && televisoes[n].volume<100 && televisoes[n].status==true) {
				televisoes[n].aumentarvolume();
			}else if(volume==2 && ((Smartv)televisoes[n]).volume>0 && ((Smartv)televisoes[n]).status==true) {
				((Smartv)televisoes[n]).diminuirvolume();
			}else if(volume==2 && televisoes[n].volume>0 && televisoes[n].status==true) {
				televisoes[n].diminuirvolume();
			}
		}catch(NullPointerException e) {
			System.out.println("ERRO!");
			System.out.println("Primeiro crie uma Tv");
		}catch(Exception e) {
			if(televisoes[n]==null) {
				System.out.println("Confira se a tv está ligada");
			}
		}
			finally {
			System.out.println("");
			start(sc);		
		}
		break;
	case 3:
		if(televisoes[n] instanceof Smartv) {
		((Smartv)televisoes[n]).alterarcanal();
		}else {
			televisoes[n].alterarcanal();
		}
		break;
	case 4:
		System.out.println("Qual o número da televisão?");
		n=sc.nextInt();
		televisoes[n].alterarstatus();
		start(sc);
		break;
	case 5:
		lista(sc);
		break;
	case 6 :
		editartv(sc);
		break;
	case 7:
		System.out.println("Qual o número da televisão?");
		n=sc.nextInt();
		if(televisoes[n]instanceof Smartv && ((Smartv)televisoes[n]).status==true) {
		((Smartv)televisoes[n]).conectar();
		}else {
			System.out.println("A Televisão não é uma Smartv ou não está ligada");
			start(sc);
		}
		break;
	case 8 :
		start_controle(sc);
	case 9:
		break;
	default: System.out.println("Opção inválida!");
	start(sc);
	}
}
public static void criartv(Scanner sc) {
	int aux=0,contador=0,tipo=0;
	System.out.println("Qual o tipo de televisão deseja adicionar?");
	System.out.println("1-SmartTv");
	System.out.println("2-Televisão");
	tipo = sc.nextInt();
	if(tipo==1) {	
	System.out.println("Quantidade restante: "+quantidader);
	while(quantidader==0) {
		System.out.println("A quantidade máxima por residência é de 3 TVs");
		System.out.println("Primeiro delete uma tv");
		start(sc);	
	}
	//fim das condicionais
			televisoes[contador] = new Smartv("Sem nome", false, 0, 987654, 123456, "Tv", canais);
		System.out.println("Qual o nome da SmartTV para cadastro?");
		((Smartv)televisoes[quantidadet]).nome = sc.next();
		((Smartv)televisoes[quantidadet]).volume=0;
		((Smartv)televisoes[quantidadet]).login=123456;
		((Smartv)televisoes[quantidadet]).senha=987654;
		((Smartv)televisoes[quantidadet]).status=false;
		((Smartv)televisoes[quantidadet]).receberstatus();
		((Smartv)televisoes[quantidadet]).modo = "Tv";
		((Smartv)televisoes[quantidadet]).canais = canais;
		lista.add(televisoes[quantidadet]);
		aux--;
		quantidadet++;
		quantidader--;
		quantidadetotal++;
		quantidadesmart++;
			start(sc);
	}
	if(tipo==2) {
		System.out.println("Quantidade restante: "+quantidader);
		//Condicionais para acesso
		while(quantidader==0) {
			System.out.println("A quantidade máxima por residência é de 3 TVs");
			System.out.println("Primeiro delete uma tv");
			start(sc);
			
		}
		//fim das condicionais
			for(contador=quantidadet;contador<quantidader;contador++) {
				televisoes[contador] = new Tv("Sem nome",false,0,canais);
			}
			System.out.println("Qual o nome da televisão para cadastro?");
			televisoes[quantidadet].nome = sc.next();
			televisoes[quantidadet].volume=0;
			televisoes[quantidadet].status=false;
			lista.add(televisoes[quantidadet]);
			televisoes[quantidadet].receberstatus();
			quantidadet++;
			quantidader--;
			
			start(sc);
		
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
	public static void lista(Scanner sc) {
		int i=0;
		System.out.println("Quantidade total: "+quantidadet);
		System.out.println("Quantidade restante: "+quantidader);
		System.out.println("Quantide de SmartTvs: "+quantidadesmart);
		for(i=0;i<quantidadet;i++) {
			if(televisoes[i] instanceof Smartv) {
				System.out.print("Smartv número "+i+": "+"Nome "+((Smartv)televisoes[i]).nome+" ");
				System.out.print("Volume "+((Smartv)televisoes[i]).volume+" ");
				System.out.print("Canais "+((Smartv)televisoes[i]).canais.toString()+" ");
				System.out.print("Canal selecionado "+((Smartv)televisoes[i]).canal+" ");
				System.out.print("Status "+((Smartv)televisoes[i]).conferirstatus+" ");
				System.out.print("Conexão "+((Smartv)televisoes[i]).conect+" ");
				System.out.print("Modo "+((Smartv)televisoes[i]).modo+" ");
				System.out.println(" ");
			}else{
			System.out.print("Televisão número "+i+": "+"Nome "+televisoes[i].nome+" ");
			System.out.print("Volume "+televisoes[i].volume+" ");
			System.out.print("Canais "+canais.toString()+" ");
			System.out.print("Canal selecionado "+televisoes[i].canal+" ");
			System.out.print("Status "+televisoes[i].conferirstatus+" ");
			System.out.println(" ");	
			}
		}
		start(sc);
	}
	public static void editartv(Scanner sc) {
		int n=0,i=0,escolher,canal,canal_selecionado;
		System.out.println("O que deseja editar?");
		System.out.println("1- Dados da televisão");
		System.out.println("2- Alterar canais");
		i = sc.nextInt();
		System.out.println("Selecione o número da Tv para ser editada");
		n = sc.nextInt();
				switch(i) {
				case 1:
					if(televisoes[n] instanceof Smartv && i==1) {
						System.out.println("1- Alterar nome");
						System.out.println("2- Alterar login e senha");
						System.out.println("3- Alterar modo");
						escolher=sc.nextInt();
						while(escolher!=1 && escolher!=2 && escolher!=3) {
							System.out.println("Insira novamente");
							escolher=sc.nextInt();
						}
					if(escolher==1) {
						System.out.println("Qual o novo nome?");
						((Smartv)televisoes[n]).nome = sc.next();
						start(sc);
					}else if(escolher==2) {
						System.out.println("Qual o novo login?");
						((Smartv)televisoes[n]).login = sc.nextInt();
						System.out.println("Insira a nova senha");
						((Smartv)televisoes[n]).senha = sc.nextInt();
					}else if(escolher==3 && ((Smartv)televisoes[n]).status==true){
						if(((Smartv)televisoes[n]).modo=="Tv") {
							((Smartv)televisoes[n]).conectar();
							((Smartv)televisoes[n]).alterarmodo();
							start(sc);
						}else {
							((Smartv)televisoes[n]).desconectar();
							((Smartv)televisoes[n]).alterarmodo();
							start(sc);
						}
					}else {
						System.out.println("Certifique-se de ligar a tv");
						start(sc);
					}
					}else if(televisoes[n] instanceof Tv && i==1) {
						System.out.println("Qual o novo nome?");
						televisoes[n].nome = sc.next();
						start(sc);
					}else {
						System.out.println("Selecione novamente!");
						editartv(sc);
					}
					break;	
			   case 2:
				   System.out.println("1- Adicionar canal");
				   System.out.println("2- Remover canal");
				   System.out.println("3- Mudar canal");
				   canal = sc.nextInt();
				   while(canal!=1 && canal!=2 && canal!=3) {
					   System.out.println("Digite novamente");
					   canal=sc.nextInt();
				   }
				   if(canal==1) {
					   System.out.println("Canais existentes:");
					   System.out.println(canais.toString());
					   System.out.println("Insira o canal");
					   canal_selecionado = sc.nextInt();
					   canais.add(canal_selecionado);
					   start(sc);
				   }
				   if(canal==2) {
				  	System.out.println("Canais existentes:");
				  	System.out.println(canais.toString());
				  	System.out.println("Qual a posição do canal deseja remover?");
				  	canal = sc.nextInt();
				  	canais.remove(canal);
				  	start(sc);
				   }
				   if(canal==3) {
					   System.out.println("Selecione o  número da televisão");
					   i=sc.nextInt();
					   if(televisoes[i] instanceof Smartv) {
						   ((Smartv)televisoes[i]).canal = sc.nextInt();
					   }else {
						   televisoes[i].canal=sc.nextInt();
					   }
				   }
				   break;
				 
	}
	
}
}