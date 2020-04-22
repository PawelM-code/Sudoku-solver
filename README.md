# SUDOKU SOLVER API
App returns solved sudoku.

GET /v1/sudoku/{input}

Input data structure [row col value] without any separator.
For example, if row 1 column 2 has a value 5 and row 4 column 6 has a value of 8, the input should look like this {125468}

See also Frontend [https://github.com/PawelM-code/Sudoku-solver-frontend](https://github.com/PawelM-code/Sudoku-solver-frontend) 

## Demo running on Heroku
On Heroku you can find a deployed version. [https://sudoku-solverr.herokuapp.com/v1/sudoku/](https://sudoku-solverr.herokuapp.com/v1/sudoku/)

## Technologies
Project is created with:
* Java
* Maven
* Spring
* Spring-boot
* Lombok
* Junit
* Mockito