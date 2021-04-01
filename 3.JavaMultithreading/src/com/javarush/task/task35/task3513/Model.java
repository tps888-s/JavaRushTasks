package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private boolean isSaveNeeded = true;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    boolean canMove() {
        boolean result = false;
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) return true;

        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH - 1; y++) {
                if (gameTiles[z][y].value == gameTiles[z][y + 1].value) return true;
            }
        }

        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH - 1; y++) {
                if (gameTiles[y][z].value == gameTiles[y + 1][z].value) return true;
            }
        }

        return result;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        int size = emptyTiles.size();
        if (size > 0) {
            Tile tile = emptyTiles.get((int) (size * Math.random()));
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();

        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                Tile tile = gameTiles[z][y];
                if (tile.value == 0) {
                    emptyTiles.add(tile);
                }
            }
        }
        return emptyTiles;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                gameTiles[z][y] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean result = false;
        for (int z = 0; z < tiles.length - 1; z++) {
            for (int y = 0; y < tiles.length - 1; y++) {
                if (tiles[y].value == 0) {
                    if (tiles[y + 1].value != 0) result = true;
                    tiles[y].value = tiles[y + 1].value;
                    tiles[y + 1].value = 0;
                }
            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean result = false;
        for (int z = 0; z < tiles.length - 1; z++) {
            if (tiles[z].value == tiles[z + 1].value && tiles[z].value != 0) {
                tiles[z].value = tiles[z].value + tiles[z + 1].value;
                if (tiles[z].value > maxTile) maxTile = tiles[z].value;
                score += tiles[z].value;
                tiles[z + 1].value = 0;
                z++;
                result = true;
            }
        }
        boolean result2 = compressTiles(tiles);
        return result || result2;
    }

    void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean result1 = false;
        boolean result2 = false;

        for (Tile[] row : gameTiles) {
            if (compressTiles(row)) result1 = true;
            if (mergeTiles(row)) result2 = true;
        }

        if (result1 || result2) addTile();
        isSaveNeeded = true;
    }

    void down() {
        saveState(gameTiles);
        rotateClockWise();
        left();
        rotateClockWise();
        rotateClockWise();
        rotateClockWise();

    }

    void right() {
        saveState(gameTiles);
        rotateClockWise();
        rotateClockWise();
        left();
        rotateClockWise();
        rotateClockWise();

    }

    void up() {
        saveState(gameTiles);
        rotateClockWise();
        rotateClockWise();
        rotateClockWise();
        left();
        rotateClockWise();
    }

    void rotateClockWise() {
        Tile[][] rotatedArray = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                rotatedArray[z][y] = gameTiles[FIELD_WIDTH - 1 - y][z];
            }
        }
        gameTiles = rotatedArray;
    }

    void saveState(Tile[][] tile) {
        Tile[][] tileToSave = new Tile[tile.length][tile[0].length];
        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                Tile newTile = new Tile();
                newTile.value = tile[z][y].value;
                tileToSave[z][y] = newTile;
            }
        }
        previousStates.push(tileToSave);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    boolean hasBoardChanged(){
        int currentTotalValue = 0;
        int previousTotalValue = 0;
        Tile[][] previousTiles = previousStates.peek();

        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                currentTotalValue += gameTiles[z][y].value;
            }
        }

        for (int z = 0; z < FIELD_WIDTH; z++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                previousTotalValue += previousTiles[z][y].value;
            }
        }

        return !(previousTotalValue == currentTotalValue);
    }

    MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        int expectedEmptyTiles =  getEmptyTiles().size();
        int expectedScore = score;
        boolean changed = hasBoardChanged();
        rollback();
        if (changed) return new MoveEfficiency(expectedEmptyTiles, expectedScore, move);
        else
        return new MoveEfficiency(-1,0,move);
    }

    void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(this::left));
        priorityQueue.add(getMoveEfficiency(this::right));
        priorityQueue.add(getMoveEfficiency(this::up));
        priorityQueue.add(getMoveEfficiency(this::down));

        priorityQueue.peek().getMove().move();

    }
}
