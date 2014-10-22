/** This file contains specifications for the functions exported for
  * dsmigrator.
  */

package functionalops.httpgener8

import org.scalacheck.{Properties, Prop, Arbitrary}

import scalaz._
import Scalaz._
import scalacheck.ScalazProperties._
import scalacheck.ScalazArbitrary._
import scalacheck.ScalaCheckBinding._

import functionalops.httpgener8.core._

object FunctionsSpec extends Properties("functions") {
  import testInstances._

  def bounded(min: Int, max: Int)(implicit a: Arbitrary[Int]) =
    Prop.forAll { (c: Int) => c > min && c < max }

  object allCodes extends Properties("all HTTP codes") {
    implicit val arbitraryInt: Arbitrary[Int] = Arbitrary(genValidHttpStatus)
    property("between 99 and 506 not inclusive") = bounded(99, 506)(arbitraryInt)
  }

  object informationalCodes extends Properties("informational HTTP codes") {
    implicit val arbitraryInt: Arbitrary[Int] = Arbitrary(genInfoHttpStatuses)
    property("between 99 and 200 not inclusive") = bounded(99, 200)(arbitraryInt)
  }

  object successCodes extends Properties("success HTTP codes") {
    implicit val arbitraryInt: Arbitrary[Int] = Arbitrary(genSuccessHttpStatuses)
    property("between 199 and 300 not inclusive") = bounded(199, 300)(arbitraryInt)
  }

  object redirectCodes extends Properties("redirect HTTP codes") {
    implicit val arbitraryInt: Arbitrary[Int] = Arbitrary(genRedirectHttpStatuses)
    property("between 299 and 400 not inclusive") = bounded (299, 400)(arbitraryInt)
  }

  object clientErrorCodes extends Properties("client error HTTP codes") {
    implicit val arbitraryInt: Arbitrary[Int] = Arbitrary(genClientErrorHttpStatuses)
    property("between 399 and 500 not inclusive") = bounded (399, 500)(arbitraryInt)
  }

  object serverErrorCodes extends Properties("server error HTTP codes") {
    implicit val arbitraryInt: Arbitrary[Int] = Arbitrary(genServerErrorHttpStatuses)
    property("between 499 and 506 not inclusive") = bounded (499, 506)(arbitraryInt)
  }

  include(allCodes)
  include(informationalCodes)
  include(successCodes)
  include(redirectCodes)
  include(clientErrorCodes)
  include(serverErrorCodes)
}
