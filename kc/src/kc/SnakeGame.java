package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SnakeGame {
    Queue<Integer> snake = new LinkedList<Integer>();
    Map<String, int[]> map = new HashMap<String, int[]>();
    Set<Integer> set = new HashSet<Integer>();
    int height;
    int width;
    int counter = 0;
    int i = 0;
    int j = 0;
    int[][] foods;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.foods = food;
        snake.add(0);
        set.add(0);
        map.put("U", new int[] {-1 ,0});
        map.put("L", new int[] {0 ,-1});
        map.put("R", new int[] {0 ,1});
        map.put("D", new int[] {1 ,0});
        
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        i += map.get(direction)[0];
        j += map.get(direction)[1];
        
        if(i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        
        int newPosition = i * width + j;
        int food = -1;
        if(counter < foods.length)
        food = foods[counter][0] * width + foods[counter][1];
        
        if(newPosition == food) {
            counter++;
            snake.offer(food);
            set.add(food);
        } else {
            snake.offer(newPosition);
            set.remove(snake.poll());
            if (set.contains(newPosition)) {
                return -1;  
            }
            set.add(newPosition);
        }
        return counter;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
