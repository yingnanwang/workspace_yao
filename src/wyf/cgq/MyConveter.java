package wyf.cgq;
import javax.faces.convert.*;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.application.*;

public class MyConveter implements Converter{
	public Object getAsObject(FacesContext context,UIComponent component,String value){		
		try{
		  double score=Double.parseDouble((String)value);//���û����������ת��Ϊ����
		  return score;			
		}
		catch(NumberFormatException e){//���ת�����ִ���
			FacesMessage message = new FacesMessage(//��װ������Ϣ
                 FacesMessage.SEVERITY_ERROR, 
                 "������ʽ����", 
                 "������ʽ���ԣ����������룡");
			throw new ConverterException(message);//��������Ϣ�׳�
		}}
	public String getAsString(FacesContext context,UIComponent component,Object value){	
		return ((Double)value).toString();//������ת��Ϊ�ַ�������
	}}