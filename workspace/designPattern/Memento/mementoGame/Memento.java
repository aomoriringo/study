package mementoGame;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	// 所持金
	int money;
	
	// フルーツ
	ArrayList<String> fruits;
	
	
	// 所持金を得る
	public int getMoney(){
		return money;
	}
	
	Memento(int money){
		this.money = money;
		this.fruits = new ArrayList<String>();
	}
	
	// フルーツを追加する
	void addFruit(String fruit){
		fruits.add(fruit);
	}
	
	// フルーツを得る
	List<String> getFruits(){
		return (List<String>)fruits.clone();
	}
}
