package memento;

import mementoGame.Gamer;
import mementoGame.Memento;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		
		Memento memento = gamer.createMemento();
		
		for(int i=0 ; i<100 ; i++){
			System.out.println("====" + i);
			System.out.println("����:" + gamer);
			
			gamer.bet();
			
			System.out.println("��������" + gamer.getMoney() + "�~�ɂȂ�܂���");
			
			// Memento�̎�舵������
			if(gamer.getMoney() > memento.getMoney()){
				System.out.println("     (�����ԑ������̂ŁA���݂̏�Ԃ�ۑ�)");
				memento = gamer.createMemento();
			}
			else if(gamer.getMoney() < memento.getMoney() / 2){
				System.out.println("     (�����Ԍ������̂ŁA�ȑO�̏�Ԃɕ��A)");
				gamer.restoreMemento(memento);
			}
			
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
			}
			System.out.println("");
		}
		
	}

}
