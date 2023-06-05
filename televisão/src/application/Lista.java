package application;
import java.util.ArrayList;
import televisão.Tv;
import televisão.Smartv;
public class Lista {
    private static ArrayList<Tv> lista = new ArrayList<>();
    
    public static void adicionartv(Tv televisoes[], int i) {
    	lista.add(televisoes[i]);
    }
    public static void adicionarSmarttv(Tv televisoes[], int i) {
    	lista.add(((Smartv)televisoes[i]));
    }
    public static void removerTv(Tv televisoes[], int i) {
    	lista.remove(televisoes[i]);
    }
    public static void removerSmartv(Tv televisoes[], int i) {
    	lista.remove(((Smartv)televisoes[i]));
    }
    public static void mostrartv(Tv televisoes[], int i) {
    	System.out.println(lista.get(i));
    }
 
}