
https://zhuanlan.zhihu.com/p/99733519

消息队列
天上飞的理念--落地的产品实现

解耦（系统之间）--系统间耦合性太强，如上图所示，系统A在代码中直接调用系统B和系统C的代码，
                    如果将来D系统接入，系统A还需要修改代码，过于麻烦！
                将消息写入消息队列，需要消息的系统自己从消息队列中订阅，从而系统A不需要做任何修改。
消峰（核心业务）--并发量大的时候，所有的请求直接怼到数据库，造成数据库连接异常
                系统A慢慢的按照数据库能处理的并发量，从消息队列中慢慢拉取消息。在生产中，这个短暂的高峰期积压是允许的。
异步（消息发送）--一些非必要的业务逻辑以同步的方式运行，太耗费时间。
                可以提速，非必要的业务逻辑以异步的方式运行，加快响应速度

三大特点参考下列链接--在特殊场景下有其对应的好处，解耦、异步、削峰。
https://www.cnblogs.com/terry-love/p/11492397.html
https://developer.51cto.com/art/201908/601434.htm
https://www.zhihu.com/question/34243607
https://blog.csdn.net/mrs_haining/article/details/80625833
缺点
系统可用性降低（MQ 一挂，整套系统崩溃的）
系统复杂度提高（重复消费，消息丢失，保证消息可靠传输）
一致性问题



MQ的两个目的地地方
队列-一对一
主题订阅topic-一对多（订阅微信公众号)

下单付钱快，后台处理慢。。。中间用MQ缓冲
后台61616，前台8161
lsof -i:61616
ps -ef| grep activemq 
netstat -anp|grep 61616
