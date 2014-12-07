HODOR THE TRPG
---

## Commands
- Units:
  - Returns the units that the player owns
  ```
units
> 1) Ned Stark (1, 1)
  2) Rob Stark (2, 5)
  3) Arya Stark (5, 7)
  ```
- Move \[unit\] \[pos\]:
  - Attempts to move the unit to the provided position. Returns OK if the move succeeded, otherwise the reason the move failed.
  ```
move Ned 1,2
> OK!
move Ned 50,50
> Too Far! :(
  ```

- Attack \[attacker\] \[attackee\]
  - Attempts to attack with the given unit. Returns the results.
  ```
attack Ned Joffery
> OK!
  Joffery died!
  ```
