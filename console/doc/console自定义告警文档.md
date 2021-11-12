<a name="4hV5c"></a>
## 一.导入jar
直接下载jar<br />[engine-alert-sdk.jar]()<br />

如果无法下载
直接从git上下载

<a name="NY83e"></a>
## 二. 实现接口
<a name="qqW9N"></a>
### 1.短信接口实现
<a name="jtSYs"></a>
#### 1. 继承接口： com.dtstack.channel.ISmsChannel
```java
public interface ISmsChannel {
	
	/**
	 * 短信发送
	 * @param message 短信内容
	 * @param phones 手机号
	 * @param extMap 动态参数
	 * @return 
	 * @throws BizException
	 */
    public R sendSms(String message, List<String> phones, Map<String, Object> extMap) throws BizException;
    
}
```
参数： 

| 参数名 | 类型 | 备注 |
| --- | --- | --- |
| message | String | 短信内容 |
| phones | Array | 手机号列表 |
| extMap | Map | 扩展参数：在console页面配置的json。 |

<a name="ceaEa"></a>
#### 2. 页面参数讲解
![image.png](https://cdn.nlark.com/yuque/0/2020/png/1873914/1607427689359-a8eb2f8d-93be-4ed4-a194-681832e2ee82.png#align=left&display=inline&height=610&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1220&originWidth=998&size=106869&status=done&style=none&width=499)

   1. 短信通道只支持扩展通道。
   1. 上传jar由用户自己实现接口，接口详情如上1接口实现所示。
   1. 通道标识标识是通道的唯一标识，不能重复。
   1. 通道配置信息: 
      1. className: 表示jar中实现接口ISmsChannel的类的完整类名
      1. 通道配置信息客户可以根据开发需求添加字段，该字段不会被处理，在发送告警的时候回封装到extMap字段中传入方法内。


<br />

<a name="Us4Nc"></a>
### 2. 邮件接口实现
<a name="PHyzx"></a>
#### 1. 继承接口：com.dtstack.channel.IMailChannel
```java
public interface IMailChannel {
	
	/**
	 * 邮箱发送
	 * @param recipients 邮箱
	 * @param subject 主题
	 * @param message 内容
	 * @param attachFiles 附件（可为空）
	 * @param extMap 动态参数
	 * @return 
	 * @throws BizException
	 */
    public R sendMail(List<String> recipients, String subject, String message, List<File> attachFiles, Map<String, Object> extMap) throws BizException;
    
}
```
参数：

| 参数名 | 类型 | 备注 |
| --- | --- | --- |
| recipients | Array | 邮箱地址 |
| subject | String | 主题 |
| message | String | 内容 |
| attachFiles | Array[string] | 附件文件地址列表 |
| extMap | map | 动态参数 |

<a name="5XLrR"></a>
#### 2. 页面参数讲解
![image.png](https://cdn.nlark.com/yuque/0/2020/png/1873914/1607428660309-c0b8d71e-142c-468a-9117-1aebcb60f030.png#align=left&display=inline&height=626&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1252&originWidth=1084&size=140267&status=done&style=none&width=542)

   1. 邮件通道支持扩展通道和默认邮件通道。
   1. 上传jar由用户自己实现接口，接口详情如上1接口实现所示。
   1. 通道标识标识是通道的唯一标识，不能重复。
   1. 通道配置信息: 
      1. 扩展通道
         1. className: 表示jar中实现接口ISmsChannel的类的完整类名（只有客户选择扩展通道才有效）
         1. 通道配置信息客户可以根据开发需求添加字段，该字段不会被处理，在发送告警的时候回封装到extMap字段中传入方法内。
      2. 默认邮件通道
         1. mail.smtp.host : 邮箱服务商的stmp服务器地址(例如：smtp.yeah.net)
         1. mail.smtp.port：邮箱服务商的stmp服务器开放的端口（例如：25，465等）
         1. mail.smtp.ssl.enable： 是否支持ssl加密（如果465端口一般都需要ssl加密，具体配置要按照邮箱服务商的要求）
         1. mail.smtp.username：邮件发送者账号 
         1. mail.smtp.password：邮件发送者密码
         1. mail.smtp.from：邮件发送者



<a name="bGkHL"></a>
### 3 钉钉接口实现
<a name="JSNlo"></a>
#### 1. 继承接口：com.dtstack.channel.IDingChannel
```java
public interface IDingChannel {

	/**
	 * 钉钉发送
	 * @param hookUrls 钉钉机器人的webhook
	 * @param message 钉钉消息内容
	 * @param extMap 动态参数
	 * @return
	 * @throws BizException
	 */
	public R sendDing(List<String> hookUrls, String message, Map<String, String> dynamicParams, Map<String, Object> extMap) throws BizException;

    /**
     * 以markdown格式发送钉钉消息
     * @param hookUrls  钉钉机器人的webhook
     * @param title 主题
     * @param message 钉钉消息内容
     * @param extMap 动态参数
     * @return
     * @throws BizException
     */
    public R sendDingWithMarkDown(List<String> hookUrls, String title, String message, Map<String, String> dynamicParams, Map<String, Object> extMap) throws BizException;
    
}
```
方法：<br />sendDing 发送文本形式的钉钉消息<br />sendDingWithMarkDown 发送MarkDown形式的钉钉消息
<a name="EmAF9"></a>
#### 2. 页面参数讲解
![image.png](https://cdn.nlark.com/yuque/0/2020/png/1873914/1607428962849-289eaa84-82cc-4fc6-8310-944fa111bef5.png#align=left&display=inline&height=506&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1012&originWidth=1152&size=79463&status=done&style=none&width=576)

   1. 钉钉通道支持扩展通道和钉钉机器人通道。
   1. 上传jar由用户自己实现接口，接口详情如上1接口实现所示。
   1. 通道标识标识是通道的唯一标识，不能重复。
   1. 通道配置信息: 
      1. className: 表示jar中实现接口ISmsChannel的类的完整类名（只有客户选择扩展通道才有效）
      1. 通道配置信息客户可以根据开发需求添加字段，该字段不会被处理，在发送告警的时候回封装到extMap字段中传入方法内。
<a name="GjnLu"></a>
### 4. 自定义告警通道
<a name="tEA6U"></a>
#### 1. 继承接口：com.dtstack.channel.ICustomizeChannel
```java
public interface ICustomizeChannel {

    /**
     * 发送自定义告警
     *
     * @param data 自定义告警数据
     * @param extMap 扩展参数， 由控制台配置
     * @return 发送结果
     */
    public R sendCustomizeAlert(Object data,Map<String, Object> extMap);
}
```
<a name="PawZF"></a>
#### 2. 页面参数讲解

   1. 自定义通道仅支持扩展通道。
   1. 上传jar由用户自己实现接口，接口详情如上1接口实现所示。
   1. 通道标识标识是通道的唯一标识，不能重复。
   1. 通道配置信息: 
      1. className: 表示jar中实现接口ISmsChannel的类的完整类名
      1. 通道配置信息客户可以根据开发需求添加字段，该字段不会被处理，在发送告警的时候回封装到extMap字段中传入方法内。