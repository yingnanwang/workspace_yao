package wyf.cgq;
import javax.faces.model.*;
import java.util.*;
public class StudentChoseCourseBean{
	private LoginBean lb;		//����LoginBean������
	private DataModel model;	//��������ģ������
	private String result;		//����������Ľ���ַ���������
	private int size;
	public void setLb(LoginBean lb){this.lb=lb;}//lb��set����
	public LoginBean getLb(){return this.lb;}//lb��get����
	public int getSize()
	{
		this.getCourseMsgItem();
		return this.size;
	}
	public DataModel getCourseMsgItem(){//��ÿγ��б�ķ���
		ArrayList al=StudentDB.getCourseMsgItemList(lb.getId());
		size=al.size();
		if(model==null){model=new ListDataModel();}//���ģ��Ϊ�գ��򴴽�ģ��
		model.setWrappedData(al);//����ģ������
		return model;//����ģ��
	}
	public String getResult(){
		String result1=result;
		result="";
		return result1;}//result���Ե�get����
	public void setResult(String result){this.result="";
	}
	public void chose(){//�����ѡ�ΰ�ť��Ĵ�����
		result="";//��ԭresult��ֵ
		CourseMsgItem cmi=(CourseMsgItem)model.getRowData();//�����ѡ��Ŀγ̶���
		String courseNo=cmi.getCourNo();//��øÿγ̵Ŀγ̺�
		String stuNo=lb.getId();		//���ѡ��ÿγ̵�ѧ����ѧ��
		String s=StudentDB.choseCourse(stuNo,courseNo);//������Ӧ����ѡ��
		if(s.equals("success")){result="ѡ�γɹ�";}//ѡ�γɹ�
		else if(s.equals("fail")){result="ѡ��ʧ��";}//ѡ��ʧ��
		else if(s.equals("rechose")){result="�Ѿ�ѡ���ÿγ�";//�Ѿ�ѡ���ÿγ�
		}
		else{result="�ÿγ���"+s+"��ͻ";}//�������γ�ʱ���ͻ
	}}