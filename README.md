# Recipe App Backend

This is the backend service for the Recipe App, built using Java and Spring. This service provides API endpoints to manage recipes by interacting directly with the Spoonacular API.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [IntelliJ HTTP Client](#intellij-http-client)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features
- RESTful API endpoints for managing recipes
- Integration with Spoonacular API for recipe data

## Installation
To run this project locally, follow these steps:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/recipe-app-backend.git
    cd recipe-app-backend
    ```

2. **Install dependencies:**
   Ensure you have Gradle installed. Then, run:
    ```bash
    ./gradlew build
    ```

## Usage
Once you have configured the application, you can run it locally:

The backend service will be available at http://localhost:8080.

## API Endpoints
Here are the main endpoints provided by this service:

* GET /v1/recipes?query=pizza - Search for recipes by query
* GET /api/v1/recipes/{id} - Retrieve a specific recipe by ID
* GET /api/v1/recipes/{id}?excludedIngredients=15001 - Retrieve a customized recipe by ID, excluding specific ingredients and recalculating calories (interesting part! 💫 )

## Configuration
To access the Spoonacular API, you need to set up your API key in the src/main/resources/application.properties file:

```properties
spoonacular.api-key=YOUR_API_KEY
```

## IntelliJ HTTP Client
There is an IntelliJ HTTP client file that contains usage examples for the three API endpoints. You can find this file in the project directory and use it to test the API endpoints directly from IntelliJ IDEA.
check out the file [http-requests-examples.http](http-requests-examples.http)

## Testing
A test class is provided for the service. checkout the file [RecipeServiceImplTest.java](src%2Ftest%2Fjava%2Forg%2Fbmomani%2Ffoodapi%2Fservice%2Fimpl%2FRecipeServiceImplTest.java)


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)