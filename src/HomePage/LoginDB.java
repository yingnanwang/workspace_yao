package HomePage;

import java.util.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;
public class LoginDB{
	public static String modelLogin(String uid,String pwd){//锟斤拷证学锟斤拷锟斤拷录锟侥凤拷锟斤拷
		String result="fail";								 //锟斤拷锟斤拷锟斤拷锟斤拷始锟斤拷锟斤拷锟斤拷锟街凤拷锟斤拷
		Connection conn=null;Statement stmt=null;			 // 锟斤拷锟斤拷锟斤拷锟捷匡拷锟斤拷锟接猴拷锟斤拷锟�
		ResultSet rs=null;String sql=null;					 //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷煤锟絪ql锟斤拷锟�
		try{
			conn=getConnection();							 //锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟�
			if(conn!=null){									 //锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷硬锟轿拷锟�
				sql="select * from stuuser where stu_no='"+uid+"'"+//锟斤拷锟斤拷sql锟斤拷锟�
				" and pwd='"+pwd+"'";
				stmt=conn.createStatement();				//锟斤拷锟斤拷Statement锟斤拷锟�
				rs=stmt.executeQuery(sql);					//执锟叫诧拷询锟斤拷锟斤拷媒锟斤拷锟斤拷
				if(rs.next()){result="success";}			//锟叫硷拷录锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷确
			}}
		catch(SQLException e){e.printStackTrace();}			//锟届常锟斤拷锟斤拷锟斤拷锟斤拷锟�
		finally{
			try{
				if(rs!=null){rs.close();rs=null;}			//锟截闭斤拷锟斤拷锟�
				if(stmt!=null){stmt.close();stmt=null;}		//锟截憋拷锟斤拷锟�
				if(conn!=null){conn.close();conn=null;}		//锟截憋拷锟斤拷锟捷匡拷锟斤拷锟斤拷
			}
			catch(SQLException e){e.printStackTrace();}		//锟届常锟侥诧拷锟斤拷锟斤拷锟斤拷锟�		
		}
		return result;										//锟斤拷锟斤拷锟斤拷证锟斤拷锟斤拷址锟斤拷锟�
	}
	public static String photographerLogin(String uid,String pwd){//锟斤拷证锟斤拷师锟斤拷录锟侥凤拷锟斤拷
		String result="fail";								 //锟斤拷锟斤拷锟斤拷锟斤拷始锟斤拷锟斤拷锟斤拷锟街凤拷锟斤拷
		Connection conn=null;Statement stmt=null;			 // 锟斤拷锟斤拷锟斤拷锟捷匡拷锟斤拷锟接猴拷锟斤拷锟�
		String sql=null;ResultSet rs=null;					 //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷煤锟絪ql锟斤拷锟�
		try{
			conn=getConnection();							 //锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟�
			if(conn!=null){									 //锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷硬锟轿拷锟�
				sql="select col_no from teacheruser where uid='"+uid+"'"+
				" and pwd='"+pwd+"'";						 //锟斤拷锟斤拷sql锟斤拷锟�
				stmt=conn.createStatement();				 //锟斤拷锟斤拷Statement锟斤拷锟�
				rs=stmt.executeQuery(sql);					 //执锟叫诧拷询锟斤拷锟斤拷媒锟斤拷锟斤拷
				if(rs.next()){result=rs.getString(1);}		 //锟叫硷拷录锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷确
			}}
		catch(SQLException e){e.printStackTrace();}			//锟届常锟侥诧拷锟斤拷锟斤拷锟斤拷锟�
		finally{
			try{
				if(rs!=null){rs.close();rs=null;}			//锟截闭斤拷锟斤拷锟�
				if(stmt!=null){stmt.close();stmt=null;}		//锟截憋拷锟斤拷锟�
				if(conn!=null){conn.close();conn=null;}		//锟截憋拷锟斤拷锟捷匡拷锟斤拷锟斤拷
			}
			catch(SQLException e){e.printStackTrace();}		//锟届常锟侥诧拷锟斤拷锟斤拷锟斤拷锟�			
		}
		return result;										//锟斤拷锟斤拷锟斤拷证锟斤拷锟斤拷址锟斤拷锟�
	}
	public static Connection getConnection(){				//锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷拥姆锟斤拷锟�
		Connection conn=null;								//锟斤拷锟斤拷锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷锟斤拷
		try{
			Context initial=new InitialContext();			//锟斤拷锟斤拷锟斤拷锟斤拷锟�
			DataSource ds=(DataSource)initial.lookup("java:comp/env/xsglxt");
			conn=ds.getConnection();						//通锟斤拷锟斤拷锟斤拷源锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟�
		}
		catch(NamingException e){e.printStackTrace();}		//锟届常锟侥诧拷锟斤拷锟斤拷锟斤拷锟�
		catch(SQLException e){e.printStackTrace();}			//锟届常锟侥诧拷锟斤拷锟斤拷锟斤拷锟�
		return conn;										//锟斤拷锟斤拷锟斤拷锟捷匡拷锟斤拷锟斤拷
	}}