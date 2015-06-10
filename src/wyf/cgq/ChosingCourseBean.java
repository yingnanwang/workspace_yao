package wyf.cgq;
import java.util.*;
import javax.faces.model.SelectItem;
import javax.faces.model.*;
public class ChosingCourseBean
{
	private LoginBean lb;//����LoginBean������
	private int size;//��ѡ�γ̵�����
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public int getSize()
	{
		this.getCourseMsgItem();
		return this.size;
	}
	private DataModel model;//����DataModel������
	public DataModel getCourseMsgItem(){//��ÿ�ѡ�γ̿γ�����ģ�͵ķ���
		ArrayList al=TeacherDB.getCourseMsgItemList(lb.getId());//����TeacherDB�ķ�������б�
		size=al.size();
		if(model==null){model=new ListDataModel();}//����ǵ�һ�Σ����ʼ��model
		model.setWrappedData(al);//��������ģ��
		return model;//��������ģ��
	}
	public void gongBu(){//�����γ̵ķ���
		String courseno=((CourseMsgItem)model.getRowData()).getCourNo();//��ñ������Ŀγ̵Ŀγ̺�
		int day=((CourseMsgItem)model.getRowData()).getDay();//������ڼ�
		int times=((CourseMsgItem)model.getRowData()).getTimes();//��õڼ���
		TeacherDB.gongBu(courseno,day,times);//����TeacherDB�ķ������й���
	}
	public void delete(){//ɾ���γ̵ķ���
		String courseno=((CourseMsgItem)model.getRowData()).getCourNo();//��ñ�ɾ���γ̵Ŀγ̺�
		int day=((CourseMsgItem)model.getRowData()).getDay();//��ñ�ɾ���γ̵��Ͽ�ʱ��
		int times=((CourseMsgItem)model.getRowData()).getTimes();//��ñ�ɾ���γ̵��Ͽν���
		TeacherDB.delete(courseno,day,times);//����TeacherDB�ķ�������ɾ��
	}
	public void stop(){//ֹͣѡ�εķ���
		TeacherDB.stopChoseCourse(lb.getId());//����TeacherDB�ķ���ֹͣѡ��
	}
}