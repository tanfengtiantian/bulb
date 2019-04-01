## 启动Java程序的命令
1.进入classpath目录，运行Main.class文件
```
$ cd F:/bulb/bulb-demo/target/classes/
$ java com.maxzuo.agent.Main
```
2.运行Main.class时，指定classpath路径，无依赖
```
$ java -classpath F:\bulb\bulb-demo\target\classes com.maxzuo.agent.Main
```
3.运行Main.class时，指定classpath路径，有外部依赖
```
$ java -classpath D:\repository\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar;F:\bulb\bulb-demo\target\classes com.maxzuo.agent.Main
```
4.运行Main.class前，运行探针
```
$ java "-javaagent:F:\bulb\bulb-agent\target\bulb-agent.jar=123" -Dfile.encoding=UTF-8 -classpath F:\\bulb\\bulb-demo\\target\\classes com.maxzuo.agent.Main
```
5.运行jar文件前，运行探针
```
$ java "-javaagent:F:\bulb\bulb-agent\target\bulb-agent.jar=123" -Dfile.encoding=UTF-8 -jar F:\\bulb\\spring-boot-app\\target\\spring-boot-app.jar
```
6.其中：
* 指定探针路径和参数："-javaagent:F:\bulb-agent.jar=123"
* 指定文件编码：-Dfile.encoding=UTF-8
* -cp和-classpath是一样的功能，-cp是简写。用于指定类运行所依赖其他类的路径，通常是类库，jar包之类，可以为绝对路径，也可以为相对路径。
  多个路径之间window上分号“;”分隔，linux上是分号“:”分隔，用一点“.”代表当前路径。

7.unix系统不挂断执行程序
```
$ nohup java -classpath F:\bulb\bulb-demo\target\classes com.maxzuo.agent.Main > /developer/logs/app.log 2>&1 &
```
8.启动SpringBoot示例：
```
$ nohup /usr/local/java/bin/java  -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xms1024m -Xmx1024m -Xmn256m -Xss256k -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -jar /usr/local/spring_boot_app/zxcity_pay_boot-1.0-SNAPSHOT.jar --spring.config.name=application >/dev/null &
```
其中：
* nohup 可以使得命令永远运行下去和用户终端没有关系。当我们断开ssh 连接的时候不会影响他的运行。
* \> /developer/logs/app.log 指定输出的文件；补充，在类Unix系统中，/dev/null，或称空设备，是一个特殊的设备文件，它丢弃一切写入其中的数据（但报告写入操作成功），读取它则会立即得到一个EOF。
* 2>&1 将标准错误重定向到标准输出
* & 表示后台运行

8.IDEA启动Java程序的命令

下列命令插入了换行符（\r\n）无法作为脚本执行。可以使用idea_start_app.bat脚本运行程序。
```
D:\Java\jdk1.8.0_172\bin\java.exe
"-javaagent:D:\IntelliJ IDEA 2018.1.3\lib\idea_rt.jar=54767:D:\IntelliJ IDEA 2018.1.3\bin"
-Dfile.encoding=UTF-8
-classpath D:\Java\jdk1.8.0_172\jre\lib\charsets.jar;
D:\Java\jdk1.8.0_172\jre\lib\deploy.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\access-bridge-64.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\cldrdata.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\dnsns.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\jaccess.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\jfxrt.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\localedata.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\nashorn.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\sunec.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\sunjce_provider.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\sunmscapi.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\sunpkcs11.jar;
D:\Java\jdk1.8.0_172\jre\lib\ext\zipfs.jar;
D:\Java\jdk1.8.0_172\jre\lib\javaws.jar;
D:\Java\jdk1.8.0_172\jre\lib\jce.jar;
D:\Java\jdk1.8.0_172\jre\lib\jfr.jar;
D:\Java\jdk1.8.0_172\jre\lib\jfxswt.jar;
D:\Java\jdk1.8.0_172\jre\lib\jsse.jar;
D:\Java\jdk1.8.0_172\jre\lib\management-agent.jar;
D:\Java\jdk1.8.0_172\jre\lib\plugin.jar;
D:\Java\jdk1.8.0_172\jre\lib\resources.jar;
D:\Java\jdk1.8.0_172\jre\lib\rt.jar;
F:\bulb\bulb-demo\target\classes;
D:\repository\net\bytebuddy\byte-buddy\1.7.11\byte-buddy-1.7.11.jar;
D:\repository\com\alibaba\fastjson\1.2.49\fastjson-1.2.49.jar;
D:\repository\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar;
D:\repository\org\junit\jupiter\junit-jupiter-engine\5.3.2\junit-jupiter-engine-5.3.2.jar;
D:\repository\org\apiguardian\apiguardian-api\1.0.0\apiguardian-api-1.0.0.jar;
D:\repository\org\junit\platform\junit-platform-engine\1.3.2\junit-platform-engine-1.3.2.jar;
D:\repository\org\junit\jupiter\junit-jupiter-api\5.3.2\junit-jupiter-api-5.3.2.jar;
D:\repository\org\opentest4j\opentest4j\1.1.1\opentest4j-1.1.1.jar;
D:\repository\org\junit\platform\junit-platform-commons\1.3.2\junit-platform-commons-1.3.2.jar;
D:\repository\org\junit\jupiter\junit-jupiter-params\5.3.2\junit-jupiter-params-5.3.2.jar
com.maxzuo.agent.Main.class
```
