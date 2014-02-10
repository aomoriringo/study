package abstractFactory;

import abstractFactoryFactory.Factory;
import abstractFactoryFactory.Link;
import abstractFactoryFactory.Page;
import abstractFactoryFactory.Tray;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main abstractFactoryListfactory.ListFactory");
			System.out.println("Example 2: java Main abstractFactoryTablefactory.TableFactory");
			System.exit(0);
		}
		
		Factory factory = Factory.getFactory(args[0]);
		
		Link asahi = factory.createLink("�����V��", "http://www.asahi.com/");
		Link yomiuri = factory.createLink("�ǔ��V��", "http://www.yomiuri.co.jp/");
		
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http//www.google.com/");
		
		Tray traynews = factory.createTray("�V��");
		traynews.add(asahi);
		traynews.add(yomiuri);
		
		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);
		
		Tray traysearch = factory.createTray("�T�[�`�G���W��");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);
		
		Page page = factory.createPage("LinkPage", "ringo");
		page.add(traynews);
		page.add(traysearch);
		page.output();
	}

}