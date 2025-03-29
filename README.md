## API Endpoints

### Start a New Game

**Endpoint:** `POST /game/start`

- **Request Parameters:**
  - `size`: Integer (Board size)
- **Example Request:**
  ```sh
  curl -X POST "http://localhost:8080/tictactoe/start?size=5"
  ```
- **Response:**
  ```sh
  "game starts with board size 5x5"
  ```

### Make a Move

**Endpoint:** `POST /tictactoe/move`

- **Example Request:**
  ```sh
  curl -X POST "http://localhost:8080/tictactoe/move?row=1&col=2"
  ```
- **Response:**
  ```sh
  "move accepted"
  ```

### Show Current Board

**Endpoint:** `GET /tictactoe/show_board`

- **Response:**
  ```sh
  "[['X', ' ', ' '], [' ', 'O', ' '], [' ', ' ', ' ']]"
  ```
