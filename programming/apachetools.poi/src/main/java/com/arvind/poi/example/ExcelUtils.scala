package com.arvind.poi.example

import java.io.{IOException}

import org.apache.poi.EncryptedDocumentException
import org.apache.poi.openxml4j.exceptions.InvalidFormatException

import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.FileInputStream

import scala.reflect.io.File





object ExcelUtils {

  @throws[EncryptedDocumentException]
  @throws[InvalidFormatException]
  @throws[IOException]
  def getWorkSheetFromFileParams(filePath: String, workSheetNumber: Int): org.apache.poi.ss.usermodel.Sheet = try {


    val file = File(filePath)
    val inputStream = new FileInputStream(filePath)
    val fileExtensionName = file.extension

    //Check condition if the file is xlsx file//Check condition if the file is xlsx file

    if (file.exists) {
      if (fileExtensionName.equals("xlsx")) { //If it is xlsx file then create object of XSSFWorkbook class

        val workbook: XSSFWorkbook  = new XSSFWorkbook(inputStream)

        val xssfSheet: XSSFSheet = workbook.getSheetAt(0)
        return xssfSheet
      }
      else { //Check condition if the file is xls file
        if (fileExtensionName.equalsIgnoreCase("xls")) { //If it is xls file then create object of XSSFWorkbook class

          val workbook: HSSFWorkbook  = new HSSFWorkbook(inputStream)

          val hssfSheet : HSSFSheet = workbook.getSheetAt(0)
          return hssfSheet
        } else {
          throw new IllegalArgumentException("I don't know how to create that kind of new file");
        }
      }
    }
    return  null
  }

  catch {
    case e: InvalidFormatException => println(e.printStackTrace())
      null
  }


}
