//缓存编辑区域对象
var tempEditCache;
// ajx对象
var xmlhttp;
if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttp = new XMLHttpRequest();
} else {// code for IE6, IE5
	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
}
function showLogin() {
	var loginspace = document.getElementById("login_space");
	loginspace.style.display = "inline";
	var loginout = document.getElementById("login_or_logout");
	loginout.innerHTML = "隐藏登陆框";
	loginout.href = "javascript:disappearLogin()";

}
function disappearLogin() {

	var loginspace = document.getElementById("login_space");
	loginspace.style.display = "none";
	var loginout = document.getElementById("login_or_logout");
	loginout.innerHTML = "登陆";
	loginout.href = "javascript:showLogin()";

}
// 异步登陆
function login() {
	xmlhttp.open("POST", "login.do", true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	var username = document.getElementById("username");
	var pwd = document.getElementById("pwd");
	xmlhttp.send("username=" + username.value + "&pwd=" + pwd.value);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var mark = xmlhttp.responseXML.getElementsByTagName("mark")[0].firstChild.nodeValue;
			if (mark == "true") {// 登陆成功
				// 更新用户页面顶部状态栏内容
				updateTopMsg(username.value);
				// 更新要显示的web列表内容
				updateWebMsg(username.value, pwd.value);

			} else {

				alert("登陆失败");
			}
		}
	}

}
// 异步注销
function logout() {

	xmlhttp.open("GET", "logout.do", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

			var state = xmlhttp.responseXML.getElementsByTagName("state")[0].firstChild.nodeValue;
			if (state == "true") {
				var loginout = document.getElementById("login_or_logout");
				loginout.innerHTML = "登陆";
				loginout.href = "javascript:showLogin()";

				var usermsg = document.getElementById("user_msg");

				var aspan = document.createElement("span");
				aspan.innerHTML = "游客";
				var alink = usermsg.getElementsByTagName("a")[0];
				usermsg.replaceChild(aspan, alink);

				// 更新内容显示区
				updateWebMsg();

			} else {
				alert("err ");
			}

		}
	}
}

// 增加网站
function showEditcache() {

	var editcache = document.getElementById("editcache");
	// 将改区域缓存
	tempEditCache = editcache.cloneNode(true);

	// 更改操作选项
	var cancellink = document.createElement("a");
	cancellink.href = "javascript:canceOpition()";
	cancellink.innerHTML = "取消";
	// var savelink = document.createElement("a");
	// savelink.href="javascript:saveOption()";
	// savelink.innerHTML="保存";

	var title = document.getElementById("title");
	var span = title.getElementsByTagName("span")[1];
	var oldtags = span.getElementsByTagName("a");
	// span.replaceChild(savelink, oldtags[0]);
	span.replaceChild(cancellink, oldtags[0]);
	span.removeChild(oldtags[1]);

	// 显示该区域
	editcache.style.display = "inline";

}
// 取消动作
function canceOpition() {
	// 更改操作选项
	var addllink = document.createElement("a");
	addllink.href = "javascript:showEditcache()";
	addllink.innerHTML = "添加";
	var editlink = document.createElement("a");
	editlink.href = "javascript:showEditField()";
	editlink.innerHTML = "编辑";
	var title = document.getElementById("title");
	var span = title.getElementsByTagName("span")[1];
	var oldtags = span.getElementsByTagName("a");
	span.replaceChild(addllink, oldtags[0]);
	span.appendChild(editlink);
	var editcache = document.getElementById("editcache");
	var parentNode = editcache.parentNode;
	// 将区域替换成缓存内容
	parentNode.replaceChild(tempEditCache, editcache);

}

// 保存动作
function saveOption() {
	alert("saveOption medth");

}

// TODO编辑网站
function showEditField() {
	alert("showEdit methd");
	open("http://www.baidu.com");
	
}

