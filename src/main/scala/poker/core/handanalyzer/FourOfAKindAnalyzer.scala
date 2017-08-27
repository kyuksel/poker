package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

final class FourOfAKindAnalyzer extends HandAnalyzer {
  /** Detect any four cards of the same rank.
    * Record the fifth card as the kicker.
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.existsNCardsBySameRank(4)) {
      val kickerOpt = hand.findNCardsBySameRank(1)

      assert(kickerOpt.nonEmpty, s"A ${HandType.FourOfAKind} must have one card of another rank")

      HandStatus(HandType.FourOfAKind, Kickers(kickerOpt.get))
    } else {
      HandStatus.none
    }
  }
}
