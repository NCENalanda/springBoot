## Spring Security OAuth

If you're already a student of Learn Spring Security, you can get started diving deeper into OAuth2 with Module 10, and then Modules 12, 13, and the upcoming module 17. </br></br>
</br></br></br>



## Build the Project
```
mvn clean install
```



## Projects/Modules
This project contains a number of modules, but here are the main ones you should focus on and run: 
- `oauth-authorization-server` - the Authorization Server (port = 8081)
- `oauth-resource-server-1` - the Resource Server (port = 8082)
- `oauth-resource-server-2` - the secondary Resource Server (port = 8088)

And, depending on what grant type you want to try out, you'll work with one of these UI/Clients:  
- `angularjs/oauth-ui-implicit` (port = 8083)
- `angularjs/oauth-ui-password` (port = 8084)

Other Modules: 
- `clients-angular/oauth-ui-implicit-angular` - another version of the Implicit Grant UI Module - using Angular 7
- `clients-angular/oauth-ui-password-angular` - another version of the Password Grant UI Module - using Angular 7
- `clients-angular/oauth-ui-authorization-code-angular` - Authorization Code Grant UI Module - using Angular 7

Finally, you can ignore all other modules. 



## Run the Modules
You can run any sub-module using command line: 
```
mvn spring-boot:run
```

If you're using Spring STS, you can also import them and run them directly, via the Boot Dashboard 

You can then access the UI application - for example the module using the Password Grant - like this: 
`http://localhost:8084/`

You can login using these credentials, username:john and password:123 

## Run the Angular 7 Modules

- To run any of Angular7 front-end modules (_spring-security-oauth-ui-implicit-angular_ , _spring-security-oauth-ui-password-angular_ and _oauth-ui-authorization-code-angular_) , we need to build the app first:
```
mvn clean install
```

- Then we need to navigate to our Angular app directory:
```
cd src/main/resources
```

And run the command to download the dependencies:
```
npm install
```

- Finally, we will start our app:
```
npm start
```
- Note: Angular7 modules are commented out because these don't build on Jenkins as they need npm installed, but they build properly locally
- Note for Angular version < 4.3.0: You should comment out the HttpClient and HttpClientModule import in app.module and app.service.ts. These version rely on the HttpModule.

## Using the JS-only SPA OAuth Client
The main purpose of these projects are to analyze how OAuth should be carried out on Javascript-only Single-Page-Applications, using the authorization_code flow with PKCE.

The *SPA/clients-js-only-react* project includes a very simple Spring Boot Application serving a couple of separate Single-Page-Applications developed in React.

It includes two pages:
  * a 'Step-By-Step' guide, where we analyze explicitly each step that we need to carry out to obtain an access token and request a secured resource
  * a 'Real Case' scenario, where we can log in, and obtain or use secured endpoints (provided by the Auth server and by a Custom server we set up)
  * the Article's Example Page, with the exact same code that is shown in the related article

The Step-By-Step guide supports using different providers (Authorization Servers) by just adding (or uncommenting) the corresponding entries in the static/*spa*/js/configs.js.

### The 'Step-by-Step' OAuth Client with PKCE page
After running the Spring Boot Application (a simple *mvn spring-boot:run* command will be enough), we can browse to *http://localhost:8080/pkce-stepbystep/index.html* and follow the steps to find out what it takes to obtain an access token using the Authorization Code with PKCE Flow.

When prompted the login form, we might need to create a user for our Application first.

### The 'Real-Case' OAuth Client with PKCE page
To use all the features contained in the *http://localhost:8080/pkce-realcase/index.html* page, we'll need to first start the resource server (SPA/oauth-resource-server-auth0).

In this page, we can:
  * List the resources in our resource server (public, no permissions needed)
  * Add resources (we're requested the permissions to do that when logging in. For simplicity sake, we just request the existing 'profile' scope)
  * Remove resources (we actually can't accomplish this task, because the resource server requires the application to have permissions that were not included in the existing scopes)
