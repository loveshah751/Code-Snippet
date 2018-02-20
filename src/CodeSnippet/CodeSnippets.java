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

//import Demo.Form;

@WebServlet("/CodeSnippet/CodeSnippets")
public class CodeSnippets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException
    {
		  super.init(config);
	
    }
	
	public SnippetData getSnippetid(int id)
	{
		ArrayList<SnippetData> entry= (ArrayList<SnippetData>) this.getServletContext().getAttribute("Snippet");
			 for (SnippetData entries:entry)
			 
				 if(entries.getId()==id)
					 return entries;
				 
			 return null;
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		    out.println("<title></title>");
		    out.println("<meta charset=\"UTF-8\">");
		    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		    out.println("<!-- Latest compiled and minified CSS -->");
		    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"");
		        out.println("crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		// Main Div of My body
		    out.println("<div class=\"container\">");
		    
		    //Div of Code Snippet h1 tag
		        out.println("<div class=\"page-header\">");
		            out.println("<h1>Code Snippets</h1>");
		        out.println("</div>");
		        
		        //div of Horzointal Data like row
		        out.println("<div class=\"row\">");
		        
		        //div of vertical Data like column
		            out.println("<div class=\"col-xs-3\">");
		            // div of Button Add Snippet   
		            out.println("<div class=\"page-header\">");
		                    out.println("<h3>");
		                        out.println("Snippets");
		                        out.println("<small>");
		                            out.println("<a class=\"btn btn-primary\" href=\"AddSnippet\">Add Snippet</a>");
		                        out.println("</small>");
		                    out.println("</h3>");
		                    
		                   
		              //Closing Add Snippet button Div
		                    out.println("</div>");
		                
		                
		                ArrayList<SnippetData> data= (ArrayList<SnippetData>) request.getServletContext().getAttribute("Snippet");
		                for(SnippetData snippet:data)
		                { 	
		                out.println("<ul>");
		 out.println("<li>");
		                        out.println("<a href=\"CodeSnippets?id="+snippet.getId()+ "\">"+ snippet.getTitle()+ "  </a><br>");
		                        out.println(snippet.getLanguage());
		                    out.println("</li>");
		                out.println("</ul>");
		                }
		out.println("</div>");
		int id=Integer.parseInt(request.getParameter("id"));
		SnippetData snippet=getSnippetid(id);
		System.out.println("Id is "+snippet);
		out.println("<div class=\"col-xs-9\">");
		
		                out.println("<div class=\"page-header\">");
		                    out.println("<h3>"+ snippet.getTitle() +" <small>"+ snippet.getLanguage()+"</small></h3>");
		                    // Search Div
//		                    out.println("<div class=\"page-right\">");
//		                    out.println("<h4>");
//		                    out.println("<input type=\"text\" name=\"search\" palceholder=\"Enter Name of snippet \">");
//	                        out.println("<small>");
//	                            out.println("<a class=\"btn btn-primary\" href=\"CodeSnippet?id="+snippet.getId() +"\">Search Snippet</a>");
//	                        out.println("</small>");
//	                    out.println("</h4>");
//	                    out.println("</div>");
//		                    out.println("<p class=\"pull-right\">");
		                        out.println("<a href=\"DeleteSnippet?id="+ snippet.getId()+ "\">Delete</a>");
		                        out.println("<a href=\"EditSnippet?id="+snippet.getId() + "\">Edit</a>");
		                    out.println("</p>");
		                out.println("</div>");
		                out.println("<div class=\"well\">");
		                String code=snippet.getCode();
		                out.println("<pre><code class =\"html \">"+code.replace("<", "&lt")+" </code></pre> ");
		               
		                
		                out.println("</div>");
		                
		                out.println("<div class=\"well\">");
		           
		               String titlename=snippet.getTitle();
		               
		                
		                out.println("</div>");
		                
		            out.println("</div>");
		        out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
