document.createElement('nav');
document.createElement('header');
document.createElement('footer');
document.createElement('section');
document.createElement('article');
document.createElement('aside');
document.createElement('hgroup');

/*Common functions*/
function gbi(layerId){return document.getElementById(layerId)}

var $z={
	show:function(id){
		$z.gObj(id).style.display='';
	},
	showInl:function(id){
		$z.gObj(id).style.display='inline';
	},
	showb:function(id){
		$z.gObj(id).style.display='block';
	},
	hide:function(id){
		$z.gObj(id).style.display='none';
	},
	setFocus:function(id){
		$z.gObj(id).focus();
	},
	classChange:function(id, oC, nC){
    	aObj=$z.gObj(id);
		if(aObj.className==oC)
			aObj.className=nC;
	},
	changeTxt:function(id, nT){
    	$z.gObj(id).innerHTML=nT;
	},
	changeClass:function(id, nC){
    	$z.gObj(id).className=nC;
	},
	toggleSH:function(id){
		aObj=$z.gObj(id);
		aObj.style.display=='' ? aObj.style.display='none' : aObj.style.display='';
	},
	toggletxt:function(id, oT, nT){
		aObj=$z.gObj(id);
		aObj.innerHTML==oT ? aObj.innerHTML=nT : aObj.innerHTML=oT;
	},
	toggleclass:function(id, oC, nC){
		aObj=$z.gObj(id);
		aObj.className==oC ? aObj.className=nC : aObj.className=oC;
	},
	classChangeLoop:function(id, oC, nC, curObj){
		aObj=$z.gObj(id);
		var getA=$z.gtn(aObj, 'a');
		for(i=0; i<getA.length; i++){
			$z.classChange(getA[i], oC, nC);
		}
		curObj.className=oC;
	},
	gObj:function(id){
		return (typeof id == 'object' ? id : $z.gbi(id)); 
	},
	gbi:function(id){
		return document.getElementById(id);
	},
	gtn:function(curObj, tagName){
		curObj=$z.gObj(curObj);
		return curObj.getElementsByTagName(tagName);
	},
	getPositionX:function(obj){
		var curleft = 0;
		if(obj.offsetParent)
			while(1) 
			{
			  curleft += obj.offsetLeft;
			  if(!obj.offsetParent)
				break;
			  obj = obj.offsetParent;
			}
		else if(obj.x)
			curleft += obj.x;
		return curleft;
	},
	getPositionY:function(obj){
		var curtop = 0;
		if(obj.offsetParent)
			while(1)
			{
			  curtop += obj.offsetTop;
			  if(!obj.offsetParent)
				break;
			  obj = obj.offsetParent;
			}
		else if(obj.y)
			curtop += obj.y;
		return curtop;
	}
}

/*Form element*/
function txtBlur(ele, action, defVal) {
    if(action == "blur") {
        ele.value = ele.value.replace(/^\s+/,'');
        ele.value = ele.value.replace(/\s+$/,'');
        if(ele.value=="") {
            ele.value=defVal; 
            ele.style.color="#8d8d8d";
        }
    }
    else if(action == "focus" && ele.value == defVal) {
        ele.value="";
        ele.style.color="#000";
    }
}

/*Accordion*/
function menuAccordion(obj, layerid)
{
	var i=1;
	while(gbi('accordion'+i))
	{
		gbi('accordion'+i).className='menuCont dispN';
		var lia=gbi('accordion'+i).parentNode.getElementsByTagName('a');
		lia[0].parentNode.className='';
		i=i+1;
	}
	gbi(layerid).className='menuCont dispB';
	gbi(obj).className='sel';
}

function hideAllMenu(menuId){
	var liEle = gbi(menuId).getElementsByTagName('li');
	for(i=1;i<liEle.length+1; i++){
		gbi('accordion'+i).className='menuCont dispN';
	}
}

/*Swap Password type*/
function toggleField(passwordSh){
	var psswrd=gbi(passwordSh);
	if(psswrd.type=='password')
		psswrd.type='text';
	else
		psswrd.type='password';
}

/*Swap email type*/
function emailType(inputId){
	var emailField=gbi(inputId);
	if(emailField.type=='text')
		emailField.type='email';
	else
		emailField.type='text';
}

/*Radio button bold*/
function toggleRadio(emailRadio, usrNameRadio){
	var matchEmail = gbi(emailRadio);
	var matchUsername = gbi(usrNameRadio);
	if(matchEmail.checked){	
		matchEmail.parentNode.className = 'sml bold' ;
		matchUsername.parentNode.className = 'sml' ;
	}	
	else{
		matchEmail.parentNode.className = 'sml' ;
		matchUsername.parentNode.className = 'sml bold';	
	}	
}	