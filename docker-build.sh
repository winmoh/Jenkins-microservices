#!/bin/bash
docker build discovery-service:latest ./discovery-service
docker build gateway-service:latest ./api-gateway
docker build order-service:latest ./order-service
docker build product-service:latest ./microservice

