package flyweight;

import java.util.HashMap;

public class BigCharFactory {
	// 既に作ったBigCharのインスタンスを管理
	private HashMap<String, BigChar> pool = new HashMap();

	// Singletonパターン
	private static BigCharFactory singleton = new BigCharFactory();

	private BigCharFactory(){}

	// 唯一のインスタンスを得る
	public static BigCharFactory getInstance(){
		return singleton;
	}

	// BigCharのインスタンス生成(共有)
	public synchronized BigChar getBigChar(char charname){
		BigChar bc = (BigChar)pool.get("" + charname);
		if(bc == null){
			bc = new BigChar(charname);
			pool.put("" + charname, bc);
		}
		return bc;
	}
}