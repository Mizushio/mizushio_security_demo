流程图：
<br>
在每个网页（与个人信息相关部分）载入时，先向服务器询问是否处于登录状态，若不处于，则直接跳转到登录页，或者显示未登录。<br>
（因为暂时没有加载用户信息的接口，只能先加一个检查状态的接口来进行测试，之后应该可以删除）<br>
登录：<br>
 
![Image text](https://raw.githubusercontent.com/Mizushio/mizushio_security_demo/main/image/1.PNG)

注销<br>
 
![Image text](https://raw.githubusercontent.com/Mizushio/mizushio_security_demo/main/image/2.PNG)













数据库<br>
用户信息表（用于存储用户信息）<br>
Id（int）	Username(varchar(255))	Password(varchar(255))	Email(varchar(255))	Birthday(date/(varchar(255)))	…..<br>
1       	Admin	                  123			<br>
2	        User	                  123			<br>


用户角色表<br>
Id	Username	Password	Role<br>
1	Admin	123	Admin<br>
2	User	123	User<br>
<br>
<br>
<br>
<br>
接口设计：<br>
<br>
url	接口功能	类型<br>
/login	登录	Post<br>
/logout	注销	Get<br>
/check	检查登录状态	Get<br>
/usermsg	查询当前用户信息	Get<br>
		<br>
<br>
/login:<br>
Post方法，发送{“username”:”123”,”password”:”123”}<br>
登录成功返回{“code”:”200”,”msg”:”登陆成功”}<br>
失败返回{“code”:”400”,”msg”:”密码错误/账号不存在/….”}<br>
<br>
/logout:<br>
get方法<br>
登录成功返回{“code”:”200”,”msg”:”注销成功”}<br>
失败返回{“code”:”400”,”msg”:”注销失败/….”}<br>
<br>
/check:<br>
get方法<br>
已登录返回{“code”:”200”,”msg”:” 已登录”}<br>
未登录返回{“code”:”400”,”msg”:” 未登录”}<br>
（本来想在这里返回用户信息的，但是之后这个接口应该会删除，先这样丢着罢）<br>
<br>
<br>
<br>
/usermsg:<br>
get方法<br>
查询成功返回{“code”:”200”,”msg”:{“username”:”123”,”email”:”123@123.com”}}<br>
未登录返回{“code”:”400”,”msg”:”未登录”}<br>

