# Java JAX-RS REST 

## Description
This repository contains a collection of Java-based RESTful Web API examples built using the **JAX-RS (Jersey)** framework. The APIs are hosted on a standalone **Grizzly HTTP server** and utilize in-memory data structures for quick development and testing. It serves as a practical demonstration of handling HTTP methods, content negotiation, and routing in Java.

## Tech Stack & Dependencies
* **Language:** Java
* **Framework:** Jersey
* **Server:** Grizzly HTTP Server

## Project Structure
The workspace is organized into distinct example modules:

* **`rest_example_messages`:** A complete CRUD API demonstrating how to Create, Read, Update, and Delete messages. It showcases content negotiation by responding with `application/json`, `text/html`, or `text/plain` depending on the client's request headers.
* **`rest_example_sensor`:** An additional example demonstrating RESTful endpoints for sensor data simulation.
* **`libs/`:** Contains the required local dependencies (`grizzly`, `jaxrs`, `jaxb-ri-2.3.1`) needed to compile and run the project.


## Testing with Postman
Because these APIs do not include a frontend web interface, I used **Postman** for interacting with the endpoints.
<img width="1274" height="642" alt="Screenshot 2026-03-30 at 17 07 58" src="https://github.com/user-attachments/assets/2adbe75f-2948-4064-820f-18b1b124407b" />
<img width="1275" height="583" alt="Screenshot 2026-03-30 at 17 08 09" src="https://github.com/user-attachments/assets/79bb74a1-d940-4f9b-8c66-04036b4fd5e2" />

* **GET Requests:** Send a `GET` request to `http://localhost:8080/demo/rest/messages` to retrieve all stored data.
* **Test Content Negotiation:** In Postman, go to the **Headers** tab and change the `Accept` key to `application/json`, `text/html`, or `text/plain` to see how the API alters its response format.
* **POST Requests:** Create new entries by sending a `POST` request. Go to the **Body** tab, select `raw` and `JSON`, and send a valid JSON payload to `http://localhost:8080/demo/rest/messages`. 
* **PUT and DELETE:** Test updating and removing records by appending an ID to the URL (e.g., `DELETE http://localhost:8080/demo/rest/messages/1`).
