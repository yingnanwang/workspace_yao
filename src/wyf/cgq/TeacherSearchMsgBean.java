package wyf.cgq;
public class TeacherSearchMsgBean
{
	private String sno;
	private String sname;
	private String sgender;
	private String birth;
	private String nativeplace;
	private String coll;
	private String dept;
	private String classes;
	private String mianmao;
	private String comedate;
	private String result;
	private boolean cansee;
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
	public void setBirth(String birth)
	{
		this.birth=birth;
	}
	public String getBirth()
	{
		return this.birth;
	}
	public void setNativeplace(String nativeplace)
	{
		this.nativeplace=nativeplace;
	}
	public String getNativeplace()
	{
		return this.nativeplace;
	}
	public void setColl(String coll)
	{
		this.coll=coll;
	}
	public String getColl()
	{
		return this.coll;
	}
	public void setDept(String dept)
	{
		this.dept=dept;
	}
	public String getDept()
	{
		return this.dept;
	}
	public void setClasses(String classes)
	{
		this.classes=classes;
	}
	public String getClasses()
	{
		return this.classes;
	}
	public void setMianmao(String mianmao)
	{
		this.mianmao=mianmao;
	}
	public String getMianmao()
	{
		return this.mianmao;
	}
	public void setComedate(String comedate)
	{
		this.comedate=comedate;
	}
	public String getComedate()
	{
		return this.comedate;
	}
	public String getResult()
	{
		String result1=result;
		result="";
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
	public String search(){//ѧ��������Ϣ��ѯ��ҵ���߼��������
		String[] s=TeacherDB.searchMsg(sno);//����TeacharDB��ҵ�񷽷������Ϣ����
		if(s==null){result="û�и�ѧ��";cansee=false;}// û�и�ѧ��ѧ��
		else{result="";cansee=true;sno=s[0];sname=s[1];sgender=s[2];birth=s[3];
			nativeplace=s[4];coll=s[5];dept=s[6];classes=s[7];mianmao=s[8];
			comedate=s[9];//��������丳ֵ����Ӧ������
		}return "success";//����
	}
}