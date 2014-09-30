// 5631319321 Ramkhana Cheursawathee

package com.lab01.HW;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class AnimalBanner extends Applet {

	int n = 5;
	Image img[] = new Image[n];
	String name[] = new String[n];
	int x[] = new int[n];
	int height[] = new int[n];
	Animal animalPic[] = new Animal[n];
	int a[] = new int[n];
	int b[] = new int[n];

	public void init() {

		for (int i = 0; i < n; i++) {

			if (name[i] == null) {
				img[i] = null;

			}
			name[i] = getParameter("name" + i);
			img[i] = getImage(getDocumentBase(), name[i] + ".png");

			if ((getParameter("x" + i) != null)
					&& (getParameter("height" + i) != null)) {

				x[i] = Integer.parseInt(getParameter("x" + i));
				height[i] = Integer.parseInt(getParameter("height" + i));
				animalPic[i] = new Animal(name[i], x[i], height[i]);

				a[i] = animalPic[i].getX();
				b[i] = animalPic[i].getHeight();
			}

		}

	}

	public void paint(Graphics g) {
		for (int i = 0; i < n; i++) {
			if (img[i] == null) {
				break;
			}
			g.drawImage(img[i], a[i], 20, 70, b[i], this);

		}

	}

}