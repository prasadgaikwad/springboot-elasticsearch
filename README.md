# Spring Boot Elasticsearch Weather Service

This project is a demo application that demonstrates the integration of Spring Boot with Elasticsearch. It fetches weather data from an external API (MetaWeather), stores it in Elasticsearch, and exposes a simple REST API to retrieve weather information for a given location.

## Prerequisites

Before you begin, ensure you have the following installed:

*   Java Development Kit (JDK) 11 or higher
*   Apache Maven
*   Docker (for running Elasticsearch)

## Getting Started

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/springboot-elasticsearch.git
    cd springboot-elasticsearch
    ```
2.  **Start Elasticsearch using Docker Compose:**
    In the root directory of the project, run:
    ```bash
    docker-compose up -d
    ```
    This will start an Elasticsearch container in the background.
3.  **Build the application:**
    ```bash
    ./mvnw clean install
    ```
4.  **Run the application:**
    ```bash
    java -jar target/springboot-elasticsearch-0.0.1-SNAPSHOT.jar
    ```
    The application will start on port 8080 by default.

## API Endpoint

The application exposes the following API endpoint:

### Get Weather by Location ID

*   **GET** `/weather`
*   **Description:** Retrieves weather information for a specific location using its "Where On Earth ID" (WOEID).
*   **Request Parameters:**
    *   `locationId` (string, required): The WOEID of the location. Defaults to `44418` (London) if not provided.
*   **Example Request (using curl):**
    ```bash
    curl "http://localhost:8080/weather?locationId=2487956"
    ```
    This will fetch the weather for San Francisco (WOEID: 2487956).
    To get weather for the default location (London):
    ```bash
    curl "http://localhost:8080/weather"
    ```

## Project Structure

*   `src/main/java`: Contains the main source code for the application.
    *   `client`: Components for interacting with external APIs (e.g., `WeatherApiClient`).
    *   `config`: Configuration classes for Spring Boot and Elasticsearch.
    *   `controller`: Spring MVC controllers that handle incoming HTTP requests (e.g., `WeatherController`).
    *   `model`: Data model classes (e.g., `Location`).
    *   `repository`: Spring Data Elasticsearch repositories for data access (e.g., `WeatherRepository`).
    *   `service`: Business logic components (e.g., `WeatherService`).
*   `src/main/resources`: Contains application resources.
    *   `application.yml`: Configuration file for Spring Boot.
    *   `sample.json`: An example of the JSON structure used by the weather API.
*   `pom.xml`: The Maven Project Object Model file, defining project dependencies and build configuration.
*   `docker-compose.yml`: Docker Compose file for setting up the Elasticsearch service.
*   `README.md`: This file.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is open source and available under the MIT License.
