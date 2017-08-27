package poker

import org.scalatest.FunSuite
import Utils._

final class UtilsTest extends FunSuite {
  test("parseJsonArray") {
    val handJsonStr = """["JH", "4C", "4S", "JC", "9H"]"""
    val expectedCards = Traversable("JH", "4C", "4S", "JC", "9H")

    assert(parseJsonArray(handJsonStr) === expectedCards)
  }

  test("parseJsonArrayOfArrays") {
    val handJsonStr = """[["JH", "4C", "4S", "JC", "9H"], ["3H", "3S", "3D", "AH", "QD"]]"""
    val expectedCards1 = Traversable("JH", "4C", "4S", "JC", "9H")
    val expectedCards2 = Traversable("3H", "3S", "3D", "AH", "QD")

    assert(parseJsonArrayOfArrays(handJsonStr) === Traversable(expectedCards1, expectedCards2))
  }
}
