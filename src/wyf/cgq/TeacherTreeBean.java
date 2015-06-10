package wyf.cgq;
public class TeacherTreeBean{				
	private boolean root1=true;					//����һ���ڵ������
	private boolean root11=true;				//����ϵͳѡ�������ڵ������
	private boolean root21=true;				//����ѧ����Ϣ���������ڵ������
	private boolean root31=true;				//���ƿγ̹��������ڵ������
	private LoginBean lb;						//����LoginBean��Ӧ��
	public void setLb(LoginBean lb){this.lb=lb;}//lb��setter����
	public String clickCom(){					//������ڵ��ҵ������
		root1=!root1;return "success";}			//��root1����ȡ��
	public String clickRoot11(){				//���ϵͳѡ��ڵ�Ĵ�����
		root11=!root11;return "success";}		//��root11����ȡ��
	public String clickRoot21(){				//���ѧ����Ϣ����ڵ�Ĵ�����
		root21=!root21;return "success";}		//��root21����ȡ��
	public String clickRoot31(){				//����γ̹���ڵ�Ĵ�����
		root31=!root31;return "success";}		//��root31����ȡ��
	public void setRoot1(boolean root1){this.root1=root1;}	  //root1��setter����
	public boolean getRoot1(){return this.root1;}			  //root1��getter����
	public void setRoot11(boolean root11){this.root11=root11;}//root11��setter����
	public boolean getRoot11(){return this.root11;}			  //root11��getter����
	public void setRoot21(boolean root21){this.root21=root21;}//root21��setter����
	public boolean getRoot21(){return this.root21;}			  //root21��getter����
	public void setRoot31(boolean root31){this.root31=root31;}//root31��setter����
	public boolean getRoot31(){return this.root31;}			  //root31��getter����
	public String reLogin(){					//������µ�¼�ڵ��ҵ������
		lb.setId(null);							//����lb��id����Ϊnull
		lb.setUid(null);						//����lb��uid����Ϊnull
		return "login";							//���ر�־�ַ���
	}}