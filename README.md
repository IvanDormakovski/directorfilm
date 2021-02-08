# Films library  
## Requirements   
Requires Java 8+ to run.  
## Technology Stack  
1. Java 8   
2. Spring 5.2.11  
3. Tomcat 9.0.41
4. Thymeleaf template  
5. PostgreSQL 13 
6. Active JDBC
7. Maven 3  
## Description   
The application searches for films from the database, depending on the year of release and the director who shot it with the possibility of combining search data  
## Structure 
  
<img src="file:///c:\Users\Admin\IdeaProjects\TestTask\directorfilm\Structure.png" />

### Data
Сreate database 1 or choose another name and change the settings database.properties.  
Create tables using a script (tables.sql) and fill them with data (data.sql)

### Building a project with Maven
Execute mvn package

### Deploy a project with Maven and Tomcat
Make these changes in $CATALINA_HOME\conf\tomcat-users:
```
    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <user username="admin" password="admin" roles="manager-gui, manager-script"/>
```
If we want to use Maven for deploying our web archives, we must configure Tomcat as a server in Maven's settings.xml file.  
There are two locations where the settings.xml file may be found:  

The Maven install: ${maven.home}/conf/settings.xml  
A user’s install: ${user.home}/.m2/settings.xml  

Once you have found it add Tomcat as follows:
```
<server>
    <id>TomcatServer</id>
    <username>admin</username>
    <password>admin</password>
</server>
```
Now we can run the following commands from Maven.
To deploy the web app:
```
mvn tomcat7:deploy
```