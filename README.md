﻿# spring-kafka-redis-news-api

 http://localhost:8080/news?date=2025-04-26   // 200 ok
 http://localhost:8080/news?date=2025-04  = 400  {
    "code": "NEWS_MS_001",
    "type": "FUNCTIONAL",
    "message": "Invalid date request param.",
    "details": [
        "400 BAD_REQUEST \"Validation failure\""
    ],
    "timestamp": "2025-05-04"
}

----------------------

