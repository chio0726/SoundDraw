import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class DrawPanel extends JPanel {

	Float currentWidth=2.0f;	
	Color currentColor=Color.black;
	
	BufferedImage bufferImage=null;
	Graphics2D bufferGraphics=null;
	
	
	private void createBuffer(int width, int height) {
	       //バッファ用のImageとGraphicsを用意する
			bufferImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
			bufferGraphics = bufferImage.createGraphics(); //getGraphicsと似ているが、戻り値がGraphics2D。
			bufferGraphics.setBackground(Color.white);
			bufferGraphics.clearRect(0, 0, width, height); //バッファクリア
		}	
		
	public void drawLine(int x1, int y1, int x2, int y2){			
		
		if(null==bufferGraphics) {
		 	this.createBuffer(1000, 1000);  
		}//バッファをまだ作ってなければ作る
		 	
			Graphics2D g = (Graphics2D)this.getGraphics();
			//太さがcurrentWidth の線を描く．線の両端は丸くする．
			bufferGraphics.setStroke( new BasicStroke(currentWidth ,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
			bufferGraphics.setColor( currentColor );
		 	//-50することで違和感を解消
		bufferGraphics.drawLine(x1, y1-50, x2, y2-50); // バッファに描画する
		repaint();//再描画するためpaintComponentを呼び		

	}
	
	public void setPenWidth(float newWidth) {
		currentWidth = newWidth;
	}
	
	public void setPenColor( Color newColor) {
		currentColor = newColor;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//他に描画するものがあるかもしれないので親を呼んでおく
		if(null!=bufferImage) g.drawImage(bufferImage, 0,0,this);//バッファを表示する
	}
	
 }