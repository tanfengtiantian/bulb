#!/bin/bash

DEPLOY_DIR=`pwd`
DIR=$( cd $(dirname $0) ; pwd -P )
STDOUT_FILE=$DEPLOY_DIR/logs

if [ ! -d $STDOUT_FILE ]; then
  mkdir $STDOUT_FILE
fi

SERVER_NAME="spring-boot-app"

if [ -z "$JAVA_HOME" ] ; then
        JAVA_HOME=`readlink -f \`which java 2>/dev/null\` 2>/dev/null | \
        sed 's/\/bin\/java//'`
fi

echo -e "Starting the $SERVER_NAME ...\c"
nohup "$JAVA_HOME"/bin/java -Xms512m -Xmx512m -XX:+UseSerialGC -XX:-TieredCompilation -XX:CICompilerCount=2 -XX:AutoBoxCacheMax=20000 -jar $DIR/$SERVER_NAME.jar > $STDOUT_FILE/stdout.log 2>&1 &

echo "OK!"
PIDS=`ps  --no-heading -C java -f --width 1000 | grep "$DEPLOY_DIR" | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"

