package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SuccessServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//今は成功画面を表示するだけだが、
		//登録されている商品一覧を表示するようにしても、面白いと思う
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/success.jsp");
		dispatcher.forward(request, response);
	}

	

}
