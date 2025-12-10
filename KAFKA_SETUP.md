
```bash
./start_kafka-zookeeper.sh
kafka-topics.sh --create --bootstrap-server localhost:9092 \
--replication-factor 1 --partitions 1 --topic Hello-Kafka
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic Hello-Kafka
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Hello-Kafka --from-beginning
cd /shared_volume/BIGDATA_ENGINEERING_LABS/lab4_kafka_11262025
mkdir -p src/main/java/edu/supmti/kafka
cat > PROGRESS.md << 'EOF'
# Lab 4: Apache Kafka
## Started: 11/26/2025

## ✅ Completed - 11/26/2025:
- Kafka installation verified and running
- Zookeeper and Kafka services started  
- Topic "Hello-Kafka" created successfully
- Console producer/consumer tested and working
- Basic Kafka functionality confirmed

## 🔄 Next Steps:
- Develop Java Kafka applications (EventProducer/EventConsumer)
- Set up Kafka Connect
- Implement Kafka Streams WordCount
- Multi-broker cluster configuration

## Technical Details:
- Kafka Topic: Hello-Kafka
- Bootstrap Server: localhost:9092
- Partitions: 1, Replication Factor: 1
