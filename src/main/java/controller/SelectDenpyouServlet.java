package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.Slipsdao;
import model.dto.ItemSlipdto;


@WebServlet("/SelectDenpyouServlet")
public class SelectDenpyouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectDenpyouServlet() {
        super();
       
    }

	
	//伝票を表示する
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String denpyouId = request.getParameter("slipid");
		
		Slipsdao slipsdao = Slipsdao.getInstance();
		List<ItemSlipdto> itemslipdtolist = slipsdao.selectBySlipId(denpyouId);
		request.setAttribute("sliplist", itemslipdtolist);//リクエストスコープに保存
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/denpyou.jsp");
		dispatcher.forward(request, response);
	}

}
