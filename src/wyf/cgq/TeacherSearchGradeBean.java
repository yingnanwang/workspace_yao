package wyf.cgq;
import java.util.*;
public class TeacherSearchGradeBean
{
	private String sno;
	private String result;
	private boolean cansee;
	private ArrayList al;
	private int size;
	
	public void setSno(String sno)
	{
		this.sno=sno;
	}
	public String getSno()
	{
		return this.sno;
	}
	public String getResult()
	{
		System.out.println("huo de result;");
		String result1=result;
		result="";
		System.out.println("");
		return result1;
	}
	public void setResult(String result)
	{
		this.result="";
	}
	public boolean getCansee()
	{
		return this.cansee;
	}
	public List getGradeList()
	{
		return al;
	}
	public int getSize()
	{
		return this.size;
	}
	public String search(){//�����ѯ�ɼ��ķ���
		al=TeacherDB.getGradeList(sno);//����TeacherDB��ҵ�񷽷����в�ѯ
		if(al!=null){
			result="";cansee=true;this.size=al.size();
			if(size==0){result="û�и�ѧ�ŵ�ѧ������سɼ���Ϣ";
			}
		}//����м�¼����cansee��Ϊtrue
		else{result="û�и�ѧ�ŵ�ѧ������سɼ���Ϣ";cansee=false;}//���û�м�¼����cansee��Ϊfalse
		return "success";//���ص����ַ���
	}
}