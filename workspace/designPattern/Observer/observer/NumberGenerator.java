package observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	
	// Observer������ێ�
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	// Observer��ǉ�
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	
	// Observer���폜
	public void deleteObserver(Observer observer){
		observers.remove(observer);
	}
	
	// Observer�֒ʒm
	public void notifyObservers(){
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()){
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	
	// �����擾����
	public abstract int getNumber();
	
	// ���𐶐�����
	public abstract void execute();
}