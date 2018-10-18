## Spring 注解测试

### @Configuration 
表示Spring Java代码配置

### @Bean 
表示Bean注册

### @Component 
标记那个类将被扫描进入spring ioc 容器

### @ComponentScan 
标记那种策略去扫描装配Bean,默认情况下只扫描当前包及其子包，可以通过basePackageClasses定义扫
描的类，basePackages定义扫描的包名，includeFilters和excludeFilters定义包含和过滤条件

### @Value
为注入Bean指定默认值

### @Autowired
根据属性类型找到对应的Bean进行注入, 如果对应类型的Bean不是唯一，根据使用属性名称和Bean名称进行匹配，如果匹配，使用该Bean

### @Primary
标记多个匹配Bean时优先注入

### @Qualifier
指定名称以唯一匹配

### @Conditional
条件注解

### @Scope
指定作用域

##  参考
[spring doc](https://docs.spring.io/spring/docs/5.1.1.RELEASE/spring-framework-reference/core.html#beans-required-annotation)  
