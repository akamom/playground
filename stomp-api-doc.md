# Chat API Documentation
The API makes use of the STOMP protocol. Please refer to the official documentation for further information.

## Connection endpoint
Protected by basic authentication (Header: `Authorization: Basic <USER:PASSWORD>`)
```
ws://<DOMAIN>:8080/chat
```

## Subscription endpoints
For receiving chatmessages please subscribe the following endpoint.
```
/topic/message
```

## Publish endpoints
For publishing chat messages please publish to the following endpoint
```
/app/message
```

## Data Transfer Objects
### ChatMessage
```json
{
    "metaData": {
        "createdAt":"2024-01-07T13:32:05.739Z",
        "receivedAt":"2024-01-07T12:32:05.758614811Z",
        "readAt":"2024-01-07T12:33:05.758614811Z",
        "createdBy":"User 262"
    },
    "chatId":1,
    "content":"asd",
    "username": "moritz" // == authenticated user name (can be omitted while sending chat messages)
}
```