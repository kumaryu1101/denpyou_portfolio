package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.Itemsdao;
import model.dto.Itemsdto;

/**
 * Servlet implementation class ItemInsertServlet
 */
@WebServlet("/ItemInsertServlet")
public class ItemInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ItemInsertServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/iteminsert.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//新規商品を登録する
		request.setCharacterEncoding("UTF-8");
		String itemName = request.getParameter("name");
		String itemPrice = request.getParameter("price");
		int price = Integer.parseInt(itemPrice);
		Itemsdto item = new Itemsdto(itemName, price);
		
		Itemsdao itemdao = Itemsdao.getInstance();//シングルトンパターン
		boolean result = itemdao.insertItem(item);//インサートの戻り値がboolean型
		String url = null;
		if(result) {
			System.out.println("商品登録成功");
			url = "SuccessServlet"; 
		}else {
			System.out.println("商品登録失敗");
			url = "ErrServlet"; 
		}
		
		//リダイレクト
		response.sendRedirect(url);
		
	}

}
