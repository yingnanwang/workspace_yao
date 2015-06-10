package wyf.cgq;
import javax.faces.model.*;
import java.util.*;
public class CourseTableBean{
	private LoginBean lb;//LoginBean������Ӧ��
	private DataModel model;//�������ݱ�������
	private boolean onchosing;//����ɾ���е���ʾ������
	private int size;
	public int getSize()
	{
		this.getMyCourseMsgItem();
		return size;
	}
	public void setLb(LoginBean lb){this.lb=lb;}//lb��set����
	public LoginBean getLb(){return this.lb;}//lb��get����
	public boolean getOnchosing(){return this.onchosing;}//onChosing��get����
	public DataModel getMyCourseMsgItem(){//��ÿγ��б�ķ���
		ArrayList al=StudentDB.getMyCourseMsgItemList(lb.getId());//ͨ������StudentDB�ķ������в�ѯ
		this.size=al.size();
		if(al.size()>0){//�����ѯ�����Ϊ��
			onchosing=!((CourseMsgItem)al.get(0)).getState();}//��onchosing��ֵ
		if(model==null){model=new ListDataModel();}//���ģ���ǿ��򳣼�ģ��
		model.setWrappedData(al);//����ģ������
		return model;//����ģ��
	
		
	}
	public List getCourTable()
	{
		ArrayList al=StudentDB.getMyCourseMsgItemList(lb.getId());
		if(al.size()>0){//�����ѯ�����Ϊ��
			onchosing=!((CourseMsgItem)al.get(0)).getState();}
		CourseTime[] ct=new CourseTime[5];
		for(int i=0;i<ct.length;i++)
		{
			ct[i]=new CourseTime();
			ct[i].setZero("��"+(i+1)+"��");
		}
		for(Object o:al)
		{
			CourseMsgItem cmi=(CourseMsgItem)o;
			int day=cmi.getDay();
			int time=cmi.getTimes();
			String name=cmi.getCourName();
			ct[time].addCourse(day,name);
		}
		ArrayList ctable=new ArrayList();
		for(int i=0;i<ct.length;i++)
		{
			ctable.add(ct[i]);
		}
		return ctable;
	}
	public void delete(){//����ɾ���γ̵ķ���
		CourseMsgItem cmi=(CourseMsgItem)model.getRowData();//����û�Ҫɾ���Ŀγ�
		String courseNo=cmi.getCourNo();//��ĸÿγ̵Ŀγ̺�
		String stuNo=lb.getId();//��ø�ѧ����ѧ��
		StudentDB.deleteCourse(courseNo,stuNo);//ִ��ɾ����ҵ�񷽷�
	}}