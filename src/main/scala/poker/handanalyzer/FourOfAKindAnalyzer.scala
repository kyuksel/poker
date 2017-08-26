package poker.handanalyzer

import poker._

final class FourOfAKindAnalyzer extends HandAnalyzer {
  /** Detect any four cards of the same rank.
    * Record the fifth card as the kicker.
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    val cardsByRank = hand.cards.groupBy(_.rank)

    if (cardsByRank.exists(_._2.size == 4)) {
      val kickerOpt = cardsByRank.find(_._2.size == 1).map(_._2)

      assert(kickerOpt.nonEmpty, s"A ${HandType.FourOfAKind} must have one card of another rank")

      HandStatus(HandType.FourOfAKind, Kickers(kickerOpt.get))
    } else {
      HandStatus.none
    }
  }
}
