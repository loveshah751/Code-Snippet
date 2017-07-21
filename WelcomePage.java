package CodeSnippet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lab1/WelcomePage")
public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name=(String) request.getSession().getAttribute("username");
		Integer id=  (Integer) request.getSession().getAttribute("id");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(name != null && id !=null)
		{
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		    out.println("<head>");
		        out.println("<title>Welcome</title>");
		        out.println("<meta charset=\"UTF-8\">");
		        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		        out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
		    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		    out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/CSS/MyStyling.css' />");
		    out.println("</head>");
		    
		    out.println("<body>");
		    
		    out.println("<div class=\"container\">");
		    
		    out.println("<div class=\"page-header\">");
		    out.println("<div class=\"pull-right\">");
		    out.println("<a href=\"SeeMessage?id="+id+"\"><h3> See Your all Submitted Messages here</h3> </a>");
		    out.println("</div>");
		    out.println("<h1> Welcome Mr."+ name+"</h1>");
		    	out.println("</div>");
		
		    out.println("<div class=\"well\">");
		    out.println("<div class=\"page-header\">");
		    out.println("<h3> Mr."+ name +" thanks for Contacting <b> Mr.Lovepreet singh </b> </h3>");
		    out.println("<div class=\"pull-right\">");
		    out.println("<h4>Mr."+ name+" do you want to send the message again if <b>yes</b><a href=\"ContactwithSession\"> Click here </a> </h4>");
		    out.println("</div>");
		    
		    out.println("</div>");
		    out.println("<div class=\"page-header\">");
		   
		    out.println("<div class=\"pull-left\">");
		    out.println("<h3> <b> Mr.singh</b> <small> typically reply within 24 hours</small> </h3>");
		    out.println("</div>");
		    out.println("</div>");
		  
		    out.println("</div>");
		    
		    
		    out.println("</body>");
			out.println("</html>");
		}
		else{
			response.sendRedirect("Contact");
		}
	
	}



}
