# Redis Notları - Udemy Redis Eğitim Seti

Redis is a RAM-based database that stores data in key-value pairs. It is written in C and is known for its high performance and low latency. Redis supports various data structures such as strings, hashes, lists, sets, and sorted sets.

Sample Redis key-value pair is like below:

```
Key: user1001

Value: {"name":"John Doe","age":30,"email":"john.doe@example.com"}
```
Redis returns the value associated with key if the key exists. If the key does not exist, Redis returns nil.
Redis is mainly used for the features below:
1. Caching: Redis is widely used as a caching layer to store frequently accessed data, reducing latency and improving application performance.
2. Session Management: Redis is often used to manage user sessions in web applications due to its fast read and write capabilities.
3. Real-time Analytics: Redis can handle high throughput data ingestion and real time analytics, making it suitable for applications that require instant insights.
4. Message Queuing: Redis supports pub/sub messaging and can be used as a message broker for building scalable applications.

> To install:
> pkg instal redis
> 
> To activate: redis_enable = "YES"
>
> To start/stop/restart service: service redis start/stop/restart
>
> Configuration File: /usr/local/etc/redis.conf
>
> Redis Client: redis-cli

Commands for redis-cli:
```
- set key value: set user1 name1
- get user1 --> name1
- mset key1 value1 key2 value2 : for multiple data insertion
- mget key1 key2 key3: multiple get
- append key value: if key exist, it appends the new value at the end. Else, it adds new key value pair.
- del key1 key2 key3: deletes the key value pair
- flushall: deletes all data
- expire key time_in_second: deletes the key when it expires determined by time_in_second
- expireat key timestamp: deletes the key according to the timestamp specified
- ttl key: diplays the time to live of the key
- keys * : lists all keys
- keys <pattern> : lists the keys following to pattern
- type key: returns the type of the key
- info
- time: unix time and current microsecond
- dbsize: returns the number of keys
- monitor: monitors the entering commands on redis simultanously
- exist key: checks whether the key exists
- strlen key: length of the key
- rename key newKey
- incr/decr key : increases/decreases value of key by 1
- incr/decrby key size: increases/decreases by size
```

>Assume data.txt has three lines:
>
>set key1 value1
>
>set key2 value2
>
>set key3 value3
>
>cat data.txt | redis-cli --pipe : enters all the data in data.txt to redis

- There are data types like hash and list. They work quite similar with previous types.