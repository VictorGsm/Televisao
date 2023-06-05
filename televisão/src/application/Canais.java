package application;
import java.util.ArrayList;
public class Canais {
	private ArrayList<Integer> canais = new ArrayList<Integer>();
	
	protected void adicionarcanal(Integer canal) {
		canais.add(canal);
	}
	protected void removercanal(Integer canal) {
		canais.remove(canal);
	}
	public ArrayList<Integer> getcanais() {
    	return canais;
    }
}