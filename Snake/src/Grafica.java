import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class Grafica {

	protected Shell shell;

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
			if (!display.readAndDispatch()) {
				display.sleep();
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
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(10, 50, 400, 400);
		
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
		
		Button btnUp = new Button(shell, SWT.NONE);
		btnUp.setBounds(475, 220, 50, 50);
		btnUp.setText("Up");
		
		Button btnDw = new Button(shell, SWT.NONE);
		btnDw.setBounds(475, 270, 50, 50);
		btnDw.setText("Dw");
		
		Button btnDx = new Button(shell, SWT.NONE);
		btnDx.setBounds(525, 270, 50, 50);
		btnDx.setText("Dx");
		
		Button btnSx = new Button(shell, SWT.NONE);
		btnSx.setBounds(425, 270, 50, 50);
		btnSx.setText("Sx");

	}
}
