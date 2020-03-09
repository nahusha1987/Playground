#!/bin/sh
# Script to clone Flebie repos
git clone git@github.com:flebieorg/flebie-order-management-service.git
git clone git@github.com:flebieorg/flebie-lab-test-service.git
git clone git@github.com:flebieorg/flebie-account-management-service.git
git clone git@github.com:flebieorg/flebie-frontend.git
git clone git@github.com:flebieorg/flebie-client-management-service.git
git clone git@github.com:flebieorg/flebie-client-notification-service.git
git clone git@github.com:flebieorg/flebie-config-server.git
git clone git@github.com:flebieorg/flebie-eureka-naming-server.git
git clone git@github.com:flebieorg/flebie-order-fulfillment-service.git
git clone git@github.com:flebieorg/flebie-availability-service.git
git clone git@github.com:flebieorg/flebie-docker.git
git clone git@github.com:flebieorg/flebie-zuul-api-gateway-server.git

cd flebie-order-management-service && mvn clean install & cd ..
cd flebie-lab-test-service && mvn clean install & cd ..
cd flebie-account-management-service && mvn clean install && cd ..
cd flebie-frontend && mvn clean install && cd ..
cd flebie-client-management-service && mvn clean install && cd ..
cd flebie-client-notification-service && mvn clean install && cd ..
cd flebie-config-server && mvn clean install && cd ..
cd flebie-eureka-naming-server && mvn clean install && cd ..
cd flebie-order-fulfillment-service && mvn clean install && cd ..
cd flebie-availability-service && mvn clean install && cd ..
