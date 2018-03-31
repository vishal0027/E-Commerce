package ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

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
		/*
		if(request.getServletPath().startsWith("/Startup")) {
			response.sendRedirect(this.getServletContext().getContextPath()+"/Start");
			return;
		}*/
		
		
		String principle 	= "0.0";
		String period 		= "0.0";
		String intrest 		= "0.0";
		
		if(request.getQueryString() != null) {
			principle  	= request.getParameter("principal");
			period 	 	= request.getParameter("period");
			intrest 	 	= request.getParameter("interest");
			
			double fixedIntrest = 5;
			double gracePeriod = 6;
			double first			= (Double.parseDouble(intrest)/1200.0);
			double second		= (Double.parseDouble(principle));
			double temp			= - (Double.parseDouble(period));
			double third			= (1 - Math.pow((1 + first),  temp));
			double result 	 	= (first*second)/ third;
			Double resultg = ((Double.parseDouble(intrest)/1200.0)*(Double.parseDouble(principle)))/(1 - Math.pow((1 + (Double.parseDouble(intrest)/1200.0)),  - (Double.parseDouble(period))));
			DecimalFormat df = new DecimalFormat("00.00");
			Double graceIntrest =  Double.parseDouble(principle)* ((((Double.parseDouble(intrest))+fixedIntrest)/1200)*gracePeriod);
			resultg = resultg + (graceIntrest/gracePeriod);
			if(request.getParameter("grace") == null) {
				request.setAttribute("monthly", df.format(result));
			}else {
				request.setAttribute("monthly", df.format(resultg));
			}
			request.setAttribute("graceInterest", df.format(graceIntrest));
		 }
		
		if(request.getParameter("calculate") == null) {
			  request.getRequestDispatcher("/UI.jspx").forward(request,response);
		}else {
			 
			  request.getRequestDispatcher("/result.jspx").forward(request,response);
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
