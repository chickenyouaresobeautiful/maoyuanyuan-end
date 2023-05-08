# 1、安装环境

## 1.1、安装虚拟机

参考 https://blog.csdn.net/qq_40950957/article/details/80467513安装vmware

去 http://repo1.sea.innoscale.net/centos/7.9.2009/isos/x86_64/下载centos镜像文件

![image-20230315114426007](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20230315114426007.png)之后在vmware上安装centos，一路next即可

## 1.2、安装MySQL

参考 https://blog.csdn.net/qq_59636442/article/details/123058454

## 1.3、Nodejs

进入 https://nodejs.org/zh-cn/download/releases/ 下载 Node.js 16.19.1，之后参考 https://blog.csdn.net/Small_Yogurt/article/details/104968169 进行安装

## 1.4、安装yarn

win + r 打开cmd，输入以下指令安装yarn

```shell
npm install --global yarn
```

## 1.5、在虚拟机上安装docker

使用root账户登录虚拟机

docker官方文档：https://docs.docker.com/engine/install/centos/

安装docker所需的工具包

```shell
sudo yum install -y yum-utils
 
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
```

安装docker

```shell
sudo yum install docker-ce docker-ce-cli containerd.io docker-compose-plugin
```

配置docker镜像加速器

```shell
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://2xu4qxm6.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker
```

启动docker

```shell
sudo systemctl start docker
```

设置docker开机自启

```shell
systemctl enable docker
```

确认Docker是否已设置为自启动

```shell
systemctl is-enabled docker
```

## 1.6、使用docker安装redis

1. 下载 Redis 镜像。在终端中运行以下命令：

   ```shell
   docker pull redis
   ```

2. 启动redis

   ```shell
   mkdir -p /mydata/redis/conf
   
   touch /mydata/redis/conf/redis.conf
   
   echo "appendonly yes"  >> /mydata/redis/conf/redis.conf
   
   docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data \
   -v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf \
   -d redis redis-server /etc/redis/redis.conf
   ```

3. 查看docker是否启动

   ```shell
   docker ps
   ```

4. 设置redis在docker启动的时候启动

   ```shell
   docker update redis --restart=always
   
   docker restart redis
   ```

   

# 2、购买阿里云oss

- 登录阿里云官网搜索oss并完成购买

- 点击Access Key获取密钥

- ![image-20230314200438947](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20230314200438947.png)

- 点击创建bucket

  



# 3、后端配置

- https://github.com/chickenyouaresobeautiful?tab=repositories 拉取maoyuanyuan-end（后端）和maoyuanyuan（前端）

- 后端使用idea打开，前端使用webstorm或vscode打开

- 点击红圈安装依赖

- ![image-20230314201459340](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20230314201459340.png)

- 打开数据库管理工具创建数据库，库名自己订

- 打开左边sql文件夹，执行里面的sql文件建表

- 修改后端yml配置文件

- ### ![image-20230314200948041](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20230314200948041.png)

- url改为mysql的位置，username，password改为自己的密码，redis改为自己虚拟机的地址，oss配置使用自己申请的Accesskey

- ![image-20230314201311699](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20230314201311699.png)

- endpoint和bucketname使用自己创建的bucket上显示的信息
- 找到下图启动类启动项目
- ![image-20230314201605660](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20230314201605660.png)

# 4、前端配置

使用webstorm打开项目于，点击终端

![image-20230314201812987](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20230314201812987.png)

在命令行输入yarn安装依赖

依赖安装完毕之后继续输入yarn start:dev启动项目，登陆页面输入数据库中存在的用户名密码即可

