package poker

import scala.collection.immutable.HashMap

object Utils {
  def parseJsonArray(s: String): Traversable[String] = {
    import spray.json._
    import DefaultJsonProtocol._

    s.parseJson.convertTo[Iterable[String]]
  }

  def parseJsonArrayOfArrays(s: String): Traversable[Traversable[String]] = {
    import spray.json._
    import DefaultJsonProtocol._

    s.parseJson.convertTo[Iterable[Iterable[String]]]
  }

  def rankAsInt(c: Char): Int = ranksToInts(c)

  lazy val ranksToInts: HashMap[Char, Int] = HashMap(
    '2' -> 2,
    '3' -> 3,
    '4' -> 4,
    '5' -> 5,
    '6' -> 6,
    '7' -> 7,
    '8' -> 8,
    '9' -> 9,
    'T' -> 10,
    'J' -> 11,
    'Q' -> 12,
    'K' -> 13,
    'A' -> 14
  )
}
