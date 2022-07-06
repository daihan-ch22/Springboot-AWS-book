#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=Springboot-AWS-book

echo "> Copy Build file"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> Check pid of currently running application"

CURRENT_PID=$(pgrep -f1 Springboot-AWS-book | grepjar | awk '{print $1}')

echo "> Currently running application pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "> NOT CLOSED: No application on running."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> Deploy new application"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> Jar Name: $JAR_NAME"

echo "> Authorize $JAR_NAME for start"

chmod +x $JAR_NAME

echo "> Run $JAR_NAME"

nohup java -jar \
-Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
-Dspring.profiles.active=real \
$JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
