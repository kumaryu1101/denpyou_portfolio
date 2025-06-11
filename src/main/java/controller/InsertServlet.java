package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.Itemsdao;
import model.dao.Slipsdao;
import model.dto.Itemsdto;
import model.dto.SlipInsertdto;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストスコープにitem(商品ID、商品名、単価)を保存する
		List<Itemsdto> itemsdtolist = new ArrayList<>();
		ServletContext application = this.getServletContext();
		Itemsdao item = Itemsdao.getInstance();//シングルトンパターン
		itemsdtolist = item.selectAllItem();
		request.setAttribute("itemsdtolist", itemsdtolist);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/insert.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//リクエスト取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");//伝票番号
		String itemIdStr = request.getParameter("itemId");//商品ID
		int itemId = Integer.parseInt(itemIdStr);
		
		int number = Integer.parseInt(request.getParameter("number"));//個数
		String date = request.getParameter("date");//日付
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SlipInsertdto slipinsert = new SlipInsertdto(id,itemId,number,d);
		Slipsdao slip = Slipsdao.getInstance();//シングルトンパターン
		boolean isOK = false;
		isOK = slip.insertAllSlip(slipinsert);//戻り値boolean
		
		request.setAttribute("isOK", isOK);//リクエストスコープ
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/insertresult.jsp");
		dispatcher.forward(request,response);
		
	}

}
