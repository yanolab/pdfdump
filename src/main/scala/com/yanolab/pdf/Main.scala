/**
 *
 */
package com.izumobase.pdf

import com.lowagie.text.pdf.PdfReader
import java.io.File

/**
 * @author yanolab
 *
 */
object Main {

  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      if (new File(arg).exists) {
    	val reader = new PdfReader(arg)
    	for(page <- 1 to reader.getNumberOfPages) {
          println("%s[%d]:".format(arg, page))
    	  println("\tpage size=%s".format(reader.getPageSize(page)))
          println("\tpage size with rotation=%s".format(reader.getPageSizeWithRotation(page)))
          println("\ttrim=%s".format(reader.getBoxSize(page, "trim")))
          println("\tart=%s".format(reader.getBoxSize(page, "art")))
          println("\tmedia=%s".format(reader.getBoxSize(page, "media")))
          println("\tcrop=%s".format(reader.getBoxSize(page, "crop")))
        }
    	reader.close
      } else {
        println("%s is not exists.".format(arg))
      }
    }
  }
}
