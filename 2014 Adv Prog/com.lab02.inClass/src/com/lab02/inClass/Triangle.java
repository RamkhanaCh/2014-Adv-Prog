package com.lab02.inClass;

import javax.swing.JApplet;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.Color;

public class Triangle extends JApplet {
	public void init() {

	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int x1Points[] = { 0, 60, 80, 0 };
		int y1Points[] = { 60, 0, 40, 60 };
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
				x1Points.length);
		polygon.moveTo(x1Points[0], y1Points[0]);

		for (int index = 1; index < x1Points.length; index++) {
			polygon.lineTo(x1Points[index], y1Points[index]);
		}
		;

		polygon.closePath();
		g2.draw(polygon);
		g2.setPaint(Color.RED);
		g2.fill(polygon);

		/*Graphics2D g3 = (Graphics2D) g;

		int x2Points[] = { 0, 90, 120, 0 };
		int y2Points[] = { 120, 0, 30, 120 };
		GeneralPath polygon2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
				x2Points.length);
		polygon2.moveTo(x2Points[0], y2Points[0]);

		for (int index = 1; index < x2Points.length; index++) {
			polygon2.lineTo(x2Points[index], y2Points[index]);
		}
		;

		polygon2.closePath();
		g3.draw(polygon2);
		g3.setPaint(Color.BLUE);
		g3.fill(polygon2);

		Graphics2D g4 = (Graphics2D) g;

		int x3Points[] = { 0, 20, 30, 0 };
		int y3Points[] = { 20, 0, 10, 20 };
		GeneralPath polygon3 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
				x3Points.length);
		polygon3.moveTo(x3Points[0], y3Points[0]);

		for (int index = 1; index < x3Points.length; index++) {
			polygon3.lineTo(x3Points[index], y3Points[index]);
		}
		;

		polygon3.closePath();
		g4.draw(polygon3);*/

	}
}
