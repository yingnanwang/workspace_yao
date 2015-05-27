package HomePage;

public class LoginBean{
	private String uid;      		//锟斤拷锟斤拷锟阶帮拷没锟斤拷牡锟铰硷拷没锟斤拷锟�
	private String pwd;      		//锟斤拷锟节凤拷装锟矫伙拷锟侥碉拷录锟斤拷锟斤拷
	private String type;     		//锟斤拷锟节凤拷装锟矫伙拷锟斤拷陆锟斤拷锟斤拷
	private String id;       		//锟斤拷锟节硷拷录学锟脚伙拷学院锟脚碉拷锟斤拷锟斤拷
	public void setUid(String uid){this.uid=uid;}    //uid锟斤拷锟皆讹拷应锟斤拷setter锟斤拷锟斤拷
	public String getUid(){return this.uid;}     	 //uid锟斤拷锟皆讹拷应锟斤拷getter锟斤拷锟斤拷
	public void setPwd(String pwd){this.pwd=pwd;}	 //pwd锟斤拷锟皆讹拷应锟斤拷setter锟斤拷锟斤拷
	public String getPwd(){return this.pwd;}		 //pwd锟斤拷锟皆讹拷应锟斤拷getter锟斤拷锟斤拷
	public void setType(String type){this.type=type;}//type锟斤拷锟皆讹拷应锟斤拷setter锟斤拷锟斤拷
	public String getType(){return this.type;}		 //type锟斤拷锟皆讹拷应锟斤拷getter锟斤拷锟斤拷
	public String getId(){return this.id;}			 //id锟斤拷锟皆讹拷应锟斤拷getter锟斤拷锟斤拷
	public void setId(String id){this.id=id;}		 //id锟斤拷锟皆讹拷应锟斤拷setter锟斤拷锟斤拷
	public boolean getLogin(){return this.id!=null;} //锟斤拷锟斤拷锟叫讹拷锟角凤拷锟铰�
	public String verify(){							 //锟斤拷锟节达拷锟斤拷锟斤拷姆锟斤拷锟�
		String result="fail";						 //锟斤拷志锟街凤拷锟斤拷锟斤拷默锟较碉拷录失锟斤拷
		if(type.equals("student")){					 //锟斤拷锟斤拷锟窖э拷锟斤拷没锟斤拷锟铰�
			result=LoginDB.modelLogin(uid,pwd);	 //锟斤拷锟斤拷LoginDB锟斤拷询锟斤拷锟捷匡拷锟斤拷锟斤拷卸锟�
			if(result.equals("success")){this.id=uid;}//锟斤拷录锟缴癸拷锟斤拷锟斤拷锟斤拷id锟斤拷值
			else{this.id=null;}						  //锟斤拷录失锟杰ｏ拷锟斤拷锟斤拷id为null
		}
		else{										  //锟斤拷锟斤拷墙锟绞︼拷没锟斤拷锟铰�
			result=LoginDB.photographerLogin(uid,pwd);	  //锟斤拷锟斤拷LoginDB锟斤拷询锟斤拷锟捷匡拷锟斤拷锟斤拷卸锟�
			if(!result.equals("fail")){				  //锟斤拷锟斤拷锟斤拷氐牟锟斤拷锟絝ail
				this.id=result;result="teacher";}	  //锟斤拷锟斤拷id锟斤拷值锟斤拷
			else{this.id=null;}						  //锟斤拷锟斤拷锟斤拷氐锟斤拷锟絝ail,锟斤拷锟斤拷锟斤拷id为null
		}
		return result;								  //锟斤拷锟斤拷锟斤拷锟斤拷锟侥斤拷锟�
	}
}