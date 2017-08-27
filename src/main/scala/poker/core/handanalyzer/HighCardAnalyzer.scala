package poker.core.handanalyzer

import poker.core.{Hand, HandStatus, HandType, Kickers}

/** Any hand will match */
final class HighCardAnalyzer extends HandAnalyzer {
  override def doAnalyze(hand: Hand): HandStatus = {
    HandStatus(HandType.HighCard, Kickers(hand.cards))
  }
}
