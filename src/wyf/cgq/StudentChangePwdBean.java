package wyf.cgq;
public class StudentChangePwdBean
{
	private LoginBean lb;
	private String pwd;
	private String oldpwd;
	private String newpwd;
	private String renewpwd;
	private String different;
	private String result;
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public LoginBean getLb()
	{
		return this.lb;
	}
	public void setOldpwd(String oldpwd)
	{
		this.oldpwd=oldpwd;
	}
	public String getOldpwd()
	{
		return this.oldpwd;
	}
	public void setNewpwd(String newpwd)
	{
		this.newpwd=newpwd;
	}
	public String getNewpwd()
	{
		return this.newpwd;
	}
	public void setRenewpwd(String renewpwd)
	{
		this.renewpwd=renewpwd;
	}
	public String getRenewpwd()
	{
		return this.renewpwd;
	}
	public String getDifferent()
	{
		return this.different;
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
	public String changePwd()
	{
		this.different="";
		this.result="";
		if(!this.newpwd.equals(this.renewpwd))
		{
			this.different="���������벻ƥ��";
			return "success";
		}
		else
		{
			this.different="";
		}
		if(!lb.getPwd().equals(this.oldpwd))
		{
			this.result="�����벻��ȷ";
			return "success";
		}
		else
		{
			this.result="";
		}
		if(StudentDB.changePwd(lb.getUid(),oldpwd,newpwd)==true)
		{
			result="�޸ĳɹ�";
		}
		else
		{
			result="�޸�ʧ��";
		}
		System.out.println(result);
		return "success";
	}
}