read -p "Your docker id: " DOCKER_ID

CURRENT_PWD="$PWD"

# Build jar file
cd $CURRENT_PWD/book-be
mvn package -DskipTests

# Build frontend
cd $CURRENT_PWD/book-fe
npm install
ng build


# Build docker images
cd $CURRENT_PWD/book-be/api-gateway
docker build -t gateway .
cd $CURRENT_PWD/book-be/book-service
docker build -t book-service .
cd $CURRENT_PWD/book-be/order-service
docker build -t order-service .
cd $CURRENT_PWD/book-be/user-service
docker build -t user-service .
cd $CURRENT_PWD/book-fe/
docker build -t book-client .
cd $CURRENT_PWD

# Tagging images
docker tag gateway $DOCKER_ID/book-gateway
docker tag book-service $DOCKER_ID/book-service
docker tag order-service $DOCKER_ID/order-service
docker tag user-service $DOCKER_ID/user-service
docker tag book-client $DOCKER_ID/book-client

# Push images
docker push $DOCKER_ID/book-gateway
docker push $DOCKER_ID/book-service
docker push $DOCKER_ID/order-service
docker push $DOCKER_ID/user-service
docker push $DOCKER_ID/book-client
