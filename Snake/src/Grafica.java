import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class Grafica {
	

	protected Shell shell;
	Canvas canvas;
	private GC gc;
	private int x=200,y=200,r=10;
	private Cerchio c;
	private Punto centro=null;
	private Cerchio mela=null;
	private char verso;

	public void creaMela(){
		mela=new Cerchio(new Punto((int)(Math.random()*40)*10,(int)(Math.random()*40)*10), r);
		gc.drawArc(mela.getCentro().getX()-r, mela.getCentro().getY()-r, r, r, 0, 360);
	}
	
	public void movimento(){
		switch(verso){
			case 'u':
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				c.sposta(0, 10);
				centro=new Punto(c.getCentro());
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				//if(centro.g)
				if(mela.getCentro().getY()+5 == c.getCentro().getY()-5 && mela.getCentro().getX() == c.getCentro().getX()){
					
					creaMela();
				}
				try {
				    Thread.sleep(100);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				break;
			case 'd':
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				c.sposta(0, -10);
				centro=new Punto(c.getCentro());
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				if(mela.getCentro().getY()-5 == c.getCentro().getY()+5 && mela.getCentro().getX() == c.getCentro().getX()){
					creaMela();
				}
				try {
				    Thread.sleep(100);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				break;
			case 'l':
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				c.sposta(-10, 0);
				centro=new Punto(c.getCentro());
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				if(mela.getCentro().getY() == c.getCentro().getY() && mela.getCentro().getX()-5 == c.getCentro().getX()+5){
					creaMela();
				}
				try {
				    Thread.sleep(100);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				break;
			case 'r':
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				c.sposta(10, 0);
				centro=new Punto(c.getCentro());
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				gc.drawArc(centro.getX()-r, centro.getY()-r, r, r, 0, 360);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				if(mela.getCentro().getY() == c.getCentro().getY() && mela.getCentro().getX()+5 == c.getCentro().getX()-5){
					creaMela();
				}
				try {
				    Thread.sleep(100);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				break;
		}
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Grafica window = new Grafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			/*if (!display.readAndDispatch()) {
				display.sleep();
			}*/
			while(!display.readAndDispatch()){
				movimento();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		shell.setSize(600, 520);
		shell.setText("SWT Application");
		
		canvas = new Canvas(shell, SWT.NONE);
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.keyCode){
					case 16777219:
						verso = 'l';
						break;
					case 16777217:
						verso = 'u';
						break;
					case 16777220:
						verso = 'r';
						break;
					case 16777218:
						verso = 'd';
						break;
				}
			}
		});
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(10, 50, 400, 400);
		gc=new GC(canvas);
		
		Label lblPunteggio = new Label(shell, SWT.NONE);
		lblPunteggio.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblPunteggio.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblPunteggio.setBounds(416, 50, 74, 15);
		lblPunteggio.setText("PUNTEGGIO:");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label.setBounds(490, 50, 60, 15);
		label.setText("0");
		
		Label lblSnake = new Label(shell, SWT.NONE);
		lblSnake.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblSnake.setAlignment(SWT.CENTER);
		lblSnake.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSnake.setFont(SWTResourceManager.getFont("Small Fonts", 20, SWT.BOLD));
		lblSnake.setBounds(208, 10, 190, 35);
		lblSnake.setText("SNAKE");
		
		Button btnAvvia = new Button(shell, SWT.NONE);
		btnAvvia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(centro==null){
					centro=new Punto(x,y);
					c=new Cerchio(centro,r);
					gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					gc.fillArc(x-r, y-r, r, r, 0, 360);
					gc.drawArc(x-r, y-r, r, r, 0, 360);
					gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(mela==null){
					creaMela();
				}
			}
		});
		btnAvvia.setBounds(425, 71, 150, 50);
		btnAvvia.setText("Avvia");
		
		
	}
}
