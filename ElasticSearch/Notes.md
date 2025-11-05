# Elasticsearch Notes

## What is Elasticsearch?
Elasticsearch is a distributed, RESTful search and analytics engine built on top of Apache Lucene. It is designed for horizontal scalability, reliability, and real-time search capabilities. In Elasticsearch, data is stored in JSON format and can be indexed and queried efficiently. It is commonly used for log and event data analysis, full-text search, and various other applications that require fast search capabilities. Elasticsearch is part of the Elastic Stack, which also includes Logstash (data processing pipeline) and Kibana (data visualization).

Elasticsearch is basically a NoSQL database that specializes in search and analytics, making it different from traditional relational databases. It allows for complex queries, aggregations, and real-time data analysis, making it a powerful tool for handling large volumes of data.

A sample use case of Elasticsearch is in log management, where it can ingest, store, and analyze log data from various sources, enabling users to quickly search and visualize log information for troubleshooting and monitoring purposes.

For a real-world example, consider an e-commerce website that uses Elasticsearch to power its product search functionality. When users search for products, Elasticsearch quickly retrieves relevant results based on various criteria such as keywords, categories, price ranges, and user reviews. The flow of this scnario typically involves the following steps:
1. **Data Ingestion**: Product data is ingested into Elasticsearch from the e-commerce platform database, including product names, descriptions, prices, and reviews.
2. **Indexing**: The ingested data is indexed in Elasticsearch, allowing for efficient searching and retrieval.
3. **Search Query**: When a user performs a search on the website, a search query is sent to Elasticsearch.
4. **Result Retrieval**: Elasticsearch processes the query, searches the indexed data, and returns relevant product results based on the search criteria.

## Key Features of Elasticsearch
1. **Distributed Architecture**: Elasticsearch is designed to be distributed, allowing it to scale horizontally across multiple nodes and handle large volumes of data.
2. **Full-Text Search**: It provides powerful full-text search capabilities, including support for various languages, stemming, and relevance scoring.
3. **Real-Time Data**: Elasticsearch supports near real-time search and analytics, making it suitable for applications that require up-to-date information.
4. **RESTful API**: Elasticsearch exposes a RESTful API, making it easy to interact with using standard HTTP methods.
5. **Schema-Free**: It allows for flexible data modeling without a predefined schema, enabling dynamic mapping of fields.
6. **Aggregations**: Elasticsearch provides robust aggregation capabilities for summarizing and analyzing data.

## Types of Elasticsearch Nodes
1. **Master Node**: Responsible for cluster-wide operations such as creating or deleting indices, tracking nodes, and managing cluster state.
2. **Data Node**: Stores and manages the data and performs data-related operations such as indexing and searching.
3. **Ingest Node**: Handles data preprocessing and transformation before indexing, using ingest pipelines.
4. **Coordinating Node**: Acts as a load balancer, routing requests to the appropriate data nodes and aggregating results.

## Common Use Cases of Elasticsearch
1. **Log and Event Data Analysis**: Collecting, storing, and analyzing log data from various sources for monitoring and troubleshooting.
2. **Full-Text Search**: Implementing search functionality for websites, applications, and document repositories.
3. **E-Commerce Search**: Powering product search and recommendation engines for online stores.
4. **Business Analytics**: Analyzing large datasets for business intelligence and reporting.
5. **Security Analytics**: Monitoring and analyzing security-related data for threat detection and incident response.

## Operation Formats
```bash
PUT /{index}/{type}/{id} // index is a database, type is table, id is primary key
{
    "field1": "value1",
    "field2": "value2" 
}

GET /{index}/{type}/{id}

POST /{index}/{type}/{id}/_update
{
    "doc": {
        "field1": "new_value1"
    }
}

DELETE /{index}/{type}/{id}
```
## Basic Elasticsearch Operations
1. **Indexing Data**: Adding documents to an index using the `PUT` or `POST` HTTP methods. Example:
```bash
curl -X PUT "localhost:9200/products/_doc/1" -H 'Content-Type: application/json' -d'
{
    "name": "Sample Product",
    "price": 29.99,
    "description": "This is a sample product."
}'
```
H option is used to specify the content type as JSON. d option is used to provide the JSON data to be indexed.

2. **Searching Data**: Querying indexed documents using the `GET` method with a search query. Example:
```bash
curl -X GET "localhost:9200/products/_search" -H 'Content-Type: application/json' -d'
{
    "query": {
        "match": {
            "name": "Sample"
        }
    }
}'
```
3. **Updating Documents**: Modifying existing documents using the `POST` method. Example:
```bash
curl -X POST "localhost:9200/products/_doc/1/_update" -H 'Content-Type: application/json' -d'
{
    "doc": {
        "price": 24.99
    }
}'
```
4. **Deleting Documents**: Removing documents from an index using the `DELETE` method. Example:
```bash
curl -X DELETE "localhost:9200/products/_doc/1"
```