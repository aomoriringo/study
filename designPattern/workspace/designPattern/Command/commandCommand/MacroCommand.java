package commandCommand;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {

	// ñΩóﬂÇÃèWçá
	private Stack<Command> commands = new Stack<Command>();
	
	// é¿çs
	@Override
	public void execute() {
		Iterator<Command> it = commands.iterator();
		while(it.hasNext()){
			(it.next()).execute();
		}
	}
	
	// í«â¡
	public void append(Command cmd){
		if(cmd != this){
			commands.push(cmd);
		}
	}

	public void undo(){
		if(!commands.empty()){
			commands.pop();
		}
	}
	
	public void clear(){
		commands.clear();
	}
}
