package poker

sealed trait HandType extends Ordered[HandType] {
  /** 0-based ranking of a hand type */
  def strength: Int

  override def compare(that: HandType): Int = this.strength - that.strength
}

object HandType {
  case object RoyalFlush extends HandType {
    override val strength: Int = 9
    override val toString: String = "Royal Flush"
  }

  case object StraightFlush extends HandType {
    override val strength: Int = 8
    override val toString: String = "Straight Flush"
  }

  case object FourOfAKind extends HandType {
    override val strength: Int = 7
    override val toString: String = "Four of a Kind"
  }

  case object FullHouse extends HandType {
    override val strength: Int = 6
    override val toString: String = "Full House"
  }

  case object Flush extends HandType {
    override val strength: Int = 5
    override val toString: String = "Flush"
  }

  case object Straight extends HandType {
    override val strength: Int = 4
    override val toString: String = "Straight"
  }

  case object ThreeOfAKind extends HandType {
    override val strength: Int = 3
    override val toString: String = "Three of a Kind"
  }

  case object TwoPair extends HandType {
    override val strength: Int = 2
    override val toString: String = "Two Pair"
  }

  case object OnePair extends HandType {
    override val strength: Int = 1
    override val toString: String = "One Pair"
  }

  case object HighCard extends HandType {
    override val strength: Int = 0
    override val toString: String = "High Card"
  }
}
