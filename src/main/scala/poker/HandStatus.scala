package poker

/** Encapsulate [[poker.handanalyzer.HandAnalyzer]] results */
final case class HandStatus(hto: Option[HandType], ko: Option[Kickers]) {
  def isSameAs(that: HandStatus): Boolean = that match {
    case HandStatus(thatHto, thatKo) => hto == thatHto && ko == thatKo
    case _ => false
  }

  def notSameAs(that: HandStatus): Boolean = !isSameAs(that)

  def isTypeKnown: Boolean = hto.nonEmpty

  override def toString: String = (hto, ko) match {
    case (Some(handType), Some(kickers)) => s"$handType with $kickers"
    case (Some(handType), None) => s"$handType"
    case _ => "Empty hand"
  }
}

object HandStatus {
  def apply(ht: HandType, k: Kickers): HandStatus = HandStatus(Some(ht), Some(k))
  def apply(ht: HandType): HandStatus = HandStatus(Some(ht), None)
  def apply(): HandStatus = HandStatus(None, None)

  def none: HandStatus = HandStatus()

  def nonEmpty(hs: HandStatus): Boolean = hs.hto.nonEmpty
}
