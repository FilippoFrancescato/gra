
public class Cerchio{
	private Punto centro;
	private int raggio;
	
	public Cerchio(){
		this.centro=new Punto();
		this.raggio=0;
	}
	public Cerchio(Punto c,int r){
		this.centro=new Punto(c);
		this.raggio=r;
	}
	
	public Punto getCentro() {
		return centro;
	}
	public void setCentro(Punto centro) {
		this.centro=new Punto(centro);
	}
	public int getRaggio() {
		return raggio;
	}
	public void setRaggio(int raggio) {
		this.raggio = raggio;
	}
	
	public void sposta(int deltax,int deltay){
		centro.setX(centro.getX()+deltax);
		centro.setY(centro.getY()-deltay);
	}
}
