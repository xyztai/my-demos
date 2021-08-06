#### 1. 启动sentinel-dashboard：
###### java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.2.jar 
###### sentinel-dashboard 访问端口URL：http://127.0.0.1:8080/
#### 2. 没有将sentinel的dashboard.server信息放在yml配置里面的方法，因此，只好用命令的方式传入参数：
###### java -Dproject.name=app1 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dserver.port=9090 -jar sentinel-spring-boot-demo-1.0-SNAPSHOT.jar
#### 3. 请求一下<font color=red>被Sentinel切入的</font>接口就能看到请求接口统计的情况，至此就可以使用sentinel的各种功能;
#### 4. 使用spring-boot依赖引入sentinel，需要引入如下jar包
```xml
        <!-- sentinel -->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-core</artifactId>
            <version>1.8.2</version>
        </dependency>
        <!-- sentinel 使用切面时，需要引入-->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-annotation-aspectj</artifactId>
            <version>1.8.2</version>
        </dependency>
        <!-- 客户端需要引入 Transport 模块来与 Sentinel 控制台进行通信 -->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-transport-simple-http</artifactId>
            <version>1.8.2</version>
        </dependency>
        <!-- 热点规则需要引入 -->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-parameter-flow-control</artifactId>
            <version>1.8.2</version>
        </dependency>
```