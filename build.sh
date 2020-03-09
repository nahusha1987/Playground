#!/bin/sh
# Script to build Flebie Repos
cd flebie-order-management-service && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-lab-test-service && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-account-management-service && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-frontend && git pull && gulp && cd ..
cd flebie-client-management-service && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-client-notification-service && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-config-server && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-eureka-naming-server && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-order-fulfillment-service && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-availability-service && git pull && mvn clean install -Dmaven.test.skip=true && cd ..
cd flebie-docker && git pull
