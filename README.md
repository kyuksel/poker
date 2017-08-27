# Poker Hand Evaluator

Poker is a game played with a [standard 52-card deck of cards](https://en.wikipedia.org/wiki/Standard_52-card_deck), in which players attempt
to make the best possible five-card hand according to the [ranking of the categories](http://www.pokerlistings.com/poker-hand-ranking).

This software provides APIs to

* classify a given five-card hand (according to hand types defined [here](http://www.pokerlistings.com/poker-hand-ranking))
* determine the winner(s) of a given set of two or more five-card hands
* find the best possible hand(s) that can be composed from a given set of five or more cards

## Getting Started

These instructions will get you a copy of the project running on your local machine.

### Prerequisites

The instructions were tested with `SBT 0.13.13`, `Java 8` and `Git 2.11.1`.

### Installing

Clone this repo

```
git clone https://github.com/kyuksel/poker.git
```

Change directory into the repo

```
cd poker
```

### Running the unit tests

```
sbt test
```

### Demo

Classifying the hand

```
["TC", "JC", "QC", "KC", "AC"]
```

via

```
sbt "classify src/test/resources/classify.txt"
```

outputs

```
The hand is a Royal Flush.
```

Determining the winner of a given three five-card hands
```
["8C", "9C", "TC", "JC", "QC"]
["5H", "TC", "TH", "7D", "TD"]
["KC", "KS", "AC", "AS", "6D"]
```

via

```
sbt "winner src/test/resources/winner_single.txt"
```

displays

```
The winner hand is ["8C", "9C", "TC", "JC", "QC"], which is a Straight Flush with kicker "QC".
```

In cases where there is a tie between two or more hands such as

```
$ cat src/test/resources/winner_tie.txt
["8C", "9C", "TC", "JC", "QC"]
["TC", "8C", "QC", "JC", "9C"]
```

We get

```
It is a tie between ["8C", "9C", "TC", "JC", "QC"], ["TC", "8C", "QC", "JC", "9C"].
```

Finally, finding the best possible hand(s) that can be composed from a given set of five or more cards such as

```
["AD", "2S", "JC", "KD", "7S", "TC", "3H", "AC", "JS", "QC", "KC", "2D"]
```

via

```
sbt "best src/test/resources/best_possible.txt"
```

results in

```
The best possible hand is ["JC", "TC", "AC", "QC", "KC"], which is a Royal Flush.
```

The text files used to run the examples above can be found under [test resources](https://github.com/kyuksel/poker/tree/ky_readme/src/test/resources).

## Assumptions

* A single 52-card deck is used.

* No wild cards are used.

* Aces are treated as high cards only.

* Cards are represented by their number (except for `10`, which is represented as `T`)
  or first letter for the non-numeric cards (`J`, `Q`, `K`, `A`).

* The suits are represented by their first letter (`H`, `C`, `D`, `S`).

* Hands are stored as JSON arrays. For example, the hand J♥ 4♣ 4♠ J♣ 9♥ is
  represented as `["JH", "4C", "4S", "JC", "9H"]`.

* When a category involves less than 5 cards, the next highest cards are
  added as `kickers` for the sake of breaking ties. For example, a pair
  of `queen`s with a `king` beats a pair of `queen`s with a `T (10)`.

## Design

The project aims to have a clear and modular code, taking advantage of functional programming principles.
Basic domain concepts such as [Rank](https://github.com/kyuksel/poker/blob/master/src/main/scala/poker/core/Rank.scala), [Suit](https://github.com/kyuksel/poker/blob/master/src/main/scala/poker/core/Suit.scala), [Card](https://github.com/kyuksel/poker/blob/master/src/main/scala/poker/core/Card.scala), [Hand](https://github.com/kyuksel/poker/blob/master/src/main/scala/poker/core/Hand.scala) and [Kickers](https://github.com/kyuksel/poker/blob/master/src/main/scala/poker/core/Kickers.scala) are modeled as
separate classes where `Rank` and `Suit` take advantage of value classes to not incur runtime penalty.
There is a [HandType](https://github.com/kyuksel/poker/blob/master/src/main/scala/poker/core/HandType.scala) and a [HandAnalyzer](https://github.com/kyuksel/poker/tree/master/src/main/scala/poker/core/handanalyzer)
for each type of hand. `HandAnalyzer`s implement the trait's analysis method, which indicates if a given hand
matches that type. If it does, the output captures the `type` and the `kickers` as part of [HandStatus](https://github.com/kyuksel/poker/blob/master/src/main/scala/poker/core/HandStatus.scala).
Note that a `HandAnalyzer` may match a stronger hand (e.g. `StraightFlushHandAnalyzer` would match a `Royal Flush` hand).
This works because the algorithm for classifying hands first checks for the strongest hand (`Royal Flush`) and then continues
with testing for less strong hands. It stops as soon as it finds a matching one.

## Future Work

* Fix the [tie-breaking bug](https://github.com/kyuksel/poker/issues/3)
* Benchmark performance for finding the best hand out of a large number of hands
* Allow specifying input directly on the command line
* Enforce coding style via ScalaStyle

## License

This project is licensed under the MIT License - see the [license file](https://github.com/kyuksel/poker/blob/master/LICENSE) for details.