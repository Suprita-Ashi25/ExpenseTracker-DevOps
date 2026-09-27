FROM tomcat:10.1-jdk17

COPY target/ExpenseTracker.war /usr/local/tomcat/webapps/ExpenseTracker.war

EXPOSE 8080

CMD ["catalina.sh", "run"]