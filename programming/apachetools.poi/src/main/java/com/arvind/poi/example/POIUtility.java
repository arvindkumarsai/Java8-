package com.arvind.poi.example;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
import java.io.File;
import java.util.*;

public class POIUtility {
    public static final int TYPE_ROW = 5;
    public static final int TYPE_CELL= 3;
    public static Map<String,Integer> stateMap = new LinkedHashMap<>();

    public static void main(String[] args) throws Exception {

        Sheet sheet0 =  ExcelUtils.getWorkSheetFromFileParams(new File("D://test//PBS_Data_01.xlsx"), 0);
        Row row6 = sheet0.getRow(TYPE_ROW);
        resolveType(row6.getCell(TYPE_CELL).toString(), sheet0);


    }

    private static void resolveType(String s, Sheet sheet0) {

        int numOfRows = sheet0.getLastRowNum();
        extractStateMap(sheet0, TYPE_ROW-1);
        if("$Benefit".equalsIgnoreCase(s)) {
            readBenefitValues(sheet0, numOfRows);

        } /*else {

        }*/
    }

    private static void readBenefitValues(Sheet sheet0, int numOfRows) {
        System.out.println("Read Benefit Sheet");
        List<PBSData> pbsDataList = new ArrayList<>();
        String month,rptType, pbsCode=month=rptType =pbsCode= "";
        int counter = 0;
        for(int rowNum = 6; rowNum < numOfRows ; rowNum++ ) {


                Row row = sheet0.getRow(rowNum);
                int numOfCellPerRow = row.getLastCellNum();


                for(int j =3 ; j < numOfCellPerRow - 1 ; j++) {

                    if(! row.getCell(0).toString().isEmpty()) {
                        pbsCode = row.getCell(0).toString();
                    }
                    if(!row.getCell(1).toString().isEmpty()) {
                        if(row.getCell(1).toString().equalsIgnoreCase("PBS")) {
                            rptType = row.getCell(1).toString();
                            counter = 0;
                        } else {

                            if(row.getCell(1).toString().equalsIgnoreCase("RPBS")
                                    || row.getCell(1).toString().equalsIgnoreCase("Total") ) {

                                rowNum=rowNum+counter;

                                break; // w
                            }

                        }
                    }

                    if(!row.getCell(2).toString().equalsIgnoreCase("Total")) {
                        month = row.getCell(2).toString();
                        counter++;
                    } else {
                        break;
                    }
                    if(row.getCell(j) != null &&  !row.getCell(j).toString().isEmpty()) {
                        System.out.println(counter + " :" +row.getCell(3));
                        generatePBSObject(pbsCode, rptType, month, row, pbsDataList);
                        break;
                    }
                }


            }

        pbsDataList.forEach( System.out::println );
        }

    private static void generatePBSObject(String finalPbsCode, String rptType, String month, Row row, List<PBSData> pbsDataList) {

        stateMap.forEach((k, v)-> {
            PBSData pbsData = new PBSData();
            pbsData.setRPTType(rptType);
            pbsData.setPBS_CODE(finalPbsCode);
            pbsData.setState(k);
            pbsData.setValue((int)row.getCell(v).getNumericCellValue());
            pbsData.setMonth(month);
            pbsDataList.add(pbsData);
        });
    }


    private static void extractStateMap(Sheet sheet0, int state_row) {
        Row row = sheet0.getRow(state_row);
        int numOfCellPerRow = row.getLastCellNum();
        Map<String,Integer> unSortedStateMap = new HashMap<String,Integer>();
        for(int cellNum=0;cellNum<numOfCellPerRow;cellNum++){
           String cellValue = row.getCell(cellNum).toString();

           if( null != cellValue  && !cellValue.isEmpty()) {
               unSortedStateMap.put(cellValue, cellNum);
           }
       }

       stateMap = unSortedStateMap
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));
       stateMap.forEach((k,v)-> System.out.println("   Map key " + k +"  " +v));

    }
}
