/**
 *
 */
package com.izumobase.pdf

import com.lowagie.text.pdf.PdfReader
import java.io.File
import com.lowagie.text.Rectangle

/**
 * @author Yano
 *
 */
object Main {

  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      if (new File(arg).exists) {
        val reader = new PdfReader(arg)
    	  for(page <- 1 to reader.getNumberOfPages) {
          println("%s[%d]:".format(arg, page))
          printBox("page", reader.getPageSize(page))
    	    printBox("RotatedPage", reader.getPageSizeWithRotation(page))
    	    printBox("trim", reader.getBoxSize(page, "trim"))
          printBox("art", reader.getBoxSize(page, "art"))
          printBox("media", reader.getBoxSize(page, "media"))
          printBox("crop", reader.getBoxSize(page, "crop"))
        }
    	  reader.close
      } else {
        println("%s is not exists.".format(arg))
      }
    }
  }
  
  def printBox(name:String, box:Rectangle):Unit = {
    if (box != null) {
    	println("\t%s -> top=%s, right=%s, bottom=%s, left=%s, size=%s".format(name,
    			box.getTop, box.getRight, box.getBottom, box.getLeft, box))
    } else {
    	println("\t%s -> null")
    }
  }
}