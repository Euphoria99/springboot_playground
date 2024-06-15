module: security

When a user accesses an endpoint like `/employees` in your Spring Boot application, several layers work together to process the request and return a response. Here's a step-by-step flow of execution from the REST controller to the database and back:

1. **HTTP Request to Controller:**
   - A user makes an HTTP request to an endpoint, e.g., `/api/employees`.

2. **Controller Layer (EmployeeRestController):**
   - The request is handled by the corresponding method in `EmployeeRestController`. For example, a GET request to `/api/employees` invokes the `findAll()` method.

3. **Service Layer (EmployeeService and EmployeeServiceImpl):**
   - Inside the `findAll()` method, the controller calls the `findAll()` method of `EmployeeService`, which is implemented by `EmployeeServiceImpl`.
   - The controller uses constructor injection to get an instance of `EmployeeServiceImpl`.

4. **Repository Layer (EmployeeRepository):**
   - The `findAll()` method in `EmployeeServiceImpl` calls the `findAll()` method of `EmployeeRepository`.
   - `EmployeeRepository` extends `JpaRepository`, which provides the method `findAll()` along with other CRUD operations.

5. **Data Access with JPA (EmployeeRepository):**
   - `JpaRepository` is a Spring Data interface that provides methods to perform database operations. The actual implementation is provided at runtime by Spring Data JPA.
   - The call to `findAll()` retrieves all `Employee` entities from the database.

6. **Entity Layer (Employee):**
   - The `Employee` entity is a plain Java object (POJO) annotated with JPA annotations (`@Entity`, `@Table`, `@Id`, etc.). It maps to the `employee` table in the database.
   - JPA uses these annotations to translate between database rows and Java objects.

7. **Return Response:**
   - The list of `Employee` entities retrieved by `EmployeeRepository` is returned to `EmployeeServiceImpl`.
   - `EmployeeServiceImpl` returns this list to `EmployeeRestController`.
   - The controller method `findAll()` returns the list to the client as a JSON response.

Here's a detailed breakdown for the `findAll()` method:

```java
@GetMapping("/employees")
public List<Employee> findAll() {
    return employeeService.findAll();
}
```

- **Security Configuration (DemoSecurityConfig):**
  - Before the controller method is invoked, Spring Security checks if the user has the appropriate role (e.g., "EMPLOYEE" for GET requests).
  - If the user is authorized, the request proceeds. If not, a 403 Forbidden response is returned.

- **Execution Flow:**
  1. **User makes a GET request to `/api/employees`.**
  2. **Spring Security intercepts the request and checks authorization.**
  3. **The request is mapped to `EmployeeRestController.findAll()`.**
  4. **`EmployeeRestController.findAll()` calls `EmployeeService.findAll()`.**
  5. **`EmployeeServiceImpl.findAll()` calls `EmployeeRepository.findAll()`.**
  6. **`JpaRepository.findAll()` retrieves data from the database.**
  7. **The list of `Employee` objects is returned through the layers back to the controller.**
  8. **`EmployeeRestController.findAll()` returns the list as a JSON response to the client.**

For other operations like creating, updating, and deleting employees, the flow is similar but involves additional steps like handling HTTP methods (POST, PUT, DELETE), checking for existing records, and performing save or delete operations.

- **Create (POST `/employees`):**
  1. **User sends a POST request with employee data.**
  2. **Spring Security checks for "MANAGER" role.**
  3. **Request mapped to `EmployeeRestController.addEmployee()`.**
  4. **`addEmployee()` calls `EmployeeService.save()`.**
  5. **`EmployeeServiceImpl.save()` calls `EmployeeRepository.save()`.**
  6. **JPA inserts the new employee into the database.**
  7. **The saved `Employee` object is returned through the layers.**

- **Update (PUT `/employees`):**
  1. **User sends a PUT request with updated employee data.**
  2. **Spring Security checks for "MANAGER" role.**
  3. **Request mapped to `EmployeeRestController.updateEmployee()`.**
  4. **`updateEmployee()` calls `EmployeeService.save()`.**
  5. **`EmployeeServiceImpl.save()` calls `EmployeeRepository.save()`.**
  6. **JPA updates the employee in the database.**
  7. **The updated `Employee` object is returned through the layers.**

- **Delete (DELETE `/employees/{employeeId}`):**
  1. **User sends a DELETE request with an employee ID.**
  2. **Spring Security checks for "ADMIN" role.**
  3. **Request mapped to `EmployeeRestController.deleteEmployee()`.**
  4. **`deleteEmployee()` calls `EmployeeService.deleteById()`.**
  5. **`EmployeeServiceImpl.deleteById()` calls `EmployeeRepository.deleteById()`.**
  6. **JPA deletes the employee from the database.**
  7. **A confirmation message is returned through the layers.**
