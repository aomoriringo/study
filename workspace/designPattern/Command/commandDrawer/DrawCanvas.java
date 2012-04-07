package commandDrawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import commandCommand.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {

	// �`��F
	private Color color = Color.red;
	
	// �`�悷��_�̔��a
	private int radius = 6;
	
	// ����
	private MacroCommand history;

	public DrawCanvas(int width, int height, MacroCommand history){
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}
	
	// ����S�̂��ĕ`��
	public void paint(Graphics g){
		history.execute();
	}
	
	@Override
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius*2, radius*2);
	}

}
