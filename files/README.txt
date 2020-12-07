=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: zdandrew
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Arrays - the Connect four board is represented by a 2d array containing the pieces.

  2. Collections - A LinkedList will be used so that players can undo their moves.

  3. File I/O - The current state of the board can be saved by writing the data to a file. 
  Then the data can be loaded back by reading the data in the file.

  4. Testable Component - JUnit tests were created to test the hasWinner function in the 
  Board class. 

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.

Board: This class defines the board. A 2d array, which is the instance variable, stores null or 
Piece objects. This represents the pieces on the board. This class also contains hasWinner which 
checks if there is a winner given a specific color. This class contains methods such as change, 
add, and clear that can be called to modify the board.

Game: This class stores the main method. This class also contains all the buttons that are used. 
This class sets up the user interface where each column is an invisible button. The main method 
is also what sets the game into motion upon running.

GameCourt: This is the class that contains most of the game's logic. The methods that are run upon 
button presses are all defined here. This method also controls the timer which continuously updates 
the display. This class contains the logic that puts together Board and Piece methods to create the 
overall project. The LinkedList is also an instance variable here so that the undo button removes 
the last turn, like popping a stack. Finally, the File I/O element is also here. The methods for 
save and load are defined here and write/read information from the files. 

Piece: This class represents a playing piece. It is either red or blue, and has an x and y position.
Piece objects are what comprises the Board's 2d-array.

GameTest: This contains the JUnit tests for the hasWinner method in Board. Many edge cases are 
tested to make sure that the winner is always detected.



- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

No, the most difficult part was setting up the invisible buttons.


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

Yes, I would say the separation is mostly good. I think that the Board class can be improved upon 
because I created a get method which  compromises the private state encapsulation a bit. I think 
I would move some of the File I/O stuff into the Board class. Currently it is in the GameCourt 
class so I have to use the board.get method.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
