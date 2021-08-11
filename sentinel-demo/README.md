#### 问题点：
1. 发现当客户端（要检测的主机）存在虚拟网卡时，Sentinel DashBoard 会获取到客户端的虚拟网卡的 ip;  
**解决方法**  
1） 暂时只能禁用客户端的虚拟网关；  
2） 在应用端增加配置项 spring.cloud.sentinel.transport.clientIp；



