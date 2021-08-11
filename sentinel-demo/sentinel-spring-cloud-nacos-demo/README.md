#### 1. 启动sentinel-dashboard：
###### java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.2.jar 
###### sentinel-dashboard 访问端口URL：http://127.0.0.1:8080/
#### 2. 在nacos上添加配置；
```json
[
    {
        "resource": "/demo/{name}",
        "limitApp": "default",
        "grade": 1,
        "count": 1,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    },
    {
        "resource": "sayHello",
        "limitApp": "default",
        "grade": 1,
        "count": 1,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    },
    {
        "resource": "/block",
        "limitApp": "default",
        "grade": 1,
        "count": 1,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    }
]
```
#### 3. 请求一下<font color=red>被Sentinel限流</font>接口就能看到请求接口统计的情况，至此就可以使用sentinel的各种功能;
#### 4. nacos配置文件说明
|字段|说明|
|--|--|
|resource|资源名，即限流规则的作用对象|
|limitApp|流控针对的调用来源，若为default则不区分调用来源|
|grade|限流阈值类型（QPS或并发线程数）；0代表根据并发数量来限流，1代表根据QPS来进行限流控制|
|count|限流阈值|
|strategy|流控模式，0-直接，1-关联，2-链路|
|controlBehavior|流量控制效果（0-快速失败，1-warm up，2-排队等待）|
|clusterMode|是否为集群模式|
#### 5. 可以先在sentinel-dashboard上，手工新增一些配置，然后通过接口 http://127.0.0.1:8720/getRules?type=flow 就可以看到流控下的配置如何写，这样子就可以很方便地写到配置文件里面去；
