# sortedArray
An algorithm that checks how many elements will fit in the given range. Thanks to the use of the binsearch algorithm pessimistic time complexity equals O (log n).

## Input:

1. integer 1<=n<=10<sup>6</sup>: number of sets
2. integers 1<=a<sub>i</sub><=2<sup>15</sup>: elements of array
3. integers 1<=a<sub>i</sub><=2<sup>15</sup>: number of value ranges
4. integers 1<=k<sub>j</sub><=2<sup>15</sup>: value ranges

## Output

For each set:

1. How many elements will fit in the given range
2. At the end of the set- how many different numbers were given in the array

## Example
### Input
```
1
12  
-1 1 2 2 2 3 5 5 7 7 9 9 
12   
1 2   
2 2   
3 6   
2 1  
-1 10   
1 0   
4 6   
4 3  
-1 9   
1 1   
4 4   
0 9
```

### Output

```
4
3
3
0
1
2
0
2
0
12
1
0
11 
7
```