// 增加一个网站
function addweb() {
	var edit = document.getElementById("edit");
	// 查找该标签内的所有input
	var inputs = edit.getElementsByTagName("input");
	var selects = edit.getElementsByTagName("select");
	var webName;
	var webUrl;
	var webClass;
	webName = inputs[0].value;
	webUrl = inputs[1].value;
	// 如果input的数量为4则有新加分类所有数据直接从input数组里取得否则从select里边取
	if (inputs.length == 4) {
		webClass = inputs[2].value;
	} else {
		webClass = selects[0].value;
	}

	// 向服务器提交新增网址
	xmlhttp.open("POST", "addweb.do", true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	var showwebdiv = document.getElementById("showwebdiv");
	var inputs = showwebdiv.getElementsByTagName("input");
	var userid = inputs[0].value;

	xmlhttp.send("name=" + webName + "&address=" + webUrl + "&clazz="
			+ webClass + "&userId=" + userid);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200)// 连接成功的话刷新显示网站区域
		{

			var showWebdiv = document.getElementById("showwebdiv");
			var trs = showWebdiv.getElementsByTagName("tr");

			var parentNode = parentNode = trs[0].parentNode;
			var mark = false;
			// 找到对应分类
			for (var i = 0; i < trs.length; i++) {
				// 找到相应分类
				if (trs[i].getElementsByTagName("td")[0].innerHTML == webClass) {
					mark = true;
					// 找出该行所有link
					var links = trs[i].getElementsByTagName("a");
					// 找到第一个空白位置
					for (var j = 0; j < links.length; j++) {
						if (links[i].innerHtml) {
							continue;
						}
						links[i].innerHTML = webName;
						links[i].href = "http://" + webUrl;
					}
					break;
				}

			}
			if (!mark) {// 如果没有找到相应分类则在表格尾部新增一行
				// 直接克隆一行
				var newTr = trs[0].cloneNode(true);
				var oldtds = newTr.getElementByTagName("td");
				// 第一个填入分类信息
				oldtd[0].innerHTML = webClass;
				// 找出所有link
				var links = newTr.getElementByTagName("a");
				// 第一个link填入性内容
				links[0].innerHTML = webName;
				links[0].href = "http:" + webUrl;
				// 其余links清零
				for (var i = 1; i < links.length; i++) {
					links[i].innerHTML = "";
					links[i].href = "#";
				}
				parentNode.appendChild(newTr);
			}

		}
	}

}
// 下拉框改变事件
function change(select) {
	var value = select.value;
	if (value == "addClass") {
		addClass();
	} else {
		// 获得编辑区域div元素
		var edit = document.getElementById("edit");
		// 查找该标签内的所有input
		var inputs = edit.getElementsByTagName("input");
		// 如果input标签的数目大于3说明已经存在了分类的输入框
		if (inputs.length > 3) {
			edit.removeChild(inputs[2]);
		}
	}
}

// 增加一个类别
function addClass() {
	var edit = document.getElementById("edit");
	// 查找该标签内的所有input
	var inputs = edit.getElementsByTagName("input");
	// 如果input标签的数目大于3说明已经存在了分类的输入框
	if (inputs.length > 3) {
		return;
	} else {// 创建新的input域
		var newClazz = document.createElement("input");
		newClazz.type = "text";
		newClazz.name = "clazz";
		newClazz.value = "请输入新类别";
		// input数组的第三个是button
		var button = inputs[2];
		// 在button前加入类别输入文本域
		edit.insertBefore(newClazz, button);
	}
}

// 更新用户页面顶部状态栏内容
function updateTopMsg(username) {

	var loginspace = document.getElementById("login_space");
	var loginout = document.getElementById("login_or_logout");
	loginspace.style.display = "none";
	loginout.innerHTML = "注销";
	loginout.href = "javascript:logout()";
	var usermsg = document.getElementById("user_msg");

	var alink = document.createElement("a");
	alink.href = "userMsg.do";
	alink.innerHTML = username;
	var aspan = usermsg.getElementsByTagName("span")[0];
	usermsg.replaceChild(alink, aspan);
}
// 更新要显示的web列表内容
function updateWebMsg(username, pwd) {
	
	xmlhttp.open("POST", "queryWebsByusername.do", true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");

	if (username && pwd) {

		xmlhttp.send("username=" + username + "&pwd=" + pwd);
	} else {
		xmlhttp.send();
	}
	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// JSON解析json字符串

			var webCatalogs = JSON.parse(xmlhttp.responseText);

			// 得到showwebdiv
			var showwebdiv = document.getElementById("showwebdiv");

			// 得到table节点
			var table = showwebdiv.getElementsByTagName("table")[0];
			//清除table节点内容
			table.innerHTML="";
			if (webCatalogs.length > 0) {
				for (var i = 0; i < webCatalogs.length; i++) {

					var newTr = document.createElement("tr");

					var webs = webCatalogs[i].webs;
					var clazzTd = document.createElement("td");
					clazzTd.width = "10%";
					clazzTd.innerHTML = webCatalogs[i].clazz;
					newTr.appendChild(clazzTd);
					for (var j = 0; j < 5; j++) {
						var newTd = document.createElement("td");
					
						if (j < webs.length) {
							//设置宽度
							newTd.width = "17%";
							//产生设置图片
							var  newImg= document.createElement("img");
							newImg.src="http://" + webs[j].webUrl+"/"+"favicon.ico";
							//产生设置连接
							var	newLink = document.createElement("a");
							newLink.href = "http://" + webs[j].webUrl;
							newLink.innerHTML = webs[j].webname;
							newLink.target="blank";
							newTd.appendChild(newImg);
							newTd.appendChild(newLink);
						} else {
							newTd.width = "5%";

						}
					
						newTr.appendChild(newTd);

					}
					table.appendChild(newTr);
				}

				showwebdiv.style = "display:inline";
			}else{
				table.innerHTML="";
				showwebdiv.style="display:none";
			}

		}
	}

}


function openUrl(){
	alert(arguments);
	open("http://"+arguments[0]);
}
