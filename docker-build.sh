#!/bin/bash
docker build -t discovery-service:latest ./discovery-service
docker build -t gateway-service:latest ./api-gateway
docker build -t order-service:latest ./order-microservice
docker build -t product-service:latest ./microservice

