package com.realtutsgml.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.realtutsgml.neon.framework.GameObject;
import com.realtutsgml.neon.framework.ObjectID;

public class Block extends GameObject{
	
	public Block(float x, float y, ObjectID id) {
		super(x, y, id);
	}

	
	public void tick(LinkedList<GameObject> object) {
	}

	
	public void render(Graphics g) {
		//green block as player:
		g.setColor(Color.white);
		//size of player:
		g.drawRect((int)x, (int)y, 32, 32);
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
		}
	}