package CodeSnippet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CodeSnippet/SearchSnippet")
public class SearchSnippet extends HttpServlet {
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
        out.println("<h2> Search Your Snippet that<small><b> you Want ? </b></small> </h2>");
        out.println("</div>");
        out.println("  <div class=\"form-group\">");
        out.println("<form method=\"post\" action=\"SearchSnippet\">");
    
        int id=Integer.parseInt(request.getParameter("id"));
		SnippetData entry=getSnippetid(id);
		
		if(entry==null)
		{
			response.sendRedirect("CodeSnippets");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
