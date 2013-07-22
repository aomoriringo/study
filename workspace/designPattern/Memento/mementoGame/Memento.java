package mementoGame;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	// ������
	int money;
	
	// �t���[�c
	ArrayList<String> fruits;
	
	
	// �������𓾂�
	public int getMoney(){
		return money;
	}
	
	Memento(int money){
		this.money = money;
		this.fruits = new ArrayList<String>();
	}
	
	// �t���[�c��ǉ�����
	void addFruit(String fruit){
		fruits.add(fruit);
	}
	
	// �t���[�c�𓾂�
	List<String> getFruits(){
		return (List<String>)fruits.clone();
	}
}