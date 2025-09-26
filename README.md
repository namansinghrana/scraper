
# ThreadFlow: Multithreaded Producer-Consumer Simulation

## Overview

ThreadFlow is a Java-based educational project that demonstrates the use of multithreading to solve the classic producer-consumer problem. The simulation models a warehouse where multiple producers generate goods and multiple consumers place orders for those goods. The system is designed to handle race conditions, delays, and thread synchronization, providing a practical example of concurrent programming in Java.

## Features

- **Multithreaded Simulation:** Multiple producer and consumer threads operate concurrently.
- **Warehouse Inventory:** Goods are stored and managed in a synchronized warehouse.
- **Randomized Production and Consumption:** Both producers and consumers randomly select product types and quantities.
- **Thread Synchronization:** All inventory operations are thread-safe, preventing race hazards.
- **Console Logging:** Real-time status updates for production, consumption, and warehouse inventory.

## Project Structure

```
src/pr_lab_9/
  ├── Lab9.java         # Main entry point; sets up and starts all threads
  ├── Producer.java     # Producer thread logic
  ├── Consumer.java     # Consumer thread logic
  ├── Warehouse.java    # Synchronized warehouse for goods storage
  ├── Goods.java        # Represents a type of good and its quantity
  ├── Type.java         # Defines available product types and random selection
```

## How It Works

- **Lab9.java:** Initializes the simulation with a configurable number of producers and consumers. Each thread is started and interacts with the shared `Warehouse` instance.
- **Producer.java:** Each producer thread randomly selects a product type and quantity, then attempts to add goods to the warehouse. If the warehouse is full, the producer waits and retries.
- **Consumer.java:** Each consumer thread randomly selects a product type and quantity, then attempts to take goods from the warehouse. If insufficient goods are available, the consumer waits and retries.
- **Warehouse.java:** Manages inventory for each product type. All `add` and `take` operations are synchronized to ensure thread safety.
- **Goods.java:** Represents an individual product type and tracks its quantity.
- **Type.java:** Enumerates available product types (e.g., tomato, cucumber, onion) and provides random selection functionality.

## Running the Project

1. **Compile the Source Code:**
	```
	javac src/pr_lab_9/*.java
	```

2. **Run the Simulation:**
	```
	java -cp src pr_lab_9.Lab9
	```

3. **Observe Output:**
	- The console will display logs from producers and consumers, as well as periodic warehouse inventory snapshots.

## Customization

- **Number of Producers/Consumers:** Adjust `NUM_PRODUCERS` and `NUM_CONSUMERS` in `Lab9.java` to simulate different workloads.
- **Product Types:** Modify `Type.java` to add or remove product types.
- **Warehouse Capacity:** Change `SHELF_CAPACITY` in `Warehouse.java` to increase or decrease storage limits.

## Educational Value

This project is ideal for students and developers learning about:
- Java threads and concurrency
- Synchronization and race condition avoidance
- Producer-consumer design patterns

---
