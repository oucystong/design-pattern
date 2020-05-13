## 开发环境
tomcat 8.0+
JDK 1.8

## 数据库信息（勿外泄）
数据库地址： 101.201.57.15
端口号：3307      **注意：由于使用Docker上的mysql，因此端口不是3306**
账号：root
密码：123456


## 迭代器模式
interface： UserAggragate   UserIterator

class: UserAggragateImpl  UserIteratorImpl  AllUsers

实现代码：AllUsersController

每次查询，会将查询出的用户信息写入到${catalina.home}/logs/myLog目录下


## 观察者模式
interface：Observer    Operation

class：LoggerError  LoggerInfo  LoggerWarn  SelectOperation UpdateOperation DeleteOpearation

实现代码：db.java

每次查询，会记录到日志文件  



## 责任链模式
abstract class: IHandler

class：RegisterMessageHelper  UserNameLengthHandler 
UserNameSameHandler  UserPasswordHandler

实现代码： YonghuzhuceController.addYonghuzhuce

当前端js校验被用户恶意禁止时，可以通过java后端责任链模式的校验防止用户恶意注册来顶替用户信息。



## 环境
jdk13+tomcat9，部署项目出现初始化异常，修改lombok版本为最新的1.18版本可运行。

## 享元模式
应用：修改网站的社团展示的静态页面，多个用户查看时，不用创建新的url对象，共享池中的url对象，降低内存的浪费

分析：内部状态是各种类型的网站，外部状态是不同的用户

jsp：修改shetuanlist.jsp，增加shuxuejianmoshetuan.jsp  yecaowenxueshetuan.jsp aixinjuanzhushetuan.jsp fengkuanglunhuashetuan.jsp kuxuanjiewushetuan.jsp

图片：增加各社团的展示图片

util：Website、WebsiteFactory、impl\ConcreteWebsite

server:ShetuanUrlServer、impl\ShetuanUrlServerimpl

dao：ShetuanUrlMapper和相应的mapper映射文件

controller：ShetuanUrlController