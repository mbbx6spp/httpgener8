package functionalops.httpgener8

import scalaz._
import Scalaz._

import org.scalacheck.Gen

trait Functions extends Instances {
  /** Generator for informational HTTP status codes */
  def genInfoHttpStatuses:         Gen[Int] = Gen.choose(100, 101)

  /** Generator for success HTTP status codes */
  def genSuccessHttpStatuses:      Gen[Int] = Gen.choose(200, 204)

  /** Generator for redirect HTTP status codes */
  def genRedirectHttpStatuses:     Gen[Int] = Gen.choose(300, 307)

  /** Generator for client error HTTP status codes */
  def genClientErrorHttpStatuses:  Gen[Int] = Gen.choose(400, 417)

  /** Generator for server error HTTP status codes */
  def genServerErrorHttpStatuses:  Gen[Int] = Gen.choose(500, 505)

  /** Generator for all valid HTTP status codes */
  def genValidHttpStatus: Gen[Int] =
    Gen.oneOf(
      genInfoHttpStatuses,
      genSuccessHttpStatuses,
      genRedirectHttpStatuses,
      genClientErrorHttpStatuses,
      genServerErrorHttpStatuses
    )

  /** Generator for a standard HTTP request header */
  def genStandardHttpRequestHeader: Gen[String] =
    Gen.oneOf(
      "Accept",
      "Accept-Charset",
      "Accept-Encoding",
      "Accept-Language",
      "Accept-Datetime",
      "Authorization",
      "Cache-Control",
      "Connection",
      "Cookie",
      "Content-Length",
      "Content-MD5",
      "Content-Type",
      "Date",
      "Expect",
      "From",
      "Host",
      "If-Match",
      "If-Modified-Since",
      "If-None-Match",
      "If-Range",
      "If-Unmodified-Since",
      "Max-Forwards",
      "Origin",
      "Pragma",
      "Proxy-Authorization",
      "Range",
      "Referer",
      "User-Agent",
      "Upgrade",
      "Via",
      "Warning"
    )

  def genStandardHttpResponseHeader: Gen[String] =
    Gen.oneOf(
      "Access-Control-Allow-Origin",
      "Accept-Ranges",
      "Age",
      "Allow",
      "Cache-Control",
      "Connection",
      "Content-Encoding",
      "Content-Language",
      "Content-Length",
      "Content-Location",
      "Content-MD5",
      "Content-Disposition",
      "Content-Range",
      "Content-Type",
      "Date",
      "ETag",
      "Expires",
      "Last-Modified",
      "Link",
      "Location",
      "P3P",
      "Pragma",
      "Proxy-Authenticate",
      "Refresh",
      "Retry-After",
      "Server",
      "Set-Cookie",
      "Status",
      "Upgrade",
      "Vary",
      "Via",
      "Warning",
      "WWW-Authenticate"
    )
}
