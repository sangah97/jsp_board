package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

@WebServlet("/WriteCtrl.do")
public class WriteCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		BoardDAO bdao = new BoardDAO();
		BoardVO v = new BoardVO();
		v.setTitle(request.getParameter("title"));
		v.setNickname(request.getParameter("nickname"));
		v.setContent(request.getParameter("content"));
		v.setUserid(request.getParameter("userid"));
		
		bdao.writeBoard(v);
		RequestDispatcher dis = request.getRequestDispatcher("BoardListCtrl.do");
		dis.forward(request, response);
	}

}
