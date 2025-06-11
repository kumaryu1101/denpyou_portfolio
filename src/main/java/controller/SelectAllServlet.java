package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.Slipsdao;
import model.dto.ItemSlipdto;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/SelectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllServlet() {
        super();
    }
    //指定した日付すべての伝票を検索する
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/history.jsp");
		dispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String statdate = request.getParameter("statdate");
		SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat Format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		String enddate = request.getParameter("enddate");
		Date d2 = null;
		try {
			d1= Format.parse(statdate);//String型でもらったのを日付型に
			d2 = Format2.parse(enddate);//String型でもらったのを日付型に
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Slipsdao slipsdao = Slipsdao.getInstance();//シングルトン
		List<ItemSlipdto> itemslip = new ArrayList<>();
		itemslip = slipsdao.selectAll(d1, d2);//これで日付で検索した伝票一覧リストをもらう
		
		HttpSession session = request.getSession();
		session.setAttribute("itemslip", itemslip);//セッションスコープに保存
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/resultsdisplay.jsp");
		dispatcher.forward(request,response);
		
	}

}
