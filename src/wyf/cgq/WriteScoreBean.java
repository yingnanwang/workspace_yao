package wyf.cgq;
import java.util.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
public class WriteScoreBean{
	private LoginBean lb;//LoginBean������
	private String courseNo;//��ǰ�����Ŀγ̵Ŀγ̺�
	private DataModel model;//����ģ��
	private String result="";//��Ų���������ַ���
	private boolean dual;//�����жϵ�ǰ�γ��Ƿ��Ѿ��ύ
	ArrayList courseItem;//û����γ̵��б�
	private int courseSize;
	public void setLb(LoginBean lb){this.lb=lb;}//lb��setter����
	public LoginBean getLb(){return this.lb;}//lb��getter����
	public ArrayList getCourseItem(){//���Ϊ�����ɼ��Ŀγ̵��б�
		courseItem=TeacherDB.getCourseItem(lb.getId());
		this.courseSize=courseItem.size();
		return courseItem;}//���ظÿγ��б�
	public void setCourseNo(String courseNo){//����courseNo�ķ���
		dual=false;result="";this.courseNo=courseNo;}//��ֵ�������
	public String getCourseNo(){
		courseItem=TeacherDB.getCourseItem(lb.getId());//��ÿγ��б�
		if(courseNo==null||dual){//����ǵ�һ�λ�û����ǵ�ǰ�γ̺��ѱ�����
			if(courseItem.size()>0){//���δ�����Ŀγ̻������򽫵�һ��ֵ��ֵ��courseNo
				courseNo=(String)((SelectItem)courseItem.get(0)).getValue();
			}else{courseNo=null;}//����ֵһ��null
		}return this.courseNo;}//����courseNo
	public String getResult(){String result1=result;result="";
		return result1;}//��õ�������ɼ���Ľ���ַ���
	public void setResult(String result){this.result="";}//result��setter����
	public DataModel getGradeList(){//��óɼ��б�ķ���
		ArrayList al=TeacherDB.getGradeItemList(courseNo);//���ָ���γ̺ſγ̵ĳɼ��б�
		
		if(model==null){model=new ListDataModel();}//�������ģ��Ϊnull�򴴽�����ģ��
		model.setWrappedData(al);return model;//����ģ�����ݲ�����
	}
	public int getCourseSize(){this.getCourseItem();
		return this.courseSize;}//��ÿɲ����γ̵�����
	public void gongbu(){//��������ÿƳɼ���ť�Ĵ�����
		result="";boolean b=TeacherDB.gongBuScore(courseNo);//����TeacherDB�ķ��������ɼ�
		if(b==true){result="�����ɹ�";this.dual=true;}//��������ɹ���������������Ե�ֵ
		else{result="����ʧ��";}//����ʧ����result��Ϊ"����ʧ��"
	}
	public String saveScore(){//����ɼ��ķ���
		List list=(List)model.getWrappedData();//���Ҫ����ĳɼ��б�
		TeacherDB.saveScore(list);//����saveScore��������ɼ�
		return "success";//���ؽ���ַ���
	}
}