package com.arvind.poi.example;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.SystemOutLogger;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class POIUtility {
    public static final int TYPE_ROW = 5;
    public static final int TYPE_CELL= 3;
    public static Map<String,Integer> stateMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        Sheet sheet0 =  ExcelUtils.getWorkSheetFromFileParams(new File("D://test//Benefits_PBS.xlsx"), 0);
        Row row6 = sheet0.getRow(TYPE_ROW);
        resolveType(row6.getCell(TYPE_CELL).toString(), sheet0);


    }

    private static void resolveType(String s, Sheet sheet0) {
        System.out.println("resolveType");
        if("$Benefit".equalsIgnoreCase(s)) {
            readBenefitValues(sheet0);

        } /*else {

        }*/
    }

    private static void readBenefitValues(Sheet sheet0) {
        System.out.println("Read Benefit Sheet");
        int numOfRows = sheet0.getLastRowNum();
        extractStateMap(sheet0, numOfRows);

        for(int rowNum = 4; rowNum < numOfRows ; rowNum++ ) {

                Row row = sheet0.getRow(rowNum);
                int numOfCellPerRow = row.getLastCellNum();

                if(row.getCell(0).toString() != null && ! row.getCell(0).toString().isEmpty()) {

                    stateMap.values().forEach(v -> {
                        if(row.getCell(1).toString().equals("PBS"))
                        System.out.println(row.getCell(0)+ ":"  + row.getCell(1) + "value :" + row.getCell(v));



                    });


                }



            }


        }


    private static void extractStateMap(Sheet sheet0, int numOfRows) {
        Iterator<Row> rowIterator = sheet0.rowIterator();

        //   for(int rowNum = 4; rowNum < numOfRows ; rowNum++ ) {
        Row row = sheet0.getRow(4);
        int numOfCellPerRow = row.getLastCellNum();
        for(int cellNum=0;cellNum<numOfCellPerRow;cellNum++){
           String cellValue = row.getCell(cellNum).toString();
            System.out.println(cellValue + ":" + cellNum);


           if( null != cellValue  && !cellValue.isEmpty()) {
               stateMap.put(cellValue, cellNum);
           }
       }

        // }


        stateMap.forEach((k,v)-> System.out.println("Map key" + k +":" +v));
    }
}
