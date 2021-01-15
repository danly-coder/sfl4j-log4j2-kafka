本项目是一个基于slf4j+log4j2，生产者程序输出日志，log4j2配置文件根据日志级别输出到console，文件和kafka中。消费者程序用于
连接kafka中,并不断拉取kafka中的日志消息，打印到console中。
## 生产者程序
src/main/java/SimpleProducer

## 消费者程序
src/main/java/SimpleConsumer

## lo4j2配置文件
src/main/resources/log4j2.xml

