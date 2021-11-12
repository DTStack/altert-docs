<a name="lbWrF"></a>
## 一、安装jar
1. 下载jar

engine-alert-sdk-1.0.0.jar

2. 使用maven安装jar
```
mvn install:install-file -Dfile=${下载路径} -DgroupId=com.dtstack.engine -DartifactId=engine-alert-sdk -Dversion=1.0.0 -Dpackaging=jar
```

3. 此时jar安装完成，依赖关系如下
```
<dependency>
		<groupId>com.dtstack.engine</groupId>
    <artifactId>engine-alert-sdk</artifactId>
    <version>1.0.0</version>
</dependency>

```
二、使用jar

1. 创建java工程，导入依赖（补助一中的3小步依赖）
1. 基础接口(接口如下，注意通道基础的接口不同，具体实现请阅读console自定义告警文档.md)
```
com.dtstack.channel.ICustomizeChannel（自定义）
com.dtstack.channel.IDingChannel（钉钉）
com.dtstack.channel.IMailChannel（邮件）
com.dtstack.channel.ISmsChannel（短信）
```

3. 完成开发后打包。
   1. 在工程的pom文件中加入代码
```html
<build>
        <plugins>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </plugin>
        </plugins>
 </build>
```

4. 执行打包命令 mvn assembly:assembly ，执行完后就会在target中出现两个jar，去控制台新建通道（新建通道的文档请参考console自定义告警文档.md），使用后缀是-with-dependencies.jar的jar即可。

![image.png](https://cdn.nlark.com/yuque/0/2021/png/1873914/1636696614295-c1414b22-470e-43d5-ba34-219a6b193733.png#clientId=u22af4c88-13ef-4&from=paste&height=123&id=u83803edc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=246&originWidth=872&originalType=binary&ratio=1&size=47458&status=done&style=none&taskId=ucd3d5144-ed72-4068-a6cc-b11b75a4c72&width=436)<br />
<br />

