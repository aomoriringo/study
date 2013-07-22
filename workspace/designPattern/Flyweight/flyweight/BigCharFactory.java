package flyweight;

import java.util.HashMap;

public class BigCharFactory {
	// ���ɍ����BigChar�̃C���X�^���X���Ǘ�
	private HashMap<String, BigChar> pool = new HashMap();

	// Singleton�p�^�[��
	private static BigCharFactory singleton = new BigCharFactory();

	private BigCharFactory(){}

	// �B��̃C���X�^���X�𓾂�
	public static BigCharFactory getInstance(){
		return singleton;
	}

	// BigChar�̃C���X�^���X����(���L)
	public synchronized BigChar getBigChar(char charname){
		BigChar bc = (BigChar)pool.get("" + charname);
		if(bc == null){
			bc = new BigChar(charname);
			pool.put("" + charname, bc);
		}
		return bc;
	}
}