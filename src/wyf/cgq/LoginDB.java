package wyf.cgq;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;
public class LoginDB{
	public static String studentLogin(String uid,String pwd){//��֤ѧ����¼�ķ���
		String result="fail";								 //��������ʼ�������ַ���
		Connection conn=null;Statement stmt=null;			 // �������ݿ����Ӻ����
		ResultSet rs=null;String sql=null;					 //������������ú�sql���
		try{
			conn=getConnection();							 //������ݿ�����
			if(conn!=null){									 //������ݿ����Ӳ�Ϊ��
				sql="select * from stuuser where stu_no='"+uid+"'"+//����sql���
				" and pwd='"+pwd+"'";
				stmt=conn.createStatement();				//����Statement���
				rs=stmt.executeQuery(sql);					//ִ�в�ѯ����ý����
				if(rs.next()){result="success";}			//�м�¼���û���������ȷ
			}}
		catch(SQLException e){e.printStackTrace();}			//�쳣���������
		finally{
			try{
				if(rs!=null){rs.close();rs=null;}			//�رս����
				if(stmt!=null){stmt.close();stmt=null;}		//�ر����
				if(conn!=null){conn.close();conn=null;}		//�ر����ݿ�����
			}
			catch(SQLException e){e.printStackTrace();}		//�쳣�Ĳ��������		
		}
		return result;										//������֤����ַ���
	}
	public static String teacherLogin(String uid,String pwd){//��֤��ʦ��¼�ķ���
		String result="fail";								 //��������ʼ�������ַ���
		Connection conn=null;Statement stmt=null;			 // �������ݿ����Ӻ����
		String sql=null;ResultSet rs=null;					 //������������ú�sql���
		try{
			conn=getConnection();							 //������ݿ�����
			if(conn!=null){									 //������ݿ����Ӳ�Ϊ��
				sql="select col_no from teacheruser where uid='"+uid+"'"+
				" and pwd='"+pwd+"'";						 //����sql���
				stmt=conn.createStatement();				 //����Statement���
				rs=stmt.executeQuery(sql);					 //ִ�в�ѯ����ý����
				if(rs.next()){result=rs.getString(1);}		 //�м�¼���û���������ȷ
			}}
		catch(SQLException e){e.printStackTrace();}			//�쳣�Ĳ��������
		finally{
			try{
				if(rs!=null){rs.close();rs=null;}			//�رս����
				if(stmt!=null){stmt.close();stmt=null;}		//�ر����
				if(conn!=null){conn.close();conn=null;}		//�ر����ݿ�����
			}
			catch(SQLException e){e.printStackTrace();}		//�쳣�Ĳ��������			
		}
		return result;										//������֤����ַ���
	}
	public static Connection getConnection(){				//������ݿ����ӵķ���
		Connection conn=null;								//�������ݿ���������
		try{
			Context initial=new InitialContext();			//���������
			DataSource ds=(DataSource)initial.lookup("java:comp/env/xsglxt");
			conn=ds.getConnection();						//ͨ������Դ������ݿ�����
		}
		catch(NamingException e){e.printStackTrace();}		//�쳣�Ĳ��������
		catch(SQLException e){e.printStackTrace();}			//�쳣�Ĳ��������
		return conn;										//�������ݿ�����
	}}