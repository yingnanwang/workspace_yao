package wyf.cgq;
import java.util.*;
import javax.faces.model.SelectItem;
import javax.faces.event.ValueChangeEvent;
public class AddStuBean
{
	private LoginBean lb;
	private String sno;
	private String sname;
	private String sgender="��";
	private int biryear=new Date().getYear()+1900-20;
	private int birmonth=1;
	private int birday=1;
	private String nativeplace;
	private String collid;
	private String deptid;
	private String classid;
	private String mianmao;
	private int comeyear=new Date().getYear()+1900;
	private int comemonth;
	private int comeday;
	private String msg;
	public void setSno(String sno)
	{
		this.sno=sno;
	}
	public String getSno()
	{
		return this.sno;
	}
	public void setSname(String sname)
	{
		this.sname=sname;
	}
	public String getSname()
	{
		return this.sname;
	}
	public void setSgender(String sgender)
	{
		this.sgender=sgender;
	}
	public String getSgender()
	{
		return this.sgender;
	}
	public void setBiryear(int biryear)
	{
		this.biryear=biryear;
	}
	public int getBiryear()
	{
		return this.biryear;
	}
	public void setBirmonth(int birmonth)
	{
		this.birmonth=birmonth;
	}
	public int getBirmonth()
	{
		return this.birmonth;
	}
	public void setBirday(int birday)
	{
		this.birday=birday;
	}
	public int getBirday()
	{
		return this.birday;
	}
	public void setNativeplace(String nativeplace)
	{
		this.nativeplace=nativeplace;
	}
	public String getNativeplace()
	{
		return this.nativeplace;
	}
	public void setCollid(String collid)
	{
		this.collid=collid;
	}
	public String getCollid()
	{
		return this.collid;
	}
	public void setDeptid(String deptid)
	{
		this.deptid=deptid;
	}
	public String getDeptid()
	{
		return this.deptid;
	}
	public void setClassid(String classid)
	{
		this.classid=classid;
	}
	public String getClassid()
	{
		return this.classid;
	}
	public void setMianmao(String mianmao)
	{
		this.mianmao=mianmao;
	}
	public String getMianmao()
	{
		return this.mianmao;
	}
	public void setComeyear(int comeyear)
	{
		this.comeyear=comeyear;
	}
	public int getComeyear()
	{
		return this.comeyear;
	}
	public void setComemonth(int comemonth)
	{
		this.comemonth=comemonth;
	}
	public int getComemonth()
	{
		return this.comemonth;
	}
	public void setComeday(int comeday)
	{
		this.comeday=comeday;
	}
	public int getComeday()
	{
		return this.comeday;
	}
	public String getMsg()
	{
		String msg1=msg;
		msg="";
		return msg1;
	}
	public void setMsg(String msg)
	{
		msg="";
	}
	
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public LoginBean getLb()
	{
		return this.lb;
	}
	
