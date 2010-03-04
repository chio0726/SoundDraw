import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 */

/**
 * @author g0820521
 *
 */

public class SimpleDraw extends JFrame implements ActionListener,
MouseListener, MouseMotionListener 
{
 

	int lastx, lasty, newx, newy;
	float noteNum;
	DrawPanel panel;
	DrawSound sound;
 	
	private void addMenuItem
	(JMenu targetMenu, String itemName, String actionName, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(itemName);
		menuItem.setActionCommand(actionName);
		menuItem.addActionListener(listener);
		targetMenu.add(menuItem);
	}
	
	
	
	private void initMenu() {
		JMenuBar menubar = new JMenuBar();
		
	/*	later!
		JMenu menuFile = new JMenu("File");
		this.addMenuItem(menuFile,"New","New",this);
		this.addMenuItem(menuFile,"Open...","Open",this);
		this.addMenuItem(menuFile,"Save...","Save",this);
		menubar.add(menuFile);
		*/
		
		JMenu menuPen = new JMenu("Pen");

		JMenu menuCol = new JMenu("Color");
		this.addMenuItem(menuCol, "Black", "black", this);
		this.addMenuItem(menuCol, "Green", "green", this);
		this.addMenuItem(menuCol, "Yellow", "yellow", this);
		this.addMenuItem(menuCol, "Red", "red", this);
		
		this.addMenuItem(menuCol, "Cloud", "cloud", this);
		this.addMenuItem(menuCol, "Water", "water", this);
		
		this.addMenuItem(menuCol, "Erase", "white", this);
		this.addMenuItem(menuCol, "other", "other", this);
		this.addMenuItem(menuCol, "Erase", "white", this);
		menuPen.add(menuCol);
		
		
		
		JMenu menuWidth = new JMenu("Width");
		this.addMenuItem(menuWidth, "ç◊", "width5", this);
		this.addMenuItem(menuWidth, "ï¿", "width10", this);
		this.addMenuItem(menuWidth, "ëæ", "width20", this);
		menuPen.add(menuWidth);
		
		
		
		menubar.add(menuPen);
		this.setJMenuBar(menubar);
	}
	
	
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			
		
		//set width
			if(arg0.getActionCommand().equals("width5")) 
				panel.setPenWidth(5);
			else if(arg0.getActionCommand().equals("width10")) 
				panel.setPenWidth(10);
			else if(arg0.getActionCommand().equals("width20")) 
				panel.setPenWidth(20);
			
			
			//set color

			else if(arg0.getActionCommand().equals("other")){
				Color color1 = JColorChooser.showDialog(this, "choose a color", panel.currentColor);
				panel.setPenColor( color1 );
			}
					
			else if(arg0.getActionCommand().equals("green")) 
				panel.setPenColor(Color.green);

			else if(arg0.getActionCommand().equals("black")) 
				panel.setPenColor(Color.black);
			
			else if(arg0.getActionCommand().equals("red")) 
				panel.setPenColor(Color.red);
			
			else if(arg0.getActionCommand().equals("cloud")) 
				panel.setPenColor(Color.lightGray);
			
			else if(arg0.getActionCommand().equals("water")) 
				panel.setPenColor(Color.cyan);

			else if(arg0.getActionCommand().equals("yellow")) 
				panel.setPenColor(Color.blue);
			
			else if(arg0.getActionCommand().equals("white"))
				panel.setPenColor(Color.white);			
			
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	 	lastx=arg0.getX();
	 	lasty=arg0.getY();

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		newx=arg0.getX();
		newy=arg0.getY();
		noteNum = (float)lasty/400;
		if( panel.currentWidth == 20 ){
			sound.play( Math.round( noteNum*47 ) );
		}
		else if( panel.currentWidth == 10 ){
			sound.play( Math.round(noteNum*(95-48) )+48 );
		}
		else{ sound.play(Math.round(noteNum*(127-96))+96 );}
		panel.drawLine(lastx,lasty,newx,newy);
		lastx=newx;
		lasty=newy;
		

	}

 

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void init() {
		
		this.initMenu();
		
		this.setTitle("SoundPaint");
		this.setSize(600, 400);
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		panel=new DrawPanel();
		sound = new DrawSound();
		this.getContentPane().add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPenWidth(10);

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDraw frame=new SimpleDraw();

		frame.init();

	}

}