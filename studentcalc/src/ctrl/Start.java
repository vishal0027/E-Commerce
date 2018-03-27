package ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Start
 */
@WebServlet({"/Start", "/Startup","/Startup/*"})
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Hello, Got a GET request!");
		PrintWriter out 		= response.getWriter();
		//String parameter 	= request.getParameter("test");
		String principle  	= request.getParameter("principal");
		String period 	 	= request.getParameter("period");
		String intrest 	 	= request.getParameter("interest");
		double first			= (Double.parseDouble(intrest)/1200.0);
		double second		= (Double.parseDouble(principle));
		double temp			= - (Double.parseDouble(period));
		double third			= (1 - Math.pow((1 + first),  temp));
		double result 	 	= (first*second)/ third;
		if(request.getServletPath().startsWith("/Startup")) {
			response.sendRedirect(this.getServletContext().getContextPath()+"/Start");
			return;
		}
		
		out.append("Hello World!")
		.append("\n")
		.append("Client IP: "+ request.getRemoteAddr().toString())
		.append("\n")
		.append("Client Port: "+ request.getRemotePort())
		.append("\n")
		.append("This IP has been Flagged!")
		.append("\n")
		.append("Client Protocol: "+ request.getProtocol())
		.append("\n")
		.append("Client Method: " + request.getMethod())
		.append("\n")
		.append("Query String: " + request.getQueryString())
		.append("\n")
		.append("Query Param foo = null")
		.append("\n")
		.append("Request URL : "+ request.getRequestURI())
		.append("\n")
		.append("Request Servlet Path : " + request.getServletPath())
		.append("\n")
		.append("---- Monthly payments ----")
		.append("\n")
		.append("Based on Principal = " + (principle) + " Period = "+ (period) + " Interest = " + (intrest))
		.append("\n")
		.append("Monthly Payments : " + Double.toString(Math.round(result)))
		.append("\n")
		;

		
		/*
		 out.append("Served at: ")
		 	.append(request.getContextPath())
			.append(
					String.format("\n%s	: %s \n"
						+ "Protocol	: %s \n"
						+ "Method  	: %s	",
						request.getRemoteAddr().toString(),request.getRemotePort(), request.getProtocol().toString(), request.getMethod())
					)
			.append(String.format("\nParameter	: %s", parameter))
			.append("\n")

			.append(this.getServletContext().getInitParameter("appName"))
			.append("\n")
			.append(this.getServletContext().getInitParameter("principle"));
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
