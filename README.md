# car2gosling
Simple Java client wrapping the Car2Go API v2.1: https://github.com/car2go/openAPI/wiki.  Returns data as a `String` in JSON array format.

James Gosling has not endorsed this library in any way and is (hopefully) completely unaware of its existence.

## Car2Go API Oauth consumer key required
Email openapi@car2go.com with your request for a key.  See https://github.com/car2go/openAPI/wiki for details.

Provide the key to your program by sending the system property to the JVM thusly:

`-DCAR2GO_CONSUMER_KEY=yoursecretkey`

## Tests
Functional tests only (this client doesn't manipulate data).  These functional tests hit the Car2Go API for realz so you need a Car2Go API OAuth token for them to pass (see https://github.com/car2go/openAPI/wiki).

When running the tests with Maven (or any target that causes tests to run, e.g. `package`) you'll need a Car2Go OAuth consumer key assigned to `CAR2GO_CONSUMER_KEY`.

`mvn test -DCAR2GO_CONSUMER_KEY=yoursecretkey`
