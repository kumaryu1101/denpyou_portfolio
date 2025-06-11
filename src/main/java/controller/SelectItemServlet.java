package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.Itemsdao;
import model.dao.Slipsdao;
import model.dto.ItemSlipdto;
import model.dto.Itemsdto;


@WebServlet("/SelectItemServlet")
public class SelectItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectItemServlet() {
        super();

    }

	//商品を検索する
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Itemsdao itemsdao = Itemsdao.getInstance();//シングルトン
		List<Itemsdto> itemlist = itemsdao.selectAllItem();
		//商品一覧リストをリクエストスコープに格納
		request.setAttribute("itemlist", itemlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/selectitem.jsp");
		dispatcher.forward(request, response);
		
	}

	//指定された商品を表示する
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String itemid = request.getParameter("itemId");
		int itemId = Integer.parseInt(itemid); // String型をint型に変換
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = null;
		try {
			startDate = sdf.parse(startdate); // String型をDate型に変換
			endDate = sdf2.parse(enddate); // String型をDate型に変換
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Slipsdao slipsdao = Slipsdao.getInstance();
		List<ItemSlipdto> itemlist = slipsdao.selectByDate(startDate, endDate, itemId);
		//商品一覧リストをリクエストスコープに格納
		request.setAttribute("itemlist", itemlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/resultitem.jsp");
		dispatcher.forward(request, response);
		

		
	}

}
