package poker

/** Encapsulate [[poker.handanalyzer.HandAnalyzer]] results */
final case class HandStatus(hto: Option[HandType], ko: Option[Kickers]) {
  def sameAs(that: HandStatus): Boolean = that match {
    case HandStatus(thatHto, thatKo) => hto == thatHto && ko == thatKo
    case _ => false
  }

  def notSameAs(that: HandStatus): Boolean = !sameAs(that)
}

object HandStatus {
  def apply(ht: HandType, k: Kickers): HandStatus = HandStatus(Some(ht), Some(k))
  def apply(ht: HandType): HandStatus = HandStatus(Some(ht), None)
  def apply(): HandStatus = HandStatus(None, None)

  def none: HandStatus = HandStatus()
}
