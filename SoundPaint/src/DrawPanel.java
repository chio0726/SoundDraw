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
	       //�o�b�t�@�p��Image��Graphics��p�ӂ���
			bufferImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
			bufferGraphics = bufferImage.createGraphics(); //getGraphics�Ǝ��Ă��邪�A�߂�l��Graphics2D�B
			bufferGraphics.setBackground(Color.white);
			bufferGraphics.clearRect(0, 0, width, height); //�o�b�t�@�N���A
		}	
		
	public void drawLine(int x1, int y1, int x2, int y2){			
		
		if(null==bufferGraphics) {
		 	this.createBuffer(1000, 1000);  
		}//�o�b�t�@���܂�����ĂȂ���΍��
		 	
			Graphics2D g = (Graphics2D)this.getGraphics();
			//������currentWidth �̐���`���D���̗��[�͊ۂ�����D
			bufferGraphics.setStroke( new BasicStroke(currentWidth ,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
			bufferGraphics.setColor( currentColor );
		 	//-50���邱�Ƃň�a��������
		bufferGraphics.drawLine(x1, y1-50, x2, y2-50); // �o�b�t�@�ɕ`�悷��
		repaint();//�ĕ`�悷�邽��paintComponent���Ă�		

	}
	
	public void setPenWidth(float newWidth) {
		currentWidth = newWidth;
	}
	
	public void setPenColor( Color newColor) {
		currentColor = newColor;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//���ɕ`�悷����̂����邩������Ȃ��̂Őe���Ă�ł���
		if(null!=bufferImage) g.drawImage(bufferImage, 0,0,this);//�o�b�t�@��\������
	}
	
 }