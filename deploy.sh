#!/bin/bash

echo "========================================"
echo "Building Docker image..."
echo "========================================"

docker build -t registration-form:latest .

echo "Docker image built successfully."

echo "========================================"
echo "Loading image into KIND..."
echo "========================================"

kind load docker-image registration-form:latest --name registration-cluster

echo "Image loaded successfully."

echo "========================================"
echo "Deploying application to Kubernetes..."
echo "========================================"

kubectl apply -f registration-form-deployment.yaml
kubectl apply -f registration-form-service.yaml

echo "========================================"
echo "Waiting for Pods to be ready..."
echo "========================================"

kubectl wait --for=condition=Ready pod -l app=registration --timeout=120s

echo "========================================"
echo "Kubernetes Pods:"
echo "========================================"

kubectl get pods

echo "========================================"
echo "Kubernetes Services:"
echo "========================================"

kubectl get services

echo "========================================"
echo "Application URL:"
echo "========================================"

echo "http://localhost:31293"
