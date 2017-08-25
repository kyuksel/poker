package poker

/** Encapsulate [[poker.handanalyzer.HandAnalyzer]] results */
final case class HandStatus(hto: Option[HandType], ko: Option[Kickers])
  extends Ordered[HandStatus] {

  def isTypeKnown: Boolean = hto.nonEmpty

  /** The strongest hand type wins.
    * For hands of the same type:
    *   The hand with the strongest kicker wins.
    *   If one or both kickers is undefined, it is considered a tie.
    */
  override def compare(that: HandStatus): Int = {
    require(
      hto.nonEmpty && that.hto.nonEmpty,
      "Cannot compare HandStatuses with unknown HandTypes"
    )

    val ht = hto.get
    val thatHt = that.hto.get

    if (ht != thatHt) {
      ht.compare(thatHt)
    } else {
      (ko, that.ko) match {
        case (Some(thisKicker), Some(thatKicker)) => thisKicker.compare(thatKicker)
        case _ => 0
      }
    }
  }

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
