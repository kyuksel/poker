package poker

import org.scalatest.FunSuite

final class HandTest extends FunSuite {
  private val royalFlush = Hand.fromStrings(Traversable("TC", "JC", "QC", "KC", "AC"))
  private val royalFlushMixed = Hand.fromStrings(Traversable("JC", "TC", "AC", "QC", "KC"))

  private val straight = Hand.fromStrings(Traversable("7S", "8H", "9S", "TH", "JC"))
  private val straightMixed = Hand.fromStrings(Traversable("TH", "7S", "9S", "JC", "8H"))

  test("hasSameSuit") {
    assert(royalFlush.hasSameSuit)
    assert(!straight.hasSameSuit)
  }

  test("sorted") {
    assert(royalFlushMixed.sorted sameAs royalFlush)
    assert(straightMixed.sorted sameAs straight)
  }

}
