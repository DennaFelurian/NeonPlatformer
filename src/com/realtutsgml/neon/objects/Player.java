package com.realtutsgml.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.realtutsgml.neon.framework.GameObject;
import com.realtutsgml.neon.framework.ObjectID;

public class Player extends GameObject{
	
	private float width = 48, height = 96;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	
	public Player(float x, float y, ObjectID id) {
		super(x, y, id);
	
	}

	
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		
		if (falling || jumping) {
			velY += gravity;
			
			if (velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
	}


	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	
	//Collision detect right
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	
	// "" Left
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	
	
	//"" Top
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
}
