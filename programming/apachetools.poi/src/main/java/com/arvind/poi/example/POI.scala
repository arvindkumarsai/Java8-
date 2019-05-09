package com.arvind.poi.example

import java.io.File

import org.apache.poi.ss.usermodel.Workbook

object POI {

  def main(args: Array[String]): Unit = {
    val wb: Workbook = ExcelUtils.readFromExcel( new File("C://test//pbs_data.xlsx"), 0)
    println(wb.getSheetName(0))
  }

}
