package CodeSnippet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CodeSnippet/AddSnippet")
public class AddSnippet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		ArrayList<SnippetData> data=new ArrayList<SnippetData>();
		this.getServletContext().setAttribute("Snippet", data);
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Demo  Form</title>");
		out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		  // Main Div
	    out.println("<div class=\"container \" >");
	   
	    out.println("<div  \"class=bg-warning\" >");
     
        out.println("<h1 style=\"text-align:Center;color:orange\" \"class=bg-warning\" > Welcome to Snippet Code  <small style=\"color:red\"> Entry</small></h1>");
        out.println("</div>");
        out.println("    <div class=\"page-header\" style=\"text-align:Center\" >");
        out.println("<h2> Enter the Snippet of<small><b> Programming Languages </b></small> </h2>");
        out.println("</div>");
        out.println("  <div class=\"form-group\">");
        out.println("   <form method=\"post\" action=\"AddSnippet\">");
        
        
    String titleerror= (String) request.getAttribute("TitleError");
    if(titleerror!=null)
    {
    	out.println(" <p style=\" color: red\">"+ titleerror +" </p>");
    }
    	String title=request.getParameter("title")==null ? "":request.getParameter("title");
    	out.println("<label for=\"title\">Title:</label> <input type=\"text\" value=\" "+ title +"\" name=\"title\"  class=\"form-control\" palceholder=\" Enter the Title of Your snippet !\" > <br>");
    	//DropDown Menu  
    	out.println("<div class=\"dropdown\" style=\"text-align:Center\">");
   out.println( " <label for=\"Languages\">Select Langauge:</label><br> ");
    	out.println("<select name=\"language\"> ");
    	  out.println("<option>Html</option>");
    	  out.println("<option>Java</option>");
    	  out.println("<option>C</option>");
    	  out.println("<option >C++</option>");
    	out.println("</select>");
    	  out.println("</div><br>");
    	  String messageerror= (String) request.getAttribute("CodeError");
    	    if(messageerror!=null)
    	    {
    	    	out.println(" <p style=\" color: red\">"+ messageerror +" </p>");
    	    }
    	  String message=request.getParameter("message")==null ?"": request.getParameter("message");
      	out.println("<label for=\"Message\">Syntax of Code:</label><textarea name=\"message\" rows=\"4\" cols=\"5\" class=\"form-control\" placeholder=\"Enter your Message Here\">"+ message+" </textarea><br>");
        out.println("<input type=\"submit\" style=\"background-color:green\" class=\"btn btn-default\" value=\"Submit\">");
      	out.println(" </form>");	
      	out.println("</div> ");
      	out.println("</div> ");
		out.println("</body>");
		out.println("</html>");
		
	
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String title=request.getParameter("title");
		String lanuage=request.getParameter("language");
		String code=request.getParameter("message");
		boolean haserror=false;
		if(title==null || title.trim().length()==0)
		{
			request.setAttribute("TitleError", "Please Enter the Title! ");
			haserror=true;
		}
		
		if(code==null || code.trim().length()==0)
		{
			request.setAttribute("CodeError", "Please Enter the Valid Snippet! ");
			haserror=true;
		}
		
		if(haserror==true)
		{
			doGet(request,response);
		}
		else
		{
		ArrayList<SnippetData> data=  (ArrayList<SnippetData>) getServletContext().getAttribute("Snippet");
		data.add(new SnippetData(title,lanuage,code));
		response.sendRedirect("CodeSnippets");
		}	
}
	}


