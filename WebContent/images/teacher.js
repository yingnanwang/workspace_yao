String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
function checkLogin()
{
	var uid=document.getElementById("myform:uid").value.trim();
	if(uid=="")
	{
		alert("�û�������Ϊ��");
		return false;
	}
	var pwd=document.getElementById("myform:pwd").value.trim();
	if(pwd=="")
	{
		alert("���벻��Ϊ��");
		return false;
	}
	return true;
}		     
function check(id,msg)
{
	var com=document.getElementById(id);

	if(com.value.trim()=="")
	{
   		alert(msg);
   		return false;
	}
	return true;
}

function checknewpwd(id)
{
	var com=document.getElementById(id);
	var values=com.value.trim();
	var pat=/^[a-zA-Z0-9]{6,12}$/;
	if(pat.exec(values))
	{
		return true;
	}
	else
	{
		alert("�������Ϊ6~12λ���ֺ�Ӣ����ĸ���");
		return false;
	}
}
function pwd()
{
	var newpwd=document.getElementById("myform:newpwd").value.trim();
	var renewpwd=document.getElementById("myform:renewpwd").value.trim();
	if(newpwd==renewpwd)
	{
		return true;
	}
	else
	{
		alert("�������������벻ƥ��");
		return false;
	}

}
function stucheck()
{
	var sno=document.getElementById("stuform:sno").value.trim();
	var pat=/^[0-9]{12,12}$/;
	if(!pat.exec(sno))
	{
		alert("ѧ��Ӧ����12λ�������");
		document.getElementById("stuform:sno").focus();
		return false;
	}
	var sname=document.getElementById("stuform:sname").value.trim();
	if(sname=="")
	{
		alert("��������Ϊ��");
		document.getElementById("stuform:sname").focus();
		return false;
	}
	var nativepalce=document.getElementById("stuform:nativeplace").value.trim();
	if(nativepalce=="")
	{
		alert("���᲻��Ϊ��");
		document.getElementById("stuform:nativeplace").focus();
		return false;
	}
	return true;
}
function coursemsgcheck()
{
	var courseNo=document.getElementById("manageform:courseNo").value.trim();
	if(courseNo=="")
	{
		alert("������Ҫ�����Ŀγ̺�");
		return false;
	}
	var teacher=document.getElementById("manageform:teacher").value.trim();
	if(teacher=="")
	{
		alert("�������ον�ʦ");
		return false;
	}
	return true;
}
function updateDate()
{
	var yearindex=document.getElementById("stuform:biryear").selectedIndex;
	var year=document.getElementById("stuform:biryear")[yearindex].value;
	var monthindex=document.getElementById("stuform:birmonth").selectedIndex;
	var month=document.getElementById("stuform:birmonth")[monthindex].value;
	var date=new Date(year,month,0);
	var number=date.getDate();
	var length=document.getElementById("stuform:birday").length;
	while(document.getElementById("stuform:birday").length>0)
	{document.getElementById("stuform:birday")[0]=null;}
	for(var i=0;i<number;i++){document.getElementById("stuform:birday").options[i]=new Option(i+1+"��",i+1);}
}
function updateDate1()
{
	var yearindex=document.getElementById("stuform:comeyear").selectedIndex;
	var year=document.getElementById("stuform:comeyear")[yearindex].value;
	var monthindex=document.getElementById("stuform:comemonth").selectedIndex;
	var month=document.getElementById("stuform:comemonth")[monthindex].value;
	var date=new Date(year,month,0);
	var number=date.getDate();
	var length=document.getElementById("stuform:comeday").length;
	while(document.getElementById("stuform:comeday").length>0)
	{document.getElementById("stuform:comeday")[0]=null;}
	for(var i=0;i<number;i++){document.getElementById("stuform:comeday").options[i]=new Option(i+1+"��",i+1);}
}
function checkpre()
{
	var sno=document.getElementById("stuform:sno").value.trim();
	if(sno=="")
	{
		alert("ѧ�Ų���Ϊ��");
		document.getElementById("stuform:sno").focus();
		return;
	}
	if(sno.length!=12)
	{
		alert("ѧ�ų���Ϊ");
		document.getElementById("stuform:sno").focus();
		return;
	}
	if(sno.length>12)
	{
		alert("ѧ�ų��Ȳ��ܴ���12λ");
		document.getElementById("stuform:sno").focus();
		return;
	}

	var sname=document.getElementById("stuform:sname").value.trim();
	if(sname=="")
	{
		alert("��������Ϊ��");
		document.getElementById("stuform:sname").focus();
		return;
	}
	var nativeplace=document.getElementById("stuform:nativeplace").value.trim();
	if(nativeplace=="")
	{
		alert("���᲻��Ϊ��");
		document.getElementById("stuform:nativeplace").focus();
		return;
	}
}
function checksno()
{
	var sno=document.getElementById("searchform:search").value.trim();
	if(sno=="")
	{
		alert("������Ҫ��ѯ��ѧ����ѧ��");
		return false;
	}
	var pat=/^[0-9]{12,12}$/;
	if(!pat.exec(sno))
	{
		alert("�������ѧ�Ÿ�ʽ����ȷ��Ӧ��Ϊ12λ���֣�����");
		document.getElementById("searchform:search").focus();
		return false;
	}
	return true;
}

function checkscore(com)
{
	var score=com.value;
	var pat=/^\d+(\.\d+)?$/;
	if(!pat.exec(score))
	{
		alert("������ķ�������");
		com.focus();
		return false;
	}
	if(score<0||score>100)
	{
		alert("����Ӧ����0~100֮��");
		com.focus();
		return false;
	}
	
	return true;
}
function checkallscore()
{
	alert(document.getElementById("scoreform").value.length+"sssss");
	
    for(i=0;i<document.getElementById("scoreform").rows.length;i++)   
    {   
    	alert(i+"��");
        for(j=0;j<document.getElementById("scoreform").rows(i).cells.length;j++)   
        {   
        	alert(i+"��"+j+"��");
           var value=document.getElementById("scoreform").rows(i).cells(j).value; 
            alert(value);
        }   
    }   
	return false;
}

function checkss()
{   
 var pat=/^\d+(\.\d+)?$/; 
 var oo = document.getElementById("scoreform").getElementsByTagName("input");  
 var len=oo.length;
  var number=1;     
 for(var k = 0; k < len; k++)    
 {        
  
    var t = oo[k].type;  
    var value=oo[k].value;
    if(t=="text")
    {
    	if(!pat.exec(value))
		{
			alert("��"+number+"��������ķ�������");
			oo[k].focus();
			return false;
		}
		if(value<0||value>100)
		{
			alert("��"+number+"�з���Ӧ����0~100֮��");
			oo[k].focus();
			return false;
		}
		number=number+1;   
    }
 }
 return true;
}


function checkcourse()
{
	var cno=document.getElementById("myform:cno").value.trim();
	if(cno=="")
	{
		alert("�γ̺Ų���Ϊ�գ���");
		return false;
	}
	var cname=document.getElementById("myform:cname").value.trim();
	if(cname=="")
	{
		alert("�γ����Ʋ���Ϊ�գ���");
		return false;
	}
	var xuefen=document.getElementById("myform:xuefen").value.trim();
	if(xuefen=="")
	{
		alert("ѧ�ֲ���Ϊ�գ���");
		return false;
	}
	var pat=/^\d+(\.\d+)?$/;
	if(!pat.exec(xuefen))
	{
		alert("ѧ�ֵĸ�ʽ����ȡ");
		return false;
	}
}




