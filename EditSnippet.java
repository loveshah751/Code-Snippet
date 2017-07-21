package CodeSnippet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CodeSnippet/EditSnippet")
public class EditSnippet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public SnippetData getSnippetid(int id)
	{
		ArrayList<SnippetData> entries= (ArrayList<SnippetData>) this.getServletContext().getAttribute("Snippet");
			 for (SnippetData entry:entries)
			 
				 if(entry.getId()==id)
					 return entry;
			
			 return null;
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(" ");
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
	   
	    out.println("<div style=\"padding-left:400px \" \"class=bg-warning\" >");
     
	    out.println("<h1 style=\"text-align:Center;color:orange\" \"class=bg-warning\" > Welcome to Snippet Code  <small style=\"color:red\"> Entry</small></h1>");
        out.println("</div>");
        out.println("    <div class=\"page-header\" style=\"text-align:Center\" >");
        out.println("<h2> Edit Your Snippet that<small><b> you enter recently </b></small> </h2>");
        out.println("</div>");
        out.println("  <div class=\"form-group\">");
        out.println("<form method=\"post\" action=\"EditSnippet\">");
    
        int id=Integer.parseInt(request.getParameter("id"));
		SnippetData entry=getSnippetid(id);
		
		if(entry==null)
		{
			response.sendRedirect("CodeSnippets");
			return;
		}
		 String titleerror= (String) request.getAttribute("TitleError");
		    if(titleerror!=null)
		    {
		    	out.println(" <p style=\" color: red\">"+ titleerror +" </p>");
		    }
    	String title=request.getParameter("title")==null ?"":request.getParameter("title");
    	out.println("<label for=\"title\">Title:</label><input class=\"form-control\" type=\"text\" value=\" "+ entry.getTitle() +"  \" name=\"title\" palceholder=\" Enter the Title of Your snippet !\" > <br>");
    	//DropDown Menu  
    	if(entry.getLanguage().equals("Java"))
    	{
out.println("<label for=\"option\">Select Language:</label>");
    	out.println("<div class=\"dropdown\">");
    	out.println("<select name=\"language\"> ");
	  	out.println("<option>"+ entry.getLanguage()+"</option>");
    	  out.println("<option>Html</option>");
    	  out.println("<option>C</option>");
    	  out.println("<option >C++</option>");
    	out.println("</select>");
    	}
    	else 	if(entry.getLanguage().equals("Html"))
    	{
    		out.println("<label for=\"option\">Select Language:</label>");
        	out.println("<div class=\"dropdown\">");
        	out.println("<select name=\"language\"> ");
        	out.println("<option>"+ entry.getLanguage()+"</option>");
        	  out.println("<option>Java</option>");
        	  out.println("<option>C</option>");
        	  out.println("<option >C++</option>");
        	out.println("</select>");
    	}
    	else 	if(entry.getLanguage().equals("C"))
    	{
    		out.println("<label for=\"option\">Select Language:</label>");
        	out.println("<div class=\"dropdown\">");
        	out.println("<select name=\"language\"> ");
     		out.println("<option>"+ entry.getLanguage()+"</option>");
        	out.println("<option>Java</option>");
        	  out.println("<option>Html</option>");
       out.println("<option >C++</option>");
        	out.println("</select>");
    	}
    	else
    	{
    		out.println("<label for=\"option\">Select Language:</label>");
        	out.println("<div class=\"dropdown\">");
        	out.println("<select name=\"language\"> ");
       		out.println("<option>"+ entry.getLanguage()+"</option>");
        	out.println("<option>Java</option>");
        	  out.println("<option>Html</option>");
     
        	  out.println("<option >C</option>");
        	out.println("</select>");
    	}
    	  out.println("</div>");
    	  String messageerror= (String) request.getAttribute("CodeError");
  	    if(messageerror!=null)
  	    {
  	    	out.println(" <p style=\" color: red\">"+ messageerror +" </p>");
  	    }
      	String message=request.getParameter("message")==null ?"": request.getParameter("message");
      	out.println("<label for=\"message\">Enter the Syntax :</label><textarea class=\"form-control\" name=\"message\" rows=\"4\" cols=\"5\" placeholder=\"Enter your Message Here\">"+entry.getCode() +" </textarea><br>");
        out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Submit\"><br>");
        out.println("<input type=\"hidden\" value=\"" + id +"\" name=\"id\" >");
        
      	out.println(" </form>");	
      	out.println("</div> ");
      	out.println("</div> ");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		int id=Integer.parseInt(request.getParameter("id"));
		SnippetData entry= getSnippetid(id);
			
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
		
		else{
		entry.setTitle(title);
		entry.setLanguage(lanuage);
		entry.setCode(code);
		
		response.sendRedirect("CodeSnippets");
		}	
	
	}
	
	

}
