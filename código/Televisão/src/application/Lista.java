package application;
import java.util.ArrayList;
import televis�o.Tv;
import televis�o.Smartv;
import televis�o.Televis�o;
public class Lista {
    private static ArrayList<Tv> lista = new ArrayList<>();
    
    public static void adicionartv(Televis�o televis�o) {
    	lista.add(televis�o);
    }
    public static void adicionarSmarttv(Smartv smart) {
    	lista.add(smart);
    }
}