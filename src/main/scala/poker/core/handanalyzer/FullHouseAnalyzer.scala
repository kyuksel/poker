package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

final class FullHouseAnalyzer extends HandAnalyzer {
  /** Detect any three cards of the same rank
    * together with any two cards of the same rank.
    *
    * Record the fifth card as the kicker.
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.existsNCardsBySameRank(3) && hand.existsNCardsBySameRank(2)) {
      val kickerOpt = hand.findNCardsBySameRank(2)

      assert(kickerOpt.nonEmpty, s"A ${HandType.FullHouse} must have two cards of another rank")

      HandStatus(HandType.FullHouse, Kickers(kickerOpt.get))
    } else {
      HandStatus.none
    }
  }
}
