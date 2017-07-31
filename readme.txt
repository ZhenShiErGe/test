一.这个项目能提供给你的
1. 典型的ssm框架分层结构
2. 数据源动态切换，开发者仅仅需要使用DataSourceContext.setDataSource(builder); 语句就可以动态的切换数据源，对业务没有任何侵入性。见dev_add_multi_datasource分支。
3. 定时任务的配置举例，代码中有关于如何基于spring配置定时任务的例子。参见spring_scheduler分支。
4. 统一的异常处理逻辑，代码中所有的方法一致采用抛出异常的逻辑，在最外层的拦截器中对异常进行统一的处理。参见add_exception_handle分支。
5. 数据库事务的配置距离，代码中有关于如何基于spring配置数据库事务的例子。
6. 支持认证的httpinvoker，，传统的httpinvoker调用不支持认证的，demo里面给出的例子支持对调用者的身份认证。参见dev_security_httpinvoker分支。
7. 被简化的controller类，采用回调模式，让开发者只关心业务。
8. 还在添加中，希望有兴趣的小伙伴一起来开发。。。


二. 运行代码：
1.在mysql数据库中，先创建test数据库，然后执行test.sql脚本；
2.再创建testbackup数据库，然后再执行test_backup.sql脚本；



