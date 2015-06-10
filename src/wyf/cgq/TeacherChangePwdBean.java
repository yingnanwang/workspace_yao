package wyf.cgq;
public class TeacherChangePwdBean
{
	private LoginBean lb;//LoginBean������
	private String pwd;// ���ڴ���û��޸�ǰ����ʵ����
	private String oldpwd;//�û������ԭʼ����
	private String newpwd;//�û�����ľ�����
	private String renewpwd;//�û��ڶ�������ľ�����
	private String different;//���ڴ���������������벻ͬʱ����Ϣ
	private String result;//���ڴ���޸Ľ��
	public void setLb(LoginBean lb){this.lb=lb;}//lb��setter����
	public LoginBean getLb(){return this.lb;}//lb��getter����
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
		result="";
	}
	public void changePwd(){//�����޸ĵ�ҵ���߼�����
		this.different="";this.result="";//���ô������ĳ�ʼֵ
		if(!this.newpwd.equals(this.renewpwd)){//��������������벻��ͬ
			this.different="���������벻ƥ��";//���ý��ֵ
			return ;							//����
		}
		else{							//�����ͬ
			this.different="";			//��Ϊ���ַ���
		}
		if(!lb.getPwd().equals(this.oldpwd)){//������������벻��ȷ
			this.result="�����벻��ȷ";			//��ֻ������Ϣ
			return;							//����
		}
		else{			//�����������ȷ
			this.result="";		//��Ϊ���ַ���
		}
		if(TeacherDB.changePwd(lb.getUid(),oldpwd,newpwd)==true){//ִ���޸�����
			result="�޸ĳɹ�";			//�޸ĳɹ�
			lb.setPwd(newpwd);			//��LoginBean�е�pwd����Ϊ���µ�
		}
		else{					//����޸�ʧ��
			result="�޸�ʧ��";		//���ô�����Ϣ
		}
	}
}