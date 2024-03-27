package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

@WebServlet("/DeleteBoard.do")
public class DeleteBoard extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	// doGetPost
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 파라미터
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("삭제seq : " + num );
		
		BoardDAO bdao = new BoardDAO();
		bdao.deleteBoard(num);
		
		RequestDispatcher dis = request.getRequestDispatcher("BoardListCtrl.do");
		dis.forward(request, response);
	}

}
