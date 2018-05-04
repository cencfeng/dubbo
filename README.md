# dubbo
springboot dubbo zookeeper
学springboot 整合 dubbo,因为没有想出什么好的项目方案,就以工作中的系统功能为例,巩固技术.

一.准备工作
windows:
  (1)zookeeper安装
      zookeeper的安装很简单,下载网址为zookeeper:http://mirror.bit.edu.cn/apache/zookeeper/
  解压后在conf文件夹中把zoo_sample.cfg重命名为zoo.cfg或者复制zoo_sample.cfg命名为zoo.cfg
  
  (2)dubbo安装
      下载网址为:https://github.com/alibaba/dubbo
  我选择的是2.6.0版本,下载后解压,cmd进入解压出来的目录执行命令:mvn install -Dmaven.test.skip=true  打包(maven),打包完成后在
\dubbo-dubbo-2.6.0\dubbo-admin\target下找到对应的war包,复制到tomcat下的webapps下

 (3)redis安装
      我是在虚拟机中安装,用的是ubuntu,安装redis很简单,ubuntu自带了redis,也可以自己去下载安装使用命令sudo apt-get install redis-server 
  启动redis命令:redis-server 
  客户端查看:redis-cli 可能中文是乱码,要使用--row参数
  远程访问,在ubuntu中修改redis.conf文件,/etc/redis/redis.conf ,bind 127.0.0.1加上#注释掉,重启服务
  
 (2)分别启动zookeeper和dubbo
     先启动zookeeper,运行bin目录下的zkServer.cmd,然后启动tomcat,不出异常的话,就可以访问
 http://localhost:8080/dubbo-admin-2.6.0,用户名和密码在dubbo的配置文件中,默认都是root
 
 二.开始工作
 
     项目结构:
     新建项目:springbootdubbo
     三个模块:
         dubbo-api
         dubbo-consumer
         dubbo-provider
     maven加入依赖
