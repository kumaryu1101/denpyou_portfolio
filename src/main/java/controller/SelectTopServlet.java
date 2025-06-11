package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectTopServlet
 */
@WebServlet("/SelectTopServlet")
public class SelectTopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectTopServlet() {
        super();
    }

	
    //検索画面のTOPページを表示する
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/selecttop.jsp");
		dispatcher.forward(request, response);
	}


}
