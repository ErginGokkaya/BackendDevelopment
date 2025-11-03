# RESTful API Notes

## 1. What is a RESTful API?
A RESTful API (Representational State Transfer) is an architectural style for designing networked applications. It relies on a stateless, client-server communication protocol, typically HTTP. RESTful APIs use standard HTTP methods such as GET, POST, PUT, DELETE, and PATCH to perform operations on resources, which are identified by URLs (Uniform Resource Locators).

## 2. Why do we need RESTful APIs? 

RESTful APIs are essential for several reasons:
1. **Statelessness**: RESTful APIs are stateless, meaning each request from a client to a server must contain all the information needed to understand and process the request. This simplifies server design and improves scalability.
2. **Scalability**: Because RESTful APIs are stateless, they can handle a large number of requests from multiple clients simultaneously, making them suitable for high-traffic applications.
3. **Flexibility**: RESTful APIs can handle multiple types of calls, return different data formats (like JSON, XML), and can be used over various protocols (though HTTP is the most common).
4. **Separation of Client and Server**: RESTful APIs allow the client and server to evolve independently. The client can be updated without affecting the server and vice versa, as long as the API contract is maintained.
5. **Cacheability**: Responses from RESTful APIs can be cached, which improves performance by reducing the need for repeated requests to the server for the same resource.
6. **Uniform Interface**: RESTful APIs provide a uniform interface that simplifies and decouples the architecture, making it easier for developers to understand and use the API.

## Anatomy of a Request
A typical RESTful API request consists of the following components:
1. **HTTP Method**: The action to be performed (e.g., GET, POST, PUT, DELETE).
Common methods include:

GET: Retrieve data from the server.

POST: Send data to the server to create a new resource.

PUT: Update an existing resource on the server.

DELETE: Remove a resource from the server.

HEAD: Retrieve metadata about a resource without fetching the resource itself.

CONNECT: Establish a tunnel to the server identified by the target resource.

OPTIONS: Describe the communication options for the target resource.

TRACE: Perform a message loop-back test along the path to the target resource.

2. **URL/Endpoint**: The specific resource being accessed i.e base url + a path as a destination (e.g., /users/123).

 A sample path could be `/users/:username/repos` for github. [:] indicates a variable parameter i.e username can be any valid username. 
 
 Additional query parameters can be appended to the URL using `?` and `&` that is ?query1=value1&query2=value2 (e.g., /users?role=admin). 

3. **Headers**: Metadata about the request (e.g., Content-Type, Authorization). 

Headers provide additional context and instructions for the server on how to process the request. Header property-value format examples include:
- Host: Specifies the domain name of the server (e.g., api.example.com).
- Content-Type: Specifies the media type of the resource (e.g., application/json).
- Authorization: Contains credentials for authenticating the client (e.g., Bearer token).
- Accept: Indicates the media types that the client is willing to receive (e.g., application/json).
- User-Agent: Identifies the client software making the request (e.g., Mozilla/5.0).
- Cache-Control: Directives for caching mechanisms in both requests and responses (e.g., no-cache).

4. **Body**: The data sent with the request (mainly for POST and PUT requests).

Example of a RESTful API Request
```GET /users/123 HTTP/1.1
Host: api.example.com
Authorization: Bearer your_token_here
Accept: application/json
```