## Excercise 1
Functionalities:
- make oboarding workflows automated/esier
- create taskes/reminder for employees for
  - overtime breaks, onboarding
- collect employee data on
  - working hours, payroll
- dashboards
  - for example how many employees work in which department, how many are on vacation
- keep documents organized and in a central place

Functionalities in class:
- Time tracking
- check absence
- oboardign
- file storage
- performance review
- recruiting
- eploye training
- payroll
- Analytics
- Whistleblowing
- HR Helpdesk
- Employee Information / History

[1_sheet2.pdf](1_sheet2.pdf) (architectural solution from class)

## Excercise 2

### 2. Design Principles:

### 2.7 Interest Managment:
- aoi and dynmaic zoning => not good at handling flocking
  - how to tackle => split zones, until zones are as small as aoi, then shrink aois
  - 

### 3. MMOG Architectures:
- currently prevalent game architecture: client server
- peer to peer would be beneficial because:
  - clients do part of the computing, so server computing reduced
  - server network bandwidth can be reduced
  - can potentially achieve high scalability, low cost and good performance 
  game architecture has to meet latency requirements-

- Main game architectures in MMOG: Client-Server, MultiServer and Peer-to-peer

### 3.5 Hybrid architectures:
- coopearative message dissemination:
  - game maintained by one or multiple servers
  - client sends update to server => server uses p2p to send that update to all clients
- state distribution:
  - peers can hold primary copies of objects and are therefore repsonsible for execution of player actions
  - communication between peers / join/leaves are managed by server
- Basic Server control: 
  - server only takes care of sensitive login data, leave and joins, player progress

### 3.6 Heterogeneous and Homogeneous P2P Architectures:
- heterogeneous: different nodes have different roles
    - superpeers, responsible nodes, normal nodes
- homogenus: all nodes have similar responsibilities

### 4. Peer-to-peer Architectures:
- peer-to-peer: structured or unstructured
  - structured: specific routing protocols used to find other peers in network, creating a graph structure, deterministic 
    - DHT mechanism used in SimMud is actually pretty similar to a hierarchical architectural style: the nodes with the primary objects essentially give out permissions to modify objects. The routing is also layered, as the nodes are grouped in to multigroups which have a route node. 
  - unstructured: network connections established with probabilities, not deterministic 
    - Here a more event based style is used. The nodes only now of each other because approaching nodes trigger an event to tell other nodes they are in range

## Excercise 4

1. A whistleblowing system on the internet.
   - bus-system, so event-oriented architecture: whistleblowers publish to an anonymous bus,
    and the data is then displayed from the bus to the public
   - multiserver architecture: connecting the whistleblowers and journalist happens though a network
    of servers, so tracing back the route is difficult (tor network)

   - class: 
2. A video conferencing system
   - client and server, peer to peer
   - client and server for setting up connections, peer to peer video transmission
3. A GPS tracker for cats
   - event-oriented: publish-subscribe system, the gps tracker only publishes data and the owner only receives it with an app


