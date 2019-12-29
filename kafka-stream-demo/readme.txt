Goal:

Aim of this article is to create an application which works as shown below.

    Producers keep on producing messages into a Kafka topic (Topic-1).
        In this case I would be generating numbers sequentially from 1 every second
    
    We would be creating stream processor which consumes these messages, transforms
      and writes data into (Topic-2)
        
        I would be finding the square of the number only if the number is an 
        even number. That is, when we receive numbers 1, 2, 3 – we would be 
        finding the square of 2 only. We will skip 1 and 3.
    
    Consumers consume the messages from Topic-2.
        Consumers consume the numbers like 4, 16 etc (processed by the stream processors)

        