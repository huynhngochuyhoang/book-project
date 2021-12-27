kubectl delete -f k8s/mysql.yml
kubectl delete -f k8s/book-client.yml
kubectl delete -f k8s/book-user.yml
kubectl delete -f k8s/book-service.yml
kubectl delete -f k8s/book-order.yml
kubectl delete -f k8s/book-gateway.yml
kubectl delete -f k8s/ingress.yml
kubectl detele pvc mysql-volume-mysql-sfs-0