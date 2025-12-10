#!/bin/bash

# Start Zookeeper
zookeeper-server-start.sh config/zookeeper.properties &
sleep 5

# Start Kafka
kafka-server-start.sh config/server.properties &
sleep 5

# Create topic
kafka-topics.sh --create --bootstrap-server localhost:9092 \
  --replication-factor 1 --partitions 1 --topic Hello-Kafka

echo "Kafka setup complete!"
echo "Topic: Hello-Kafka"
echo "Bootstrap Server: localhost:9092"
