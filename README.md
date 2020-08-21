# Game of Life

To wrap up the Java basics we are developing a small game called `Game of Life`. This game was developed by the famous mathematician John Horton Conway in the 1970s. It just has 3 simple rules:

1. Any live cell with two or three live neighbors survives.
2. Any dead cell with three live neighbors becomes a live cell.
3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.

As you might have guessed you will need at least 1 two-dimensional array. Which is representing our game field.

You will not have any restrictions, as long as you implement the rules above. You can use `Scanners` for reading in user inputs and so on. Please **use methods** and implement your software in a clean and precise style.

>**NOTE:** This program will take you some time and this is intended. You should code it in various sessions. Do not hesitate if you struggle, take your time, and ask. **Programming is teamwork**.

* Check out the rules [here](https://de.wikipedia.org/wiki/Conways_Spiel_des_Lebens).
* Some nice visualizations can be found [here](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

## Some Tips
If you want to initialize the field randomly you can use a coin flip.

The following snippet generates one random numbers which value is 0 or 1.

~~~java
int coin = new Random().nextInt(2);
~~~
