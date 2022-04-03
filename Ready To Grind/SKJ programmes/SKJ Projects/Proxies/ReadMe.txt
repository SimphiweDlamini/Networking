
SKJ HTTP Proxy
DESCRIPTION:
From the main class is run which launches the Proxy class and its method listenSocket
The method listenSocket then creates a server by creating a new Server Socket which will be waiting for a connection to 
a client and once a connection to a client is established it will run a new proxyThread for each client.
This method is put in a loop so it continously waits for new clients and not only deals with one client.
When the proxy thread is run on a client it will indicate that the connection with the client has been made.
After this this first 3 lines from the clients request will be read because they will contain the request we will need 
to connect to the server requested by the client and the host address which we need to establish with the server 
requested by the client.If the client does not contain the information needed for us to collect this we indicate that this
request is incompatible for the proxy.

So when this does work we extract the address from the clients request and act as the client as we establish a connection to
the server we need to get information from.
After establish this connection we send the request to the server and the address it is for.
And we then read the response the server has for the client and send it back to the client to whom had made a connection
with the proxy as a server.
HOW TO INSTALL:
TAKE THE 2 CLASS FILES SUBMITTED ALONGSIDE THIS FILE AND PUT THEM IN THE SOURCE CODE OF THE PROJECT YOU ARE GOING TO RUN
ON YOUR ENVIRONMENT(CLASSES MADE IN INTELLI-J).
HOW TO RUN:
RUN THE MAIN CLASS WHICH WILL BE FOUND WITHIN THE PROXY CLASS.
HOW TO USE:
GO TO YOUR COMMAND PROMPT AND USE THE IPCONFIG COMMAND TO GET THE IP ADDRESS OF WHERE YOU WILL RUN THE PROXY ON
GO TO YOUR PROXY SETTINGS AND MANUALLY SET THE DEVICE TO USE THE PROXY SERVER, INSERT THE DEVICES IP ADRRESS IN THE 
ADDRESS SLOT AND THE PORT NUMBER: 3020 IN THE PORT SLOT
SAVE THE SETTINGS.
TEST THE SERVER BY RUNNUNG A REQUEST IN YOUR BROWSER(e.g "www.pja.edu.pl")
AND WATCH IN THE CONSOLE AS THE DETAILED RESULTS WILL BE SHOWN BACK TO YOU AS THE USER

