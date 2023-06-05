package application;
import java.util.ArrayList;
import televisão.Tv;
import televisão.Smartv;
import televisão.Televisão;
public class Lista {
    private static ArrayList<Tv> lista = new ArrayList<>();
    
    public static void adicionartv(Televisão televisão) {
    	lista.add(televisão);
    }
    public static void adicionarSmarttv(Smartv smart) {
    	lista.add(smart);
    }
}