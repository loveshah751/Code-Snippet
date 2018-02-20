package CodeSnippet;

public class SnippetData
{
static int count =1;
int id; 

	String Title,language,code;
	public SnippetData( String title, String language, String code) 
	{
		id=count++;
		Title = title;
		this.language = language;
		this.code = code;
	}
	public String getTitle() 
	{
		return Title;
	}
	public void setTitle(String title) 
	{
		Title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getId() {
	return id;
}

}
