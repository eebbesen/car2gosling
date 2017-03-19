# car2gosling
Car2Go Java API client

James Gosling has not endorsed this library in any way and is (hopefully) completely unaware of its existence.

## Tests
The functionality is pretty light right now so there's only one test. It is a functional test that hits the Car2Go API for realz so you need a Car2Go API for it to pass (see https://github.com/car2go/openAPI/wiki).  Feel free to mock that behavior out.

When running the tests with Maven (or any target that causes tests to run, e.g. `package`)you'll need a Car2Go OAuth consumer key assigned to `CAR2GO_CONSUMER_KEY`.

`mvn test -DCAR2GO_CONSUMER_KEY=yoursecretkey`
