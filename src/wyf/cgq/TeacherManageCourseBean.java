package wyf.cgq;
import java.util.*;
import javax.faces.model.SelectItem;
import javax.faces.model.*;
public class TeacherManageCourseBean{
	private LoginBean lb;//����LoginBean������
	public void setLb(LoginBean lb){this.lb=lb;}//lb��setter����
	public LoginBean getLb(){return this.lb;}//lb��getter����
	public List getCourseItemList(){ //��ÿγ��б�ķ���
		ArrayList al=TeacherDB.getCourseItemList(lb.getId());//����TeacherDB�ķ�����ÿγ��б�
		return al;}//���ؿγ��б�
	private String courseNo;//��װ�û�����Ŀγ̺�
	private String teacher;//��װ�û�������ον�ʦ
	private int day;//��װ�û�ѡ������ڼ�
	private int times;//��װ�û�ѡ��Ľ���
	private String result;//��װ������Ľṹ�ַ���
	private SelectItem[] dayItem={//��������ʼ�������б�
		new SelectItem(1,"����1"),new SelectItem(2,"����2"),
		new SelectItem(3,"����3"),new SelectItem(4,"����4"),
		new SelectItem(5,"����5"),new SelectItem(6,"����6"),
		new SelectItem(7,"����7")};
	private SelectItem[] timesItem={//��������ʼ�������б�
		new SelectItem(1,"��1��"),new SelectItem(2,"��2��"),
		new SelectItem(3,"��3��"),new SelectItem(4,"��4��"),
		new SelectItem(5,"��5��")};
	public void setCourseNo(String courseNo){this.courseNo=courseNo;}//courseNo��setter����
	public String getCourseNo()
	{
		return this.courseNo;
	}
	public void setTeacher(String teacher)
	{
		this.teacher=teacher;
	}
	public String getTeacher()
	{
		return this.teacher;
	}
	public void setDay(int day)
	{
		this.day=day;
	}
	public int getDay()
	{
		return this.day;	
	}
	public void setTimes(int times)
	{
		this.times=times;
	}
	public int getTimes()
	{
		return this.times;
	}
	public SelectItem[] getDayItem()
	{
		return dayItem;
	}
	public SelectItem[] getTimesItem()
	{
		return timesItem;
	}
	public String getResult(){
		String result1=result;
		result="";
		return result1;
	}//result��getter����
	public void setResult(String result){result="";	}
	public String addToDB(){//����ӿγ̵���ѡ�б�İ�ť����Ӧ����
		String s=TeacherDB.addToDB(courseNo,day,times,teacher,lb.getId());//����TeacherDB�ķ�������
		if(s.equals("addfail")){	//������ʧ��
			result="���ʧ��,�����Ƿ��ظ�����˸ÿγ�";}//����Ϣ���Ը�ֵ
		else if(s.equals("addok")){result="��ӳɹ�";}//�����ӳɹ�����Ҳ����Ϣ��ֵ
		else if(s.equals("nocourse")){result="δ�ҵ���Ӧ�γ�";}//δ�ҵ���Ӧ�Ŀγ���Ϣ
		return "success";//���ص����ַ���
	}
	
}