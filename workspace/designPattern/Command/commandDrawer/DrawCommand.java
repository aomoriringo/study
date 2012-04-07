package commandDrawer;

import java.awt.Point;

import commandCommand.Command;

public class DrawCommand implements Command {

	// �`��Ώ�
	protected Drawable drawable;
	
	// �`��ʒu
	private Point position;
	
	public DrawCommand(Drawable drawable, Point position){
		this.drawable = drawable;
		this.position = position;
	}
	
	@Override
	public void execute() {
		drawable.draw(position.x, position.y);
	}

}
