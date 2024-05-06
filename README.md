# Spring Boot Application with Kafka

This is a sample Spring Boot application that demonstrates how to integrate Apache Kafka for messaging and event-driven architecture.

## Features

- Producing messages: The application includes an endpoint to produce messages and publish them to a Kafka topic.
- Consuming messages: It also contains a message consumer that listens to the Kafka topic and processes incoming messages.
- Configuration: Various configuration options are available in the `application.properties` file to customize the behavior of the Kafka integration.

## Prerequisites

Before running this application, ensure you have the following prerequisites:

1. Java Development Kit (JDK) installed on your machine
2. Apache Kafka set up locally or accessible via remote connection
3. Maven build tool installed

## Getting Started

1. Clone the repository: 
     `git clone https://github.com/PujithaMohan/Springboot-KafkaBroker.git`

2. Navigate to the project directory:
     `cd springboot-kafka`

3. Configure Kafka properties:
     - Open `src/main/resources/application.properties`.
     - Update `spring.kafka.consumer.bootstrap-servers` and `spring.kafka.producer.bootstrap-servers` property with your Kafka broker address.
   
4. Build the project: `mvn clean install`

## Usage

1. Start the ZooKeeper service
   Navigate to Kafka folder in cmd :
      .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

2. Start the Kafka broker service
   Navigate to Kafka folder in cmd :
       .\bin\windows\kafka-server-start.bat .\config\server.properties

3. Run the springboot application

4. Access the endpoints:
- Use Postman to send POST requests to `http://localhost:8080/api/v1/kafka/publish` with JSON payload like :
- {
  "id":[value],
  "firstName":"[value]",
  "lastName" : "[value]"
  }

5. Check logs and verify message consumption in your configured Kafka setup.
                                      (or)
   Read the events
   Navigate to Kafka folder
       .\bin\windows\kafka-console-consumer.bat --topic topic_json --from-beginning --bootstrap-server localhost:9092

## Technologies Used

- Java 17
- Spring Boot framework
- Apache Kafka for messaging and event streaming
- Maven as build tool

## Folder Structure

The project structure looks like this:

spring-boot-kafka/
├── src/
│    ├── main/
│    │     ├── java/                  # Source code files
│    │     └── resources/             # Configuration files, including 'application.properties'
│    └── test/                         # Test files 
├── pom.xml                            # Project configuration file (for Maven)
└── README.md                          # Project documentation (you are here)


