import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PaintImage extends JPanel{
	private Image image;
	private double x;
	private double y;
	private double r;
	private int fcount;
	public PaintImage() throws IOException{
		File input = new File("E:\\eclipsewsj\\ObjectRecog\\penisball.jpg");
		image = ImageIO.read(input);
		image = scaleImage(image);
	}
	
	public void paint(Graphics g){
		 Graphics2D g2d = (Graphics2D)g;
		 image = scaleImage(image);
		 g2d.drawImage(image, 0, 0, null);
		 g2d.setColor(Color.GREEN);
		 g2d.drawOval((int) (x-(r/2)), (int) (y-(r/2)), (int) r, (int) r);
		 g2d.setFont(new Font("TimesRoman",Font.BOLD,70));
		 g2d.drawString("Frame "+fcount, 100, 100);
		 this.removeAll();
		 repaint();
	}
	
	public Image scaleImage(Image frame){	 
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	 	frame = frame.getScaledInstance(d.width, d.height, Image.SCALE_REPLICATE);
		return frame;	
	}
	
	public void queueImage(Image k, double[] ary){
		image = k;
		x = Math.round((ary[0]*1920) / 640.0);
		y = Math.round((ary[1] * 1080) / 480.0);;
		r = ary[2] * 5;
	}
	public void setfcount(int i)
	{
		fcount = i;
	}
}