	public ArrayList<SelectItem> getBiryearList(){//��ó�����������б�ķ���
		int year=new Date().getYear()+1900;			//��õ�ǰ��
		ArrayList<SelectItem> biryearList=new ArrayList<SelectItem>();//�������б�
		for(int i=year-30;i<=year-15;i++){//���һ����Χ�ڵ����
			biryearList.add(new SelectItem(i,i+"��"));//��ӵ����б���
		}
		return biryearList;	//�������б�
	}
	public ArrayList<SelectItem> getBirmonthList(){//��ó��������µ��б�ķ���
		ArrayList<SelectItem> birmonthList=new ArrayList<SelectItem>();//�������б�
		for(int i=1;i<=12;i++){
			birmonthList.add(new SelectItem(i,i+"��"));//��12����������ӵ��б���
		}
		return birmonthList;//�����б�
	}
	public ArrayList<SelectItem> getBirdayList(){//��ó��������յ����
		ArrayList<SelectItem> birdayList=new ArrayList<SelectItem>();//�������б�
		Date d=new Date(biryear,birmonth,0);//���������´���ʱ�����
		int date=d.getDate();//��ø��µ��������
		for(int i=1;i<=date;i++){//������Щ����
			birdayList.add(new SelectItem(i,i+"��"));//��ӵ��б���
		}
		return birdayList;//�������б�
	}
	public String getColl(){	//���ѧԺ���ķ���
		collid=lb.getId();		//����û���id�ţ���ѧԱ���
		String coll=TeacherDB.getCollById(collid);//����TeacherDB�ķ������ѧԺ������
		return coll;//����ѧԺ������
	}
	public ArrayList<SelectItem> getDeptList(){//���רҵ�б�ķ���
		ArrayList<SelectItem> al=TeacherDB.getDeptListByCollid(collid);//���רҵ�б�
		if(deptid==null){//���רҵ�б�Ϊ��
			SelectItem sl=al.get(0);//����б��һ��
			deptid=(String)sl.getValue();//��ʼ��deptid
		}
		return al;		//����רҵ���
	}
	public ArrayList<SelectItem> getClassList(){//��ð༶�б�ķ���
		ArrayList<SelectItem> al=TeacherDB.getClassListByDeptid(deptid);//��ð༶�б�
		return al;//���ذ༶�б�
	}
	public ArrayList<SelectItem> getMianmaoList(){//���������ò���б�
		ArrayList al=new ArrayList();//����ArrayList�б�
		al.add(new SelectItem("��Ա","��Ա"));
		al.add(new SelectItem("ѧ��","ѧ��"));//����Ӧ��������òѡ����ӵ��б���
		al.add(new SelectItem("��Ա","��Ա"));
		return al;		//�����б�
	}
	public void updateClass(ValueChangeEvent event){//���°༶�б�ķ���
		this.getClassList();
	}
	public void updateBirday(ValueChangeEvent event){//���³������������б�ķ���
		this.getBirdayList();
	}
	public void updateComeday(ValueChangeEvent event){//������ѧʱ�������б�ķ���
		this.getComedayList();
	}
	public ArrayList<SelectItem> getComeyearList(){//�����ѧ��������б�ķ���
		int year=new Date().getYear()+1900;//��õ�ǰ��
		ArrayList<SelectItem> comeyearList=new ArrayList<SelectItem>();//�������б�
		for(int i=year-10;i<=year+1;i++){//���һ����Χ�ڵ����
			comeyearList.add(new SelectItem(i,i+"��"));//��ӵ����б���
		}
		return comeyearList;//�������б�
	}
	public ArrayList<SelectItem> getComemonthList(){//��ó��������µ��б�ķ���
		ArrayList<SelectItem> comemonthList=new ArrayList<SelectItem>();//�������б�
		for(int i=1;i<=12;i++){
			comemonthList.add(new SelectItem(i,i+"��"));//��12����������ӵ��б���
		}
		return comemonthList;//�����б�
	}
	public ArrayList<SelectItem> getComedayList(){//��ó��������յ����
		ArrayList<SelectItem> comedayList=new ArrayList<SelectItem>();//�������б�
		Date d=new Date(comeyear,comemonth,0);//���������´���ʱ�����
		int date=d.getDate();//��ø��µ��������
		for(int i=1;i<=date;i++){
			comedayList.add(new SelectItem(i,i+"��"));//��ӵ��б���
		}
		return comedayList;//�������б�
	}
	public String addStu(){  //���ѧ����ҵ���߼�����
		String result=TeacherDB.AddStu(sno,sname,sgender,biryear,birmonth,
		                birday,nativeplace,collid,deptid,classid,mianmao,
		                comeyear,comemonth,comeday);//����TeacherDB�ķ�������ѧ��
		if(result.equals("success")){this.msg="����ɹ�";}//����ɹ�
		else if(result.equals("restuadd")){
			this.msg="����ʧ�ܣ��Ѿ����˸�ѧ��ѧ��";//����ʧ�ܣ��Ѿ��и�ѧ��ѧ��
		}
		else if(result.equals("addstufail")){
			this.msg="����ʧ��";//����ʧ��
		}
		return "success";//��������ҳ��
	}
}