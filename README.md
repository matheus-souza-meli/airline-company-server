# AirlineCompanyApp

This REST API was made in Java using Spring boot, JPA and with HSQLDB database. Api returns a short list of flights from an airline.

# Table of contents
1. [Build](#build)
2. [Runnint](#running)
3. [Running Tests](#runningTests)
4. [API](#api)

## Build <a name="build"></a>

For build you need the regular `mvn` command 
http://maven.apache.org/run-maven/index.html[Maven v3.2.1 or above].

----
	mvn clean install
----

## Running <a name="running"></a>

----
	mvn spring-boot:run
----

or

----
	java -jar target/airline-company-0.0.1-SNAPSHOT.jar
----

## Running Tests <a name="runningTests"></a>

----
	mvn test
----

## API <a name="api"></a>

* **URL**

    /flights

* **Method**

    GET

* **Sample Call:**

    curl localhost:8080/flights

* **Response**
    
    ```json
    [
        {
            "id":1,
            "start":"1503235800000",
            "end":"1503244800000",
            "origin":"São José dos Campos - SP",
            "destiny":"Fortaleza - CE",
            "airplane":{
                "id":1,
                "model":
                "E195-E2",
                "capacity":144
            },
            "pilot":{
                "id":1,
                "name":"Matheus",
                "birthday":[1994,2,24]
            },
            "flightStatus":[
                {
                    "id":1,
                    "status":"SCHEDULED",
                    "time":"1503232200000"
                },
                {
                    "id":2,
                    "status":"TAKING_OFF",
                    "time":"1503235800000"
                },
                {
                    "id":3,
                    "status":"FLYING",
                    "time":"1503241200000"
                }
            ]
        },
        {
            "id":2,
            "start":"1503358200000",
            "end":"1503367200000",
            "origin":"São José dos Campos - SP",
            "destiny":"Curitiba - PR",
            "airplane":{
                "id":2,
                "model":"E175-E2",
                "capacity":90
            },
            "pilot":{
                "id":2,
                "name":"Raquel",
                "birthday":[1994,3,27]
            },
            "flightStatus":[
                {
                    "id":4,
                    "status":"SCHEDULED",
                    "time":"1503352800000"
                }
            ]
        }
    ]
    ```

**All Pull Requests are welcome!**

If you found a bug feel free to open one issue.
