FROM tomcat:8-jre8  
MAINTAINER Abadi

RUN echo "export JAVA_OPTS=\"-Dapp.env=weathervar\"" > /usr/local/tomcat/bin/setenv.sh  
COPY ./target/my-awesome-weather.war /usr/local/tomcat/webapps/weather.war

CMD ["catalina.sh", "run"] 
