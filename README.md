📘 README: Producer-Consumer using Message Queue in Java
🧾 Description
This is a basic implementation of the Producer-Consumer Problem using a custom bounded queue (MessageQueue) in Java. It simulates a simple message-passing system where:

Producers generate messages and add them to a queue.

Consumers retrieve and process messages from the queue.

Java's intrinsic synchronization (synchronized, wait(), notifyAll()) is used for thread communication.

🏗️ Project Structure
```
├── Message.java        // Represents a single message
├── MessageQueue.java   // Custom bounded message queue
├── Producer.java       // Producer thread
├── Consumer.java       // Consumer thread
└── Main.java           // Entry point
```

🧩 Class Overview
🔹 Message.java
Represents a message object with a unique messageId.


🔹 MessageQueue.java
A thread-safe queue that handles synchronization between producers and consumers.
It uses a LinkedBlockingDeque internally and a maximum size for bounding.

Key methods:
produce(Message msg) - Waits if the queue is full, otherwise adds message and notifies consumers.
consume() - Waits if the queue is empty, otherwise removes a message and notifies producers.

🔹 Producer.java
Implements Runnable to run in a separate thread.
Creates and adds 10 messages into the queue with small delays.

🔹 Consumer.java
Implements Runnable.
Consumes 10 messages from the queue, simulating processing delay.

🔹 Main.java
Starts both producer and consumer threads and waits for their completion.

⚙️ How It Works
Only one producer and one consumer thread are started.

The queue has a maximum size of 5.

The producer adds 10 messages; if the queue is full, it waits.

The consumer removes 10 messages; if the queue is empty, it waits.

wait() and notifyAll() coordinate this behavior.

🏁 Running the Code
message produced: id:0

message consumed: id:0

message produced: id:1

message produced: id:2

message produced: id:3

message produced: id:4

message produced: id:5

message consumed: id:1

message produced: id:6

message consumed: id:2

message produced: id:7

message consumed: id:3
message produced: id:8
message consumed: id:4
message produced: id:9
message consumed: id:5
message consumed: id:6
message consumed: id:7
message consumed: id:8
message consumed: id:9
