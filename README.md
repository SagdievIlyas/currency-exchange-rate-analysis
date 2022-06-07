# currency-exchange-rate-analysis
Application run instruction:

1. Build image from Dockerfile:
    docker build  -t currency-exchange .
  
2. Run docker container with application from image:
    docker run -p 8080:8080 currency-exchange
    
3. Send GET request to /api/v1/analysis/create/ endpoint with parameter:
    String code - International-standard 3-letter ISO currency code
