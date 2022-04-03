PORT KNOCKING
DESCRIPTION:
From the class MyServer you run the server from the main class which opens up
a UDP server for to wait for a client to connect. It runs method listen which 
loops in case more than one client would want to connect and you can set the number
of sockets you want to open by setting the number of the private variable numports
which indicates the number of ports you want to make available with the constructer of the MyServer class it 
will run a method opensockets which will set up these UDP sockect according
to the number of ports you have chosen to set up. This then runs a method service 
which runs after waiting for a client to connect and when connect it will send one of the created 
UDP port numbers to the client expecting the client to connect with that separate port to recieve the intended 
file for it.Also I have made the assumption that each created port will have one file for itself prepared to send
So in my example I have made sample files for each port created.There are also private variable assigned as counters to be
 able to keep a record of the ports used we assume that when a private port has been accessed it will send the files needed 
and use the next port to send to the client and the process will terminate when more then the number of ports specified.
So for each port created when the client accesses it we run a method serve on the port with it as the parameter 
and send the name of the file and then send its contexts along with it.

Now for the MyClient class after the server is run it will display its port number in the console and you have to set this number before you run the cilent class
Depending on where you run the server you will have to also set the address of the server.In this case we get the local host address since we run the clinet on the 
same address of the server. After connecting with the server we try to read what the server is sending and it should be a port number of one of the ports which
has been created and we establish a connection with this port and then read the contexts of this port and read the name of the file and after reading it again it should 
be able to read the contexts of this file. 
HOW TO INSTALL:
TAKE ALL THE FILES SUBMITTED WITHIN THE DOCUMENTS AND PLACE THEM IN THE SOURCE CODE OF THE PROJECT
YOU ARE GOING TO RUN ON YOUR ENVIRONMENT(CLASSES MADE IN INTELLI-J).
HOW TO RUN:
RUN THE MAIN CLASS FOUND IN THE MYSERVER CLASS AND AFTER RECEIVING THE PORT NUMBER OF THE RUNNING SERVER
SET THIS IN THE CLASS OF MY CLIENT AND RUN THE MAIN OF THE MYCLIENT CLASS.
HOW TO USE:
TO BE ABLE TO READ THE FILES YOU HAVE TO SET THE PATHS OF THE FILES IN THE MYSERVER CLASS I HAVE PROVIDED SAMPLE TEST FILES WITHIN THE DOCUMENTS
AND PUT THE FULL PATHS OF THE FILES WITHIN THE PARANTHESES.
DIFFICULTIES AND ERRORS:
I COULD NOT MANAGE TO DISPLAY THE CONTEXTS OF THE FILES FROM THE CLIENT IN THE SO I WAS NOT SURE IF A SUCCESSFUL CONNECTION WAS MADE TO THE SERVER AND THE CREATED UDP PORTS
I WAS NOT ABLE TO FIND A WAY TO MONITER IF THE SERVER HAS ISSUES WITH CONFLICTING PROCCESES.


