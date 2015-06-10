package wyf.cgq;
import java.util.*;
import java.util.Date;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import javax.faces.model.SelectItem;
public class TeacherDB{
	public static boolean changePwd(String uid,String oldpwd,String newpwd){//�޸�����ķ���
		boolean result=false;		//���ڴ���޸Ľ��
		Connection conn=null;Statement stmt=null;String sql=null;//�������ݿ����Ӽ�Statement��sql���
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){		//������Ӳ�Ϊ��
				sql="update teacheruser set pwd='"+newpwd+"' where uid='"+uid+"' and pwd='"+oldpwd+"'";
				stmt=conn.createStatement();//����sql��估Statement
				int i=stmt.executeUpdate(sql);//ִ��sql���
				if(i==1){result=true;} //������ĳɹ�������true
			}
		}
		catch(Exception e){e.printStackTrace();}//���쳣�Ĵ���
		finally{
			try{if(stmt!=null){stmt.close();stmt=null;}//�ر�Statement���
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}
			catch(SQLException e){e.printStackTrace();}	//	�쳣�������		
		}
		return result;//���ؽ��
	}
	
	public static String getCollById(String colid){//����ѧԺ��Ż��ѧԺ����
		String coll=null;Connection conn=null;Statement stmt=null;//�����������
		String sql=null;ResultSet rs=null;//�����������sql�ַ�������
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//�����Ϊ��
				sql="select col_name from colleges where col_no='"+colid+"'";
				stmt=conn.createStatement();//����Statement���
				rs=stmt.executeQuery(sql);//ִ��SQL���
				if(rs.next()){coll=new String(rs.getString("col_name").getBytes("ISO-8859-1"));
				}//���ѧԺ�����Ʋ�ת��
				}}
		catch(Exception e){e.printStackTrace();}//���쳣�Ĵ���
		finally{try{if(rs!=null){rs.close();rs=null;}//�رս����
				if(stmt!=null){stmt.close();stmt=null;}//�ر�Statement���
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}
			catch(SQLException e){e.printStackTrace();}	//���쳣�Ĵ���			
		}return coll;					//����ѧԺ����
	}
	public static ArrayList<SelectItem> getDeptListByCollid(String colid){//���רҵ�б�ķ���
		ArrayList<SelectItem> al=new ArrayList<SelectItem>();//����רҵ�б�
		Connection conn=null;Statement stmt=null;//�������ݿ����Ӽ����
		String sql=null;ResultSet rs=null;//����sql��估���������
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//�����Ϊ��
				sql="select dept_no,dept_name from depts where col_no='"+colid+"'";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//  �������ִ��SQL
				while(rs.next()){//��������������רҵ��Ϣ�������뵽�б���
					String dept_no=rs.getString("dept_no");
					String dept_name=new String(rs.getString("dept_name").getBytes("ISO-8859-1"));
					al.add(new SelectItem(dept_no,dept_name));
				}}}
		catch(Exception e){e.printStackTrace();}//���쳣�Ĵ���	
		finally{try{if(rs!=null){rs.close();rs=null;}//�رս����
				if(stmt!=null){stmt.close();stmt=null;}//�ر�Statement���
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}
			catch(SQLException e){e.printStackTrace();}	//���쳣�Ĵ���				
		}return al;//����רҵ�б�
	}
	public static ArrayList<SelectItem> getClassListByDeptid(String deptno){
		ArrayList<SelectItem> al=new ArrayList<SelectItem>();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select class_no,class_name from classes where dept_no='"+deptno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String class_no=rs.getString("class_no");
					String class_name=new String(rs.getString("class_name").getBytes("ISO-8859-1"));
					al.add(new SelectItem(class_no,class_name));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return al;
	}
	public static String AddStu(String sno,String sname,String sgender,
	                            int biryear,int birmonth,int birday,
	                            String nativeplace,String collid,String deptid,
	                            String classid,String mianmao,int comeyear,
	                            int comemonth,int comeday)
	{
		String result="addstufail";Connection conn=null;//��������ַ��������ݿ���������
		Statement stmt=null;String sql=null;ResultSet rs=null;//������䣬sql�������
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//�����Ϊ��
				sql="select stu_no from students where stu_no='"+sno+"'";//����sql���
				stmt=conn.createStatement();//����statement���
				rs=stmt.executeQuery(sql);//ִ�����
				if(rs.next()){return "restuadd";}//����м�¼˵����ѧ��ѧ������
				conn.setAutoCommit(false);//�ر��Զ��ύ
				sql="insert into students values('"+sno+"','"+new String(sname.getBytes(),"ISO-8859-1")+"',"+
				     "'"+new String(sgender.getBytes(),"ISO-8859-1")+"',"+
					"'"+biryear+"-"+birmonth+"-"+birday+"','"+new String(nativeplace.getBytes(),"ISO-8859-1")+"','"+collid+"',"+
					"'"+deptid+"','"+classid+"','"+new String(mianmao.getBytes(),"ISO-8859-1")+"','"+comeyear+"-"+comemonth+"-"+comeday+"')";
				int i=stmt.executeUpdate(sql);//ִ��sql��������ѧ��
				if(i!=1){conn.rollback();//���������һ�������ʧ�ܣ��ع�
					conn.setAutoCommit(true);//���Զ��ύ
					return "addstufail";//���ؽ���ַ���
				}
				sql="insert into stuuser values('"+sno+"','"+sno+"')";
				i=stmt.executeUpdate(sql);//��ѧ���û�����������û�
				if(i!=1){conn.rollback(); //���������һ�������ʧ�ܣ��ع�
					conn.setAutoCommit(true);//���Զ��ύ
					return "addstufail";//���ؽ���ַ���
				}conn.commit();result="success";//�ύ�������ַ���
			}}
		catch(Exception e){try{conn.rollback();//���쳣��ع�
				conn.setAutoCommit(true);//���Զ��ύ
			}catch(SQLException ea){ea.printStackTrace();}//���쳣�Ĵ���	
		}
		finally{try{if(rs!=null){rs.close();rs=null;}	//�رս����
				if(stmt!=null){stmt.close();stmt=null;}//�ر����
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}
			catch(SQLException e){e.printStackTrace();}//���쳣�Ĵ���	
		}return result;//���ؽ���ַ���
	}
	public static String[] searchMsg(String sno){//��ѯѧ��������Ϣ�ķ���
		String[] result=new String[10];//�������ѧ��������Ϣ������
		Connection conn=null;Statement stmt=null;//�������ݿ����Ӽ�Statement���
		ResultSet rs=null;String sql=null;//������������ü�sql��������
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){	//������ݿ����Ӳ�Ϊ��
				sql="select stu_no,stu_name,stu_gender,stu_birthday,nativeplace,"+
				      "colleges.col_name,depts.dept_name,classes.class_name,mianmao,cometime "+
				      "from students,colleges,depts,classes where students.col_no=colleges.col_no"
				      +" and students.dept_no=depts.dept_no and students.class_no=classes.class_no"
				      +" and students.stu_no='"+sno+"'";//����SQL���
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//������䲢ִ��
				if(rs.next()){//����ּ�¼��˵���ָ�ѧ�ŵ�ѧ��
					for(int i=0;i<10;i++){//���������ֶ�
						if(i==3||i==9){//��������֯���ַ���
							Date date=rs.getDate(i+1);String year=date.getYear()+1900+"��";
							String month=date.getMonth()+1+"��";String day=date.getDate()+"��";
							result[i]=year+month+day;
						}
						else{result[i]=new String(rs.getString(i+1).getBytes("ISO-8859-1"));
						}//�������ڵ���ֱ�ӻ����ת�뼴��
					}return result;	//�����ַ�������
				}
				else{return null;}//û�и�ѧ���򷵻�null
			}}
		catch(Exception e){e.printStackTrace();}//�쳣�Ĵ������
		finally{try{if(stmt!=null){stmt.close();stmt=null;}//�ر����
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
				if(rs!=null){rs.close();rs=null;}//�رս����
			}
			catch(SQLException e){e.printStackTrace();}	//�쳣�Ĵ������			
		}return result;//���ؽ���ַ�������
	}
	public static ArrayList getGradeList(String sno){//����ѧ�Ż�óɼ����ķ���
		ArrayList al=new ArrayList();//�������ڴ�ųɼ���Ϣ���б�
		Connection conn=null;Statement stmt=null;//�������ݿ����Ӽ�Statement���
		String sql=null;ResultSet rs=null;//������������ü�sql��������
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//������ݿ����Ӳ�Ϊ��
				sql="select course.cou_name,grade.score,course.xuefen from course,grade"+
					" where grade.stu_no='"+sno+"' and grade.isdual=1 and "+
			 		"grade.cou_no=course.cou_no";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//������䲢ִ��
				while(rs.next()){//��������������ɼ���Ϣ�洢���б���
					al.add(new Grade(new String(rs.getString(1).getBytes("ISO-8859-1")),
							rs.getDouble(2),rs.getDouble(3)));}return al;//���سɼ��б�
			}}
		catch(Exception e){	e.printStackTrace();}//�쳣�Ĵ������
		finally{try{if(rs!=null){rs.close();rs=null;}//�رս����
				if(stmt!=null){stmt.close();stmt=null;}//�ر����
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}
			catch(SQLException e){e.printStackTrace();}	//�쳣�Ĵ������			
		}return null;}
		
		public static ArrayList getCourseItemList(String collno){//���ѧԺ����γ��б�ķ���
		ArrayList al=new ArrayList();//������ſγ���Ϣ���б�
		Connection conn=null;Statement stmt=null;//�������ݿ����Ӽ�Statement��������
		String sql=null;ResultSet rs=null;//����sql������������
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//���ݿ������Ѿ����
				sql="select cou_no,cou_name,xuefen,colleges.col_name,depts.dept_name from "+
			       "course,colleges,depts where depts.dept_no=course.dept_no and"+
			       " course.col_no=course.col_no and depts.col_no=colleges.col_no and course.col_no='"+collno+"'";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//����Statement��ִ��sql���
				while(rs.next()){//���������������Ϣ�����б�
					al.add(new CourseItem(new String(rs.getString(1).getBytes("ISO-8859-1")),
							new String(rs.getString(2).getBytes("ISO-8859-1")),
							rs.getDouble(3),new String(rs.getString(4).getBytes("ISO-8859-1")),
							new String(rs.getString(5).getBytes("ISO-8859-1"))));			
				}return al;//�����б�
			}}catch(Exception e){e.printStackTrace();}//�쳣�Ĵ������	
		finally{try{if(rs!=null){rs.close();rs=null;}//�رս����
				if(stmt!=null){stmt.close();stmt=null;}//�ر����
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}catch(SQLException e){e.printStackTrace();}//�쳣�Ĵ������					
		}return null;}//����
		
		
	public static String  addToDB(String courseNo,int day,int times,String teacher,String collno){
		String result="addfail";//��������ַ���������ֵ
		Connection conn=null;Statement stmt=null;String sql=null;ResultSet rs=null;
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//������ݿ����Ӳ�Ϊ��
				sql="select cou_no from course where cou_no='"+courseNo+"' and col_no='"+collno+"'";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//������䲢ִ��sql
				if(!rs.next()){return "nocourse";}//���û������˵���ü�¼���ݿ��в�����
				sql="insert into coursemsg(cou_no,cou_day,cou_time,teacher) values('"+courseNo+"',"+
				     day+","+times+",'"+new String(teacher.getBytes(),"ISO-8859-1")+"')";
				int i=stmt.executeUpdate(sql);//���û������в���
				if(i==1){return "addok";}//����ɹ������ر�־�ַ���
			}}catch(Exception e){System.out.println("���ʧ��");}//�쳣�Ĵ������
		finally{try{if(rs!=null){rs.close();rs=null;}//�رս����
				if(stmt!=null){stmt.close();stmt=null;}//�ر����
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}catch(SQLException e){e.printStackTrace();}//�쳣�Ĵ������				
		}return result;}//���ؽ���ַ���
		
		
	public static ArrayList getCourseMsgItemList(String collno){
		ArrayList al=new ArrayList();//������ſ�ѡ�γ̵��б�
		Connection conn=null;Statement stmt=null;String sql=null;ResultSet rs=null;
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//������ݿ����Ӳ�Ϊ��
				sql="select coursemsg.cou_no,course.cou_name,cou_day,cou_time,teacher,onchosing,"
					+"course.xuefen from course,coursemsg where course.col_no='"+collno+"' and "+
					"course.cou_no=coursemsg.cou_no";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//������䲢ִ��SQL
				while(rs.next()){//���������
					al.add(new CourseMsgItem(rs.getString(1),//���γ���Ϣ�����б�
					       new String(rs.getString(2).getBytes("ISO-8859-1")),
					       rs.getInt(3),rs.getInt(4),
					       new String(rs.getString(5).getBytes("ISO-8859-1")),
					       rs.getString(6),rs.getDouble(7)));		
				}}}catch(Exception e){e.printStackTrace();}//�쳣�Ĵ������
		finally{try{if(rs!=null){rs.close();rs=null;}//�رս����
				if(stmt!=null){stmt.close();stmt=null;}//�ر����
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}catch(SQLException e){e.printStackTrace();}//�쳣�Ĵ������				
		}return al;}//����ѧ����ѡ�γ��б�
	  
	public static void gongBu(String courseno,int day,int times){
		Connection conn=null;Statement stmt=null;String sql=null;
		try{conn=getConnection();//������ݿ�����
			if(conn!=null){//������ݿ����Ӳ�Ϊ��
				sql="update coursemsg set onchosing='1' where cou_no='"+courseno+"' and"+
				   " cou_day="+day+" and cou_time="+times;
				stmt=conn.createStatement();int i=stmt.executeUpdate(sql);//�������ִ��sql
			}}catch(Exception e){e.printStackTrace();}//�쳣�Ĵ������
		finally{try{if(stmt!=null){stmt.close();stmt=null;}//�ر����
				if(conn!=null){conn.close();conn=null;}//�ر����ݿ�����
			}catch(SQLException e){e.printStackTrace();}//�쳣�Ĵ������				
		}}     
	public static void delete(String courseno,int day,int times){
		Connection conn=null;Statement stmt=null;String sql=null;
		try{conn=getConnection();
			if(conn!=null)
			{
				sql="delete from coursemsg where cou_no='"+courseno+"' and"+
				   " cou_day="+day+" and cou_time="+times;
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
	}
	public static ArrayList<SelectItem> getCourseItem(String collno)
	{
		ArrayList<SelectItem> al=new ArrayList<SelectItem>();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select distinct cou_name,course.cou_no from course,grade where"+
		  		" course.col_no='"+collno+"' and course.cou_no=grade.cou_no and isdual=0";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String courno=rs.getString(2);
					String couname=new String(rs.getString(1).getBytes("ISO-8859-1"));
					al.add(new SelectItem(courno,couname));
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return al;
	}
	public static void stopChoseCourse(String colNo)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="update coursemsg,course set coursemsg.onchosing='0' where course.col_no='"+colNo+"'"+
				     " and course.cou_no=coursemsg.cou_no";
				  System.out.println(sql+"=========");
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
	}	
	public static ArrayList getGradeItemList(String courno)//���ݿγ̺�
	{
		ArrayList al=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select grade.cou_no,cou_name,grade.stu_no,stu_name,xuefen,score from "+
			       "course,grade,students where grade.cou_no=course.cou_no and grade.stu_no="+
			       "students.stu_no and grade.cou_no='"+courno+"' and isdual=0";

				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					al.add(new GradeItem(
						    new String(rs.getString(1).getBytes("ISO-8859-1")),
							new String(rs.getString(2).getBytes("ISO-8859-1")),
							new String(rs.getString(3).getBytes("ISO-8859-1")),
							new String(rs.getString(4).getBytes("ISO-8859-1")),
							rs.getDouble(5),
							rs.getDouble(6)));			
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return al;
	}
	/*public static void saveScore(String courseNo,String stuNo,double score)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="update grade set score="+score+" where cou_no='"+courseNo+"' and"+
				    " stu_no='"+stuNo+"'";
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
	}*/
	public static void saveScore(List list)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			conn.setAutoCommit(false);
			for(Object o:list)
			{
				GradeItem gi=(GradeItem)o;
				String courseNo=gi.getCourseNo();
				String stuNo=gi.getStuNo();
				double score=gi.getScore();
				sql="update grade set score="+score+" where cou_no='"+courseNo+"' and"+
				    " stu_no='"+stuNo+"'";
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		}
		catch(Exception e)
		{
			try
			{
				conn.rollback();
				conn.setAutoCommit(true);
			}
			catch(SQLException ea)
			{
				ea.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	public static boolean gongBuScore(String courseNo)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="update grade set isdual=1 where cou_no='"+courseNo+"' and"+
				    " isdual=0";
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
				if(i!=0)
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return false;
	}
	
	public static String addCou(String cno,String cname,double xuefen,String colno,String deptno)
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql=null;
		String result="";
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			sql="select * from course where cou_no='"+cno+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				return "�Ѿ��иÿγ̺ŵĿγ�";
			}
			else
			{
				sql="insert into course (cou_no,cou_name,xuefen,col_no,dept_no)"+
				" values('"+cno+"','"+cname+"',"+xuefen+",'"+colno+"','"+deptno+"')";
				int i=stmt.executeUpdate(sql);
				if(i==1)
				{
					return "����ɹ�";
				}
				else
				{
					return "����ʧ��";
				}
			}
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			return "����ʧ��";
		}
	}
	
	
		
	public static Connection getConnection(){//������ݿ����ӵķ���
		Connection conn=null;			//�������ݿ���������
		try{Context initial=new InitialContext();//���������
			DataSource ds=(DataSource)initial.lookup("java:comp/env/xsglxt");//�������Դ
			conn=ds.getConnection();//������ݿ�����
		}
		catch(NamingException e){e.printStackTrace();}//�쳣�������
		catch(SQLException e){e.printStackTrace();}//�쳣�������
		return conn;		//�������ݿ�����
	}
}