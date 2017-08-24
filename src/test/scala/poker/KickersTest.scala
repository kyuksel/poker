package poker

import org.scalatest.FunSuite

final class KickersTest extends FunSuite {
  test("toString") {
    val kickerQS = s"""kicker "QS""""
    val kickers7DQS = s"""kickers "7D", "QS""""

    assert(Kickers.fromStrings("QS").toString === kickerQS)
    assert(Kickers.fromStrings("7D", "QS").toString === kickers7DQS)
  }
}
