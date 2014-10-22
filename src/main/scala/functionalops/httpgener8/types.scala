package functionalops.httpgener8

import scalaz._
import Scalaz._

trait Types {
  sealed abstract class HttpStatus(code: Int)
  object HttpStatus {
    final case object Continue extends HttpStatus(100)
    final case object SwitchingProtocols extends HttpStatus(101)
    final case object Ok extends HttpStatus(200)
    final case object Created extends HttpStatus(201)
    final case object Accepted extends HttpStatus(202)
    final case object NonAuthoritative extends HttpStatus(203)
    final case object NoContent extends HttpStatus(204)
    final case object ResetContent extends HttpStatus(205)
    final case object PartialContent extends HttpStatus(206)
    final case object MultipleChoices extends HttpStatus(300)
    final case object MovedPermanently extends HttpStatus(301)
    final case object Found extends HttpStatus(302)

    def apply(code: Int): Option[HttpStatus] = code match {
      case 100  => Continue.some
      case 101  => SwitchingProtocols.some
      case 200  => Ok.some
      case 201  => Created.some
      case 202  => Accepted.some
      case 203  => NonAuthoritative.some
      case 204  => NoContent.some
      case 205  => ResetContent.some
      case 206  => PartialContent.some
      case 300  => MultipleChoices.some
      case 301  => MovedPermanently.some
      case 302  => Found.some
      case _    => none[HttpStatus]
    }
  }
}
