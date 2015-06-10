package wyf.cgq;
public class LoginBean{
	private String uid;      		//�����װ�û��ĵ�¼�û���
	private String pwd;      		//���ڷ�װ�û��ĵ�¼����
	private String type;     		//���ڷ�װ�û���½����
	private String id;       		//���ڼ�¼ѧ�Ż�ѧԺ�ŵ�����
	public void setUid(String uid){this.uid=uid;}    //uid���Զ�Ӧ��setter����
	public String getUid(){return this.uid;}     	 //uid���Զ�Ӧ��getter����
	public void setPwd(String pwd){this.pwd=pwd;}	 //pwd���Զ�Ӧ��setter����
	public String getPwd(){return this.pwd;}		 //pwd���Զ�Ӧ��getter����
	public void setType(String type){this.type=type;}//type���Զ�Ӧ��setter����
	public String getType(){return this.type;}		 //type���Զ�Ӧ��getter����
	public String getId(){return this.id;}			 //id���Զ�Ӧ��getter����
	public void setId(String id){this.id=id;}		 //id���Զ�Ӧ��setter����
	public boolean getLogin(){return this.id!=null;} //�����ж��Ƿ��¼
	public String verify(){							 //���ڴ�����ķ���
		String result="fail";						 //��־�ַ�����Ĭ�ϵ�¼ʧ��
		if(type.equals("student")){					 //�����ѧ���û���¼
			result=LoginDB.studentLogin(uid,pwd);	 //����LoginDB��ѯ���ݿ�����ж�
			if(result.equals("success")){this.id=uid;}//��¼�ɹ�������id��ֵ
			else{this.id=null;}						  //��¼ʧ�ܣ�����idΪnull
		}
		else{										  //����ǽ�ʦ�û���¼
			result=LoginDB.teacherLogin(uid,pwd);	  //����LoginDB��ѯ���ݿ�����ж�
			if(!result.equals("fail")){				  //������صĲ���fail
				this.id=result;result="teacher";}	  //����id��ֵ��
			else{this.id=null;}						  //������ص���fail,������idΪnull
		}
		return result;								  //���������Ľ��
	}
}