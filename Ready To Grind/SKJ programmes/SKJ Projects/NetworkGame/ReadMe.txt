NETWORK GAME
DESCRIPTION:
From the class Server you run the the main class which will launch a TCP server 
with the method listenSocket() after this the server is created and waits for clients
to connect. When a client is connected a thread is run for it in the class Player.
This is where the server manages the contact with the client and sends the default message 
for the game telling it to indicate wether it wants to play,logout or recieve a 
list of the active players involved. After this a class called CPLayer is made to 
create and hold the Player ID to the socket of the client and this will be added to the of 
players and active players stored in the server.

If the current list of players in the active list are uneven it will send message to the 
odd player to please wait for the opponent.Once the list is even the odd player will be matched 
to the new even. When this occurs we launch a new game for the 2 matched up players.
In this game we make a 3 by 3 board to play tic tac toe with one player marking X and the other 
marking O...we constantly print the current status of the board after each move is made.
We then scan the input from the terminal of the client assuming they are inputing the rows
and numbers of the game board to mark a position. After each move is made we check if the board is used up 
 and there is a draw or if someone has won.

The client on the other hand connects to this server by setting the address of and port number to create a
socket which will establish this connection.It reads the info provided by the server and then one of the 3 options
is sent to the server "PLAY,LOGOUT or LIST" set in the message sent to the server and then we constantly read the info 
the server until we send the LOGOUT command to close the connection;
For the client the row and columns are sent through the terminal to be read into the board.

HOW TO INSTALL:
TAKE ALL THE FILES SUBMITTED WITHIN THE DOCUMENTS AND PLACE THEM IN THE SOURCE CODE OF THE PROJECT
YOU ARE GOING TO RUN ON YOUR ENVIRONMENT(CLASSES MADE IN INTELLI-J).
HOW TO RUN:
RUN THE MAIN CLASS FOUND IN THE SERVER CLASS AND IN THE CLASS OF MY CLIENT AND RUN THE MAIN OF THE CLIENT AND CLIENT 2 CLASS.
HOW TO USE:
SET THE ADDRESS IN THE CLIENT CLASS TO THE ADDRESS OF THE DEVICE YOU ARE RUNNING THE SERVER ON
THE PORT NUMBER IS SET TO 55555.RUN BOTH CLIENTS TO BE CONNECTED TO A GAME AND USE ROW AND COLUMN NUMBERS FROM THE TERMINALS.
DIFFICULTIES AND ERRORS:
I COULD NOT ACCOMODATE FOR THE VIEWERSHIP OF THE GAME USING THE THE UDP PORTS AND COULD NOT FULLY SYNCHRONIZE 2 PLAYERS TO DUEL WITH 
EACH OTHER. 
