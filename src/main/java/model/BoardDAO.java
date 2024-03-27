package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	// 커넥션 풀 사용 오라클 DB 접속 메서드
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// DB접속 메서드
	public void dbConn() {
		try {
			// 1. 외부에서 data를 읽어들이기 위한 Context 생성
			Context initctx = new InitialContext(); // server.xml <Context> 설정과 관련
			System.out.println("1. Context 생성 성공!!");
			// 2. 톰캣 서버에 정보를 담아놓은 곳으로 이동
			Context envctx = (Context)initctx.lookup("java:comp/env"); // lookup() 사용환경 찾기
			System.out.println("2. Context 환경생성 성공!!");
			// 3. DataSource 객체 선언 = 톰캣 server.xml에 코딩한 문자열 값
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool"); // lookup() Reource 찾기
			System.out.println("3. DataSource 찾기 성공!!");
			// 4. DataSource를 기준으로 DB에 Connection 연결
			conn = ds.getConnection();
			System.out.println("4. DB접속 성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //end of dbConn
	
	// 전체보기 메서드
	public ArrayList<BoardVO> getAllBoard(){
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		dbConn();
		try {
			String sql = "select * from test_board order by seq desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bean = new BoardVO();
				bean.setSeq(rs.getInt(1));
				bean.setTitle(rs.getString(2));
				bean.setNickname(rs.getString(3));
				bean.setContent(rs.getString(4));
				bean.setRegdate(rs.getDate(5));
				bean.setCnt(rs.getInt(6));
				bean.setUserid(rs.getString(7));
				
				boardList.add(bean);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	} // end of getAllBoard
	
	// 글등록
	public void writeBoard(BoardVO v) {
		dbConn();
		try {
			String sql = "insert into test_board values(TEST_BOARD_SEQ.nextval,?,?,?,sysdate,0,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getTitle());
			pstmt.setString(2, v.getNickname());
			pstmt.setString(3, v.getContent());
			pstmt.setString(4, v.getUserid());
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of writeBoard
	
	// 글상세
	public BoardVO getInfo(int num) {
		BoardVO info = new BoardVO();
		dbConn();
		try {
		// 조회수 증가
			String sql = "update test_board set cnt=cnt+1 where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt.close();
		// 글상세
			sql = "select * from test_board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				info.setSeq(rs.getInt(1));
				info.setTitle(rs.getString(2));
				info.setNickname(rs.getString(3));
				info.setContent(rs.getString(4));
				info.setRegdate(rs.getDate(5));
				info.setCnt(rs.getInt(6));
				info.setUserid(rs.getString(7));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	} //end of getInfo
	
	// 수정용 글 상세
	public BoardVO getUpdateBoard(int num) {
		BoardVO info = new BoardVO();
		dbConn();
		try {
		// 글상세
			String sql = "select * from test_board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				info.setSeq(rs.getInt(1));
				info.setTitle(rs.getString(2));
				info.setNickname(rs.getString(3));
				info.setContent(rs.getString(4));
				info.setRegdate(rs.getDate(5));
				info.setCnt(rs.getInt(6));
				info.setUserid(rs.getString(7));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	} //end of getUpdateBoard
	
	// 글수정
	public void updateBoard(int num, String title, String content) {
		dbConn();
		try {
			String sql = "update test_board set title=?, content=? where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of updateBoard
	
	//글삭제
	public void deleteBoard(int num) {
		dbConn();
		try {
			String sql = "delete from test_board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of deleteBoard
	
	
	
	
	
	
	
	
	
	
}// end of class
