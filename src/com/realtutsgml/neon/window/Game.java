package com.realtutsgml.neon.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import com.realtutsgml.neon.framework.ObjectID;
import com.realtutsgml.neon.objects.Block;
import com.realtutsgml.neon.objects.Test;

public class Game extends Canvas implements Runnable {
	

	private static final long serialVersionUID = -6261436164361361187L;
	
	private boolean running = false;
	private Thread thread;
	
	//Object
	Handler handler;
	
	
	
	private void init() {
		handler = new Handler();
		
	}
	
	//if already started the game, don´t open another window
	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}

	public void run()
	{
		//running with 60fps 
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks= 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS:" +frames + " Ticks;"  + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		
		//Draw Here///////////////////////
		//black background
		g.setColor(Color.black);
		//size of window
		g.fillRect(0, 0, getWidth(), getHeight());
		
		handler.render(g);
		//////////////////////////////////
		g.dispose();
		bs.show();
		
	}
	public static void main(String args []){
		//width, height and title
		new Window (800, 600, "Neon Platform Game Prototype", new Game());
	}
	}


