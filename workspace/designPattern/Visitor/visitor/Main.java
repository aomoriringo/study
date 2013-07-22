package visitor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			System.out.println("Making root entries...");
			
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("dir");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add(new File("vi", 10000));
			bindir.add(new File("latex", 20000));
			rootdir.accept(new ListVisitor());
			
			System.out.println("");
			System.out.println("Making user entries...");
			Directory ringo = new Directory("ringo");
			Directory hanako = new Directory("hanako");
			Directory tomura = new Directory("tomura");
			usrdir.add(ringo);
			usrdir.add(hanako);
			usrdir.add(tomura);
			
			ringo.add(new File("diary.html", 100));
			ringo.add(new File("Composite.java", 200));
			hanako.add(new File("memo.tex", 300));
			tomura.add(new File("game.doc", 400));
			tomura.add(new File("junk.mail", 500));
			rootdir.accept(new ListVisitor());
		}
		catch(FileTreatmentException e){
			e.printStackTrace();
		}
	}

}