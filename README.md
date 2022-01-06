# Java
# All the projects for the java master course

## Lab2
I created a Web application containing the following components:
- input.jsp: a page containing a form for introducing a record, i.e. a triple containing a category, a key and a value. (The key may be a word and the value may be its definition). The categories are not static, being read from a server-side component (an object);
- result.jsp a page describing the response that will be delivered to the client, for example an HTML table containing the records stored on the server.
- an object-oriented domain model;
- a server-side component responsible with the business-logic of the application: writing the record to a server-side data structure, reading data from it, etc.
- a server-side component responsible with controlling the web-flow.
- a web filter that will log all requests received by input.jsp.
- a web filter that will decorate the response by adding a specific prelude (at the beginning) and a specific coda (at the end) to the generated HTML page.
- a cookie that stores the category selected by the client. ( the category is set automatically when the client returns to the site)
- a math-inspired captcha.

## Lab3 --> DatabaseLaborator3-facultate
Created the following components:
- A Web page for defining the exams. Each exam has a name, a starting time and a duration. --> inputExams.xhtml
- A Web page for defining the students that must attend the exams. Each student has a name and the list of exams. --> inputStudents.xhtml
- Use a relational database and JDBC in order to store and retrieve data. (PostgreSQL is recommended).
- Use at least one non trivial JSF component, for example a data table, a dialog, etc. -->viewTables.xhtml. Used a dataTable
- Internationalize the user interface and offer support for at least two locales. --> en and ro

## Lab4 --> DatabaseLaborator3-facultate
Created the following pages and components:
- [page.xhtml](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/WEB-INF/templates/page.xhtml): describing the general aspect of the application pages: [header](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/views/header.xhtml), content, [footer](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/views/footer.xhtml). The header should display the title and might include a [menu bar](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/views/menuBar.xhtml).
The footer will display a copyright notice and the current version of the aplication. The header, footer and the menu bar should all be in separate .xhtml files.
- [dataView.xhtml](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/WEB-INF/templates/genericDataView.xhtml): a generic page for displaying data as a list, dataTable, etc.
- [dataEdit.xhtml](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/WEB-INF/templates/genericDataEdit.xhtml): a generic page for editing data. This could be a dialog containing a generic form.
- at least one [composite](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/resources/ezcomp/autoComplete.xhtml) component using auto-complete. 
- use the components ajax and [poll](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/webapp/views/home.xhtml) in order to continuously display how many students are enlisted for an exam.

## Lab 5 --> DatabaseLaborator3-facultate
Implemented the following:
- Defined the [persistence](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/resources/META-INF/persistence.xml) unit using a data source configured as a JDBC Resource.
- Created the [EntityManager](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/java/com/theo/config/JPAConfig.java) objects using dependency injection.
- Defined the [mappings](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/java/com/theo/entities/ExamEntity.java) using JPA-only annotations.
- Implemented the [repository](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/java/com/theo/repositories/ExamRepository.java) classes using JPA-QL.
- Defined at least two type of classes representing exams. (ProjectEntity and PresentationEntity)

## Lab 6 --> DatabaseLaborator3-facultate
- Used the support offered by the EJB technology for implementing transactions.
The following enterprise beans were implemented:
- A [stateless](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/java/com/theo/repositories/ResourcesRepository.java) session bean that offers methods for checking the availability of a resource.
- A [stateful](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/java/com/theo/beans/AssignmentStatefulBean.java) session bean responsible with the assignment of one or more resource to a specific exam.
- A [singleton](https://github.com/Theo3699/Java/blob/main/DatabaseLaborator3-facultate/src/main/java/com/theo/beans/SingletonCurrentAssignments.java) session bean that keeps an in-memory map of the current assignments.

## Lab 7 --> Lab7
Created a JSF application for managing the submission of documents into a repository. The application allows the following:
- An [authentication](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/beans/Login.java) mechanism based on username and password
- Register new users and assign them a specific role (Admin, User)
- Specify a time frame, in which registration is open for users and submissions.
- The possibility to upload a document (for [authors](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/webapp/views/user.xhtml)) and to view all uploaded documents (for [admin](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/webapp/views/admin.xhtml)). Each uploaded document will have a uniquely generated registration number. All submissions will be logged in a text file.

Used Contexts and Dependency Injection (CDI) for:
- the management of application's beans; ([@Inject](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/repositories/DocumentRepository.java)) and transactions ([@Transactional](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/repositories/UserRepository.java))
- decoupling the components using dependency injection; ([@Produces](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/config/JPAConfig.java))
- decoupling orthogonal concerns, such as logging; ([@Interceptor](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/config/MyInterceptor.java))
- decoupling bussines concerns, such as verifying the date for operations like registration and submission ([@Decorator](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/config/ValidateTimeFrameDecorator.java));
- implementing at least one event-based comunication ([@Observes](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/beans/Database.java));
- data validation, using Bean Validation [annotations](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/beans/DocumentBean.java).

## Lab 8 --> Lab7
Created RESTful Web services using JAX-RS that allow the interaction with at least one JPA entity, implementing CRUD operations.
- [AddDocumentService](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/services/AddDocumentService.java) that allows adding a new document;
- [UpdateDocumentService](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/services/UpdateDocumentService.java) that allows replacing an existing document;
- [DeleteDocumentService](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/services/DeleteDocumentService.java) that allows deleting an existing document from the database;
- [ViewDocumentService](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/services/ViewDocumentService.java) that returns a "list" of the documents there were uploaded. The parameter of the web method will be an identifier for the user. If the parameter is null, then all documents should be considered.
- Use JSON for representing consumed or produced data.

Created a [filter](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/config/DocumentFilter.java) that will act as a cache for the ViewDocumentService, storing the parameters of the incoming request and the returned responses. If the documents are modified by the application, reset the cache accordingly.

## Lab 9 -> first three bullets are in Lab7, the other two bullets are in microservice
Add security features to the application created in the previous lab, using standard mechanisms offered by Java EE for:
- Authentication, using a JDBC Realm (followed all the steps in the course and http://www.mastertheboss.com/jbossas/jboss-security/configure-an-elytron-jdbc-realm-on-wildfly-11/ and other tutorials in order to set the jdbc realm. However, i cannot start the server once the configurations are made  (i am getting an error while deploying the artifact). I have added these "comments" in order to see that i really tried :) );
- Controlling the access to Web resources, using Web constraints;
- [Securing](https://github.com/Theo3699/Java/blob/main/Lab7/src/main/java/ro/theo/lab7/services/ViewDocumentService.java) the business logic components and REST services.

Expose a CRUD REST [resource](https://github.com/Theo3699/Java/blob/main/microservice/src/main/java/ro/theo/microservice/services/ViewDocumentService.java) from the previous lab as a microservice.
- Run the microservice using an Eclipse Microprofile server implementation (Microprofile 4.0 + Wildfly)
- Create an [additional](https://github.com/Theo3699/Java/blob/main/microservice/src/main/java/ro/theo/microservice/services/ClientController.java) microservice that will invoke the first one.
