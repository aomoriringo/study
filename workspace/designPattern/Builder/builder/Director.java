package builder;

public class Director {
	private Builder builder;
	
	public Director(Builder builder)
	{
		this.builder = builder;
	}
	
	public void construct()
	{
		builder.makeTitle("Greeting");
		builder.makeString("’©‚©‚ç’‹‚É‚©‚¯‚Ä");
		builder.makeItems(new String[]{
				"‚¨‚Í‚æ‚¤‚²‚´‚¢‚Ü‚·",
				"‚±‚ñ‚É‚¿‚Í",
		});
		
		builder.makeString("–é‚É");
		builder.makeItems(new String[]{
				"‚±‚ñ‚Î‚ñ‚Í",
				"‚¨‚â‚·‚Ý‚È‚³‚¢",
				"‚³‚æ‚¤‚È‚ç"
		});
		builder.close();
	}
}
