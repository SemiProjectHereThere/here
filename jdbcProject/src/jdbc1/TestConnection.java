package jdbc1;

import java.sql.*;

public class TestConnection {
	public TestConnection(){}
	
	//db 연결을 담당하는 메소드
	public void connection(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공...");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"student",
					"student");
			System.out.println("오라클 연결 성공...");
			
			stmt = conn.createStatement();
			
			String query = "select * from employee where emp_id = '100'";
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				//조회해 온 행에서 각 컬럼별 값을 추출해서 변수에 옮겨 저장
				String empId = rset.getString("emp_id");
				String empName = rset.getString("emp_name");
				String empNo = rset.getString("emp_no");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				java.sql.Date hireDate = rset.getDate("hire_date");
				String jobId = rset.getString("job_id");
				int salary = rset.getInt("salary");
				double bonusPct = rset.getDouble("bonus_pct");
				char marriage = rset.getString("marriage").charAt(0);
				String mgrId = rset.getString("mgr_id");
				String deptId = rset.getString("dept_id");
				
				System.out.println(empId + ", " + empName + ", " + 
						empNo + ", " + email + ", " + phone + ", " + 
						hireDate + ", " + jobId + ", " + salary + ", " +
						bonusPct + ", " + marriage + ", " + mgrId + 
						", " + deptId);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
