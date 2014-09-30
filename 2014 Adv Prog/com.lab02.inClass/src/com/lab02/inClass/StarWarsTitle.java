//5631319321 Ramkhana  Cheursawathee
//5631354221 Saris Ophaswongse
package com.lab02.inClass;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;

import javax.swing.JOptionPane;


public class StarWarsTitle extends Applet  implements Runnable {
	int x =0;
	int y =420;
	int delay = 100;
	int fontSize = 60;
	int state =0; //text:0 spaceship:1
	boolean textFinish = false;
	boolean textFinish2 = false;
	int x1Points[] = {520, 540, 600};
	int y1Points[] = {0, -80, -20};
	int x2Points[] = {650, 740, 770};
	int y2Points[] = {-150, -270, -240};
	int x3Points[] = {650, 654, 666};
	int y3Points[] = {-150, -166, -154};
	String message = "A long time ago";
	String message2 = "in a galaxy, far, far away .....";
	Thread textThread;
	Thread spaceShipThread;
	public void init(){
		textThread = new Thread(this);
		spaceShipThread = new Thread(this);
		spaceShipThread.setName("SPACE");
		textThread.setName("TEXT");
		textThread.start();
		spaceShipThread.start();

	}
	public void paint(Graphics g){
		if(!textFinish){
			drawText(g);
		}else{
			drawSpaceship(g);
		}
			
	}
	protected void drawText(Graphics g){
			fontSize -= 2;
			g.setFont(new Font("Dialog",Font.PLAIN,fontSize));
			int textWidth = g.getFontMetrics().stringWidth(message);
			int textWidth2 = g.getFontMetrics().stringWidth(message2);
			int textHeight = g.getFontMetrics().getHeight();
			x = (700-textWidth)/2;
			int x2 = (700-textWidth2)/2;
			y -= 14;
			g.drawString(message, x, y);
			g.drawString(message2, x2, y+textHeight);
			System.out.println(fontSize);
			if(fontSize <= 0){
				textFinish = true;
				textFinish2 = true;
				fontSize = 1;
			}
			
	}
	protected void drawSpaceship(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Polygon ship1 = new Polygon(x1Points, y1Points, 3);
		g.setColor(Color.RED);
		g.fillPolygon(ship1);
		g.drawPolygon(ship1);
		
		Polygon ship2 = new Polygon(x2Points, y2Points, 3);
		g.setColor(Color.BLUE);
		g.fillPolygon(ship2);
		g.drawPolygon(ship2);
		
		Polygon bullet = new Polygon(x3Points, y3Points, 3);
		g.setColor(Color.YELLOW);
		g.fillPolygon(bullet);
		g.drawPolygon(bullet);
		
		Area ship1Area = new Area(ship1);
		Area bulletArea = new Area(bullet);
		ship1Area.intersect(bulletArea);
		if(!ship1Area.isEmpty()){
			x3Points[0] = x2Points[0];
			y3Points[0] = y2Points[0];
			x3Points[1] = x3Points[0] +4;
			y3Points[1] = y3Points[0] -15;
			x3Points[2] = x3Points[0] +16;
			y3Points[2] = y3Points[0] -4;
		}
		for(int i =0; i<x1Points.length; i++){
			x1Points[i] -= 10;
			y1Points[i] += 10;
			x2Points[i] -= 10;
			y2Points[i] += 10;
			x3Points[i] -= 20;
			y3Points[i] += 20;
		}
	}
	public void run(){
		if(Thread.currentThread().getName().equals("SPACE")){
			try {
				textThread.join();
			} catch (InterruptedException e) {}
		}
		System.out.println(Thread.currentThread().getName());
		while(true){
			try{
				if(textFinish2 || x2Points[2] <= 0){ //variable textFinish2 ที่ประกาศไว้ พอจบdrawText ค่ามันจะกลับเป็นค่าที่ initialize ไว้
					textFinish2 = false;
					break;
				}
				this.repaint();
				Thread.sleep(delay);
			  }catch(InterruptedException e){
				  
			  }
		}
		if(Thread.currentThread().getName().equals("SPACE")){
			JOptionPane.showMessageDialog(null, "The End!");
			System.out.print("Close");
		}
	}

}
