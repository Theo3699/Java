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
