1. download git for windows
https://gitforwindows.org/

2. create a directory
 C:/config-server-repo

3.config-server-client.properties
msg = Hello world - this is from config server.

4. config-server-client-development.properties
msg = Hello world - this is from config server Development environment.

5. config-server-client-production.properties
msg = Hello world - this is from config server Production environment

6. Now open command prompt from config-server-repo directory and run command
"git init"  to make that directory as git repository.

7. Now run "git add ." to add everything to this repo.

8. Then finally we need to commit the properties file by running command 
git commit –m "initial checkin".

spring-boot-config-server
----------------------------

1. create spring-boot-starter project -> dependencies  config-server

2. add @EnableConfigServer on Spring boot main class

3. add bootstrap.yml

server:
  port: 8888
  
spring:
  cloud:
    config:
      server:
        git:
          uri: d:\config-server-repo
 
4. start the application

5. Verify Server Side Configuration
    http://localhost:8888/config-server-client/client
    http://localhost:8888/config-server-client/development
    http://localhost:8888/config-server-client/production
	
spring-boot-config-client
---------------------------

1. create a spring boot starter project -> config-client,actuator,web

2. create MessageRestController.java

@RefreshScope
@RestController
class MessageRestController {
 
    @Value("${msg:Hello world - Config Server is not working..pelase check}")
    private String msg;
 
    @RequestMapping("/msg")
    String getMsg() {
        return this.msg;
    }
}

3. create bootstrap.yml

spring:
  application:
    name: config-server-client
    
  profiles:
    active:
    - development
    
  cloud:
    config:
      uri:
      - http://localhost:8888
	  profile: development  # for version > 2.1.5

	  
management:
  endpoints:
    web:
      exposure:
        include:
          heapdump,metrics,info,health,shutdown,threaddump,env,refresh
	  
Test the client application
----------------------------
http://localhost:8080/msg

Note : change the profile and test it

Test Property Change
------------------------
1. change the msg value in property file

2. point to  http://localhost:8080/msg   
Note : value is not changed

3. To reflect the new value, we need to refresh the configuration by hitting http://localhost:8080/refresh
endpoint using POST method from any of the REST client.




	

	









 