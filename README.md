#INFO
####1. Run TestApplication
####2. Make a request
    curl -i -X POST -d username=admin -d password=admin http://localhost:8080/login
####3. If it is  between 8-00 AM and 5-00 PM now, you'll get a code 200 (success). In other way, you'll get code 401 (unauthorized).