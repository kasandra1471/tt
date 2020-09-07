package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JdbcUtil;
import vo.MemberBean;
import vo.MoneyBean;

public class MemberDAO {
	public static MemberDAO instance; // 싱글톤.
	Connection con;
	PreparedStatement pstmt;// 쿼리 전달용 객체, stmt의 개선 버전.
	ResultSet rs;// 쿼리 실행 결과 저장용.

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public ArrayList<MemberBean> selectMemberList() {

		String sql = "select custno, custname, phone, address,to_char(joindate,'YYYY-MM-DD') joindate,"
				+ "decode(grade,'A','VIP','B','일반','직원')	grade,city "
				+ "from member_tbl_02 order by custno asc";
		
		
		ArrayList<MemberBean> memberList = new ArrayList<>();
		MemberBean mb = null;

		try {
			pstmt = con.prepareStatement(sql);
			// 오라클에서 실행할 수 있도록 쿼리문 만들기.

			rs = pstmt.executeQuery();
			// 쿼리문을 이용하여 레코드 추출.

			if (rs.next()) {
				do {
					mb = new MemberBean();
					mb.setCustno(rs.getInt("custno"));
					mb.setCustname(rs.getString("custname"));
					mb.setPhone(rs.getString("phone"));
					mb.setAddress(rs.getString("address"));
					mb.setGrade(rs.getString("grade"));
					mb.setCity(rs.getString("city"));
					mb.setJoindate(rs.getString("joindate"));

					memberList.add(mb);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return memberList;
	}

	public MemberBean selectMember(String id) {

		String sql = "select * from member_tbl_02 where custno=?";
		ArrayList<MemberBean> memberList = new ArrayList<>();
		MemberBean mb = null;

		try {
			pstmt = con.prepareStatement(sql);
			// 오라클에서 실행할 수 있도록 쿼리문 만들기.
			pstmt.setString(1, id);
			// 1: tabindex 라고 해서 물음표의 위치, 0이 아니라 1부터 시작.
			// select * from member_tbl_02 where custno = 1000001
			rs = pstmt.executeQuery();
			// 쿼리문을 이용하여 레코드 추출.

			if (rs.next()) {
				mb = new MemberBean();
				mb.setCustno(rs.getInt("custno"));
				mb.setCustname(rs.getString("custname"));
				mb.setPhone(rs.getString("phone"));
				mb.setAddress(rs.getString("address"));
				mb.setGrade(rs.getString("grade"));
				mb.setCity(rs.getString("city"));
				mb.setJoindate(rs.getString("joindate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return mb;
	}

	public int updateMember(MemberBean mb) {
		String sql = "update member_tbl_02 set custname=?," + "phone=?,address=?,joindate=?,grade=?,"
				+ "city=? where custno=?";
		int updateCnt = 0;

		try {
			pstmt = con.prepareStatement(sql);
			// 오라클에서 실행할 수 있도록 쿼리문 만들기
			pstmt.setString(1, mb.getCustname());
			pstmt.setString(2, mb.getPhone());
			pstmt.setString(3, mb.getAddress());
			pstmt.setString(4, mb.getJoindate());
			pstmt.setString(5, mb.getGrade());
			pstmt.setString(6, mb.getCity());
			pstmt.setInt(7, mb.getCustno());
			updateCnt = pstmt.executeUpdate();
			// update, lnsert , delate....
			// 정상 처리된다면, 0 이외의 숫자값 리턴.
			// Crate, rop 등 (ddl)문들을 실행하는데 사용
			// ( 갱신 카운트를 간주되는)를 나타내는 정수
			// ddl을 사용할 경우 리턴값 : 0 을 리턴
			// DML을 실행 후 아무런 명령을 주지 않는 경우에도 ' 0 ' 을 리턴한다
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return updateCnt;
	}

	public ArrayList<MoneyBean> selectMoneyList() {

		String sql = 
				"select mn.custno, mb.custname," + 
				"        decode(mb.grade,'A','VIP','B','일반','직원') grade," + 
				"		sum(mn.price) total " + 
				"		from money_tbl_02 mn,member_tbl_02 mb " + 
				"		where mn.custno=mb.custno" + 
				"		group by mn.custno, mb.custname,  mb.grade " + 
				"	order by total desc;";

		ArrayList<MoneyBean> moneyList = new ArrayList<>();
		MoneyBean mb = null;

		try {
			pstmt = con.prepareStatement(sql);
			// 오라클에서 실행할 수 있도록 쿼리문 만들기.

			rs = pstmt.executeQuery();
			// 쿼리문을 이용하여 레코드 추출.

			if (rs.next()) {
				do {
					mb = new MoneyBean();
					mb.setCustno(rs.getInt("custno"));
					mb.setCustname(rs.getString("custname"));
					mb.setGrade(rs.getString("grade"));
					mb.setMoney(rs.getInt("total"));

					moneyList.add(mb);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return moneyList;
	}

	public int getSeq() {
		String sql = "select max(custno) custno from " + "member_tbl_02";
		int custno = 100001;
		try {
			rs = con.prepareStatement(sql).executeQuery();
			if (rs.next())
				custno = rs.getInt(1) + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
		}
		return custno;
	}

	public int insertMember(MemberBean member) {		
	
		
		String sql = "insert into member_tbl_02 values ("
				+ "custno_seq.nextval,?,?,?,?,?,?)";
				int insertCount=0;
				try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, member.getCustname());
				pstmt.setString(2, member.getPhone());
				pstmt.setString(3, member.getAddress());
				pstmt.setString(4, member.getJoindate());
				pstmt.setString(5, member.getGrade());
				pstmt.setString(6, member.getCity());
				insertCount = pstmt.executeUpdate();
				}catch(Exception e) {
				e.printStackTrace();
				}finally {
					JdbcUtil.close(pstmt);
				}
				return insertCount;
	}

}