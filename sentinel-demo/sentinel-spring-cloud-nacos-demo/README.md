#### 1. 启动sentinel-dashboard：
###### java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.2.jar 
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
#### 3. 请求一下<font color=red>被Sentinel切入的</font>接口就能看到请求接口统计的情况，至此就可以使用sentinel的各种功能;