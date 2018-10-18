## Spring 配置测试

### @Value
使用@Value(${...})直接读取属性配置文件配置注入至对象属性

### @ConfigurationProperties
将POJO属性名称去配置文件中查找，匹配将对应的属性值注入POJO属性

### @PropertySource 
将配置分开到多个文件

### @Profile 
根据属性配置的spring.profiles.active和spring.profiles.default确定属性

### application.properties
通过spring.profiles.active和spring.profiles.default可以方便切换配置文件

### @ImportResource 
可以引入xml bean配置

### Spring EL
使用spring EL可以更加灵活为Bean属性注入值 [参考](https://docs.spring.io/spring/docs/5.1.1.RELEASE/spring-framework-reference/core.html#expressions)

