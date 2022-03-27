# Dining Philosophers

<img align="left" alt="BUILD" src="https://img.shields.io/badge/Build-Success-brightgreen"/>
<br>
<br>
<img align="left" alt="COURSE" src="https://spin.atomicobject.com/wp-content/uploads/dining-philosophers-problem-small.jpg"/>

## Problem Description
There are N philosphers sitting around a circular table eating spaghetti and discussing philosphy. The problem is that each philosopher needs 2 forks to eat, and there are only N forks, one between each 2 philosophers. Design an algorithm that the philosophers can follow that insures that none starves as long as each philosopher eventually stops eating, and such that the maximum number of philosophers can eat at once.

## Basic Semaphore Approach 

In this problem, semaphore was used to control who can access the fork (the common resource).  When a left or right fork is released (i.e finished being used) its value is incremented to indicate its free and decremented when used again. 

When the value is decremented to less than zero, the access to the fork is blocked by the `wait()` method (negative wait). While, when the value is zero, the fork is ready for use and notified by `notify()` method.  

## Sample Output

```
 Fork 2 taken by Philosopher 1
 Fork 1 taken by Philosopher 1
 Fork 5 taken by Philosopher 4
 Fork 4 taken by Philosopher 4
 Philosopher 4 completed his dinner
 Philosopher 4 released fork 5
 Philosopher 4 released fork 4
 Till now num of philosophers completed dinner are 1
 Fork 4 taken by Philosopher 3
 Fork 3 taken by Philosopher 3
 Philosopher 1 completed his dinner
 Philosopher 1 released fork 2
 Philosopher 1 released fork 1
Till now num of philosophers completed dinner are 2
 Fork 1 taken by Philosopher 5
 Fork 5 taken by Philosopher 5
 Philosopher 5 completed his dinner
 Philosopher 5 released fork 1
 Philosopher 5 released fork 5
Till now num of philosophers completed dinner are 3
 Fork 5 taken by Philosopher 4
 Philosopher 3 completed his dinner
 Philosopher 3 released fork 4
 Philosopher 3 released fork 3
Till now num of philosophers completed dinner are 4
 Fork 3 taken by Philosopher 2
 Fork 2 taken by Philosopher 2
 Fork 4 taken by Philosopher 4
 Philosopher 2 completed his dinner
 Philosopher 2 released fork 3
 Philosopher 2 released fork 2
Till now num of philosophers completed dinner are 5
```
