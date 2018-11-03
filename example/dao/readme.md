## Spring 数据库访问

### JdbcTemplate

### MyBatis集成

### Jdbc Transaction

### @Transaction

#### 事务传播

##### PROPAGATION_REQUIRED 
需要事务，如果当前存在事务，就沿用当前事务，否则新建一个事务运行子方法

#### PROPAGATION_REQUIRED_NEW
每交创建新事务运行方法，新事务拥有新的锁和隔离级别等特性,与当前事务完全独立

#### PROPAGATION_NESTED
当前方法调用子方法时，子方法发生异常，只回滚子方法执行过SQL, 而不回滚当前方法事务
NESTED传播行为会沿用当前事务的特性

#### 自调用失效问题