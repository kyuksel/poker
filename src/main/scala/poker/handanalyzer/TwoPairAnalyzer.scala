package poker.handanalyzer

import poker.{Hand, HandStatus, HandType, Kickers}

final class TwoPairAnalyzer extends HandAnalyzer {
  /** Detect any two cards of the same rank together with another two cards of the same rank
    *
    * Record all of the cards as kickers since they all could be used as tie-breaker
    */
  override def doAnalyze(hand: Hand): HandStatus = {
    if (hand.existsNCardsBySameRank(2)) {
      val remainingCards = hand.cards.toSeq diff hand.findNCardsBySameRank(2).get.toSeq

      if (Hand.existsNCardsBySameRank(remainingCards, 2)) {
        HandStatus(HandType.TwoPair, Kickers(hand.cards))
      } else {
        HandStatus.none
      }
    } else {
      HandStatus.none
    }
  }
}
