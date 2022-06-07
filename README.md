# currency-exchange-rate-analysis
Application run instruction:
1. Set your appid for OpenExchangeRate service and set apikey for Giphy service in application.properties

2. Build .jar file by gradle: ./gralew build

3. Build image from Dockerfile:
    docker build  -t currency-exchange .
    
4. Run docker container with application from image:
    docker run -p 8080:8080 currency-exchange
    
5. Send GET request to /api/v1/analysis/create/ endpoint with parameter:
    String code - International-standard 3-letter ISO currency code
