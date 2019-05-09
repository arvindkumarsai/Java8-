package com.arvind.poi.example

import java.io.{File, IOException}

import org.apache.poi.EncryptedDocumentException
import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.ss.usermodel.Sheet

object ExcelUtils {

  @throws[EncryptedDocumentException]
  @throws[InvalidFormatException]
  @throws[IOException]
  def readFromExcel(filePath: File, workSheet : Int ): Workbook = {

    var wb: Workbook = null
    try {
      wb = WorkbookFactory.create(filePath)

      val sheet = wb.getSheetAt(0)
    } catch {
      case e: InvalidFormatException =>
        e.printStackTrace()
    }
    wb
  }


}
