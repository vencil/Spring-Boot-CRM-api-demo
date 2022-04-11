# springboot-simple-crm-api-demo

A simple spring boot demo shows how to implement basic CRUD APIs to manipulate CRM data
under constructing...

## The ideal display content

Users who are not logged in will be directed to the login page: http://localhost:8080/login
You can login using the following three sets of Account/Password
* superuser / abc123
* manager / abc123
* operator / abc123

super user: access to all functions.
manager: modify/delete/view company/client data.
operator: create/view company/client data.

After successful login, you will be directed to the swagger-ui page: http://localhost:8080/swagger-ui/
and you are able to try the API operation based on the role permission
You can switch role at any time via the logout page: http://localhost:8080/logout

## Practical details

Use Spring Boot / H2 database / Maven / Spring Data JPA to build a backend RESTful API project.
Use Spring Security for role control.
Integrate with Swagger to display all APIs.

## Known issues

* Spring security doesn't work exactly right
* API details