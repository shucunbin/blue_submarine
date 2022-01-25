# blue_submarine
show me code

# mysql 开启主从同步

```bash
# 1. 以下在主库中操作
# master 开权限
grant replication slave,replication client on *.* to 'slave'@'%' identified by "!master&root&pw";
flush privileges;


# 2. 以下在从库中操作
# 重置 master
RESET master;

# MASTER_HOST - master 主机名，建议使用逻辑名
# MASTER_PORT - master 端口
# MASTER_USER - 用于数据同步的用户
# MASTER_PASSWORD - 用于同步的用户的密码
# MASTER_LOG_POS - 从哪个 Position 开始读，在 master 中通过  show master status; 获取
# MASTER_LOG_FILE - 从哪个日志文件开始复制数据， 在 master 中通过  show master status; 获取
CHANGE MASTER TO MASTER_HOST='172.20.0.5',MASTER_USER='slave',MASTER_PASSWORD='!master&root&pw',
MASTER_PORT=3306,MASTER_LOG_POS=154, MASTER_LOG_FILE='mysql-bin.000005', MASTER_CONNECT_RETRY=30;

# 启动 slave
START slave;

# 查看状态
show slave status \G

# 设置从库为只读
shwo variables like '%read_only%';
set global super_read_only=1;


```
