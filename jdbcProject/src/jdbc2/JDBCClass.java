package jdbc2;

import java.sql.*;

public class JDBCClass {
	public JDBCClass(){}
	
	public Connection dbConnect(){
		Connection conn = null;
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. db연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"student",
					"student");
			
			//자동 커밋 안되게 처리함
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//emp 테이블의 전체 행 조회 처리용 메소드
	public void selectAll(){
		Connection conn = this.dbConnect();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from emp";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()){
				//결과가 true 이면은 조회된 행이 있다면을 의미함
				String eno = rset.getString("eno");
				String ename = rset.getString("ename");
				String sex = rset.getString("sex");
				String job = rset.getString("job");
				String mgr = rset.getString("mgr");
				Date hdate = rset.getDate("hdate");
				int sal = rset.getInt("sal");
				int comm = rset.getInt("comm");
				String dno = rset.getString("dno");
				
				System.out.println(eno + ", " + ename + ", " + 
						sex + ", " + job + ", " + mgr + ", " + 
						hdate + ", " + sal + ", " + comm + ", " + 
						dno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//emp 테이블의 한 행 조회 처리용 메소드
	public void selectOne(){
		Connection conn = this.dbConnect();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from emp where eno = '2002'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				//결과가 true 이면은 조회된 행이 있다면을 의미
				String eno = rset.getString("eno");
				String ename = rset.getString("ename");
				String sex = rset.getString("sex");
				String job = rset.getString("job");
				String mgr = rset.getString("mgr");
				Date hdate = rset.getDate("hdate");
				int sal = rset.getInt("sal");
				int comm = rset.getInt("comm");
				String dno = rset.getString("dno");
				
				System.out.println(eno + ", " + ename + ", " + 
						sex + ", " + job + ", " + mgr + ", " + 
						hdate + ", " + sal + ", " + comm + ", " + 
						dno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	
	
}















