package poker

import org.scalatest.FunSuite

final class KickersTest extends FunSuite {
  test("toString") {
    val kickerQS = s"""kicker "QS""""
    val kickers7DQS = s"""kickers "7D", "QS""""

    assert(Kickers("QS").toString === kickerQS)
    assert(Kickers("7D", "QS").toString === kickers7DQS)
  }

  test("compare") {
    import TestHelpers._

    assert(aceKicker > queenKicker)
    assert(queenKicker === queenKicker)
    assert(Kickers("7D", "8H") < Kickers("2C", "TS"))
  }
}
